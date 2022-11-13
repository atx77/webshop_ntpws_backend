package hr.tvz.diplomski.webshop_ntpws.converter;

import hr.tvz.diplomski.webshop_ntpws.domain.Address;
import hr.tvz.diplomski.webshop_ntpws.dto.AddressDto;
import org.springframework.core.convert.converter.Converter;

public class AddressToAddressDtoConverter implements Converter<Address, AddressDto> {

    @Override
    public AddressDto convert(Address source) {
        AddressDto addressDto = new AddressDto();
        addressDto.setFirstName(source.getFirstName());
        addressDto.setLastName(source.getLastName());
        addressDto.setStreet(source.getStreet());
        addressDto.setCity(source.getCity());
        addressDto.setPostcode(source.getPostcode());
        addressDto.setCountry(source.getCountry().getDescription());
        return addressDto;
    }
}
