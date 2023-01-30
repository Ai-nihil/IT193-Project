package com.rijai.users.services;

import com.rijai.users.model.Dog;
import com.rijai.users.repository.AdminRepository;
import com.rijai.users.repository.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService implements IAdminService {

    @Autowired
    private DogRepository repository;
    private AdminRepository AdminRepository;

    // Dog repository Functions
    @Override
    public List<Dog> findAll() {
        // The AdminService retrieves all List of Dogs
        return (List<Dog>) repository.findAll();
    }

    @Override
    public Dog addDog(Dog dog) {
        // The AdminService will add a record for Dog
        return repository.save(dog);
    }

    @Override
    public Dog updateDog(Dog dog) {
        // The AdminService will update a Dog record
        int id = dog.getId();
        Dog dg = repository.findById(id).get();
        dg.setDogName(dog.getDogName());
        dg.setDogBreed(dog.getDogBreed());
        dg.setDogAge(dog.getDogAge());
        dg.setDogWeight(dog.getDogWeight());
        dg.setDogStatus(dog.getDogStatus());
        return repository.save(dog);
    }

    @Override
    public Dog getDog(int id) {
        // The AdminService will get a single record of dog record
        Optional optional = repository.findById(id);
        if (optional.isEmpty())
            return null;
        else
            return (Dog) optional.get();
    }


    @Override
    public void deleteDog(int id) {
        /**
         * @note This deletes a user entry from the database if it is present.
         * @note Otherwise, nothing happens, only a print in terminal
         */

        Optional<Dog> dog_toDelete = repository.findById(id);
        if(dog_toDelete.isPresent()) {
            repository.delete(dog_toDelete.get());
            System.out.println("Entry deleted!");
        }
        System.out.println("No entries to delete!");
    }
}