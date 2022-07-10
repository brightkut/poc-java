package com.example.pocjava.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
// ไม่ส่ง field name กับ surname ออกไป ใน output endpoint
@JsonIgnoreProperties({"name","surname"})
public class UserDetail {
    private String name;
    private String surname;
    private String email;
}
