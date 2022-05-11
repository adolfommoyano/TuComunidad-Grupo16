package es.upm.dit.isst.tucomunidadapi.model;

import lombok.Data;

import java.util.HashMap;

@Data
public class ReservedFacility {

    private String facilityName;
    private int allReserved;
    private int totalReserved;
    public String getFacilityName() {
        return facilityName;
    }
    public void setFacilityName(String facilityName) {
        this.facilityName = facilityName;
    }
    public int getAllReserved() {
        return allReserved;
    }
    public void setAllReserved(int allReserved) {
        this.allReserved = allReserved;
    }
    public int getTotalReserved() {
        return totalReserved;
    }
    public void setTotalReserved(int totalReserved) {
        this.totalReserved = totalReserved;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + allReserved;
        result = prime * result + ((facilityName == null) ? 0 : facilityName.hashCode());
        result = prime * result + totalReserved;
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
        ReservedFacility other = (ReservedFacility) obj;
        if (allReserved != other.allReserved)
            return false;
        if (facilityName == null) {
            if (other.facilityName != null)
                return false;
        } else if (!facilityName.equals(other.facilityName))
            return false;
        if (totalReserved != other.totalReserved)
            return false;
        return true;
    }

    

}
