package com.rijai.users.controller;

import com.rijai.users.model.Dog;
import com.rijai.users.services.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AdminController {

    /**
     * This is responsible for communicating with the Admin Models and Service
     * The application should allow, creating/adding, viewing, updating and deleting of dog record/s.
     */
    @Autowired
    private IAdminService adminService;

    @RequestMapping("/api/admin")
    public List<Dog> findDogs_withAdmin() {
        // Using the admin root path, it should list all the Dogs properly
        return adminService.findAll();
    }

    @RequestMapping(value = "/api/show-admin-dog/{id}")
    public Dog showDog_withAdmin(@PathVariable int id) {
        // Using the admin root path, it should list all the Dogs properly
        return adminService.getDog(id);
    }

    @RequestMapping(value = "/api/add-dog-with-admin", method = RequestMethod.POST)
    public Dog addDogSubmit(@RequestBody Dog dog) {
        return adminService.addDog(dog);
    }

    @RequestMapping(value = "/api/update-dog-with-admin", method = RequestMethod.PUT)
    public Dog updateDog(@RequestBody Dog dog) {
        return adminService.updateDog(dog);
    }

    @RequestMapping(value = "/api/delete-dog-with-admin/{id}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable int id) {
        adminService.deleteDog(id);
        System.out.println("Resource deleted!");
    }

}