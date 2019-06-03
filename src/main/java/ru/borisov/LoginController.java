package ru.borisov;

import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.borisov.objects.User;


@Controller
public class LoginController {

    @RequestMapping(value = "/", method = RequestMethod.GET)//RequestMethod.GET - все входящие запросы по этому урлу.
    public ModelAndView main() {
        return new ModelAndView("login", "user" ,new User());
    }

    @RequestMapping(value = "/check-user", method = RequestMethod.POST) // форма всегда передается в виде post запроса. Любые пост запросы со страницы check-user.
    public ModelAndView checkUser (@ModelAttribute ("user") User user) {
//        ModelAndView modelAndView = new ModelAndView(); // более длинный вариант
//        modelAndView.setViewName("main");
//        modelAndView.addObject("user", user);
//        return modelAndView;
        return new ModelAndView("main", "user", user);
    }

    @RequestMapping(value = "/failed", method = RequestMethod.GET)//RequestMethod.GET - все входящие запросы по этому урлу.
    public ModelAndView failed() {
        return new ModelAndView("login-failed", "message", "Login Failed");
    }


}
