package br.com.clinic.aesthetic.application.ports.output;

public class ApiException extends Exception{
    public ApiException(String message){
        super(message);
    }
}
