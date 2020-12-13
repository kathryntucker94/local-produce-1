package org.launchcode.liftoffproject.controllers;

import org.launchcode.liftoffproject.models.User;
import org.launchcode.liftoffproject.models.Vendor;
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
import java.util.Optional;


@Controller
public class VendorController {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private VendorRepository vendorRepository;

    @GetMapping("vendor/create")
    public String displayCreateProfileForm(Model model) {
        model.addAttribute("title", "Create Profile");
        model.addAttribute(new Vendor());
        return "vendors/edit";
    }

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

        HttpSession session = request.getSession(false);

        User user = getUserFromSession(session);



//        newVendor.setUser(user);
        user.setVendor(newVendor);
        vendorRepository.save(newVendor);
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

//    Path to view a vendor's profile by vendor Id.
    @GetMapping("vendor/profile/{vendorId}")
    public String displayViewVendor(Model model, @PathVariable int vendorId) {

        Optional vendor = vendorRepository.findById(vendorId);
        Vendor vendorObject = (Vendor) vendor.get();

        model.addAttribute("vendor", vendorObject);

        return "vendors/profile";
    }

    @GetMapping("vendor/profile")
    public String displayMyVendorProfile(Model model, HttpServletRequest request) {

        //Get user from session
        HttpSession session = request.getSession(false);
        User user = getUserFromSession(session);

        //get vendor from session user and redirect to their profile
        if (user.getVendor() != null) {
            Vendor vendor = user.getVendor();
            model.addAttribute("vendor", vendor);
            return "vendors/profile";
        } else {
            //if user is not linked to a vendor yet, send to create profile and link to session user
            model.addAttribute("title", "Create Profile");
            model.addAttribute(new Vendor());
            return "redirect:/vendor/create";
        }


    }

}