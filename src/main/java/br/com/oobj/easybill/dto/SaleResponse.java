package br.com.oobj.easybill.dto;

import br.com.oobj.easybill.enums.Status;
import br.com.oobj.easybill.model.Client;
import br.com.oobj.easybill.model.Sale;

import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

public class SaleResponse {

    private Long id;
    private Calendar date;
    private Status status;
    private Client client;

    public SaleResponse() {
    }

    public SaleResponse(Sale sale) {
        this.id = sale.getId();
        this.client = sale.getClient();
        this.date = sale.getDate();
        this.status = sale.getStatus();

    }

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

    public static List<SaleResponse> toListSaleResponse(List<Sale> sales) {
        return sales.stream().map(SaleResponse::new).collect(Collectors.toList());
    }
}
