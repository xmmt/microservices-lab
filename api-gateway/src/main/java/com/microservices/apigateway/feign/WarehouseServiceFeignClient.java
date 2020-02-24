package com.microservices.apigateway.feign;

import com.microservices.apigateway.dto.ItemDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "warehouse-service")
public interface WarehouseServiceFeignClient {

    @GetMapping(path = "/warehouse/items/{id}")
    ResponseEntity<ItemDto> getItemById(@PathVariable("id") int id);
}
