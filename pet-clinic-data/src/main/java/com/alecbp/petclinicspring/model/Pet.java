package com.alecbp.petclinicspring.model;

import java.time.LocalDate;

public class Pet extends BaseEntity {
    private PetType petType;
    private Owner owner;
    private LocalDate birhtday;

    public PetType getPetType() {
        return petType;
    }

    public void setPetType(PetType petType) {
        this.petType = petType;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public LocalDate getBirhtday() {
        return birhtday;
    }

    public void setBirhtday(LocalDate birhtday) {
        this.birhtday = birhtday;
    }
}
