package com.example.jpa_assigment.repository;

import com.example.jpa_assigment.entity.Recipe;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface recipeRepository extends CrudRepository<Recipe, Integer> {
    Optional<Recipe> findByRecipeName(String recipeName);
}
