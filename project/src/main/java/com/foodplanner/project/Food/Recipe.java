package com.foodplanner.project.Food;

public class Recipe {
    private int id;
    private String title;
    // private String image; // image link
    // private float pricePerServing;
    // private boolean cheap; 
    // private boolean vegan;
    // private boolean vegetarian;
    // private List<Ingredient> ingredients; 

    public Recipe(int id, String title, float pricePerServing) {
        this.id = id;
        this.title = title;
        // this.pricePerServing = pricePerServing;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    // public float getPricePerServing() {
    //     return pricePerServing;
    // }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    // public void setPricePerServing(float pricePerServing) {
    //     this.pricePerServing = pricePerServing;
    // }
}
