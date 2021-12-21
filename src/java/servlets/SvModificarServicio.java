
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logica.Cliente;
import logica.Controlador;
import logica.ServicioTuristico;

@WebServlet(name = "SvModificarServicio", urlPatterns = {"/SvModificarServicio"})
public class SvModificarServicio extends HttpServlet {

    Controlador control = new Controlador();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
    }



    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int id = Integer.parseInt(request.getParameter("id"));
        
        ServicioTuristico servicio = control.buscarServicio(id);
        
        request.getSession().setAttribute("servicio", servicio);
        
        response.sendRedirect("views/vistaServicio/modificarServicio.jsp");
        
        
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
