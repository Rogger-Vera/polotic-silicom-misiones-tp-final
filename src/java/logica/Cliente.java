
package logica;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Cliente extends Persona implements Serializable {
    
    
    
    @OneToMany(mappedBy = "cliente")
    private List<Venta> listaVentas;
    
    public Cliente(){}

    public Cliente(List<Venta> listaVentas) {
        this.listaVentas = listaVentas;
    }

    public Cliente(List<Venta> listaVentas, int id, String nombre, String apellido, String direccion, String dni, Date fechaNac, String nacionalidad, String celular, String email) {
        super(id, nombre, apellido, direccion, dni, fechaNac, nacionalidad, celular, email);
        this.listaVentas = listaVentas;
    }

    

    

    

    public void setListaVentas(List<Venta> listaVentas) {
        this.listaVentas = listaVentas;
    }

    public List<Venta> getListaVentas() {
        return listaVentas;
    }
    
    
    
    
    
    
}
