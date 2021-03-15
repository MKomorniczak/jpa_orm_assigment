package com.example.jpa_assigment.repository;

import com.example.jpa_assigment.entity.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class recipeRepositoryTest {
    @Autowired
    recipeRepository testObject;

    Recipe recipe;


    @BeforeEach
    public void setup() {
        List<RecipeIngredient> spaghettiIngredients = new ArrayList<>();
        Ingredient ingredient = new Ingredient("pasta");
        RecipeIngredient something = new RecipeIngredient(ingredient, 1, Measurement.KG);
        spaghettiIngredients.add(something);
        System.out.println(ingredient);
        System.out.println(something);
        System.out.println(spaghettiIngredients);
        RecipeInstruction instruction = new RecipeInstruction("manual");
        List<RecipeCategory> categories = new ArrayList<>();

        //List<Recipe> recipeList = new ArrayList<>();
   /*     Recipe extraRecipe = new Recipe(2, "extra recipe", spaghettiIngredients, instruction, categories);
        recipeList.add(extraRecipe);*/


        RecipeCategory spaghettiCategories = new RecipeCategory(1, "spicy");
        categories.add(spaghettiCategories);
     /*   RecipeCategory extraCategory = new RecipeCategory(2, "basic", recipeList);
        categories.add(spaghettiCategories);
        categories.add(extraCategory);*/


        Recipe spaghettiRecipe = new Recipe( "spaghetti", spaghettiIngredients, instruction, categories);
        Recipe result = testObject.save(spaghettiRecipe);
        System.out.println(result);

    }
    @Test
    public void test_find_by_recipe_name(){
        /*Optional<Recipe> result = testObject.findByRecipeName("spaghetti");
        Assertions.assertEquals("spaghetti", result.get().getRecipeName());
        System.out.println("----------------------");
        System.out.println(result.toString());*/

    }

}
