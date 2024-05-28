package com.lab3.lab3eng.controllers;

import com.google.gson.Gson;
import com.lab3.lab3eng.model.Customer;
import com.lab3.lab3eng.model.Manager;
import com.lab3.lab3eng.model.User;
import com.lab3.lab3eng.repos.CustomerRepo;
import com.lab3.lab3eng.repos.ManagerRepo;
import com.lab3.lab3eng.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Properties;

@RestController
public class UserController {

    @Autowired
    private ManagerRepo managerRepo;
    @Autowired
    private CustomerRepo customerRepo;
    @Autowired
    private UserRepo userRepo;

    @GetMapping(value = "/getAllManagers")
    public @ResponseBody Iterable<Manager> getAllManagers() {
        return managerRepo.findAll();
    }

    @GetMapping(value = "/getAllCustomers")
    public @ResponseBody Iterable<Customer> getAllCustomer() {
        return customerRepo.findAll();
    }

    @PostMapping(value = "/createManager")
    public @ResponseBody Manager createManager(@RequestBody Manager manager){
        managerRepo.save(manager);
        return new Manager();//I will update this
    }

    @PutMapping(value = "/updateManagerObject")
    public @ResponseBody Manager updateManagerObject(@RequestBody Manager manager){
        managerRepo.save(manager);
        return new Manager();//I will update this
    }
    @PutMapping(value = "/updateManager")
    public @ResponseBody Manager updateManager(@RequestBody String info){
        Gson gson = new Gson();
        Properties properties = gson.fromJson(info, Properties.class);

        var id = properties.getProperty("id");
        var name = properties.getProperty("name");
        var randomStuffs = properties.getProperty("randomStuff");

        Manager manager = managerRepo.getReferenceById(Integer.parseInt(id));
        manager.setName(name);

        managerRepo.save(manager);
        return managerRepo.getReferenceById(manager.getId());
    }

    @DeleteMapping(value = "/deleteUser/{id}")
    public @ResponseBody Optional<User> deleteUser(@PathVariable(name = "id") int id){
        userRepo.deleteById(id);
        return userRepo.findById(id);
    }


}
