package org.launchcode.liftoffproject.models.data;

import org.launchcode.liftoffproject.models.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer> {

}
