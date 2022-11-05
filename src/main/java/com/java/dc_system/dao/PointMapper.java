package com.java.dc_system.dao;

import com.java.dc_system.pojo.Point;

/**
 * @Author Forest1sLand_
 */
public interface PointMapper {
    int deleteByPrimaryKey(Integer pointid);

    int insert(Point record);

    int insertSelective(Point record);

    Point selectByPrimaryKey(Integer pointid);

    int updateByPrimaryKeySelective(Point record);

    int updateByPrimaryKey(Point record);
}