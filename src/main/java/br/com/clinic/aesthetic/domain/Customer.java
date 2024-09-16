package br.com.clinic.aesthetic.domain;

import java.time.LocalDate;

public class Customer {

    private Long id;
    private String name;
    private String cpf;
    private String address;
    private LocalDate birthdayDate;
    private String email;
    private String phone;

    public Customer() {
    }

    public Customer(Long id, String name, String cpf, String address, LocalDate birthdayDate, String email,
            String phone) {
        Id = id;
        this.name = name;
        this.cpf = cpf;
        this.address = address;
        this.birthdayDate = birthdayDate;
        this.email = email;
        this.phone = phone;
    }

    public Long getId() {
        return Id;
    }

    public String getName() {
        return name;
    }

    public String getCpf() {
        return cpf;
    }

    public String getAddress() {
        return address;
    }

    public LocalDate getBirthdayDate() {
        return birthdayDate;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public void setId(Long id) {
        Id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setBirthdayDate(LocalDate birthdayDate) {
        this.birthdayDate = birthdayDate;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    

    

}
