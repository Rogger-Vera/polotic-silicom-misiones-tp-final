
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logica.Controlador;
import logica.ServicioTuristico;

@WebServlet(name = "SvModDatosServicio", urlPatterns = {"/SvModDatosServicio"})
public class SvModDatosServicio extends HttpServlet {
    
    Controlador control = new Controlador();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int id = Integer.parseInt(request.getParameter("id"));
        String nombre = request.getParameter("nombre");
        String descripcion = request.getParameter("descripcion");
        String destino = request.getParameter("destino");
        String fecha = request.getParameter("fecha");
        Double costo = Double.parseDouble(request.getParameter("costo"));
        
        ServicioTuristico servicio = control.buscarServicio(id);
        
        servicio.setNombre(nombre);
        servicio.setDescripcion(descripcion);
        servicio.setDestinoServicio(destino);
        servicio.setFecha(control.deStringADate(fecha));
        servicio.setCostoServicio(costo);
        
        control.modificarServicio(servicio);
        
        request.getSession().setAttribute("listaServicios", control.listarServicios());
        
        response.sendRedirect("views/vistaServicio/listarServicio.jsp");

        
        
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
