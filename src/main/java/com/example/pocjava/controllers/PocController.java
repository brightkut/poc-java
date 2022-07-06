package com.example.pocjava.controllers;

import com.example.pocjava.request.GetCacheRequest;
import com.example.pocjava.request.PostCacheRequest;
import com.example.pocjava.request.TestGenQrRequest;
import com.example.pocjava.services.PocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PocController {
    @Autowired
    private PocService pocService;

    @PostMapping("/poc/test-qr")
    public ResponseEntity<String> testQr(@RequestBody TestGenQrRequest qrString) throws Exception {
        //https://codebeautify.org/base64-to-image-converter

        return ResponseEntity.ok(this.pocService.testQr(qrString));
    }

    @PostMapping("/poc/cache")
    public ResponseEntity<String> cacheData(@RequestBody PostCacheRequest request){

        return ResponseEntity.ok(this.pocService.testCache(request));
    }

    @PostMapping("/poc/getCache")
    public ResponseEntity<String> getCache(@RequestBody GetCacheRequest request){

        return ResponseEntity.ok(this.pocService.getCache(request));
    }

    @GetMapping("/poc/getAllCacheName")
    public ResponseEntity<List<String>> getAllCacheName(){

        return ResponseEntity.ok(this.pocService.getAllCacheName());
    }
}

