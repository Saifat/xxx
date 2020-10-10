package web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.expression.Lists;
import web.dao.UserDao;
import web.model.User;
import web.service.UserService;
import web.service.UserServiceImpl;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    UserService userService = new UserServiceImpl();


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String hello(){
        return "index";
    }

    @PostMapping("users")
    public String listUsers(@ModelAttribute("user") User user, Model model){
        List<User> userList = userService.listUsers();
        model.addAttribute("listUsers", userList);
        return "users";
    }

    @PostMapping()
    public String addUser(@ModelAttribute("user") User user ){
        userService.addUser(user);
        return "redirect:/";
    }

    @RequestMapping("/remove/{id}")
    public String removeUser(@PathVariable("id") int id ){
        userService.removeUser(id);
        return "redirect:/";
    }

    @GetMapping("edit/{id}")
    public String editUserForm(@PathVariable("id") int id, Model model){
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
       return "edit";
    }
    @PostMapping("/edit")
    public String editUser(User user){
         userService.updateUser(user);
        return "redirect:/";
    }


}
