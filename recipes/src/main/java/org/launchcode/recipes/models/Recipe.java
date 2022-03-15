package org.launchcode.recipes.models;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.List;

@Entity
public class Recipe extends AbstractEntity {

    /* FIELDS */
    @ManyToOne
    private Cuisine cuisine;

    @ManyToMany
    private List<Ingredient> ingredients;


    /* CONSTRUCTORS */
    public Recipe() { }

    public Recipe(Cuisine aCuisine, List<Ingredient> someIngredients) {
        super();
        this.cuisine = aCuisine;
        this.ingredients = someIngredients;
    }

    /* METHODS: Getters and Setters */

    public Cuisine getCuisine() {
        return cuisine;
    }

    public void setCuisine(Cuisine cuisine) {
        this.cuisine = cuisine;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }
}
