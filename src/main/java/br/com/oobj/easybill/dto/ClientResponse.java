package br.com.oobj.easybill.dto;

import br.com.oobj.easybill.model.Client;

public class ClientResponse {

    private Long id;
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
        this.complement = client.getComplement();
        this.city = client.getCity();
        this.number = client.getNumber();
        this.district = client.getDistrict();
        this.state = client.getState();
        this.street = client.getStreet();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}
