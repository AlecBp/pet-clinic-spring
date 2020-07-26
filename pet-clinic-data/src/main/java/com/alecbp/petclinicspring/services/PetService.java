package com.alecbp.petclinicspring.services;

import com.alecbp.petclinicspring.model.Pet;

import java.util.Set;

public interface PetService {
    Pet findById(Long id);

    Pet save(Pet owner);

    Set<Pet> findAll();
}
