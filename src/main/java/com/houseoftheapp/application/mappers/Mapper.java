package com.houseoftheapp.application.mappers;


/**
 * Mapping Encapsulation DTO
 * Mapper will deal with Class A and Class B
 *
 *
 *
 */


public interface Mapper<A, B> {

    B mapTo(A a);

    A mapFrom(B b);

}
