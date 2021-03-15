package com.example.jpa_assigment.repository;

import com.example.jpa_assigment.entity.Ingredient;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ingredientRepository extends CrudRepository<Ingredient, Integer> {

    Optional<Ingredient> findByIngredientName(String ingredientName);
}
