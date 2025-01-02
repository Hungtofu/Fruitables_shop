package Fruitables.shop.controller;

import Fruitables.shop.payload.RestResponse;
import Fruitables.shop.service.OrderStatusService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
@RequestMapping("/order_status")
public class OrderStatusController {
    private final OrderStatusService orderService;
    public OrderStatusController(OrderStatusService orderService)
    {
        this.orderService = orderService;
    }

    @GetMapping("/getall")
    public ResponseEntity<RestResponse<Object>> getAllOrdSta()
    {
        RestResponse<Object> response = new RestResponse<Object>();
        response.setData(orderService.getAllOrderStatus());
        return ResponseEntity.status(HttpStatus.OK.value()).body(response);
    }
}
