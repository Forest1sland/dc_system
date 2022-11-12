package com.java.dc_system.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: zjt
 * @Date: 2022-11-12 12:38
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Point {
    //监测点Id
    private Integer pointId;
    //检测地点
    private String pointName;
}
