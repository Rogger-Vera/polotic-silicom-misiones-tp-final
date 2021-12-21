
package logica;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class ServicioTuristico implements Serializable{
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int codigoServicio;
    @Basic
    private String nombre;
    private String descripcion;
    private String destinoServicio;
    private double costoServicio;
    @Temporal(TemporalType.DATE)
    private Date fecha;
    
    @ManyToMany
    private List<PaqueteTuristico> listaPaquetes;
    @OneToMany(mappedBy="ServicioTuristico")
    private List<Venta> listaVentas;
    
    
    public ServicioTuristico(){}

    public ServicioTuristico(int codigoServicio, String nombre, String descripcion, String destinoServicio, double costoServicio, Date fecha, List<PaqueteTuristico> listaPaquetes, List<Venta> listaVentas) {
        this.codigoServicio = codigoServicio;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.destinoServicio = destinoServicio;
        this.costoServicio = costoServicio;
        this.fecha = fecha;
        this.listaPaquetes = listaPaquetes;
        this.listaVentas = listaVentas;
    }

    public void setCodigoServicio(int codigoServicio) {
        this.codigoServicio = codigoServicio;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setDestinoServicio(String destinoServicio) {
        this.destinoServicio = destinoServicio;
    }

    public void setCostoServicio(double costoServicio) {
        this.costoServicio = costoServicio;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setListaPaquetes(List<PaqueteTuristico> listaPaquetes) {
        this.listaPaquetes = listaPaquetes;
    }

    public void setListaVentas(List<Venta> listaVentas) {
        this.listaVentas = listaVentas;
    }

    public int getCodigoServicio() {
        return codigoServicio;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getDestinoServicio() {
        return destinoServicio;
    }

    public double getCostoServicio() {
        return costoServicio;
    }

    public Date getFecha() {
        return fecha;
    }

    public List<PaqueteTuristico> getListaPaquetes() {
        return listaPaquetes;
    }

    public List<Venta> getListaVentas() {
        return listaVentas;
    }
    
    
    
    
    
    
    
    
}
