package hr.tvz.diplomski.webshop_ntpws.dto.request;

import hr.tvz.diplomski.webshop_ntpws.enumeration.DeliveryMode;
import hr.tvz.diplomski.webshop_ntpws.enumeration.PaymentMethod;
import lombok.Data;

@Data
public class CheckoutFormRequest {
    private String firstName;
    private String lastName;
    private String street;
    private String city;
    private String postcode;
    private DeliveryMode deliveryMode;
    private PaymentMethod paymentMethod;
}
