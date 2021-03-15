package com.example.jpa_assigment.repository;

import com.example.jpa_assigment.entity.Ingredient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

@DataJpaTest
public class ingredientRepositoryTest {
    @Autowired
    ingredientRepository testObject;


    Ingredient ingredient;
    @BeforeEach
    public void setup(){
        ingredient = new Ingredient("chili");
        testObject.save(ingredient);
    }

    @Test
    public void test_find_by_id(){
        Optional<Ingredient> result = testObject.findById(2);
        Assertions.assertTrue(result.isPresent());
        Assertions.assertEquals("chili", result.get().getIngredientName());
        System.out.println("-------------------------------------------");
        System.out.println(result.toString());
    }

    @Test
    public void test_find_by_ingredient_name(){
        Optional<Ingredient> result = testObject.findByIngredientName("chili");
        Assertions.assertEquals("chili", result.get().getIngredientName());
        System.out.println("------------------------------------------");
        System.out.println(result.toString());
    }



}
