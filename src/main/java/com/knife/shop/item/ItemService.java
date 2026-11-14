package com.knife.shop.item;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    public List<Item> findAll() {

        return itemRepository.findAll();

    }

    public void saveItem(String title, Integer price) {
        Item item = new Item();
        item.setTitle(title);
        item.setPrice(price);
        itemRepository.save(item);
    }

    public Optional<Item> findItem(Long id) {

        return itemRepository.findById(id);
    }

    public void editItem(Long id, String title, Integer price) {
        Item item = new Item();
        item.setId(id);
        item.setTitle(title);
        item.setPrice(price);
        itemRepository.save(item);
    }

    @Transactional
    public void deleteItem(Long id) {
        System.out.println(id);
        itemRepository.deleteById(id);
    }

}
