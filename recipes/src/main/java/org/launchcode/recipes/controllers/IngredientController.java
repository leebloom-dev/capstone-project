package org.launchcode.recipes.controllers;

import org.launchcode.recipes.models.Ingredient;
import org.launchcode.recipes.models.data.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("ingredients")
public class IngredientController {

    @Autowired
    private IngredientRepository ingredientRepository;

    @GetMapping("")
    public String index(Model model) {
        model.addAttribute("ingredients", ingredientRepository.findAll());
        return "ingredients/index";
    }

    @GetMapping("add")
    public String displayAddIngredientForm(Model model) {
        model.addAttribute(new Ingredient());
        return "ingredients/add";
    }

    @PostMapping("add")
    public String processAddIngredientForm(@ModelAttribute @Valid Ingredient newIngredient,
                                           Errors errors,
                                           Model model) {
        if (errors.hasErrors()) {
            model.addAttribute("title", "Create Ingredient");
            return "ingredients/add";
        }

        ingredientRepository.save(newIngredient);

        return "redirect:";
    }

    @GetMapping("view/{ingredientId}")
    public String displayViewIngredient(Model model,
                                        @PathVariable int ingredientId) {

        Optional optIngredient = ingredientRepository.findById(ingredientId);

        if (optIngredient.isPresent()) {
            Ingredient ingredient = (Ingredient) optIngredient.get();
            model.addAttribute("ingredient", ingredient);
            return "ingredients/view";
        } else {
            return "redirect:../";
        }
    }

}
