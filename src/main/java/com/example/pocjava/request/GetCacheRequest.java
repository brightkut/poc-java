package com.example.pocjava.request;

import lombok.Data;

@Data
public class GetCacheRequest {
    private String cacheName;
    private String key;
}
