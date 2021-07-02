package br.com.joao.calorias.models;

import org.springframework.boot.autoconfigure.condition.ConditionalOnNotWebApplication;

import java.util.List;

public class FoodForm {

    private String name;
    private List<Ingredient> ingredients;

    public void setName(String name) {
        this.name = name;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    private int totalCaloria(){
        return ingredients.stream().mapToInt(Ingredient::getCalories).sum();
    }

    public Food convert(){
        return new Food(name, totalCaloria(), ingredients);
    }

}
