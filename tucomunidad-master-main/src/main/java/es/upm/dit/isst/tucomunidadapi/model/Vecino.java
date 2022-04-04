package es.upm.dit.isst.tucomunidadapi.model;
import es.upm.dit.isst.tucomunidadapi.model.Votacion;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.ManyToAny;



@Entity
public class Vecino {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idvecino;
    
    private String dni;
    private String email;
    private String contraseña;
    private String nombre; 
    private String piso;

    @OneToOne
    private Comunidad comunidad;

    @OneToMany(mappedBy = "vecino")
    private List<Correspondencia> correspondencias;

    public int getIdvecino() {
        return idvecino;
    }

    public void setIdvecino(int idvecino) {
        this.idvecino = idvecino;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPiso() {
        return piso;
    }

    public void setPiso(String piso) {
        this.piso = piso;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((contraseña == null) ? 0 : contraseña.hashCode());
        result = prime * result + ((dni == null) ? 0 : dni.hashCode());
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        result = prime * result + idvecino;
        result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
        result = prime * result + ((piso == null) ? 0 : piso.hashCode());
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
        Vecino other = (Vecino) obj;
        if (contraseña == null) {
            if (other.contraseña != null)
                return false;
        } else if (!contraseña.equals(other.contraseña))
            return false;
        if (dni == null) {
            if (other.dni != null)
                return false;
        } else if (!dni.equals(other.dni))
            return false;
        if (email == null) {
            if (other.email != null)
                return false;
        } else if (!email.equals(other.email))
            return false;
        if (idvecino != other.idvecino)
            return false;
        if (nombre == null) {
            if (other.nombre != null)
                return false;
        } else if (!nombre.equals(other.nombre))
            return false;
        if (piso == null) {
            if (other.piso != null)
                return false;
        } else if (!piso.equals(other.piso))
            return false;
        return true;
    }

    
    
}
