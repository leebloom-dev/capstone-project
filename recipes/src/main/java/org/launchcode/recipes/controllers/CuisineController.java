package org.launchcode.recipes.controllers;

import org.launchcode.recipes.models.Cuisine;
import org.launchcode.recipes.models.data.CuisineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("cuisines")
public class CuisineController {

    /* FIELDS */

    @Autowired
    private CuisineRepository cuisineRepository;


    /* CONTROLLER METHODS */

    @GetMapping
    public String index(Model model) {
        model.addAttribute("cuisines", cuisineRepository.findAll());
        return "cuisines/index";
    }

    @GetMapping("add")
    public String displayAddCuisineForm(Model model) {
        model.addAttribute(new Cuisine());
        return "cuisines/add";
    }

    @PostMapping("add")
    public String processAddCuisineForm(@ModelAttribute @Valid Cuisine newCuisine,
                                         Errors errors, Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Create Cuisine"); // added March 6
            return "cuisines/add";
        }

        cuisineRepository.save(newCuisine);

        return "redirect:";
    }

    @GetMapping("view/{cuisineId}")
    public String displayViewCuisine(Model model, @PathVariable int cuisineId) {

        Optional<Cuisine> optCuisine = cuisineRepository.findById(cuisineId);
        if (optCuisine.isPresent()) {
            Cuisine cuisine = (Cuisine) optCuisine.get();
            model.addAttribute("title", "Cuisine ID: " + cuisineId);
            model.addAttribute("cuisine", cuisine);
            return "cuisines/view";
        } else {
            return "redirect:../";
        }
    }

}
