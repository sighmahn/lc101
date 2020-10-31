package org.LaunchCode.codingevents.controllers;

import org.LaunchCode.codingevents.data.EventCategoryRepository;
import org.LaunchCode.codingevents.models.EventCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("eventcategories")
public class EventCategoryController {

    @Autowired
    private EventCategoryRepository eventCategoryRepository;

    @GetMapping("")
    public String displayAllEventsCategories(Model model) {
        model.addAttribute("title", "All Categories");
        model.addAttribute("eventCategories", eventCategoryRepository.findAll());
        return "eventcategories/index";
    }

    @GetMapping("/create")
    public String renderCreateEventCategoryForm(Model model) {
        model.addAttribute("title", "Create Categories");
        model.addAttribute("category", new EventCategory());
        return "eventcategories/create";
    }

    @PostMapping("/create")
    public String processCreateEventCategoryForm(@ModelAttribute("category") @Valid EventCategory newCategory, Errors errors, Model model) {

        if(errors.hasErrors()) {
            model.addAttribute("title", "Create Categories");
            model.addAttribute("category", newCategory);
            return "eventcategories/create";
        }
        eventCategoryRepository.save(newCategory);
        return "redirect:";
    }

}
