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
import java.util.List;

@Service
public class PocQrService {
    public String testQr(TestGenQrRequest qrString) throws Exception {
        return generateQRCodeImage(qrString.getQrString());
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
