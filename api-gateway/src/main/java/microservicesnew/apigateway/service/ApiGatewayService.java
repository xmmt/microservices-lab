package microservicesnew.apigateway.service;

import microservicesnew.apigateway.dto.*;
import microservicesnew.apigateway.feign.OrderServiceFeignClient;
import microservicesnew.apigateway.feign.WarehouseServiceFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class ApiGatewayService {

    @Autowired
    private WarehouseServiceFeignClient warehouseServiceFeignClient;

    @Autowired
    private OrderServiceFeignClient orderServiceFeignClient;

    @Autowired
    public ApiGatewayService() {}

    public AggregatedOrderDto getAggregatedOrder(int id) {
        ResponseEntity<OrderDto> orderDtoResponseEntity = orderServiceFeignClient.getItemById(id);
        OrderDto orderDto = orderDtoResponseEntity.getBody();

        List<AggregatedOrderItemDro> items = new ArrayList<>();
        for (OrderItemDto orderItemDto : orderDto.getItems()) {
            ItemDto itemDto = warehouseServiceFeignClient.getItemById(orderItemDto.getItemId()).getBody();
            items.add(new AggregatedOrderItemDro(itemDto, orderItemDto));
        }

        return new AggregatedOrderDto(orderDto, items);
    }
}
