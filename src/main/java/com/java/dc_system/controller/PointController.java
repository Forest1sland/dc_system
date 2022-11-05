package com.java.dc_system.controller;

import com.java.dc_system.Exception.BusinessException;
import com.java.dc_system.pojo.Point;
import com.java.dc_system.service.Impl.PointServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author Forest1sLand_
 */
@RestController
@RequestMapping("/point")
public class PointController {
    @Autowired
    PointServiceImpl pointService;

    @PostMapping("/getAllPoints")
    List<Point> getAllPoints() throws BusinessException {
        return pointService.getAllPoints();
    }
}
