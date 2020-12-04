package org.launchcode.liftoffproject.models.data;

import org.launchcode.liftoffproject.models.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {
}
