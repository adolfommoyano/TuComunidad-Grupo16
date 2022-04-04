package es.upm.dit.isst.tucomunidadapi.model;

import javax.persistence.*;

import java.util.List;

@Entity
public class Correspondencia {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idcorrespondencia;
    private String texto;

    @OneToOne
    private Conserje conserje;

    @OneToOne
    private Vecino vecino;


    public Correspondencia(){}

    public int getIdcorrespondencia() {
        return idcorrespondencia;
    }

    public void setIdcorrespondencia(int idcorrespondencia) {
        this.idcorrespondencia = idcorrespondencia;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + idcorrespondencia;
        result = prime * result + ((texto == null) ? 0 : texto.hashCode());
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
        Correspondencia other = (Correspondencia) obj;
        if (idcorrespondencia != other.idcorrespondencia)
            return false;
        if (texto == null) {
            if (other.texto != null)
                return false;
        } else if (!texto.equals(other.texto))
            return false;
        return true;
    }

    

    

}