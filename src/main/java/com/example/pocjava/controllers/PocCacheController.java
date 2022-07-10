package com.example.pocjava.controllers;

import com.example.pocjava.request.GetCacheRequest;
import com.example.pocjava.request.PostCacheRequest;
import com.example.pocjava.services.PocCacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PocCacheController {
    @Autowired
    private PocCacheService pocCacheService;


    @PostMapping("/cache")
    public ResponseEntity<String> cacheData(@RequestBody PostCacheRequest request){

        return ResponseEntity.ok(this.pocCacheService.testCache(request));
    }

    @GetMapping("/fixKeyCache/{data}")
    public ResponseEntity<String> cacheFixKey(@PathVariable String data){

        return ResponseEntity.ok(this.pocCacheService.testCacheWithFixKey(data));
    }

    @GetMapping("/cacheUnless/{data}")
    public ResponseEntity<String> cacheWithUnless(@PathVariable  String data){

        return ResponseEntity.ok(this.pocCacheService.testCacheWithUnless(data));
    }

    @PostMapping("/getCache")
    public ResponseEntity<String> getCache(@RequestBody GetCacheRequest request){

        return ResponseEntity.ok(this.pocCacheService.getCache(request));
    }

    @GetMapping("/getAllCacheName")
    public ResponseEntity<List<String>> getAllCacheName(){

        return ResponseEntity.ok(this.pocCacheService.getAllCacheName());
    }
}
