package com.example.it193project.model;

import java.util.Objects;

public class Dog {
    private int id;

    private String dogName;
    private String dogBreed;
    private String dogAge;
    private String dogWeight;

    public Dog() {
    }

    public Dog(String dogName, String dogBreed, String dogAge, String dogWeight) {
        this.dogName = dogName;
        this.dogBreed = dogBreed;
        this.dogName = dogAge;
        this.dogBreed = dogWeight;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDogName() {
        return dogName;
    }

    public void setDogName (String dogName) {
        this.dogName = dogName;
    }

    public String getDogBreed() {
        return dogBreed;
    }

    public void setDogBreed(String dogBreed) {
        this.dogBreed = dogBreed;
    }

    public String getDogAge () {
        return dogAge;
    }

    public void setDogAge(String dogAge) {
        this.dogAge = dogAge;
    }

    public String getDogWeight() {
        return dogWeight;
    }

    public void setDogWeight(String dogWeight) {
        this.dogWeight = dogWeight;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.id);
        hash = 79 * hash + Objects.hashCode(this.dogName);
        hash = 79 * hash + + Objects.hashCode(this.dogBreed);
        hash = 79 * hash + Objects.hashCode(this.dogAge);
        hash = 79 * hash + + Objects.hashCode(this.dogWeight);
        return hash;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("User{");
        sb.append("id=").append(id);
        sb.append(", dogName='").append(dogName).append('\'');
        sb.append(", dogBreed=").append(dogBreed).append('\'');
        sb.append(", dogAge='").append(dogName).append('\'');
        sb.append(", dogWeight=").append(dogWeight);
        sb.append('}');
        return sb.toString();
    }

}
