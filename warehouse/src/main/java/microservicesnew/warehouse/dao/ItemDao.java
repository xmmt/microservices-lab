package microservicesnew.warehouse.dao;

import microservicesnew.warehouse.dto.ItemAmountDto;
import microservicesnew.warehouse.dto.ItemCreationDto;
import microservicesnew.warehouse.dto.ItemDto;

import java.util.List;

public interface ItemDao {

    ItemDto addItem(ItemCreationDto item);

    List<ItemDto> getAllItems();

    ItemDto getItemById(int id);

    ItemDto updateItemAmount(int id, ItemAmountDto itemAmountDto);
}
