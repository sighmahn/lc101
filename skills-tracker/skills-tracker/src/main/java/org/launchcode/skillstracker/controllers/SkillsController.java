package org.launchcode.skillstracker.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SkillsController {

    @GetMapping("/")
    @ResponseBody
    public String skillslist() {
        return "<h1>Skills Tracker</h1>" +
                "<h2>These are some skills that I want to learn</h2>" +
                "<ol>" +
                "<li>React</li>" +
                "<li>Go</li>" +
                "<li>Scala</li>" +
                "</ol>";
    }

    @GetMapping("/form")
    @ResponseBody
    public String skillForm() {
        return "<form action='/form' method='post'>" +
                "<input type='text' name='name'>" +
                "<select name='skill0'>" +
                "<option value='Java'>Java</option>" +
                "<option value='Python'>Python</option>" +
                "<option value='Javascript'>" +
                "</select>" +
                "<select name='skill1'>" +
                "<option value='Java'>" +
                "<option value='Python'>" +
                "<option value='Javascript'>Javascript</option>" +
                "</select>" +
                "<select name='skill2'>" +
                "<option value='Java'>" +
                "<option value='Python'>" +
                "<option value='Javascript'>" +
                "</select>" +
    }
}
