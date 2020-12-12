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
import javax.validation.Valid;


@Controller
public class VendorController {

    private static final String userSessionKey = "user";

    @Autowired
    private VendorRepository vendorRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("vendor/create")
    public String displayCreateProfileForm(Model model) {
        model.addAttribute("title", "Create Profile");
        model.addAttribute(new Vendor());
        return "vendors/edit";
    }

    @PostMapping("vendor/create")
    public String processCreateProfileForm(@ModelAttribute @Valid Vendor newVendor, HttpServletRequest request, Errors errors, Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Create Profile");
            return "vendors/edit";
        }

        String username = request.getRemoteUser();
        User user = userRepository.findByUsername(username);
        newVendor.setUser(user);
        user.setVendor(newVendor);
        userRepository.save(user);
        vendorRepository.save(newVendor);
        return "vendors/profile";
    }

//    @GetMapping("vendor/edit")
//    public String displayEditProfileForm(Model model, @PathVariable Integer vendorId) {
//
//        Optional<Vendor> optVendor = vendorRepository.findById(vendorId);
//        if (optVendor.isEmpty()) {
//            return "login";
//        } else {
//            Vendor vendor = optVendor.get();
//            model.addAttribute("title", "Edit Profile");
//            model.addAttribute("vendor", vendor);
//        }
//
//        return "vendors/edit";
//    }
//
//    @PostMapping("vendor/edit")
//    public String processEditProfileForm(@ModelAttribute @Valid HttpSession session, @RequestParam String name, Errors errors, Model model) {
//
//        if (errors.hasErrors()) {
//            model.addAttribute("title", "Edit Profile");
//            return "vendors/edit";
//        }
//
//        Integer id = (Integer) session.getAttribute(userSessionKey);
//        Optional<User> user = userRepository.findById(id);
//        User theUser = user.get();
//        Vendor vendor = user.get().getVendor();
//
//        vendor.setName(name);
//        vendorRepository.save(vendor);
//
//        theUser.setVendor(vendor);
//        return "vendors/profile";
//    }

    @GetMapping("vendor/profile")
    public String displayVendorProfile(User user, Model model) {

        Vendor vendor = user.getVendor();

        model.addAttribute("vendor", vendor);


        return "vendors/profile";
    }


}