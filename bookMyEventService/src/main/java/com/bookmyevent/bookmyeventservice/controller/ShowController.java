package com.bookmyevent.bookmyeventservice.controller;

import com.bookmyevent.bookmyeventservice.dto.ShowDTO;
import com.bookmyevent.bookmyeventservice.service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ShowController {


    private final ShowService showService;

    @Autowired
    public ShowController(ShowService showService) {
        this.showService = showService;
    }

    @GetMapping("/shows")
    public List<ShowDTO> getAllEvents(@RequestParam("event") String movieTitle, @RequestParam("location") String location){
        return showService.findAllEventShows(movieTitle,location);
    }
}