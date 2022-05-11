package es.upm.dit.isst.tucomunidadapi.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.annotation.Generated;
import javax.persistence.*;
import java.time.Instant;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "reserved_facilities")
public class ReservedFacilities {

    @Id
    @GeneratedValue
    @Column(name = "id_reserved_facilities", nullable = false)
    private Integer idReservedFacilities;

    @ManyToOne
    @JoinColumn(name = "id_facilities")
    private Facilities facility;

    @OneToOne
    @JoinColumn(name = "id_neighbour")
    private Neighbour neighbour;

    @Column(name = "reservation_date")
    private Instant reservationDate;

    public Integer getIdReservedFacilities() {
        return idReservedFacilities;
    }

    public void setIdReservedFacilities(Integer idReservedFacilities) {
        this.idReservedFacilities = idReservedFacilities;
    }

    public Facilities getFacility() {
        return facility;
    }

    public void setFacility(Facilities facility) {
        this.facility = facility;
    }

    public Neighbour getNeighbour() {
        return neighbour;
    }

    public void setNeighbour(Neighbour neighbour) {
        this.neighbour = neighbour;
    }

    public Instant getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(Instant reservationDate) {
        this.reservationDate = reservationDate;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((facility == null) ? 0 : facility.hashCode());
        result = prime * result + ((idReservedFacilities == null) ? 0 : idReservedFacilities.hashCode());
        result = prime * result + ((neighbour == null) ? 0 : neighbour.hashCode());
        result = prime * result + ((reservationDate == null) ? 0 : reservationDate.hashCode());
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
        ReservedFacilities other = (ReservedFacilities) obj;
        if (facility == null) {
            if (other.facility != null)
                return false;
        } else if (!facility.equals(other.facility))
            return false;
        if (idReservedFacilities == null) {
            if (other.idReservedFacilities != null)
                return false;
        } else if (!idReservedFacilities.equals(other.idReservedFacilities))
            return false;
        if (neighbour == null) {
            if (other.neighbour != null)
                return false;
        } else if (!neighbour.equals(other.neighbour))
            return false;
        if (reservationDate == null) {
            if (other.reservationDate != null)
                return false;
        } else if (!reservationDate.equals(other.reservationDate))
            return false;
        return true;
    }




}
