package br.com.oobj.easybill.dto;

import br.com.oobj.easybill.model.Address;
import br.com.oobj.easybill.model.Client;
import br.com.oobj.easybill.model.Product;

import java.util.List;
import java.util.stream.Collectors;

public class ClientResponse {

    private String name;
    private String cpf;
    private String phoneNumber;
    private String email;
    private String street;
    private  String number;
    private String complement;
    private String district;
    private String city;
    private String state;

    public ClientResponse(Client client) {
        this.name = client.getName();
        this.email = client.getEmail();
        this.cpf = client.getCpf();
        this.phoneNumber = client.getPhoneNumber();


        this.complement = client.getAddress().getComplement();
        this.city = client.getAddress().getCity();
        this.number =client.getAddress().getNumber();
        this.district = client.getAddress().getDistrict();
        this.state = client.getAddress().getState();
        this.street = client.getAddress().getStreet();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public static List<ClientResponse> toListClientResponse(List<Client> clients) {
        return clients.stream().map(ClientResponse::new).collect(Collectors.toList());
    }
}
