package microservicesnew.orders.dao;

import microservicesnew.orders.model.OrderDto;
import microservicesnew.orders.model.OrderItemDto;
import microservicesnew.orders.model.exceptions.DataIntegrityViolationException;
import microservicesnew.orders.model.Order;
import microservicesnew.orders.model.exceptions.ItemNotFoundException;

import java.util.ArrayList;

public interface OrderDao {



    default OrderDto addOrder(Order order) throws DataIntegrityViolationException {
        return null;
    }

    default Order getOrderById(int id) throws ItemNotFoundException {
        return null;
    }

    default ArrayList<OrderDto> getOrders() {
        return null;
    }

    default OrderDto setOrderStatus(Order order, String status) throws DataIntegrityViolationException, ItemNotFoundException {
        return null;
    }

    default OrderDto addItems(Order order, OrderItemDto item) throws DataIntegrityViolationException, ItemNotFoundException {
        return null;
    }

    default ArrayList<OrderItemDto> getOrderItems(Order order) throws ItemNotFoundException {
        return null;
    }
}
