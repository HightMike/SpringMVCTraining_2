package ru.borisov;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.borisov.objects.User;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@SessionAttributes("user")
public class LoginController {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

    @RequestMapping(value = "/", method = RequestMethod.GET)//RequestMethod.GET - все входящие запросы по этому урлу.
    public ModelAndView main(@ModelAttribute User user, HttpSession session) {
        user.setName("InterestingName");
        return new ModelAndView("login", "user" ,user);
    }

    @RequestMapping(value = "/check-user", method = RequestMethod.POST) // форма всегда передается в виде post запроса. Любые пост запросы со страницы check-user.
    public String checkUser (@Valid @ModelAttribute("user") User user, BindingResult binding, Model model, ModelMap modelMap) {

        if (binding.hasErrors()) {
            return "login";
        }
        //model.addAttribute("user", user);
        return "main";
    }

    @RequestMapping(value = "/failed", method = RequestMethod.GET)//RequestMethod.GET - все входящие запросы по этому урлу.
    public ModelAndView failed() {
        return new ModelAndView("login-failed", "message", "Login Failed");
    }


    @RequestMapping(value = "/get-json-user", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public User getJsonUser(@PathVariable("name") String name, @PathVariable ("admin") boolean admin) {
        User user =  new User();
        user.setName(name);
        user.setAdmin(admin);
        return user;
    }

    @RequestMapping(value = "/put-json-user", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<String> setJsonUser(@RequestBody User user) {
        System.out.println(user.getName());

        LOGGER.info(user.getName());
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    } // не работает отображение, ошибка 415

}
