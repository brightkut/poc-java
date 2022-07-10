package com.example.pocjava.services;

import com.example.pocjava.request.GetCacheRequest;
import com.example.pocjava.request.PostCacheRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PocCacheService {

    @Autowired
    private CacheManager cacheManager;

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
}
