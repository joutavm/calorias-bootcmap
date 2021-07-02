package br.com.joao.calorias.models;

import java.util.List;
import java.util.Objects;

public class Food {

    private String name;
    private int calories;
    private List<Ingredient> ingredients;

    public Food(){

    }

    public Food(String name, int calories, List<Ingredient> ingredients) {
        this.name = name;
        this.calories = calories;
        this.ingredients = ingredients;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Food food = (Food) o;

        if (calories != food.calories) return false;
        if (!Objects.equals(name, food.name)) return false;
        return Objects.equals(ingredients, food.ingredients);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + calories;
        result = 31 * result + (ingredients != null ? ingredients.hashCode() : 0);
        return result;
    }
}
