package com.foodplanner.project.Food;

public class Ingredient {
    private int id;
    private String name;
    // private double amount;
    // private String unit; 
    // private double estimatedCost;
    // private String costUnit; 
    // public Ingredient(int id, String name, double amount, String unit, double estimatedCost) {
    //     this.id = id;
    //     this.name = name;
    //     this.amount = amount;
    //     this.unit = unit;
    //     this.estimatedCost = estimatedCost;
    // }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    // public void setAmount(double amount) {
    //     this.amount = amount;
    // }

    // public void setUnit(String unit) {
    //     this.unit = unit;
    // }

    // public void setEstimatedCost(double estimatedCost) {
    //     this.estimatedCost = estimatedCost;
    // }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }


    
}
