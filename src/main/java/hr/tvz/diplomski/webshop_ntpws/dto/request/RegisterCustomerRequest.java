package hr.tvz.diplomski.webshop_ntpws.dto.request;

import lombok.Data;

@Data
public class RegisterCustomerRequest {
    private String email;
    private String password;
    private String firstName;
    private String lastName;
}
