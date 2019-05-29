package ru.borisov;

import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Locale;

@Controller
public class MainController {

    @RequestMapping(value = "/123", method = RequestMethod.GET)
    public String home(Model model) {
        model.addAttribute("thispage");
        return "home";
    }

}
