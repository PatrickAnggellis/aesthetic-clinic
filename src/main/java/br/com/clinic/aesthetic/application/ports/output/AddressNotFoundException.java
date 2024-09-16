package br.com.clinic.aesthetic.application.ports.output;

public class AddressNotFoundException extends Exception {
    public AddressNotFoundException(String message){
        super(message);
    }
}
