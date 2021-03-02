package com.beulladeu.spring_demo.controller;

import com.beulladeu.spring_demo.entity.Advert;
import com.beulladeu.spring_demo.entity.User;
import com.beulladeu.spring_demo.service.AdvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class BillboardController {

    private final AdvertService advertService;

    @Autowired
    public BillboardController(AdvertService advertService) {
        this.advertService = advertService;
    }

    @GetMapping("/billboard-auth")
    public String showBillboardAuth(Model model) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = user.getUsername();
        model.addAttribute("adverts", advertService);
        model.addAttribute("username", username);
        return "billboard_auth";
    }

    @GetMapping("/billboard")
    public String showBillboard(Model model) {
        model.addAttribute("adverts", advertService);
        return "billboard_not_auth";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        advertService.deleteAdvert(id);
        return "redirect:/billboard-auth";
    }

    @GetMapping("/add")
    public String showAddPage(Model model) {
        return "add";
    }

    @PostMapping("/add")
    public String createOrder(@ModelAttribute Advert advert) {
        if(!advert.getContent().isEmpty()) {
            advertService.create(advert.getContent());
        }
        return "redirect:/billboard-auth";
    }

}
