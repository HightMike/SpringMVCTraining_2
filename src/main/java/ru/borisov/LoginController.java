package ru.borisov;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.borisov.objects.User;

import javax.validation.Valid;

@Controller
public class LoginController {

    @RequestMapping(value = "/", method = RequestMethod.GET)//RequestMethod.GET - все входящие запросы по этому урлу.
    public ModelAndView main() {
        return new ModelAndView("login", "user" ,new User());

    }

    @RequestMapping(value = "/check-user", method = RequestMethod.POST) // форма всегда передается в виде post запроса. Любые пост запросы со страницы check-user.
    public String checkUser (@Valid @ModelAttribute("user") User user, BindingResult binding, Model model) {

        if (binding.hasErrors()) {
            return "login";
        }
        model.addAttribute("user", user);
        return "main";
    }

    @RequestMapping(value = "/failed", method = RequestMethod.GET)//RequestMethod.GET - все входящие запросы по этому урлу.
    public ModelAndView failed() {
        return new ModelAndView("login-failed", "message", "Login Failed");
    }


    @RequestMapping(value = "/get-json-user", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public User getJsonUser(@RequestParam("name") String name) {
        User user =  new User();
        user.setName(name);
        return user;
    }

}
