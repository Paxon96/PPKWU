package com.example.demo.Zadanie4.resource;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Employee {
    private String name;
    private String organization;
    private String vCardLink;
    private String academicDegree;
    private String avatar;
}
