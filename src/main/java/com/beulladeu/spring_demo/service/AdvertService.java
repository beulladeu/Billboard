package com.beulladeu.spring_demo.service;

import com.beulladeu.spring_demo.dao.AdvertRepository;
import com.beulladeu.spring_demo.entity.Advert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AdvertService {


    private final AdvertRepository advertRepository;

    @Autowired
    public AdvertService(AdvertRepository advertRepository) {
        this.advertRepository = advertRepository;
    }

    public Advert create(String content) {
        final Advert advert = new Advert();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        advert.setUsername(name);
        advert.setContent(content);
        advert.setDate(new Date(System.currentTimeMillis()));

        return advertRepository.save(advert);
    }

    public boolean deleteAdvert(Long advertId) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        if (advertRepository.findById(advertId).isPresent() && advertRepository.findById(advertId).get().getUsername().equals(name)) {
            advertRepository.deleteById(advertId);
            return true;
        }
        return false;
    }

    public List<Advert> allUsers() {
        return advertRepository.findAll();
    }
}
