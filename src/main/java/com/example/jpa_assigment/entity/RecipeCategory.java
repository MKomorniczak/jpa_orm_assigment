package com.example.jpa_assigment.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class RecipeCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int categoryId;
    private String category;

    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(name = "recipe_recipe_category",
            joinColumns = @JoinColumn(name = "category_id"),
            inverseJoinColumns = @JoinColumn(name = "recipe_id"))
    private List<Recipe> recipies;

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<Recipe> getRecipies() {
        return recipies;
    }

    public void setRecipies(List<Recipe> recipies) {
        this.recipies = recipies;
    }

    public RecipeCategory(int categoryId, String category, List<Recipe> recipies) {
        this.categoryId = categoryId;
        this.category = category;
        this.recipies = recipies;
    }

    public RecipeCategory(String category, List<Recipe> recipies) {
        this.category = category;
        this.recipies = recipies;
    }

    public RecipeCategory() {
    }

    public RecipeCategory(String category) {
        this.category = category;
    }

    public RecipeCategory(int categoryId, String category) {
        this.categoryId = categoryId;
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecipeCategory that = (RecipeCategory) o;
        return categoryId == that.categoryId && Objects.equals(category, that.category) && Objects.equals(recipies, that.recipies);
    }

    @Override
    public int hashCode() {
        return Objects.hash(categoryId, category, recipies);
    }
}
