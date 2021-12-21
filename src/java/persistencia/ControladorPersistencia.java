
package persistencia;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import logica.Cliente;
import logica.Empleado;
import logica.ServicioTuristico;
import logica.Usuario;
import persistencia.exceptions.NonexistentEntityException;

public class ControladorPersistencia {
    
    UsuarioJpaController usuarioJPA = new UsuarioJpaController();
    EmpleadoJpaController empleadoJPA = new EmpleadoJpaController();
    ClienteJpaController clienteJPA = new ClienteJpaController();
    ServicioTuristicoJpaController servicioJPA = new ServicioTuristicoJpaController();
    PaqueteTuristicoJpaController paqueteJPA = new PaqueteTuristicoJpaController();
    VentaJpaController ventaJPA = new VentaJpaController();
    
    
    public void crearUsuario(Usuario usuario){
        
        usuarioJPA.create(usuario);
    }

    public void crearEmpleado(Empleado emple, Usuario usu) {
        
        usuarioJPA.create(usu);
        empleadoJPA.create(emple);
        
    }

    public void crearCliente(Cliente client) {
        
        clienteJPA.create(client);
        
    }

    public void crearServicio(ServicioTuristico servicio) {
        
        servicioJPA.create(servicio);
    
    }

    public List<Usuario> traerUsuarios() {
        
        List<Usuario> listaUsuarios;
        listaUsuarios = usuarioJPA.findUsuarioEntities();
        
        return listaUsuarios;
    
    }

    public List<Cliente> listarClientes() {
    
        return clienteJPA.findClienteEntities();
    
    }

    public void eliminarClinete(int id) {
        
        try {
            clienteJPA.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladorPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public Cliente buscarCliente(int id) {
        
        return clienteJPA.findCliente(id);
        
    }

    public void modificarCliente(Cliente cliente) {
        
        try {
            clienteJPA.edit(cliente);
        } catch (Exception ex) {
            Logger.getLogger(ControladorPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }

    public List<Empleado> listarEmpleados() {
        
        return empleadoJPA.findEmpleadoEntities();
    
    }

    public List<ServicioTuristico> listarServicios() {
        
        return servicioJPA.findServicioTuristicoEntities();
    
    }

    public void eliminarServicio(int id) {
        
        try {
            servicioJPA.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladorPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }

    public ServicioTuristico buscarServicio(int id) {
        
        return servicioJPA.findServicioTuristico(id);
    
    }

    public void modificarServicio(ServicioTuristico servicio) {
        
        try {
            servicioJPA.edit(servicio);
        } catch (Exception ex) {
            Logger.getLogger(ControladorPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }

    public Empleado buscarEmpleado(int id) {
        
        return empleadoJPA.findEmpleado(id);
    
    }

    public void modificarEmpleado(Empleado empleado) {
        
        try {
            empleadoJPA.edit(empleado);
        } catch (Exception ex) {
            Logger.getLogger(ControladorPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }

    public void eliminarEmpleado(int id) {
        
        try {
            empleadoJPA.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladorPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public void eliminarUsuario(int id) {
        
        try {
            usuarioJPA.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladorPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }

    

    

    

    
    
    
    
    
    
    
}
