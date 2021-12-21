
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logica.Cliente;
import logica.Controlador;

@WebServlet(name = "SvListarClientes", urlPatterns = {"/SvListarClientes"})
public class SvListarClientes extends HttpServlet {
    
    Controlador control = new Controlador();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        List <Cliente> listaClientes = control.listarClientes();
        HttpSession misession = request.getSession();
        misession.setAttribute("listaClientes", listaClientes);
        response.sendRedirect("views/vistaCliente/listarCliente.jsp");
        
        
        
    }

    

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
