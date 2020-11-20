package com.dinesh.heroku.Controller;

import com.dinesh.heroku.Model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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

    @RequestMapping("/success")
    public void success_log(HttpServletResponse response) throws IOException {
        String text="<center><h2>You have successfully logged in and our website is currently in progress</h2></center>";
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");;
        response.getWriter().write(text);

    }




}
