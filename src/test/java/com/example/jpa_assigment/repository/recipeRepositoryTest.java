package com.example.jpa_assigment.repository;

import com.example.jpa_assigment.entity.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@DataJpaTest
public class recipeRepositoryTest {
    @Autowired
    recipeRepository testObject;

    Recipe recipe;


    @BeforeEach
    public void setup() {
        Ingredient ingredient = new Ingredient("pasta");
        RecipeIngredient something = new RecipeIngredient(ingredient, 1, Measurement.KG);
        RecipeInstruction instruction = new RecipeInstruction("manual");
        recipe = new Recipe("spaghetti", instruction);
        recipe.addRecipeIngredient(something);


        RecipeCategory spaghettiCategories = new RecipeCategory("spicy");
        recipe.addRecipeCategory(spaghettiCategories);


        Recipe result = testObject.save(recipe);
        System.out.println(result);

    }

    @Test
    public void test_find_by_recipe_name() {
        Optional<Recipe> result = testObject.findByRecipeName("spaghetti");

        Assertions.assertEquals("spaghetti", result.get().getRecipeName());


    }

}
