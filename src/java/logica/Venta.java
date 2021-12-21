
package logica;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Venta implements Serializable{
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int numVenta;
    @Temporal(TemporalType.DATE)
    private Date fechaVenta;
    @Basic
    private String medioPago;
    
    @ManyToOne
    private Cliente cliente;
    @ManyToOne
    private Empleado empleado;
    @ManyToOne
    private ServicioTuristico servicioTuristico;
    @ManyToOne
    private PaqueteTuristico paqueteTuristico;
    
    
    public Venta(){}

    public Venta(int numVenta, Date fechaVenta, String medioPago, Cliente cliente, Empleado empleado, ServicioTuristico servicioTuristico, PaqueteTuristico paqueteTuristico) {
        this.numVenta = numVenta;
        this.fechaVenta = fechaVenta;
        this.medioPago = medioPago;
        this.cliente = cliente;
        this.empleado = empleado;
        this.servicioTuristico = servicioTuristico;
        this.paqueteTuristico = paqueteTuristico;
    }

    public void setNumVenta(int numVenta) {
        this.numVenta = numVenta;
    }

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public void setMedioPago(String medioPago) {
        this.medioPago = medioPago;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public void setServicioTuristico(ServicioTuristico servicioTuristico) {
        this.servicioTuristico = servicioTuristico;
    }

    public void setPaqueteTuristico(PaqueteTuristico paqueteTuristico) {
        this.paqueteTuristico = paqueteTuristico;
    }

    public int getNumVenta() {
        return numVenta;
    }

    public Date getFechaVenta() {
        return fechaVenta;
    }

    public String getMedioPago() {
        return medioPago;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public ServicioTuristico getServicioTuristico() {
        return servicioTuristico;
    }

    public PaqueteTuristico getPaqueteTuristico() {
        return paqueteTuristico;
    }
    
    
    
    
    
    
    
}
