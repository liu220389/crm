package com.ttc.crms.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
/**
 *
 */
public class Dept {
    private   Integer  deptno =1;
    private   String  dname ="ttc";
    private   String loc ="沈阳市";
}
