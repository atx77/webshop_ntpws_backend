package hr.tvz.diplomski.webshop_ntpws.service.impl;

import hr.tvz.diplomski.webshop_ntpws.domain.User;
import hr.tvz.diplomski.webshop_ntpws.dto.UserDto;
import hr.tvz.diplomski.webshop_ntpws.enumeration.UserType;
import hr.tvz.diplomski.webshop_ntpws.repository.UserRepository;
import hr.tvz.diplomski.webshop_ntpws.service.UserService;
import org.springframework.core.convert.ConversionService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserRepository userRepository;

    @Resource
    private ConversionService conversionService;

    @Override
    public UserDto getLoggedUser() {
        return conversionService.convert(userRepository.findByEmailEquals(getLoggedUserUsername()).orElse(null), UserDto.class);
    }

    @Override
    public void registerNewCustomer(String email, String password, String firstName, String lastName) {
        User user = new User();
        user.setEmail(email);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setPassword(BCrypt.hashpw(password, BCrypt.gensalt(10)));
        user.setType(UserType.CUSTOMER);

        userRepository.save(user);
    }

    private String getLoggedUserUsername() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication.getPrincipal() instanceof UserDetails) {
            return ((UserDetails)authentication.getPrincipal()).getUsername();
        }
        return null;
    }
}
