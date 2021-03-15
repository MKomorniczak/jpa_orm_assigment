package com.example.jpa_assigment.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Recipe {
    @Id
    private int id;
    private String recipeName;
    @OneToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH},
    mappedBy = "recipe",
    orphanRemoval = true)
    private List<RecipeIngredient> recipeIngredients;
    @OneToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "recipe_instruction_instruction_id")
    private RecipeInstruction instruction;

    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(name = "recipe_recipe_category",
    joinColumns = @JoinColumn(name = "recipe_id"),
    inverseJoinColumns = @JoinColumn(name = "category_id"))
    private List<RecipeCategory> categories;

    public void addRecipeIngredient(RecipeIngredient recipeIngredient){
        if(recipeIngredients == null){
            recipeIngredients = new ArrayList<>();
        }
        recipeIngredients.add(recipeIngredient);
        recipeIngredient.setRecipe(this);
    }

    public void removeRecipeIngredient(RecipeIngredient recipeIngredient){
        if (recipeIngredients != null){
            recipeIngredients = new ArrayList<>();
        }
        if (recipeIngredient == null) throw new IllegalArgumentException("recipeIngredient is null");
        recipeIngredients.remove(recipeIngredient);
        recipeIngredient.setRecipe(null);
    }

    public void addRecipeCategory(RecipeCategory recipeCategory){
        if (categories == null){
            categories = new ArrayList<>();
        }
        categories.add(recipeCategory);
        recipeCategory.addRecipe(this);
    }

    public void removeRecipeCategory(RecipeCategory recipeCategory){
        if (categories != null){
            categories = new ArrayList<>();
        }
        if (recipeCategory == null) throw new IllegalArgumentException("recipeCategory is null");
        categories.remove(recipeCategory);
        recipeCategory.setRecipies(null);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public List<RecipeIngredient> getRecipeIngredients() {
        return recipeIngredients;
    }

    public void setRecipeIngredients(List<RecipeIngredient> recipeIngredients) {
        this.recipeIngredients = recipeIngredients;
    }

    public RecipeInstruction getInstruction() {
        return instruction;
    }

    public void setInstruction(RecipeInstruction instruction) {
        this.instruction = instruction;
    }

    public List<RecipeCategory> getCategories() {
        return categories;
    }

    public void setCategories(List<RecipeCategory> categories) {
        this.categories = categories;
    }

    public Recipe(int id, String recipeName, List<RecipeIngredient> recipeIngredients, RecipeInstruction instruction, List<RecipeCategory> categories) {
        this.id = id;
        this.recipeName = recipeName;
        this.recipeIngredients = recipeIngredients;
        this.instruction = instruction;
        this.categories = categories;
    }

    public Recipe(String recipeName, List<RecipeIngredient> recipeIngredients, RecipeInstruction instruction, List<RecipeCategory> categories) {
        this.recipeName = recipeName;
        this.recipeIngredients = recipeIngredients;
        this.instruction = instruction;
        this.categories = categories;
    }

    public Recipe() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recipe recipe = (Recipe) o;
        return id == recipe.id && Objects.equals(recipeName, recipe.recipeName) && Objects.equals(recipeIngredients, recipe.recipeIngredients) && Objects.equals(instruction, recipe.instruction) && Objects.equals(categories, recipe.categories);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, recipeName, recipeIngredients, instruction, categories);
    }


}
