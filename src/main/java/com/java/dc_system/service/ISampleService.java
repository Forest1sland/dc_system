package com.java.dc_system.service;

import com.java.dc_system.pojo.Sample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: zjt
 * @Date: 2022-11-07 17:36
 * @Description:
 */
public interface ISampleService {
    //查询样本数据
    List<Sample> selectSample(Sample sample);
    //添加样本数据
    int insertSample(Sample sample);
    //试管人数校验
    Integer checkSampleTestTubeId(@Param("testTubeId") Integer testTube);
}
