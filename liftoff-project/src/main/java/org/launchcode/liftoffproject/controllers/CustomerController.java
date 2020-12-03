package org.launchcode.liftoffproject.controllers;

import org.launchcode.liftoffproject.models.data.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

}
