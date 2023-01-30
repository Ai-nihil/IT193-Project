package com.rijai.users.controller;

import com.rijai.users.model.Dog;
import com.rijai.users.services.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DogController {

    @Autowired
    private DogService dogService;

    @RequestMapping("/")
    public List<Dog> getAllDogs()
    {
        return dogService.getAllDogs();
    }

    @RequestMapping(value="/dogs/{id}")
    public Dog getDog(@PathVariable int id)
    {
        return dogService.getDog(id);
    }

    @RequestMapping(value="/add-dog", method= RequestMethod.POST)
    public Dog addDog(@RequestBody Dog dog)
    {
        return dogService.addDog(dog);
    }

    @RequestMapping(value="/update-Dog", method=RequestMethod.PUT)
    public Dog updateDog(@RequestBody Dog dog)
    {
        return dogService.updateDog(dog);
    }

    @RequestMapping(value="/dogs/{id}", method=RequestMethod.DELETE)
    public void deleteDog(@PathVariable int id)
    {
        dogService.deleteDog(id);
    }
}
