package com.java.dc_system.service.Impl;

import com.java.dc_system.Exception.BusinessException;
import com.java.dc_system.dao.PointMapper;
import com.java.dc_system.pojo.Point;
import com.java.dc_system.service.IPointService;
import com.java.dc_system.utils.CodeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author Forest1sLand_
 */
@Service
public class PointServiceImpl implements IPointService {

    @Autowired
    PointMapper pointMapper;

    @Override
    public List<Point> getAllPoints() throws BusinessException {
        List<Point> pointList = pointMapper.getAllPoints();
        if (pointList.size() != 0) {
            return pointList;
        } else {
            throw new BusinessException("获取采集点列表失败", CodeEnum.BUSINESS_ERROR);
        }
    }
}
