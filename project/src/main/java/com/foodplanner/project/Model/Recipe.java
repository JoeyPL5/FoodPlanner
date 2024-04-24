package com.foodplanner.project.Model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dbID;

    private int id; // ID provided by the API
    private String title;
    private String image;
    private float pricePerServing;
    private boolean cheap; 
    private boolean vegan;
    private boolean vegetarian;
    private List<Ingredient> extendedIngredients;

    // Constructors
    public Recipe(int id, String title, String image, float pricePerServing, boolean cheap, boolean vegan, boolean vegetarian, List<Ingredient> extendedIngredients) {
        this.id = id;
        this.title = title;
        this.image = image;
        this.pricePerServing = pricePerServing;
        this.cheap = cheap;
        this.vegan = vegan;
        this.vegetarian = vegetarian;
        this.extendedIngredients = extendedIngredients;
    }

    public Recipe() {} // default
    
    // Getters
    public Long getdbId() {
        return this.dbID;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getImage() {
        return image;
    }

    public float getPricePerServing() {
        return pricePerServing;
    }

    public boolean isCheap() {
        return cheap;
    }

    public boolean isVegan() {
        return vegan;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    public List<Ingredient> getExtendedIngredients() {
        return extendedIngredients;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setPricePerServing(float pricePerServing) {
        this.pricePerServing = pricePerServing;
    }

    public void setCheap(boolean cheap) {
        this.cheap = cheap;
    }

    public void setVegan(boolean vegan) {
        this.vegan = vegan;
    }

    public void setVegetarian(boolean vegetarian) {
        this.vegetarian = vegetarian;
    }

    public void setExtendedIngredients(List<Ingredient> extendedIngredients) {
        this.extendedIngredients = extendedIngredients;
    }
}
