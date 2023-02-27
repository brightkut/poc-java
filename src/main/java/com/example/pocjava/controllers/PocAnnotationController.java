package com.example.pocjava.controllers;

import com.example.pocjava.model.ClassRoom;
import com.example.pocjava.model.User;
import com.example.pocjava.model.UserDetail;
import com.example.pocjava.services.PocAnnotationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@Validated
public class PocAnnotationController {

    @Autowired
    private PocAnnotationService pocAnnotationService;

    @GetMapping("/users")
    public ResponseEntity<User> getUserWithJsonIgnore(){
        return ResponseEntity.ok(this.pocAnnotationService.getUserWithJsonIgnore());
    }

    @GetMapping("/userDetails")
    public ResponseEntity<UserDetail> getUserDetailWithJsonIgnorePropertiesMultipleField(){
        return ResponseEntity.ok(this.pocAnnotationService.getUserDetailWithJsonIgnorePropertiesMultipleField());
    }

    @PostMapping("/classRoom")
    public ResponseEntity<String> postListValidation(@Valid @RequestBody ClassRoom classRoom){
        return ResponseEntity.ok("validate pass");
    }
}
