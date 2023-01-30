package com.rijai.users.services;

import com.rijai.users.model.Admin;
import com.rijai.users.model.Dog;

import java.util.List;

public interface IAdminService {

    // The application should allow, creating/adding, viewing, updating and deleting of dog record/s.
    List<Dog> findAll();

    Dog addDog(Dog dog);

    Dog updateDog(Dog dog);

    Dog getDog(int id);

    void deleteDog(int id);
}


//Methods for returning admin values
//not yet working
// List<Admin> findAll();
