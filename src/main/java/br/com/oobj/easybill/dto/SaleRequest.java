package br.com.oobj.easybill.dto;

import br.com.oobj.easybill.enums.Status;
import br.com.oobj.easybill.model.Client;
import br.com.oobj.easybill.model.Sale;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Calendar;

public class SaleRequest {

    @NotBlank
    private Calendar date;

    @NotBlank
    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne
    @Column(name = "client_id")
    private Client client;

    public SaleRequest() {
    }

    public SaleRequest(Sale sale) {
        this.client = sale.getClient();
        this.date = sale.getDate();
        this.status = sale.getStatus();
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

    public Sale toSale(){

        Sale sale = new Sale();

        sale.setDate(date);
        sale.setStatus(status);
        sale.setClient(client);

        return sale;
    }
}
