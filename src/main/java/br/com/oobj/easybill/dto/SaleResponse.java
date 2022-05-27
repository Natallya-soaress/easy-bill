package br.com.oobj.easybill.dto;

import br.com.oobj.easybill.enums.Status;
import br.com.oobj.easybill.model.Sale;
import br.com.oobj.easybill.model.SaleItem;

import java.time.LocalDateTime;
import java.util.List;

public class SaleResponse {

    private Long id;
    private LocalDateTime date;
    private Status status;
    private Long clientId;
    private List<SaleItemResponse> items;

    public SaleResponse() {
    }

    public SaleResponse(Sale sale, List<SaleItem> items) {
        this.id = sale.getId();
        this.clientId = sale.getClient().getId();
        this.date = sale.getDate();
        this.status = sale.getStatus();
        this.items = SaleItemResponse.toListSaleItemResponse(items);
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public List<SaleItemResponse> getItems() {
        return items;
    }

    public void setItems(List<SaleItemResponse> items) {
        this.items = items;
    }
}
