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

import java.util.HashMap;

@Controller
@RequestMapping("marketplace")
public class MarketPlaceController {

    static HashMap<String, String> searchChoices = new HashMap<>();

    public MarketPlaceController (){
        searchChoices.put("all", "All");
        searchChoices.put("type", "Type");
        searchChoices.put("location", "Location");
        searchChoices.put("vendor", "Vendor");
    }

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
        model.addAttribute("columns", searchChoices);


        return "marketplace";
    }

    @PostMapping("results")
    public String listProductsByValue(Model model, @RequestParam String searchTerm, @RequestParam String searchType) {
        Iterable<Product> products;
        Iterable<Vendor> vendors;


        products = productRepository.findAll();
        vendors = vendorRepository.findAll();



        if(searchTerm == null || searchTerm.toLowerCase().equals("all")){

            products = productRepository.findAll();

        }
        products = ProductData.findByValue( searchTerm, productRepository.findAll());
        model.addAttribute("products", products);

        return "marketplace";
    }

}
