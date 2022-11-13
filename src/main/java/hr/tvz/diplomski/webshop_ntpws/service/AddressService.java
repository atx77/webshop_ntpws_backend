package hr.tvz.diplomski.webshop_ntpws.service;

import hr.tvz.diplomski.webshop_ntpws.domain.Address;
import hr.tvz.diplomski.webshop_ntpws.domain.User;
import hr.tvz.diplomski.webshop_ntpws.enumeration.CountryEnum;

public interface AddressService {
    Address createNewAddressForUser(String firstName, String lastName, String street, String city, String postcode,
                                    CountryEnum country, User user);
}
