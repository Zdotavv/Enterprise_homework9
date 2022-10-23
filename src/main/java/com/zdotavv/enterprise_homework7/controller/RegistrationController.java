package com.zdotavv.enterprise_homework7.controller;

import com.zdotavv.enterprise_homework7.dto.PersonDto;
import com.zdotavv.enterprise_homework7.model.Person;
import com.zdotavv.enterprise_homework7.service.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {

    private final PersonService personService;


    public RegistrationController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("personForm", new Person());
        return "registration";
    }

    @PostMapping("/registration")
    public String registerPerson(@ModelAttribute("personForm") PersonDto personDto, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "registration";
        }
        if (!personDto.getPassword().equals(personDto.getPasswordConfirm())) {
            model.addAttribute("passwordError", "Wrong password");
            return "registration";
        }
        if (personService.createPerson(personDto.getFirstName(), personDto.getLastName(), personDto.getEmail(), personDto.getUsername(), personDto.getPassword()) == null) {
            model.addAttribute("usernameError", "User with this username is already exists");
            return "registration";
        }
        return "redirect:/mainIndex";
    }

}
