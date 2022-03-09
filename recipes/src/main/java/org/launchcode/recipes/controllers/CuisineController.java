package org.launchcode.recipes.controllers;

import org.launchcode.recipes.models.Cuisine;
import org.launchcode.recipes.models.data.CuisineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("cuisines")
public class CuisineController {

    @Autowired
    private CuisineRepository cuisineRepository;

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

}
