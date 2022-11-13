package hr.tvz.diplomski.webshop_ntpws.service;

import hr.tvz.diplomski.webshop_ntpws.dto.OrderDto;
import hr.tvz.diplomski.webshop_ntpws.enumeration.DeliveryMode;
import hr.tvz.diplomski.webshop_ntpws.enumeration.PaymentMethod;

import java.util.List;

public interface OrderService {
    OrderDto createOrder(String firstName, String lastName, String street, String city, String postcode,
                         DeliveryMode deliveryMode, PaymentMethod paymentMethod);

    OrderDto getByCode(String orderCode);

    List<OrderDto> getOrdersForLoggedCustomer();
}
