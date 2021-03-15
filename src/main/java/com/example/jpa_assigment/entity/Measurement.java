package com.example.jpa_assigment.entity;

public enum Measurement {

    TBSP("tablespoon") , TSP("teaspoon"), G("gram"), HG("hectogram"), KG("kilogram"), ML("milliliter"), CL("centilitre"), DL("deciliter");
    private String valueName;

    Measurement(String valueName) {
        this.valueName = valueName;
    }

    public String getValueName() {
        return valueName;
    }
}
