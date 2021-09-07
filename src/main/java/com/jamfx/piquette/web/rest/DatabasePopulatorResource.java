package com.jamfx.piquette.web.rest;

import com.jamfx.piquette.service.DatabasePopulator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DatabasePopulatorResource {

    @Autowired
    private DatabasePopulator dp;

    @GetMapping("/product/populate")
    public void init() {
        dp.populate();
    }
}
