package com.dinesh.heroku.RestController;

import com.dinesh.heroku.Dao.UserDaoImpl;
import com.dinesh.heroku.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/user-api")
public class UserRestController {

    private UserDaoImpl userDao;

    @Autowired
    public UserRestController(UserDaoImpl userDao){
        this.userDao=userDao;
    }

    @PostMapping(value = "/save",consumes = MediaType.APPLICATION_JSON_VALUE)
    public String save_user(@RequestBody User user){
        if(user.getName().trim().isEmpty() || user.getEmail().trim().isEmpty() || user.getDob().trim().isEmpty() || user.getMobile().trim().isEmpty() || user.getPass().isEmpty()){
            return "Not saved";
        }
        userDao.save_user(user);
        return "saved - "+user.getName();

    }


    @RequestMapping("/loggingprocess")
    @ResponseBody
    public String users(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String user=request.getParameter("username");
        String password=request.getParameter("password");
        if(user.trim().isEmpty()!=true && password.trim().isEmpty()!=true){
            if(userDao.getuserlogin(user,password)){
//                String text="<center><h2>You have successfully logged in and our website is currently in progress</h2></center>";
//                response.setContentType("text/html");
//                response.setCharacterEncoding("UTF-8");;
//                response.getWriter().write(text);
                System.out.println(user+" "+password);
                return "granted";
            }
        }
//        else{
//            response.sendRedirect("/home/login");
//        }
        return "denied";
    }

    @GetMapping("/user")
    public List<User> users(){

//        userDao.save_user(user);

        return userDao.getusers();


    }



}
