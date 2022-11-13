package hr.tvz.diplomski.webshop_ntpws.controller;

import hr.tvz.diplomski.webshop_ntpws.dto.OrderDto;
import hr.tvz.diplomski.webshop_ntpws.dto.request.CheckoutFormRequest;
import hr.tvz.diplomski.webshop_ntpws.service.OrderService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/order")
@CrossOrigin(origins = "http://localhost:4200")
public class OrderController {

    @Resource
    OrderService orderService;

    @RequestMapping(method = RequestMethod.POST)
    public OrderDto createOrderFromCart(@RequestBody CheckoutFormRequest checkoutFormRequest) {
        return orderService.createOrder(checkoutFormRequest.getFirstName(), checkoutFormRequest.getLastName(),
                checkoutFormRequest.getStreet(), checkoutFormRequest.getCity(), checkoutFormRequest.getPostcode(),
                checkoutFormRequest.getDeliveryMode(), checkoutFormRequest.getPaymentMethod());
    }

    @RequestMapping(value = "/get-all", method = RequestMethod.GET)
    public List<OrderDto> getAllOrdersForCustomer() {
        return orderService.getOrdersForLoggedCustomer();
    }

    @RequestMapping(value = "/{code}", method = RequestMethod.GET)
    public OrderDto getOrderForCode(@PathVariable("code") String code) {
        return orderService.getByCode(code);
    }
}
