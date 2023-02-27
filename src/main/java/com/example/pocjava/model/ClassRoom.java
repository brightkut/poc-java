package com.example.pocjava.model;

import lombok.Data;

import jakarta.validation.constraints.Size;
import java.util.List;

@Data
public class ClassRoom {
    @Size(max=2)
    private String name;
    // validate ค่าใน list
    private List<@Size(max = 3) String> room;
    //validate size ของ list
    @Size(max=4)
    private List<String>students;
}
