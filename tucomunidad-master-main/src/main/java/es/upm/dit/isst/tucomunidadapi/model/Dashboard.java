package es.upm.dit.isst.tucomunidadapi.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;


@Data
public class Dashboard {
    private int votes;
    private int packagesSize;
    List<ReservedFacility> reservedFacilityDTOS = new ArrayList<>();

    
    public int getVotes() {
        return votes;
    }
    public void setVotes(int votes) {
        this.votes = votes;
    }
    public int getPackagesSize() {
        return packagesSize;
    }
    public void setPackagesSize(int packagesSize) {
        this.packagesSize = packagesSize;
    }
    public List<ReservedFacility> getReservedFacilityDTOS() {
        return reservedFacilityDTOS;
    }
    public void setReservedFacilityDTOS(List<ReservedFacility> reservedFacilityDTOS) {
        this.reservedFacilityDTOS = reservedFacilityDTOS;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + packagesSize;
        result = prime * result + ((reservedFacilityDTOS == null) ? 0 : reservedFacilityDTOS.hashCode());
        result = prime * result + votes;
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
        Dashboard other = (Dashboard) obj;
        if (packagesSize != other.packagesSize)
            return false;
        if (reservedFacilityDTOS == null) {
            if (other.reservedFacilityDTOS != null)
                return false;
        } else if (!reservedFacilityDTOS.equals(other.reservedFacilityDTOS))
            return false;
        if (votes != other.votes)
            return false;
        return true;
    }

    

}
