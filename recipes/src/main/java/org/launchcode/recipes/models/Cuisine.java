package org.launchcode.recipes.models;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Cuisine extends AbstractEntity {

    /* FIELDS */
    @NotBlank (message = "Name is required")
    @Size (min = 3, max = 100, message = "Location must be between 3 and 100 characters")
    private String location;

    @OneToMany
    @JoinColumn (name = "cuisine_id")
    // represent the list of all items in a given recipe
    private List<Recipe> recipes = new ArrayList<>();

    // constructor for Hibernate to create an object
    public Cuisine() { }

    /* METHOD: GETTERS and SETTERS */

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
