package org.launchcode.liftoffproject.controllers;

import org.launchcode.liftoffproject.models.Product;
import org.launchcode.liftoffproject.models.User;
import org.launchcode.liftoffproject.models.Vendor;
import org.launchcode.liftoffproject.models.data.ProductRepository;
import org.launchcode.liftoffproject.models.data.UserRepository;
import org.launchcode.liftoffproject.models.data.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@Controller
public class VendorController {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private VendorRepository vendorRepository;

    @Autowired
    private ProductRepository productRepository;


    @GetMapping("vendor/create")
    public String displayCreateProfileForm(Model model, HttpServletRequest request) {
        HttpSession session = request.getSession(false);

        if (session != null) {
            User user = getUserFromSession(session);
            model.addAttribute("user", user);
        }
        model.addAttribute("title", "Create Profile");
        model.addAttribute(new Vendor());
        return "vendors/edit";
    }

    //METHOD TO GET USER FROM SESSION
    public User getUserFromSession(HttpSession session) {
        Integer userId = (Integer) session.getAttribute("user");
        if (userId == null) {
            return null;
        }

        Optional<User> user = userRepository.findById(userId);

        if (user.isEmpty()) {
            return null;
        }

        return user.get();
    }

    @PostMapping("vendor/create")
    public String processCreateProfileForm(@ModelAttribute @Valid Vendor newVendor, Errors errors, Model model, HttpServletRequest request) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Create Profile");
            return "vendors/edit";
        }

//      Get user from session.
        HttpSession session = request.getSession(false);
        User user = getUserFromSession(session);
        model.addAttribute("user", user);

//      Set the current user as the "owner" of the vendor.
        user.setVendor(newVendor);

//      Save new vendor.
        vendorRepository.save(newVendor);
        return "vendors/profile";
    }

    @GetMapping("vendor/edit")
    public String displayEditProfileForm(Model model, Vendor vendor, HttpServletRequest request) {
        model.addAttribute("title", "Edit Profile");

        HttpSession session = request.getSession(false);
        User user = getUserFromSession(session);
        vendor = user.getVendor();
        model.addAttribute("vendor", vendor);
        model.addAttribute("user", user);
        return "vendors/edit";
    }

    @PostMapping("vendor/edit")
    public String processEditProfileForm(@ModelAttribute @Valid Vendor vendor, @RequestParam String name, @RequestParam String photo, @RequestParam String location,
                                         @RequestParam String email, @RequestParam String website, @RequestParam String bio, Errors errors, Model model, HttpServletRequest request) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Edit Profile");
            return "vendors/edit";
        }

        HttpSession session = request.getSession(false);
        User user = getUserFromSession(session);
        model.addAttribute("user", user);
        vendor = user.getVendor();
        int id = vendor.getId();
        vendorRepository.findById(id);

        vendor.setName(name);
        vendor.setPhoto(photo);
        vendor.setLocation(location);
        vendor.setEmail(email);
        vendor.setWebsite(website);
        vendor.setBio(bio);

        vendorRepository.save(vendor);
        user.setVendor(vendor);
        userRepository.save(user);
        return "redirect:/vendor/profile";
    }

    @GetMapping("vendor/profile")
    public String displayMyVendorProfile(Model model, HttpServletRequest request) {
        //Get user from session
        HttpSession session = request.getSession(false);
        User user = getUserFromSession(session);
        model.addAttribute("user", user);

        //get vendor from session user and redirect to their profile
        if (user.getVendor() != null) {
            Vendor vendor = user.getVendor();
            model.addAttribute("vendor", vendor);
            Iterable<Product> vendorProducts = user.getVendor().getProducts();
            vendorProducts = productRepository.findByVendor(user.getVendor());
            model.addAttribute("vendorProducts", vendorProducts);
            return "vendors/profile";
        } else {
            //if user is not linked to a vendor yet, send to create profile and link to session user
            model.addAttribute("title", "Create Profile");
            model.addAttribute(new Vendor());
            return "redirect:/vendor/create";
        }

    }

}