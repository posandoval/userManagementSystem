package com.posandoval.UserManagementSystem.controller;

import com.posandoval.UserManagementSystem.model.User;
import com.posandoval.UserManagementSystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;


                                //Method to display all Users
    // NUNCA CREAR EL DIRECTORIO O ARCHIVO HTML EN LA CARPETA STATIC!!! CREAR EN TEMPLATES
    @GetMapping({"/users","/"})//ruta http para acceder desde endpoint
    public String findAll(Model model){
        List<User> listaUsuarios=userService.findAll();
        model.addAttribute("usersDto",listaUsuarios);
        return "users";// Nombre del html donde va el retorno
    }
                                    //Method to Find User ById
    @GetMapping({"/findById"})//ruta http para acceder desde endpoint
    public String findByIdForm(){
    return "findById";// Nombre del html donde va el retorno
    }

    @RequestMapping("/findUserById")
    //public String findById( Model model){
    public String findById(@Param("idDto") Integer idDto, Model model){
        model.addAttribute("userDto",userService.findById(idDto));
        return "findById";
    }

                                    //Method to Create User
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
    @PostMapping("/updateUser/{id}")
    public String updateUser(@PathVariable Integer id,@ModelAttribute User user){
        User userFound=userService.findById(id);
        userFound.setName(user.getName());
        userFound.setLastname(user.getLastname());
        userFound.setEmail(user.getEmail());
        userFound.setContact(user.getContact());

        userService.updateUser(userFound);
        return "redirect:/users";
    }

}