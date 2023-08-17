package com.cydeo.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "items")
@Data
@NoArgsConstructor
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String code;

    @ManyToMany(mappedBy = "itemList")  //no rules for the ownership. we pick Cart here. "cart has items".
    private List<Cart> cart;    //Set has advantage over List<> in ManyToMany

    public Item(String name, String code) {
        this.name = name;
        this.code = code;
    }
}
