package hw11.model.domain;

import javax.persistence.*;

/**
 * Created with Intellij IDEA.
 * Project name: proff16
 * User: Partizanin
 * Date: 22.07.2014
 * Time: 11:04
 * To change this template use File|Setting|File Templates.
 */
/*зарегистрировать клиента (имя, фамилия, телефон, адрес, сумма, дата последнего заказа)*/
@Entity
@Table(name = "Clients")

public class Client {

    @SequenceGenerator(name = "sequence", sequenceName = "seq_client_id", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")


    @Id
    @Column(name = "client_id")
    private Long id;

    @Column(name = "client_name")
    private String name;


    @Column(name = "client_surname")
    private String surname;

    @Column(name = "client_phoneNumber")
    private String phoneNumber;

    @Column(name = "client_address")
    private String address;

    @Column(name = "client_summa")
    private double summa;

    @Column(name = "client_lastDate")
    private String lastDate;


    public Client() {


    }


    public Client(String name, String surname, String phoneNumber, String address, double summa, String lastDate) {
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.summa = summa;
        this.lastDate = lastDate;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getSumma() {
        return summa;
    }

    public void setSumma(double summa) {
        this.summa = summa;
    }

    public String getLastDate() {
        return lastDate;
    }

    public void setLastDate(String lastDate) {
        this.lastDate = lastDate;
    }


    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", address='" + address + '\'' +
                ", summa=" + summa +
                ", lastDate='" + lastDate + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
