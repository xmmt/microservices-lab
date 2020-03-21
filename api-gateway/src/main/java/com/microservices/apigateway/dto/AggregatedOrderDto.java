package com.microservices.apigateway.dto;

import java.util.List;

public class AggregatedOrderDto {

    private Integer id;
    private Integer totalAmount;
    private OrderStatus orderStatus;
    private String totalCost;

    private List<AggregatedOrderItemDro> items;

    public AggregatedOrderDto() {}

    public AggregatedOrderDto(OrderDto order, List<AggregatedOrderItemDro> items) {
        this.id = order.getId();
        this.totalAmount = order.getTotalAmount();
        this.orderStatus = order.getOrderStatus();
        this.totalCost = order.getTotalCost();
        this.items = items;
    }

    public Integer getId() {
        return id;
    }

    public Integer getTotalAmount() {
        return totalAmount;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public String getTotalCost() {
        return totalCost;
    }

    public List<AggregatedOrderItemDro> getItems() {
        return items;
    }
}
