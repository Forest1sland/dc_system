package com.java.dc_system.service;

import com.java.dc_system.Exception.BusinessException;
import com.java.dc_system.pojo.Point;

import java.util.List;

/**
 * @Author Forest1sLand_
 */
public interface IPointService {

    List<Point> getAllPoints() throws BusinessException;

}
