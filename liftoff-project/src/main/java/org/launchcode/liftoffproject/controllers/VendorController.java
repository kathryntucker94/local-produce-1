package org.launchcode.liftoffproject.controllers;

import org.launchcode.liftoffproject.models.data.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class VendorController {

    @Autowired
    private VendorRepository vendorRepository;

}
