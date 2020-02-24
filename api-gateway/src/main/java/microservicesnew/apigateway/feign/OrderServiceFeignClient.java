package microservicesnew.apigateway.feign;

import microservicesnew.apigateway.dto.OrderDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "order-service")
public interface OrderServiceFeignClient {

    @GetMapping(path = "/orders/{id}")
    ResponseEntity<OrderDto> getItemById(@PathVariable("id") int id);
}
