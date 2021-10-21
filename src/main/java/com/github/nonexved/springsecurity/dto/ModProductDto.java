package com.github.nonexved.springsecurity.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ModProductDto {

    private String name;

    private String code;

    private double price;

    private int amount;
}
