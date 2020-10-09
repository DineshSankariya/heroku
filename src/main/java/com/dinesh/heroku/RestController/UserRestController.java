package com.dinesh.heroku.RestController;

import com.dinesh.heroku.Dao.UserDaoImpl;
import com.dinesh.heroku.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user-api")
public class UserRestController {

    private UserDaoImpl userDao;

    @Autowired
    public UserRestController(UserDaoImpl userDao){
        this.userDao=userDao;
    }

    @PostMapping("/save")
    public String save_user(@RequestBody User user){

        userDao.save_user(user);

        return "saved - "+user.getName();


    }

    @GetMapping("/user")
    public List<User> users(){

//        userDao.save_user(user);

        return userDao.getusers();


    }



}
