package me.juooon.datajpa;

import javax.persistence.Embeddable;

@Embeddable // Composite Value Type Mapping
public class Address {
    private String street;
    private String city;
    private String state;
    private String zipCode;
}
