package hw11.model.domain;

import javax.persistence.*;

/**
 * Created with Intellij IDEA.
 * Project name: proff16
 * User: Partizanin
 * Date: 22.07.2014
 * Time: 11:17
 * To change this template use File|Setting|File Templates.
 */
/*оформить заказ (дата, клиент, сумма, адрес подачи, адрес назначения)*/
@Entity
@Table(name = "Orders")
public class Orders {

    @SequenceGenerator(name = "sequence", sequenceName = "seq_orders_id", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")

    @Id
    @Column(name = "order_id")
    private Long id;

    @Column(name = "order_date")
    private String date;

    @Column(name = "order_client_id")
    private String clientId;

    @Column(name = "order_summ")
    private double summ;

    @Column(name = "order_firsAdrs")
    private String firstAdress;

    @Column(name = "order_lastAdress")
    private String lastAdress;

    @Column(name = "order_operator_id")
    private String operatorId;

    Orders() {

    }

    public Orders(String date, String clientId, double summ, String firstAdress, String lastAdress, String operatorId) {
        this.date = date;
        this.clientId = clientId;
        this.summ = summ;
        this.firstAdress = firstAdress;
        this.lastAdress = lastAdress;
        this.operatorId = operatorId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getSumm() {
        return summ;
    }

    public void setSumm(double summ) {
        this.summ = summ;
    }

    public String getFirstAdress() {
        return firstAdress;
    }

    public void setFirstAdress(String firstAdress) {
        this.firstAdress = firstAdress;
    }

    public String getLastAdress() {
        return lastAdress;
    }

    public void setLastAdress(String lastAdress) {
        this.lastAdress = lastAdress;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "date='" + date + '\'' +
                ", clientId =" + clientId +
                ", summ=" + summ +
                ", firstAdress='" + firstAdress + '\'' +
                ", lastAdress='" + lastAdress + '\'' +
                ", operator=" + operatorId +
                '}';
    }

    public Long getId() {
        return id;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId;
    }
}
