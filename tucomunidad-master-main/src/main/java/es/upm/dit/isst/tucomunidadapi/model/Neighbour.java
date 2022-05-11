package es.upm.dit.isst.tucomunidadapi.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "neighbour")
public class Neighbour {
    @Id
    @GeneratedValue
    @Column(name = "id_neighbour", nullable = false)
    private int idNeighbour;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "name")
    private String name;

    @Column(name = "identification")
    private String identification;

    @Column(name = "floor")
    private String floor;

    @Column(name = "is_login")
    private boolean isLogin;

    public int getIdNeighbour() {
        return idNeighbour;
    }

    public void setIdNeighbour(int idNeighbour) {
        this.idNeighbour = idNeighbour;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        result = prime * result + ((floor == null) ? 0 : floor.hashCode());
        result = prime * result + idNeighbour;
        result = prime * result + ((identification == null) ? 0 : identification.hashCode());
        result = prime * result + (isLogin ? 1231 : 1237);
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((password == null) ? 0 : password.hashCode());
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
        Neighbour other = (Neighbour) obj;
        if (email == null) {
            if (other.email != null)
                return false;
        } else if (!email.equals(other.email))
            return false;
        if (floor == null) {
            if (other.floor != null)
                return false;
        } else if (!floor.equals(other.floor))
            return false;
        if (idNeighbour != other.idNeighbour)
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
        if (password == null) {
            if (other.password != null)
                return false;
        } else if (!password.equals(other.password))
            return false;
        return true;
    }


}
