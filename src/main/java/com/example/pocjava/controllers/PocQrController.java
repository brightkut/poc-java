package com.example.pocjava.controllers;

import com.example.pocjava.request.GetCacheRequest;
import com.example.pocjava.request.PostCacheRequest;
import com.example.pocjava.request.TestGenQrRequest;
import com.example.pocjava.services.PocQrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PocQrController {
    @Autowired
    private PocQrService pocQrService;

    @PostMapping("/test-qr")
    public ResponseEntity<String> testQr(@RequestBody TestGenQrRequest qrString) throws Exception {
        //https://codebeautify.org/base64-to-image-converter

        return ResponseEntity.ok(this.pocQrService.testQr(qrString));
    }
}

