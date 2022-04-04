package es.upm.dit.isst.tucomunidadapi.model;



import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.NotFound;
import org.springframework.lang.NonNull;

@Entity
public class Comunidad {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idcomunidad;
    private String direccion; 
    private String codigoPostal;

    @ManyToMany (mappedBy = "comunidad")
    private List<Votacion> votaciones;

    @OneToMany (mappedBy = "comunidad")
    private List<Vecino> vecinos;


    public Comunidad (){}

    public int getIdcomunidad() {
        return idcomunidad;
    }

    public void setIdcomunidad(int idcomunidad) {
        this.idcomunidad = idcomunidad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((codigoPostal == null) ? 0 : codigoPostal.hashCode());
        result = prime * result + ((direccion == null) ? 0 : direccion.hashCode());
        result = prime * result + idcomunidad;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Comunidad other = (Comunidad) obj;
        if (codigoPostal == null) {
            if (other.codigoPostal != null)
                return false;
        } else if (!codigoPostal.equals(other.codigoPostal))
            return false;
        if (direccion == null) {
            if (other.direccion != null)
                return false;
        } else if (!direccion.equals(other.direccion))
            return false;
        if (idcomunidad != other.idcomunidad)
            return false;
        return true;
    }

    
}