package org.launchcode.liftoffproject.controllers;

import org.launchcode.liftoffproject.models.User;
import org.launchcode.liftoffproject.models.Vendor;
import org.launchcode.liftoffproject.models.data.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
public class HomeController {

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

    //allow users to see their view of a Vendor profile
    @GetMapping("users/profile/{vendorId}")
    public String displayViewVendor(Model model, @PathVariable int vendorId) {

        Optional<Vendor> optionalVendor = vendorRepository.findById(vendorId);
        if (optionalVendor.isPresent()) {
            Vendor vendor = (Vendor) optionalVendor.get();
            model.addAttribute("vendor", vendor);
            return "users/profile";
        } else {
            return "redirect:../";
        }
    }

}