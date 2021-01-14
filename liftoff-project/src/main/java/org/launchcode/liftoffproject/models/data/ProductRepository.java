package org.launchcode.liftoffproject.models.data;

import org.launchcode.liftoffproject.models.Product;
import org.launchcode.liftoffproject.models.Vendor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {

    List<Product> findByVendor(Vendor vendor);

}
