package com.example.pocjava.controllers;

import com.example.pocjava.request.TestGenQrRequest;
import com.example.pocjava.services.PocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PocController {
    @Autowired
    private PocService pocService;

    @PostMapping("/poc/test-qr")
    public ResponseEntity<String> testQr(@RequestBody TestGenQrRequest qrString) throws Exception {
        //https://codebeautify.org/base64-to-image-converter

        return ResponseEntity.ok(this.pocService.testQr(qrString));
    }
}

