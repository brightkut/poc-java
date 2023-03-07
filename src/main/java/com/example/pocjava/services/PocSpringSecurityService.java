package com.example.pocjava.services;

import com.example.pocjava.entity.UserInfo;
import com.example.pocjava.model.Product;
import com.example.pocjava.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PocSpringSecurityService {

    @Autowired
    private UserInfoRepository userInfoRepository;

    @Autowired
    private PasswordEncoder encoder;

    List<Product> productList= List.of(
            new Product().setId(1).setProductName("Nike Air"),
            new Product().setId(2).setProductName("Iphone 4 pro"),
            new Product().setId(3).setProductName("Keyboard Keychron Q4")
    );

    public Product getProduct(int id ){
        return productList.stream()
                .filter(product -> product.getId() == id)
                .findAny()
                .orElseThrow(()-> new RuntimeException("product "+ id+" not found"));
    }

    public List<Product> getProducts(){
        return productList;
    }

    public String addUser(UserInfo userInfo){
        userInfo.setPassword(encoder.encode(userInfo.getPassword()));
        userInfoRepository.save(userInfo);

        return "user added to system";
    }
}

