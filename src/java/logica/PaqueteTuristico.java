
package logica;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class PaqueteTuristico implements Serializable{
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int codigoPaquete;
    @Basic
    private double costoPaquete;
    
    @ManyToMany
    private List<ServicioTuristico> listaServicios;
    @OneToMany(mappedBy="PaqueteTuristico")
    private List<Venta> listaVentas;
    
    
    public PaqueteTuristico(){}

    public PaqueteTuristico(int codigoPaquete, double costoPaquete, List<ServicioTuristico> listaServicios, List<Venta> listaVentas) {
        this.codigoPaquete = codigoPaquete;
        this.costoPaquete = costoPaquete;
        this.listaServicios = listaServicios;
        this.listaVentas = listaVentas;
    }

    public void setCodigoPaquete(int codigoPaquete) {
        this.codigoPaquete = codigoPaquete;
    }

    public void setCostoPaquete(double costoPaquete) {
        this.costoPaquete = costoPaquete;
    }

    public void setListaServicios(List<ServicioTuristico> listaServicios) {
        this.listaServicios = listaServicios;
    }

    public void setListaVentas(List<Venta> listaVentas) {
        this.listaVentas = listaVentas;
    }

    public int getCodigoPaquete() {
        return codigoPaquete;
    }

    public double getCostoPaquete() {
        return costoPaquete;
    }

    public List<ServicioTuristico> getListaServicios() {
        return listaServicios;
    }

    public List<Venta> getListaVentas() {
        return listaVentas;
    }
    
    
    
    
    
}
