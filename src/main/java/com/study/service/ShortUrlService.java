package com.study.service;

import com.study.dao.ShortUrlRepository;
import com.study.model.ShortUrl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ShortUrlService {
    @Autowired
    private ShortUrlRepository suRep;
    public List<ShortUrl> findAll(){
        return suRep.findAll();
    }

    public String redirectUrl(String shortUrl) {
        ShortUrl shortUrlModel = suRep.findByShortUrl(shortUrl);
        if(shortUrlModel != null) return shortUrlModel.getSourceUrl();
        return null;
    }

    public boolean registerUrl(ShortUrl shortUrlModel) {
        if(shortUrlModel.getShortUrl() != null && shortUrlModel.getSourceUrl() != null) {
            shortUrlModel.setCreationDate(LocalDate.now());
            shortUrlModel.setRecentlyUsedDate(LocalDate.now());
            suRep.save(shortUrlModel);
            return true;
        }
        return false;
    }

}
