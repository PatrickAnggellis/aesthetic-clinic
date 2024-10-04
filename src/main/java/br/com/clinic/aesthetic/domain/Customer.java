package br.com.clinic.aesthetic.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDate;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Name is mandatory.")
    private String name;
    @NotBlank(message = "CPF is mandatory.")
    @Pattern(regexp = "\\d{11}", message = "CPF must contain 11 digits")
    private String cpf;
    private LocalDate birthdayDate;

    @NotBlank(message = "O email não pode estar vazio")
    @Email
    private String email;
    private String phone;
    @Embedded
    private Address address;

    public Customer() {
    }

    public Customer(Long id, String name, String cpf, LocalDate birthdayDate, String email, String phone, Address address) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.birthdayDate = birthdayDate;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCpf() {
        return cpf;
    }

    public Address getAddress() {
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
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setAddress(Address address) {
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
