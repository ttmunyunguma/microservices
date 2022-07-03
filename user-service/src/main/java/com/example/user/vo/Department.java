package com.example.user.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Department {
    private Long Id;
    private String departmentName;
    private String departmentAddress;
    private String departmentCode;
}
