package com.dinesh.heroku.Controller;

import com.dinesh.heroku.Model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class HomeController {

    @RequestMapping("/page")
    public String home_page(Model model){
        model.addAttribute("user",new User());
        return "form";
    }

    @RequestMapping("/login")
    public String login_page(Model model){
//        model.addAttribute("user",new User());
        return "login";
    }

    @RequestMapping("/reg")
    public String registration(){
        return "registration";
    }


}
