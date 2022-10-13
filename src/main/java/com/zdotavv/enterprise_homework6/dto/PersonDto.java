package com.zdotavv.enterprise_homework6.dto;

import com.zdotavv.enterprise_homework6.model.Cart;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PersonDto {
    private Long idPerson;
    private String firstName;
    private String lastName;
    private String email;
    private List<Cart> carts;
}
