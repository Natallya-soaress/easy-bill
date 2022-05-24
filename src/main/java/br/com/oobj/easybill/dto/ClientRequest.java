package br.com.oobj.easybill.dto;

import br.com.oobj.easybill.model.Client;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class ClientRequest {


    @NotBlank
    private String name;

    @NotBlank
    @Length(min=11, max=11)
    private String cpf;

    @NotBlank
    @Length(min=11, max=11)
    private String phoneNumber;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String street;

    @NotBlank
    private  String number;


    private String complement;

    @NotBlank
    private String district;

    @NotBlank
    private String city;

    @NotBlank
    private String state;

    public ClientRequest(Client client) {
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

    public ClientRequest() {
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

    public Client toClient(){
        Client client = new Client();

        client.setName(name);
        client.setCpf(cpf);
        client.setEmail(email);
        client.setPhoneNumber(phoneNumber);
        client.setCity(city);
        client.setComplement(complement);
        client.setNumber(number);
        client.setState(state);
        client.setDistrict(district);
        client.setComplement(complement);

        return client;
    }
}
