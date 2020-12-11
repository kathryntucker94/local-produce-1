package org.launchcode.liftoffproject.controllers;

import org.launchcode.liftoffproject.models.Vendor;
import org.launchcode.liftoffproject.models.data.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;


@Controller
public class VendorController {

    @Autowired
    private VendorRepository vendorRepository;

    @GetMapping("vendor/create")
    public String displayCreateProfileForm(Model model) {
        model.addAttribute("title", "Create Profile");
        model.addAttribute(new Vendor());
        return "vendors/edit";
    }

    @PostMapping("vendor/create")
    public String processCreateProfileForm(@ModelAttribute @Valid Vendor vendor, Errors errors, Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Create Profile");
            return "vendors/edit";
        }

        vendorRepository.save(vendor);
        return "vendors/profile";
    }

    @GetMapping("vendor/edit")
    public String displayEditProfileForm(Model model, Vendor vendor) {
        model.addAttribute("title", "Edit Profile");
        model.addAttribute("vendor", vendor);
        return "vendors/edit";
    }

    @PostMapping("vendor/edit")
    public String processEditProfileForm(@ModelAttribute Vendor vendor, Errors errors, Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Edit Profile");
            return "vendors/edit";
        }



        return "vendors/profile";
    }



}