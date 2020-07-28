package com.alecbp.petclinicspring.bootstrap;

import com.alecbp.petclinicspring.model.Owner;
import com.alecbp.petclinicspring.model.Pet;
import com.alecbp.petclinicspring.model.PetType;
import com.alecbp.petclinicspring.model.Vet;
import com.alecbp.petclinicspring.services.OwnerService;
import com.alecbp.petclinicspring.services.PetTypeService;
import com.alecbp.petclinicspring.services.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;


    @Autowired // Optional autowired
    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("Alec");
        owner1.setLastName("Pagliarussi");
        owner1.setAddress("123 Some Avenue");
        owner1.setCity("Nowhereland");
        owner1.setTelephone("123-123-1234");

        Pet owner1Pet = new Pet();
        owner1Pet.setPetType(savedDogPetType);
        owner1Pet.setOwner(owner1);
        owner1Pet.setBirthDate(LocalDate.now());
        owner1Pet.setName("Spike");
        owner1.getPets().add(owner1Pet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("John");
        owner2.setLastName("Doe");
        owner2.setAddress("321 Dufferin");
        owner2.setCity("Toronto");
        owner2.setTelephone("321-321-4321");

        Pet owner2Pet = new Pet();
        owner2Pet.setName("Larry");
        owner2Pet.setOwner(owner2);
        owner2Pet.setBirthDate(LocalDate.now());
        owner2Pet.setPetType(savedCatPetType);
        owner2.getPets().add(owner2Pet);

        ownerService.save(owner2);

        System.out.println("Loaded owners...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Jane");
        vet1.setLastName("Doe");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Sam");
        vet2.setLastName("Axe");

        vetService.save(vet2);

        System.out.println("Loaded vets...");
    }
}
