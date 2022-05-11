package es.upm.dit.isst.tucomunidadapi.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "package")
public class Packages {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_package", nullable = false)
    private Long idPackage;

    @Column(name = "title")
    private String title;

    @Column(name = "date_of_pickup")
    private Instant reservationDate;

    @Column(name = "description")
    private String description;

    public Long getIdPackage() {
        return idPackage;
    }

    public void setIdPackage(Long idPackage) {
        this.idPackage = idPackage;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Instant getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(Instant reservationDate) {
        this.reservationDate = reservationDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((description == null) ? 0 : description.hashCode());
        result = prime * result + ((idPackage == null) ? 0 : idPackage.hashCode());
        result = prime * result + ((reservationDate == null) ? 0 : reservationDate.hashCode());
        result = prime * result + ((title == null) ? 0 : title.hashCode());
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
        Packages other = (Packages) obj;
        if (description == null) {
            if (other.description != null)
                return false;
        } else if (!description.equals(other.description))
            return false;
        if (idPackage == null) {
            if (other.idPackage != null)
                return false;
        } else if (!idPackage.equals(other.idPackage))
            return false;
        if (reservationDate == null) {
            if (other.reservationDate != null)
                return false;
        } else if (!reservationDate.equals(other.reservationDate))
            return false;
        if (title == null) {
            if (other.title != null)
                return false;
        } else if (!title.equals(other.title))
            return false;
        return true;
    }

}
