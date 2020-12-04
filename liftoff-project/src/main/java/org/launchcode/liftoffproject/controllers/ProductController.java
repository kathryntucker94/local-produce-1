package org.launchcode.liftoffproject.controllers;

import org.launchcode.liftoffproject.models.data.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

}
