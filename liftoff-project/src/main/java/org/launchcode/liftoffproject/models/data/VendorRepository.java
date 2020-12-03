package org.launchcode.liftoffproject.models.data;

import org.launchcode.liftoffproject.models.Vendor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendorRepository extends CrudRepository<Vendor, Integer> {
}
