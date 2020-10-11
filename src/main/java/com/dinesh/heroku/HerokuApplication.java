package com.dinesh.heroku;

import com.dinesh.heroku.Model.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
public class HerokuApplication {

	public static void main(String[] args) {
		SpringApplication.run(HerokuApplication.class, args);
	}

}

@Controller
class HomenewController {

	@RequestMapping("/")
	public String home_page(Model model){
		model.addAttribute("user",new User());
		return "homepage";
	}


}
