package com.github.nonexved.springsecurity.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AdminProductDto {

    private long id;

    private String name;

    private String code;

    private double price;

    private int amount;
}
