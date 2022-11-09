package hr.tvz.diplomski.webshop_ntpws.converter;

import hr.tvz.diplomski.webshop_ntpws.domain.User;
import hr.tvz.diplomski.webshop_ntpws.dto.UserDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserToUserDtoConverter implements Converter<User, UserDto> {

    @Override
    public UserDto convert(User source) {
        UserDto userDto = new UserDto();
        userDto.setEmail(source.getEmail());
        userDto.setFirstName(source.getFirstName());
        userDto.setLastName(source.getLastName());
        return userDto;
    }
}
