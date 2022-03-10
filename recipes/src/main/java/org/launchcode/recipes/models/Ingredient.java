package org.launchcode.recipes.models;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Ingredient extends AbstractEntity {

    /* FIELDS */
    @ManyToMany (mappedBy = "ingredients")
    private List<Recipe> recipes = new ArrayList<>();

    @NotNull
    @Size(max = 255, message = "Description must be between less than 255 characters")
    private String description;


    /* CONSTRUCTORS */
    public Ingredient() { }


    /* METHODS: Getters and Setters */
    public List<Recipe> getRecipes() {
        return recipes;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
