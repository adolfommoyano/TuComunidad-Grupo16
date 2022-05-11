package es.upm.dit.isst.tucomunidadapi.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "manager")
public class Manager {
    @Id
    @Column(name = "id_manager", nullable = false)
    private int idManager;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "name")
    private String name;

    @Column(name = "identification")
    private String identification;


    @Column(name = "is_login")
    private boolean isLogin;


    public int getIdManager() {
        return idManager;
    }


    public void setIdManager(int idManager) {
        this.idManager = idManager;
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
        result = prime * result + idManager;
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
        Manager other = (Manager) obj;
        if (email == null) {
            if (other.email != null)
                return false;
        } else if (!email.equals(other.email))
            return false;
        if (idManager != other.idManager)
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
