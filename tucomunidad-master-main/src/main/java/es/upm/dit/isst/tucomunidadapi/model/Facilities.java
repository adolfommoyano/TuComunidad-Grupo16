package es.upm.dit.isst.tucomunidadapi.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "facilities")
public class Facilities {

    @Id
    @GeneratedValue
    @Column(name = "id_facilities", nullable = false)
    private Integer idFacilities;

    @Column(name = "name", nullable = false)
    private String name;

    public Integer getIdFacilities() {
        return idFacilities;
    }

    public void setIdFacilities(Integer idFacilities) {
        this.idFacilities = idFacilities;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((idFacilities == null) ? 0 : idFacilities.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
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
        Facilities other = (Facilities) obj;
        if (idFacilities == null) {
            if (other.idFacilities != null)
                return false;
        } else if (!idFacilities.equals(other.idFacilities))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }


}
