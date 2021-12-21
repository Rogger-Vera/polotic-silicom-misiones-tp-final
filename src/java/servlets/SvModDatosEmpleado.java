
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logica.Controlador;
import logica.Empleado;
import logica.Usuario;

@WebServlet(name = "SvModDatosEmpleado", urlPatterns = {"/SvModDatosEmpleado"})
public class SvModDatosEmpleado extends HttpServlet {

    Controlador control = new Controlador();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int id = Integer.parseInt(request.getParameter("id"));
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String direccion = request.getParameter("direccion");
        String nroDocumento = request.getParameter("documento");
        String fechaNac = request.getParameter("fechaNac");
        String nacionalidad = request.getParameter("nacionalidad");
        String celular = request.getParameter("celular");
        String email = request.getParameter("email");
        String cargo = request.getParameter("cargo");
        String sueldo = request.getParameter("sueldo");
        String usuario = request.getParameter("usuario");
        String contraseña = request.getParameter("password");
        
        Empleado empleado = control.buscarEmpleado(id);
        
        empleado.setNombre(nombre);
        empleado.setApellido(apellido);
        empleado.setDireccion(direccion);
        empleado.setDni(nroDocumento);
        empleado.setFechaNac(control.deStringADate(fechaNac));
        empleado.setNacionalidad(nacionalidad);
        empleado.setCelular(celular);
        empleado.setEmail(email);
        empleado.setCargo(cargo);
        empleado.setSueldo(Double.parseDouble(sueldo));
        
        Usuario usu = new Usuario();
        usu.setUsuario(usuario);
        usu.setContraseña(contraseña);
        
        empleado.setUsuario(usu);
        
        control.modificarEmpleado(empleado);
        
        request.getSession().setAttribute("listaEmpleados", control.listarEmpleados());
        
        response.sendRedirect("views/vistaEmpleado/listarEmpleado.jsp");
        
        
        
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
