package com.example.addressbook.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
public class AddressBookDTO {
    @NotEmpty(message="First name cant be empty")
    @Pattern(regexp="^[a-zA-Z]{3,10}$",message="Please Enter correct first name")
    private String firstName;

    @NotEmpty(message="Last name cant be empty")
    @Pattern(regexp="^[a-zA-Z]{3,10}$",message="Please Enter correct last name")
    private String lastName;



    @NotNull(message="Phone number cant be empty")
    //@Pattern(regexp = "^[0-9]{10}$", message = "Please enter a valid phone number")
    private Long phoneNumber;

    @NotEmpty(message="city cant be empty")
    private String city;

    @NotEmpty(message="State cant be empty")
    private String state;

    @NotNull(message="Zip code cant be empty")
    // @Pattern(regexp = "^[0-9]{6}$", message = "Please enter a valid zip code")
    private Integer zip;

    public AddressBookDTO() {
        super();
    }
}