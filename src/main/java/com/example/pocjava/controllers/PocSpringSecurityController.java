package com.example.pocjava.controllers;

import com.example.pocjava.model.Product;
import com.example.pocjava.services.PocSpringSecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class PocSpringSecurityController {

    @Autowired
    private PocSpringSecurityService service;

    @GetMapping("/welcome")
    public String welcome(){
        return "Welcome this endpoint is not secure";
    }


    @GetMapping("/all")
    public List<Product> getAllTheProducts(){
        return service.getProducts();
    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable Integer id){
        return service.getProduct(id);
    }
}
