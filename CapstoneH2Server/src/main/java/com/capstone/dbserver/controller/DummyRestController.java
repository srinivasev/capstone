package com.capstone.dbserver.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DummyRestController {

    @GetMapping("/api")
    public void getMessage(){
        //nothing
    }
}
