package com.java.dc_system.service;

import com.java.dc_system.Exception.BusinessException;
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
    List<Sample> selectSample(Sample sample) throws BusinessException;

    //添加样本数据
    Integer insertSample(Sample sample) throws BusinessException;

    //试管人数校验
    Integer checkSampleTestTubeId(@Param("testTubeId") Integer testTube) throws BusinessException;

    //该试管下的被检测人员信息
    List<Sample> selectInfoUnderSample(@Param("testTubeId") Integer testTubeId) throws BusinessException;

    //删除样本信息
    Integer deleteSample(Sample sample) throws BusinessException;
}
