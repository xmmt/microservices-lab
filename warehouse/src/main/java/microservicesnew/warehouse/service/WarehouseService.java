package microservicesnew.warehouse.service;

import microservicesnew.warehouse.dao.ItemDao;
import microservicesnew.warehouse.dto.ItemAmountDto;
import microservicesnew.warehouse.dto.ItemCreationDto;
import microservicesnew.warehouse.dto.ItemDto;
import microservicesnew.warehouse.dto.OrderDto;
import microservicesnew.warehouse.model.OrderStatus;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WarehouseService {

    private final ItemDao itemDao;

    @Autowired
    public WarehouseService(@Qualifier("sqlite") ItemDao itemDao) {
        this.itemDao = itemDao;
    }

    public ItemDto addItem(ItemCreationDto item) {
        return itemDao.addItem(item);
    }

    public List<ItemDto> getAllItems() {
        return itemDao.getAllItems();
    }

    public ItemDto getItemById(int id) {
        return itemDao.getItemById(id);
    }

    public ItemDto updateItemAmount(int id, ItemAmountDto itemAmountDto) {
        return itemDao.updateItemAmount(id, itemAmountDto);
    }

    @Bean
    public Jackson2JsonMessageConverter converter() {
        return new Jackson2JsonMessageConverter();
    }

    @RabbitListener(queues = "order-warehouse")
    public void orderQueueConsumer(OrderDto orderDto) {
        OrderStatus orderStatus = orderDto.getOrderStatus();
        System.out.println(String.format("Order {%d} status changed to {%s}", orderDto.getId(), orderStatus));
        if (orderStatus == OrderStatus.PAID) {
            orderDto.getItems().forEach(orderItemDto -> {
                this.updateItemAmount(orderItemDto.getItemId(), new ItemAmountDto("available", -orderItemDto.getAmount()));
            });
        } else if (orderStatus == OrderStatus.CANCELLED) {
            orderDto.getItems().forEach(orderItemDto -> {
                this.updateItemAmount(orderItemDto.getItemId(), new ItemAmountDto("available", orderItemDto.getAmount()));
            });
        } else if (orderStatus == OrderStatus.COMPLETED) {
            orderDto.getItems().forEach(orderItemDto -> {
                this.updateItemAmount(orderItemDto.getItemId(), new ItemAmountDto("actual", -orderItemDto.getAmount()));
            });
        }
    }
}
