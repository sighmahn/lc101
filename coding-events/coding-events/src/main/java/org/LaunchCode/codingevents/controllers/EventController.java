package org.LaunchCode.codingevents.controllers;

import org.LaunchCode.codingevents.data.EventRepository;
import org.LaunchCode.codingevents.models.EventType;
import org.LaunchCode.codingevents.models.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("events")
public class EventController {

    @Autowired
    private EventRepository eventRepository;



    @GetMapping
    public String displayAllEvents(Model model) {
        model.addAttribute("title", "All Events");
        model.addAttribute("events", eventRepository.findAll());
        return "events/index";
    }

    @GetMapping("create")
    public String displayCreateEventForm(Model model) {
        model.addAttribute("title", "Create Event");
        model.addAttribute(new Event());
        model.addAttribute("types", EventType.values());
        return "events/create";
    }

    @PostMapping("create")
    public String processCreateEventForm(@ModelAttribute @Valid Event newEvent,
                                         Errors errors, Model model) {
        if (errors.hasErrors()) {
            model.addAttribute("title", "Create Event");
            return "events/create";
        }

        eventRepository.save(newEvent);
        return "redirect:";
    }

    @GetMapping("delete")
    public String displayDeleteEventsForm(Model model) {
        model.addAttribute("title", "Delete Events");
        model.addAttribute("events", eventRepository.findAll());
        return "events/delete";
    }

    @PostMapping("delete")
    public String processDeleteEventsForm(@RequestParam(required = false) int[] eventIds) {

        if (eventIds != null) {
            for (int id : eventIds) {
                eventRepository.deleteById(id);
            }
        }

        return "redirect:";
    }

//    @GetMapping("edit/{eventId}")
//    public String displayEditForm(Model model, @PathVariable int eventId) {
//        //controller code will go here
//        Event event = EventData.getById(eventId);
//        model.addAttribute("event", event);
//        if(event != null) {
//            model.addAttribute("title", "Edit Event" + event.getName() + " (ID=" + event.getId() + ")");
//        }
//        return "events/edit";
//    }

//    @PostMapping("edit")
//    public String processEditForm(int eventId, String name, String description) {
//        // controller code will go here
//        Event event = eventRepository.findAll(eventId);
//        event.setName(name);
//        event.setDescription(description);
//        return "redirect:";
//    }
}