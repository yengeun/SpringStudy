package com.example.study.service;

import com.example.study.entity.Item;
import com.example.study.repository.ItemRepository;
import com.example.study.model.AddItemInput;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;

@Service
public class ItemService {
    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository){
        this.itemRepository = itemRepository;
    }


    public long addItem(AddItemInput input) {
       Item item = Item.builder()
                .name(input.getName().toString())
                .description(input.getDescription().toString())
                .startingPrice((int) input.getStartingPrice())
                .build();
        Item saved = itemRepository.save(item);
        return saved.getId();
    }

}
