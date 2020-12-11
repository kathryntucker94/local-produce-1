package org.launchcode.liftoffproject.controllers;

import org.launchcode.liftoffproject.models.Vendor;
import org.launchcode.liftoffproject.models.data.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
public class HomeController {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private VendorRepository vendorRepository;

    @RequestMapping("")
    public String index(Model model){
        model.addAttribute("title", "Local Produce");

        return "index";
    }

    @GetMapping("vendor/{vendorId}")
    public String displayVendor(Model model, @PathVariable int vendorId) {

        Optional<Vendor> optionalVendor = vendorRepository.findById(vendorId);
        if (optionalVendor.isPresent()) {
            Vendor vendor = (Vendor) optionalVendor.get();
            model.addAttribute("vendor", vendor);
            return "vendors/profile";
        } else {
            return "redirect:../";
        }
    }
}