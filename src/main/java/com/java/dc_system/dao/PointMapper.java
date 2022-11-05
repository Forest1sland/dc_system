package com.java.dc_system.dao;

import com.java.dc_system.pojo.Point;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author Forest1sLand_
 */
@Mapper
public interface PointMapper {
    int deleteByPrimaryKey(Integer pointid);

    int insert(Point record);

    int insertSelective(Point record);

    Point selectByPrimaryKey(Integer pointid);

    int updateByPrimaryKeySelective(Point record);

    int updateByPrimaryKey(Point record);

    List<Point> getAllPoints();
}