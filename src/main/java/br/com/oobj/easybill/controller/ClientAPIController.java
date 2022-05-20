package br.com.oobj.easybill.controller;

import br.com.oobj.easybill.dto.ClientRequest;
import br.com.oobj.easybill.dto.ClientResponse;
import br.com.oobj.easybill.model.Client;
import br.com.oobj.easybill.repository.ClientRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

@RestController
public class ClientAPIController {

    private ClientRepository clientRepository;

    public ClientAPIController(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @PostMapping("api/clients")
    public ResponseEntity<ClientRequest> newProduct(@RequestBody @Valid ClientRequest requisition, UriComponentsBuilder uriBuilder, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(new ClientRequest());
        }
        Client client = requisition.toClient();
        clientRepository.save(client);

        URI uri = uriBuilder.path("products/{id}").buildAndExpand(client.getId()).toUri();

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
}
