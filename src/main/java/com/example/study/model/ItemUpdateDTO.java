package com.example.study.model;

public class ItemUpdateDTO {
    private int price; // 클라이언트로부터 받은 새로운 가격
    private String description; // 새로운 설명

    public int getStartingPrice() {
        return price;
    }

    public void setStartingPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}