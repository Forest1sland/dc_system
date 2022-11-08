package com.java.dc_system.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


/**
 * @Author: zjt
 * @Date: 2022-11-05 18:14
 * @Description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Sample {
    //样本Id
    private Integer sampleId;
    //被检测人员Id
    private Integer peopleId;
    //试管Id
    private Integer testTubeId;
    //采集时间
    private Date collectTime;
    //被采集人员
    private People people;
    //试管
    private TestTube testTube;


}
