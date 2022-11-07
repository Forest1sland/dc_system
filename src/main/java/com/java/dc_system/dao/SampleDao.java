package com.java.dc_system.dao;

import com.java.dc_system.pojo.Sample;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.annotations.Mapper;

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

}
