
package logica;

import static java.lang.Double.parseDouble;
import java.util.Date;
import persistencia.ControladorPersistencia;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Controlador {
    
    ControladorPersistencia controlPersis = new ControladorPersistencia();
    
    private List<Usuario> listaUsuarios;
    
    
    //Convierte String a Date en formato yyyy-MM-dd
    
    public static synchronized java.util.Date deStringADate(String fecha){
        
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaEnviar = null;
        try{
            fechaEnviar = df.parse(fecha);
            return fechaEnviar;
        }catch(ParseException e){
            e.printStackTrace();
            return null;
        }
        
    } 
    
    //Convierte Date a String en formato yyyy-MM-dd
    public static String deDateAString(Date fecha){
        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
        return formatoFecha.format(fecha);
        
    }
    
    public void crearUsuario(String usuario, String contraseña){
        
        Usuario usu = new Usuario();
        
        usu.setUsuario(usuario);
        usu.setContraseña(contraseña);
        
        controlPersis.crearUsuario(usu);
        
    }

    public void crearEmpleado(String nombre, String apellido, String direccion, String nroDocumento, String fechaNac, String nacionalidad, String celular, String email, String cargo, String sueldo, String usuario, String contraseña){
        
        try {
            Usuario usu = new Usuario();
            Empleado emple = new Empleado();
            
            usu.setUsuario(usuario);
            usu.setContraseña(contraseña);
            
            emple.setNombre(nombre);
            emple.setApellido(apellido);
            emple.setDireccion(direccion);
            emple.setDni(nroDocumento);
            
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            Date fecha = formato.parse(fechaNac);
            
            emple.setFechaNac(fecha);
            emple.setNacionalidad(nacionalidad);
            emple.setCelular(celular);
            emple.setEmail(email);
            emple.setCargo(cargo);
            emple.setSueldo(Double.parseDouble(sueldo));
            emple.setUsuario(usu);
            
            controlPersis.crearEmpleado(emple, usu);
        } catch (ParseException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public void crearCliente(String nombre, String apellido, String direccion, String nroDocumento, String fechaNac, String nacionalidad, String celular, String email) {
        
        try {
            Cliente client = new Cliente();
            
            client.setNombre(nombre);
            client.setApellido(apellido);
            client.setDireccion(direccion);
            client.setDni(nroDocumento);
            
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            Date fecha = formato.parse(fechaNac);
            client.setFechaNac(fecha);
            client.setNacionalidad(nacionalidad);
            client.setCelular(celular);
            client.setEmail(email);
            
            controlPersis.crearCliente(client);
        } catch (ParseException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    
    }

    public void crearServicioTuristico(String nombre, String descripcion, String destino, String fecha, Double costo) {
        
        try {
            ServicioTuristico servicio = new ServicioTuristico();
            
            servicio.setNombre(nombre);
            servicio.setDescripcion(descripcion);
            servicio.setDestinoServicio(destino);
            
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            Date fechaServicio = formato.parse(fecha);
            servicio.setFecha(fechaServicio);
            servicio.setCostoServicio(costo);
            
            controlPersis.crearServicio(servicio);
        } catch (ParseException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    
    }

    public boolean comprobarIngreso(String usuario, String password) {
        
        boolean bandera = false;
        
        listaUsuarios = controlPersis.traerUsuarios();
        
        for (Usuario usu : listaUsuarios) {
            
            if(usu.getUsuario().equals(usuario) && usu.getContraseña().equals(password)){
                bandera = true;
                return bandera;
            }
        }
    
        return bandera;
        
    }

    public List<Cliente> listarClientes() {
        
        return controlPersis.listarClientes();
    
    }

    public void eliminarCliente(int id) {
        
        controlPersis.eliminarClinete(id);
    
    }

    public Cliente buscarCliente(int id) {
        
        return controlPersis.buscarCliente(id);
        
    }

    public void modificarCliente(Cliente cliente) {
        
        controlPersis.modificarCliente(cliente);
    
    }

    public List<Empleado> listarEmpleados() {
        
        return controlPersis.listarEmpleados();
    
    }

    public List<ServicioTuristico> listarServicios() {
        
        return controlPersis.listarServicios();
    
    }

    public void eliminarServicio(int id) {
        
        controlPersis.eliminarServicio(id);
    
    }

    public ServicioTuristico buscarServicio(int id) {
        
        return controlPersis.buscarServicio(id);
    
    }

    public void modificarServicio(ServicioTuristico servicio) {
        
        controlPersis.modificarServicio(servicio);
    
    }

    public Empleado buscarEmpleado(int id) {
        
        return controlPersis.buscarEmpleado(id);
    
    }

    public void modificarEmpleado(Empleado empleado) {
        
        
        controlPersis.modificarEmpleado(empleado);
    }

    public void eliminarEmpleado(int id) {
        
        controlPersis.eliminarEmpleado(id);
    
    }

    public void eliminarUsuario(int id) {
        
        controlPersis.eliminarUsuario(id);
    
    }
    
    
    
    
    
    
    
    

    
    
    

    
    
}
