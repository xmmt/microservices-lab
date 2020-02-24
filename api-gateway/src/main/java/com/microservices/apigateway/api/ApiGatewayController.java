package com.microservices.apigateway.api;

import com.microservices.apigateway.dto.AggregatedOrderDto;
import com.microservices.apigateway.service.ApiGatewayService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api")
public class ApiGatewayController {
    private final ApiGatewayService apiGatewayService;

    public ApiGatewayController(ApiGatewayService apiGatewayService) {
        this.apiGatewayService = apiGatewayService;
    }

    @GetMapping(path = "/orders/{id}")
    public AggregatedOrderDto getAggregatedOrder(@PathVariable int id) {
        return apiGatewayService.getAggregatedOrder(id);
    }
}
