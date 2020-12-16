package org.launchcode.liftoffproject.controllers;

import org.launchcode.liftoffproject.models.Product;
import org.launchcode.liftoffproject.models.data.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("add")
    public String displayAddProductForm(Model model){
        model.addAttribute(new Product());
        return "products/add";

    }

    @PostMapping("add")
    public String processAddProductForm(@ModelAttribute @Valid Product newProduct, Errors errors, Model model) {
        if (errors.hasErrors()) {
            return "products/add";
        }
        productRepository.save(newProduct);
        return "products/add";
    }
}
