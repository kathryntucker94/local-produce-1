package org.launchcode.liftoffproject.controllers;

import org.launchcode.liftoffproject.models.Product;
import org.launchcode.liftoffproject.models.ProductData;
import org.launchcode.liftoffproject.models.Utility;
import org.launchcode.liftoffproject.models.Vendor;
import org.launchcode.liftoffproject.models.data.ProductRepository;
import org.launchcode.liftoffproject.models.data.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("marketplace")
public class MarketPlaceController {

    Utility utility = new Utility();

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private VendorRepository vendorRepository;


    @RequestMapping("")
    public String list(Model model) {
        Iterable<Product> products;
        Iterable<Vendor> vendors;

        products = productRepository.findAll();
        vendors = vendorRepository.findAll();

        model.addAttribute("products", products);
        model.addAttribute("vendors", vendors);


        return "marketplace";
    }

    @PostMapping("results")
    public String listProductsByValue(Model model, @RequestParam String value) {
        Iterable<Product> products;
        Iterable<Vendor> vendors;


        products = productRepository.findAll();
        vendors = vendorRepository.findAll();



        if(value !=null){

            products = ProductData.findByValue( value, productRepository.findAll());

        }
        model.addAttribute("products", products);

        return "marketplace";
    }

}
