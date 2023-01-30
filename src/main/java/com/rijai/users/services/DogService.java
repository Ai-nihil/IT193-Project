package com.rijai.users.services;

import com.rijai.users.model.Dog;
import com.rijai.users.repository.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DogService {
    @Autowired
    private DogRepository dogRepository;

    public List<Dog> getAllDogs()
    {
        List<Dog>userRecords = new ArrayList<>();
        dogRepository.findAll().forEach(userRecords::add);
        return userRecords;
    }
    public Dog addDog(Dog dog) {
        return dogRepository.save(dog);
    }
    public Dog updateDog(Dog dog) {
        return dogRepository.save(dog);
    }
    public Dog getDog(int id)
    {
        Optional<Dog> dog = dogRepository.findById(id);
        if(dog.isPresent()) {
            return dog.get();
        }
        else
            return null;
    }
    public void deleteDog(int id)
    {
        Optional<Dog> dog = dogRepository.findById(id);
        if(dog.isPresent()) {
            dogRepository.delete(dog.get());
        }
    }
}
