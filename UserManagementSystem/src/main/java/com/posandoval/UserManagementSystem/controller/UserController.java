package com.posandoval.UserManagementSystem.controller;

import com.posandoval.UserManagementSystem.model.User;
import com.posandoval.UserManagementSystem.repository.UserRepository;
import com.posandoval.UserManagementSystem.service.UserService;
import org.aspectj.apache.bcel.classfile.Module;
import org.hibernate.dialect.SelectItemReferenceStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class UserController {

    @Autowired
    private UserService userService;


    //Test Methods
    @GetMapping("/index")//ruta http para acceder desde endpoint
    public String test(){
        return "index";// Nombre del html donde va el retorno
    }

    @GetMapping("/users/create")
    public String formCreateUser(){
        return "createUser";//name of html where goes the return
    }

    // NUNCA CREAR EL DIRECTORIO O ARCHIVO HTML EN LA CARPETA STATIC!!! CREAR EN TEMPLATES
    @GetMapping({"/users","/"})//ruta http para acceder desde endpoint
    public String findAll(Model model){
        List<User> listaUsuarios=userService.findAll();
        model.addAttribute("users",listaUsuarios);
        return "users";// Nombre del html donde va el retorno
    }

    //"GetMapping" because it's only used to display the form of createUser
     @GetMapping("/create")
    public String formCreateUser(Model model){
        User user=new User();
        model.addAttribute("userDto",user);//name form to recibe the user
        return "createUser";//name of html where goes the return
    }

    //Method that saves user data, written in form
    @PostMapping("/create")
    public String createUser(@ModelAttribute("userDto") User user){
        userService.create(user);
        return "redirect:/users";
    }

                                    //Method to delete user
    @RequestMapping("/deleteById/{id}")
    public String deleteUserById(@PathVariable("id") Integer id){
    userService.deledeById(id);
    return "redirect:/users";
    }

                                    //Method to updateUser

    //Method to view form of updateUser
    @GetMapping("updateUser/{id}")
    public String updateUserForm(@PathVariable Integer id, Model model){
        model.addAttribute("userDto",userService.findById(id));
        return "updateUser";
    }

    //Method to updateUser
    @PostMapping("updateUserById/{id}")
    public String updateUser(@PathVariable Integer id,@ModelAttribute("userDto") User user, Model model){
        User userFound=userService.findById(id);
        userFound.setId(user.getId());
        userFound.setName(user.getName());
        userFound.setLastname(user.getLastname());
        userFound.setEmail(user.getEmail());
        userFound.setContact(user.getContact());
        userService.updateUser(userFound);
        return "redirect:/users";
    }

}