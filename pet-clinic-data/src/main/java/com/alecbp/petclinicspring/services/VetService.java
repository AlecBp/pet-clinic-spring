package com.alecbp.petclinicspring.services;

import com.alecbp.petclinicspring.model.Vet;

import java.util.Set;

public interface VetService {
    Vet findById(Long id);

    Vet save(Vet vet);

    Set<Vet> findAll();
}
