package com.spslog.bdd.types;

import com.spslog.bdd.domain.Product;
import io.cucumber.java.ParameterType;

public class CustomParameterTypes {

    @ParameterType(".*")
    public Product product(String name) {
        // this regular expression takes in double quotes as well so replace it
        return new Product(name.replace("\"", ""));
    }
}
