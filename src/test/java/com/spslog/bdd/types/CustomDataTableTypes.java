package com.spslog.bdd.types;

import com.spslog.bdd.domain.Address;
import com.spslog.bdd.domain.Product;
import io.cucumber.java.DataTableType;

import java.util.List;
import java.util.Map;

public class CustomDataTableTypes {

    @DataTableType
    public Address addressEntry(Map<String, String> details) {
        return new Address(details.get("first_name"), details.get("last_name"), details.get("country"),
                details.get("street_address"), details.get("city"), details.get("state"), details.get("pin_code"),
                details.get("email"));
    }

    @DataTableType
    public Product productEntry(List<String> products) {
        // this regular expression takes in double quotes as well so replace it
        return new Product(products.get(0));
    }
}
