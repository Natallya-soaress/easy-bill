package br.com.oobj.easybill.controller;

import br.com.oobj.easybill.dto.*;
import br.com.oobj.easybill.model.Client;
import br.com.oobj.easybill.model.Product;
import br.com.oobj.easybill.model.Sale;
import br.com.oobj.easybill.model.SaleItem;
import br.com.oobj.easybill.repository.ClientRepository;
import br.com.oobj.easybill.repository.ProductRepository;
import br.com.oobj.easybill.repository.SaleItemRepository;
import br.com.oobj.easybill.repository.SaleRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("api/sales")
public class SaleAPIController {

    private SaleItemRepository saleItemRepository;
    private ProductRepository productRepository;
    private ClientRepository clientRepository;
    private SaleRepository saleRepository;


    public SaleAPIController(SaleItemRepository saleItemRepository, ProductRepository productRepository, ClientRepository clientRepository, SaleRepository saleRepository) {
        this.saleItemRepository = saleItemRepository;
        this.productRepository = productRepository;
        this.clientRepository = clientRepository;
        this.saleRepository = saleRepository;
    }

    @PostMapping()
    @Transactional
    public ResponseEntity<SaleRequest> newSale(@RequestBody @Valid SaleRequest request, UriComponentsBuilder uriBuilder, BindingResult result) {

        if (result.hasErrors()) {
            return ResponseEntity.badRequest().build();
        }

        Sale sale = request.toSale(clientRepository);
        saleRepository.save(sale);

        List<SaleItem> items = new ArrayList<>();
        request.getItems().forEach(item ->
                items.add(item.toSaleItem(productRepository, sale))
        );

        saleItemRepository.saveAll(items);

        URI uri = uriBuilder.path("api/sales/{id}").buildAndExpand(sale.getId()).toUri();
        return ResponseEntity.created(uri).body(new SaleRequest(sale, request.getItems()));
    }

   @GetMapping("/{id}")
   public ResponseEntity<SaleResponse> detail(@PathVariable Long id) {
       Optional<Sale> optionalSale = saleRepository.findById(id);

       if (!optionalSale.isPresent()) {
           return ResponseEntity.notFound().build();
       }
       Sale sale = saleRepository.getById(id);
       List<SaleItem> saleItems = saleItemRepository.findBySaleItemSale(id);

       return ResponseEntity.ok(new SaleResponse(sale, saleItems));
   }

}
