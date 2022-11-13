package hr.tvz.diplomski.webshop_ntpws.service;

import hr.tvz.diplomski.webshop_ntpws.domain.User;
import hr.tvz.diplomski.webshop_ntpws.dto.UserDto;

public interface UserService {
    UserDto getLoggedUser();
    void registerNewCustomer(String email, String password, String firstName, String lastName);
    void updateUserPersonalInformation(String firstName, String lastName, String password);

    User getLoggedUserModel();
}
