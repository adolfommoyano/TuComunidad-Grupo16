package es.upm.dit.isst.tucomunidadapi.model;



import javax.persistence.*;

import org.hibernate.annotations.ManyToAny;

@Entity
public class Votacion{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idvotaciones;
    private String titulo; 
    private String descripcion;
    private String gestor;
    private int numeroVotosFavor;
    private int numeroVotosContra;

    @ManyToOne
    private Comunidad comunidad;    

    public Votacion() {
    }
    
    

    public int getIdvotaciones() {
        return idvotaciones;
    }



    public void setIdvotaciones(int idvotaciones) {
        this.idvotaciones = idvotaciones;
    }



    public String getTitulo() {
        return titulo;
    }



    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }



    public String getDescripcion() {
        return descripcion;
    }



    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }



    public String getGestor() {
        return gestor;
    }



    public void setGestor(String gestor) {
        this.gestor = gestor;
    }



    public int getNumeroVotosFavor() {
        return numeroVotosFavor;
    }



    public void setNumeroVotosFavor(int numeroVotosFavor) {
        this.numeroVotosFavor = numeroVotosFavor;
    }



    public int getNumeroVotosContra() {
        return numeroVotosContra;
    }



    public void setNumeroVotosContra(int numeroVotosContra) {
        this.numeroVotosContra = numeroVotosContra;
    }



    public void aumentarNumeroVotosFavor(){
        this.numeroVotosFavor += 1; 
    }

    public void aumentarNumeroVotosContra() {
        this.numeroVotosContra += 1; 
    }



    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
        result = prime * result + ((gestor == null) ? 0 : gestor.hashCode());
        result = prime * result + idvotaciones;
        result = prime * result + numeroVotosContra;
        result = prime * result + numeroVotosFavor;
        result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
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
        Votacion other = (Votacion) obj;
        if (descripcion == null) {
            if (other.descripcion != null)
                return false;
        } else if (!descripcion.equals(other.descripcion))
            return false;
        if (gestor == null) {
            if (other.gestor != null)
                return false;
        } else if (!gestor.equals(other.gestor))
            return false;
        if (idvotaciones != other.idvotaciones)
            return false;
        if (numeroVotosContra != other.numeroVotosContra)
            return false;
        if (numeroVotosFavor != other.numeroVotosFavor)
            return false;
        if (titulo == null) {
            if (other.titulo != null)
                return false;
        } else if (!titulo.equals(other.titulo))
            return false;
        return true;
    }


    
}