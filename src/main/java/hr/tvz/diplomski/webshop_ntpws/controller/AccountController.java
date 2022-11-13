package hr.tvz.diplomski.webshop_ntpws.controller;

import hr.tvz.diplomski.webshop_ntpws.dto.request.UpdatePersonalInformationRequest;
import hr.tvz.diplomski.webshop_ntpws.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/account")
@CrossOrigin(origins = "http://localhost:4200")
public class AccountController {

    @Resource
    private UserService userService;

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public void updatePersonalInformation(@RequestBody UpdatePersonalInformationRequest updatePersonalInformationRequest) {
        userService.updateUserPersonalInformation(updatePersonalInformationRequest.getFirstName(),
                updatePersonalInformationRequest.getLastName(), updatePersonalInformationRequest.getPassword());
    }
}
