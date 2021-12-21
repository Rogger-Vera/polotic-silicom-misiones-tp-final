
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logica.Controlador;


@WebServlet(name = "SvEmpleado", urlPatterns = {"/SvEmpleado"})
public class SvEmpleado extends HttpServlet {

    Controlador control = new Controlador();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
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
            
            
            request.getSession().setAttribute("nombre", nombre);
            request.getSession().setAttribute("apellido", apellido);
            request.getSession().setAttribute("direccion", direccion);
            request.getSession().setAttribute("documento", nroDocumento);
            request.getSession().setAttribute("fechaNac", fechaNac);
            request.getSession().setAttribute("nacionalidad", nacionalidad);
            request.getSession().setAttribute("celular", celular);
            request.getSession().setAttribute("email", email);
            request.getSession().setAttribute("cargo", cargo);
            request.getSession().setAttribute("sueldo", sueldo);
            request.getSession().setAttribute("usuario", usuario);
            
            control.crearEmpleado(nombre, apellido, direccion, nroDocumento, fechaNac, nacionalidad, celular, email, cargo, sueldo, usuario, contraseña);
            
            response.sendRedirect("index.jsp");
        
        
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
