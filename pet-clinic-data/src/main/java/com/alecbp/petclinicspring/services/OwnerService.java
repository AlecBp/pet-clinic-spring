package com.alecbp.petclinicspring.services;

import com.alecbp.petclinicspring.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);

}
