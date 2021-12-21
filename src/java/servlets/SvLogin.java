
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logica.Controlador;


@WebServlet(name = "SvLogin", urlPatterns = {"/SvLogin"})
public class SvLogin extends HttpServlet {
    
    Controlador control = new Controlador();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
    }

    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        boolean encontrado = false;
        
        encontrado = control.comprobarIngreso(request.getParameter("usuario"), request.getParameter("password"));
        
        
        if (encontrado == true){
            //trae la sesion activa
            HttpSession miSession = request.getSession(true);
            String usuario = request.getParameter("usuario");
            String password = request.getParameter("password");
            miSession.setAttribute("usuario", usuario);
            miSession.setAttribute("control", control);
            
            response.sendRedirect("index.jsp");
            
            
        }else{
            
            response.sendRedirect("views/vistaEmpleado/errorLogin.jsp");
        }
        
        
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
