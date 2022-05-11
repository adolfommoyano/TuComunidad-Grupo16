package es.upm.dit.isst.tucomunidadapi.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "community")
public class Community {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_community", nullable = false)
    private Long idCommunity;

    @Column(name = "address")
    private String address;

    @Column(name = "address_code")
    private String addressCode;

    @Column(name = "name")
    private String name;

    @Column(name = "identification")
    private String identification;

    @Column(name = "floor")
    private String floor;

    @Column(name = "is_login")
    private boolean isLogin;

    public Long getIdCommunity() {
        return idCommunity;
    }

    public void setIdCommunity(Long idCommunity) {
        this.idCommunity = idCommunity;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddressCode() {
        return addressCode;
    }

    public void setAddressCode(String addressCode) {
        this.addressCode = addressCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public boolean isLogin() {
        return isLogin;
    }

    public void setLogin(boolean isLogin) {
        this.isLogin = isLogin;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((address == null) ? 0 : address.hashCode());
        result = prime * result + ((addressCode == null) ? 0 : addressCode.hashCode());
        result = prime * result + ((floor == null) ? 0 : floor.hashCode());
        result = prime * result + ((idCommunity == null) ? 0 : idCommunity.hashCode());
        result = prime * result + ((identification == null) ? 0 : identification.hashCode());
        result = prime * result + (isLogin ? 1231 : 1237);
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
        Community other = (Community) obj;
        if (address == null) {
            if (other.address != null)
                return false;
        } else if (!address.equals(other.address))
            return false;
        if (addressCode == null) {
            if (other.addressCode != null)
                return false;
        } else if (!addressCode.equals(other.addressCode))
            return false;
        if (floor == null) {
            if (other.floor != null)
                return false;
        } else if (!floor.equals(other.floor))
            return false;
        if (idCommunity == null) {
            if (other.idCommunity != null)
                return false;
        } else if (!idCommunity.equals(other.idCommunity))
            return false;
        if (identification == null) {
            if (other.identification != null)
                return false;
        } else if (!identification.equals(other.identification))
            return false;
        if (isLogin != other.isLogin)
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }


}
