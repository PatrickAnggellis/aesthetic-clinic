package br.com.clinic.aesthetic.infrastructure.adapters.output;

import br.com.clinic.aesthetic.application.ports.output.AddressApiPort;
import br.com.clinic.aesthetic.application.ports.output.AddressNotFoundException;
import br.com.clinic.aesthetic.application.ports.output.ApiException;
import br.com.clinic.aesthetic.domain.Address;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Component
public class AddressApiAdapter implements AddressApiPort {

    private final RestTemplate restTemplate;
    private final String apiUrl = "https://opencep.com/v1/";

    public AddressApiAdapter(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Address findAddressByZipCode(String cep) throws AddressNotFoundException, ApiException {
        String url = apiUrl + cep;
        try {
            Address address = restTemplate.getForObject(url, Address.class);
            if(address == null){
                throw new AddressNotFoundException("Address not found for zip code: " + cep);
            }
            return address;
        } catch (RestClientException e) {
            throw new ApiException("Error call a API address" + e.getMessage());
        }
    }
}
