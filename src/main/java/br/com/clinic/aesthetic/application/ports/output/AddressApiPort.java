package br.com.clinic.aesthetic.application.ports.output;

import br.com.clinic.aesthetic.domain.Address;

public interface AddressApiPort {

    /**
     *
     * @param cep
     * @return
     */
    Address findAddressByZipCode(String cep) throws AddressNotFoundException, ApiException;
}
