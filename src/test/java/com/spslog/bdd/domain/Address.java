package com.spslog.bdd.domain;

public record Address(
        String firstName,
        String lastName,
        String country,
        String street,
        String city,
        String state,
        String pinCode,
        String email
) {
}
