
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
import logica.Empleado;

@WebServlet(name = "SvListarEmpleados", urlPatterns = {"/SvListarEmpleados"})
public class SvListarEmpleados extends HttpServlet {
    
    Controlador control = new Controlador();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        List <Empleado> listaEmpleados = control.listarEmpleados();
        HttpSession misession = request.getSession();
        misession.setAttribute("listaEmpleados", listaEmpleados);
        response.sendRedirect("views/vistaEmpleado/listarEmpleado.jsp");
        
        
    }

    

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
