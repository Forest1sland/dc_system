package com.java.dc_system.dao;

import com.java.dc_system.pojo.Sample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: zjt
 * @Date: 2022-11-07 12:05
 * @Description:
 */
@Mapper
public interface SampleDao {
    //查询样本数据
    List<Sample> selectSample(Sample sample);

    //添加样本数据
    Integer insertSample(Sample sample);

    //试管人数校验
    Integer checkSampleTestTubeId(@Param("testTubeId") Integer testTubeId);

    //该试管下的被检测人员信息
    List<Sample> selectInfoUnderSample(@Param("testTubeId") Integer testTubeId);

    //更新样本数据
    Integer updateSample(Sample sample);

    //删除样本信息
    Integer deleteSample(Sample sample);
}
