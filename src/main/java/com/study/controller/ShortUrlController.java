package com.study.controller;

import com.study.service.ShortUrlService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

@RestController
@RequestMapping("/su")
public class ShortUrlController {
    @Autowired
    ShortUrlService shortUrlService;

    @GetMapping("/{shortUrl}")
    public void redirctUrl(@PathVariable("shortUrl") String shortUrl
            , HttpServletResponse response) throws IOException {
        System.out.println("url:"+shortUrl);
        String redirectUrl = shortUrlService.redirectUrl(shortUrl);
        if(redirectUrl == null) {
            redirectUrl = "";
        } else {
            response.sendRedirect("http://" + redirectUrl);
        }
    }

    @PostMapping("")
    public ModelAndView createShortUrl() {
        ModelAndView mv = new ModelAndView("jsonView");
        return mv;
    }

}
