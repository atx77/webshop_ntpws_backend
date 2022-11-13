package hr.tvz.diplomski.webshop_ntpws.dto.request;

import lombok.Data;

@Data
public class UpdatePersonalInformationRequest {
    private String firstName;
    private String lastName;
    private String password;
}
