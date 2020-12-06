package org.launchcode.liftoffproject.controllers;

import org.launchcode.liftoffproject.models.Product;
import org.launchcode.liftoffproject.models.ProductData;
import org.launchcode.liftoffproject.models.Vendor;
import org.launchcode.liftoffproject.models.data.ProductRepository;
import org.launchcode.liftoffproject.models.data.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;

@Controller
@RequestMapping("marketplace")
public class MarketPlaceController {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private VendorRepository vendorRepository;

    static HashMap<String, String> columnChoices = new HashMap<>();

    public MarketPlaceController () {

        columnChoices.put("all", "All");
        columnChoices.put("product", "Product");
        columnChoices.put("skill", "Skill");

    }


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

    @RequestMapping(value = "products")
    public String listProductsByColumnAndValue(Model model, @RequestParam String column, @RequestParam String value) {
        Iterable<Product> products;
        Iterable<Vendor> vendors;


        products = productRepository.findAll();
        vendors = vendorRepository.findAll();

        if(column != null && value !=null){

            products = ProductData.findByColumnAndValue(column, value, productRepository.findAll());

        }
        model.addAttribute("products", products);

        return "marketplace";
    }

}
