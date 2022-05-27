package br.com.oobj.easybill.controller;

import br.com.oobj.easybill.dto.ClientRequest;
import br.com.oobj.easybill.dto.ClientResponse;
import br.com.oobj.easybill.dto.ProductResponse;
import br.com.oobj.easybill.model.Client;
import br.com.oobj.easybill.model.Product;
import br.com.oobj.easybill.repository.ClientRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

import static java.lang.constant.ConstantDescs.NULL;

@RestController
public class ClientAPIController {

    private ClientRepository clientRepository;

    public ClientAPIController(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @PostMapping("api/clients")
    public ResponseEntity<ClientRequest> newProduct(@RequestBody @Valid ClientRequest requisition, UriComponentsBuilder uriBuilder, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().build();
        }
        Client client = requisition.toClient();
        clientRepository.save(client);

        URI uri = uriBuilder.path("api/clients/{id}").buildAndExpand(client.getId()).toUri();

        return ResponseEntity.created(uri).body(new ClientRequest(client));
    }

    @GetMapping("api/clients/{id}")
    public ResponseEntity<ClientResponse> detail(@PathVariable Long id) {
        Optional<Client> client = clientRepository.findById(id);
        if (!client.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(new ClientResponse(client.get()));
    }

    @GetMapping("admin/clients")
    public List<ClientResponse> detailState(@RequestParam(required = false) String state) {
        if (state == null) {
            List<Client> clients = clientRepository.findAll();
            return ClientResponse.toListClientResponse(clients);
        }
        List<Client> clients = clientRepository.findByState(state);
        return ClientResponse.toListClientResponse(clients);
    }

}
