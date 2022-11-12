package com.java.dc_system.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

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
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date collectTime;
    //被采集人员People类
    private People people;
    //试管采集表TestTube类
    private TestTube testTube;
}
