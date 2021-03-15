package com.example.jpa_assigment.repository;

import com.example.jpa_assigment.entity.RecipeIngredient;
import org.springframework.data.repository.CrudRepository;

public interface recipeIngredientRepository extends CrudRepository<RecipeIngredient, String> {

}
