package br.com.oobj.easybill.model;

import br.com.oobj.easybill.enums.Status;

import javax.persistence.*;
import java.util.Calendar;

@Entity
@Table(name = "sales")
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Calendar date;
    private Status status;

    @ManyToOne
    @Column(name = "client_id")
    private Client client;


    public Long getId() {
        return id;
    }

    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
