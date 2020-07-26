package com.alecbp.petclinicspring.bootstrap;

import com.alecbp.petclinicspring.model.Owner;
import com.alecbp.petclinicspring.model.Vet;
import com.alecbp.petclinicspring.services.OwnerService;
import com.alecbp.petclinicspring.services.VetService;
import com.alecbp.petclinicspring.services.map.OwnerServiceMap;
import com.alecbp.petclinicspring.services.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader() {
        ownerService = new OwnerServiceMap();
        vetService = new VetServiceMap();
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Alec");
        owner1.setLastName("Pagliarussi");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("John");
        owner2.setLastName("Doe");

        ownerService.save(owner2);

        System.out.println("Loaded owners...");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Jane");
        vet1.setLastName("Doe");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Sam");
        vet2.setLastName("Axe");

        vetService.save(vet2);

        System.out.println("Loaded vets...");
    }
}
