package hw11.model.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created with Intellij IDEA.
 * Project name: proff16
 * User: Partizanin
 * Date: 22.07.2014
 * Time: 16:25
 * To change this template use File|Setting|File Templates.
 */
@Entity
@Table(name = "Admins")
public class Administrator implements Serializable {

    @SequenceGenerator(name = "sequence", sequenceName = "seq_admin_id", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")

    @Id
    @Column(name = "admin_id")
    private Long id;

    @Column(name = "admin_login")
    private String login;

    @Column(name = "admin_pass")
    private String password;

    @Column(name = "admin_invitor")
    private String loginAnotherAdmin;


    public Administrator() {

    }

    public Administrator(String login, String password, String loginAnotherAdmin) {
        this.login = login;
        this.password = password;
        this.loginAnotherAdmin = loginAnotherAdmin;
    }


    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLoginAnotherAdmin() {
        return loginAnotherAdmin;
    }

    public void setLoginAnotherAdmin(String loginAnotherAdmin) {
        this.loginAnotherAdmin = loginAnotherAdmin;
    }

    @Override
    public String toString() {
        return "Administrator{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", loginAnotherAdmin='" + loginAnotherAdmin + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
