package com.example.study.controller.item;


import com.example.study.entity.Item;
import com.example.study.model.AddItemInput;
import com.example.study.model.ItemUpdateDTO;
import com.example.study.repository.ItemRepository;
import com.example.study.service.ItemService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
public class ItemController {

    @Autowired
    private ItemRepository itemRepository;
    private ItemService itemService;

    ItemController(ItemService itemService,ItemRepository itemRepository){
        this.itemService=itemService;
        this.itemRepository=itemRepository;
    }

    @GetMapping("/items")
    public List<Item> getAllBooks() {
        List<Item> books = itemRepository.findAll();
        return books;
    }
//
//    @PostMapping
//    public ResponseEntity<Item> addItem(@RequestBody Item item) {
//        Item savedItem = ItemRepository.save(item);
//        return ResponseEntity.ok(savedItem);
//    }


    @PostMapping("/auction")
    public long addItem(@RequestBody @Valid AddItemInput input){
        long id=itemService.addItem(input);
        return id;
    }

    @PutMapping("/items/{itemId}")
    public ResponseEntity<?> updateItem(@PathVariable Long itemId, @RequestBody ItemUpdateDTO itemUpdateDTO) {
        Item item = itemRepository.findById(itemId)
                .orElseThrow(() -> new RuntimeException("Item not found"));

        if (item.getStartingPrice() < itemUpdateDTO.getStartingPrice()) {
            item.setStartingPrice(itemUpdateDTO.getStartingPrice());
            item.setDescription(itemUpdateDTO.getDescription());
            itemRepository.save(item);
            return ResponseEntity.ok(item);
        } else {
            return ResponseEntity.badRequest().body("새로운 가격은 기존 가격보다 높아야 합니다.");
        }
    }
}