package com.foodplanner.project.Food;

public class Meal {
    private int id;
    private String title;
    // private String image; // image link
    private float pricePerServing;
    // private boolean cheap; 
    // private boolean vegan;
    // private boolean vegetarian;
    // private List<Ingredient> ingredients; 

    public Meal(int id, String title, float pricePerServing) {
        this.id = id;
        this.title = title;
        this.pricePerServing = pricePerServing;
    }

}
