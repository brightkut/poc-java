package com.example.pocjava.services;

import com.example.pocjava.request.GetCacheRequest;
import com.example.pocjava.request.PostCacheRequest;
import com.example.pocjava.request.TestGenQrRequest;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PocService {
    @Autowired
    private CacheManager cacheManager;

    public String testQr(TestGenQrRequest qrString) throws Exception {
        return generateQRCodeImage(qrString.getQrString());
    }


    // value กับ cacheNames คือ set config cache name เหมือนกัน
    // key คือ ค่า key ที่เก็บ
    @Cacheable( value = "test", key = "#request.key")
    public String testCache(PostCacheRequest request){
        return request.getData();
    }

    // HardCode Cache Key
    @Cacheable( value = "test2", key = "'fix_key'")
    public String testCacheWithFixKey(String data){
        return data;
    }

    // unless หมายถึง จะไม่ cache ถ้า value ที่ return จาก method == hello
    @Cacheable( value = "test3", key = "'cacheUnless'" , unless = "#result == 'hello'")
    public String testCacheWithUnless(String data){
        return data;
    }

    public String getCache(GetCacheRequest request){
        System.out.println(cacheManager.getCache(request.getCacheName()));
        return cacheManager.getCache(request.getCacheName()).get(request.getKey()).get().toString();
    }

    public List<String> getAllCacheName(){
        return new ArrayList<>(cacheManager.getCacheNames());
    }

    public static String generateQRCodeImage(String barcodeText) throws Exception {
        // Generate QR from String to Buffer Image
        QRCodeWriter barcodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = barcodeWriter.encode(barcodeText, BarcodeFormat.QR_CODE, 200, 200);

        // Convert Buffered Image to Base64
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        MatrixToImageWriter.writeToStream(bitMatrix,"png", outputStream);

        return encodeBase64(outputStream.toByteArray());
    }

    public static String encodeBase64(byte[] data){
        //RFC4648
        String encodedString = Base64.getEncoder().encodeToString(data);

        return encodedString;
    }

    public static String decodeBase64(String data){
        byte[] decodedBytes = Base64.getDecoder().decode(data);
        String decodedString = new String(decodedBytes);

        return decodedString;
    }
}
