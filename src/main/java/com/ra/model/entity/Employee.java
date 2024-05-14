package com.ra.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Employee
{
    private Integer id;
    private String name;
    private String address;
    private String phone;
    private Boolean status;
}
