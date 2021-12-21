
package logica;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity
public class Empleado extends Persona implements Serializable {
    
    
    
    @Basic
    private String cargo;
    private double sueldo;
    
    @OneToOne
    private Usuario usuario;
    @OneToMany(mappedBy = "empleado")
    private List<Venta> listaVentas;
    
    
    public Empleado(){}

    public Empleado(String cargo, double sueldo, Usuario usuario, List<Venta> listaVentas) {
        this.cargo = cargo;
        this.sueldo = sueldo;
        this.usuario = usuario;
        this.listaVentas = listaVentas;
    }

    public Empleado(String cargo, double sueldo, Usuario usuario, List<Venta> listaVentas, int id, String nombre, String apellido, String direccion, String dni, Date fechaNac, String nacionalidad, String celular, String email) {
        super(id, nombre, apellido, direccion, dni, fechaNac, nacionalidad, celular, email);
        this.cargo = cargo;
        this.sueldo = sueldo;
        this.usuario = usuario;
        this.listaVentas = listaVentas;
    }

    
    
    
    public String getCargo() {
        return cargo;
    }

    public double getSueldo() {
        return sueldo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public List<Venta> getListaVentas() {
        return listaVentas;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void setListaVentas(List<Venta> listaVentas) {
        this.listaVentas = listaVentas;
    }
    
    
    
    
}
