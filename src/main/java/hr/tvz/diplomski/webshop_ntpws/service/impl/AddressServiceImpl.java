package hr.tvz.diplomski.webshop_ntpws.service.impl;

import hr.tvz.diplomski.webshop_ntpws.domain.Address;
import hr.tvz.diplomski.webshop_ntpws.domain.User;
import hr.tvz.diplomski.webshop_ntpws.enumeration.CountryEnum;
import hr.tvz.diplomski.webshop_ntpws.repository.AddressRepository;
import hr.tvz.diplomski.webshop_ntpws.service.AddressService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AddressServiceImpl implements AddressService {

    @Resource
    private AddressRepository addressRepository;

    @Override
    public Address createNewAddressForUser(String firstName, String lastName, String street, String city, String postcode,
                                           CountryEnum country, User user) {
        Address address = new Address();
        address.setFirstName(firstName);
        address.setLastName(lastName);
        address.setUser(user);
        address.setCountry(country);
        address.setCity(city);
        address.setPostcode(postcode);
        address.setStreet(street);
        addressRepository.save(address);
        return address;
    }
}
