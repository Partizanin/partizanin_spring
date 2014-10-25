package hw11.model.domain;

import javax.persistence.*;

/**
 * Created with Intellij IDEA.
 * Project name: proff16
 * User: Partizanin
 * Date: 22.07.2014
 * Time: 16:25
 * To change this template use File|Setting|File Templates.
 */
@Entity
@Table(name = "Operators")
public class Operator {

    @SequenceGenerator(name = "sequence", sequenceName = "seq_operator_id", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")

    @Id
    @Column(name = "operator_id")
    private Long id;

    @Column(name = "operator_identifyNumber")
    private int identifyNumber;

    @Column(name = "operator_login")
    private String login;


    @Column(name = "operator_password")
    private String password;

    @Column(name = "operator_invitor")
    private String loginAnotherOperator;


    public Operator() {
    }

    public Operator(String login, String password, int identifyNumber, String loginAnotherOperator) {
        this.login = login;
        this.password = password;
        this.identifyNumber = identifyNumber;
        this.loginAnotherOperator = loginAnotherOperator;
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

    public int getIdentifyNumber() {
        return identifyNumber;
    }

    public void setIdentifyNumber(int identifyNumber) {
        this.identifyNumber = identifyNumber;
    }

    @Override
    public String toString() {
        return "Operator{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", identifyNumber='" + identifyNumber + '\'' +
                '}';
    }

    public String getLoginAnotherOperator() {
        return loginAnotherOperator;
    }

    public void setLoginAnotherOperator(String loginAnotherOperator) {
        this.loginAnotherOperator = loginAnotherOperator;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
