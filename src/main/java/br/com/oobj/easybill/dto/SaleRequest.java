package br.com.oobj.easybill.dto;

import br.com.oobj.easybill.enums.Status;
import br.com.oobj.easybill.model.Sale;
import br.com.oobj.easybill.repository.ClientRepository;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

public class SaleRequest {

    @NotNull
    private Long clientId;

    @NotEmpty
    private List<SaleItemRequest> items;

    public SaleRequest() {
    }

    public SaleRequest(Sale sale, List<SaleItemRequest> items) {
        this.clientId = sale.getClient().getId();
        this.items = items;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public List<SaleItemRequest> getItems() {
        return items;
    }

    public void setItems(List<SaleItemRequest> items) {
        this.items = items;
    }



    public Sale toSale(ClientRepository clientRepository){

        Sale sale = new Sale();

        sale.setClient(clientRepository.getById(clientId));
        sale.setStatus(Status.MADE);
        sale.setDate(LocalDateTime.now());

        return  sale;
    }
}
