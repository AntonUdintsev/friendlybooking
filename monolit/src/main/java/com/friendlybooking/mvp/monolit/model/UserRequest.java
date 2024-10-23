package com.friendlybooking.mvp.monolit.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserRequest {
    private String phoneNumber;
    private String name;
}
