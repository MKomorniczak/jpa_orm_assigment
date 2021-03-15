package com.example.jpa_assigment.repository;

import com.example.jpa_assigment.entity.RecipeIngredient;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class recipeIngredientRepositoryTest {
    @Autowired
    recipeIngredientRepository testObject;

    RecipeIngredient recipeIngredient;

    @BeforeEach
    public void setup(){
        recipeIngredient = new RecipeIngredient();
    }

}
