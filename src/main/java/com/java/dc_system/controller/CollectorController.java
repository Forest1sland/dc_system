package com.java.dc_system.controller;


import com.java.dc_system.Exception.BusinessException;
import com.java.dc_system.pojo.Collector;
import com.java.dc_system.pojo.vo.ResultModel;
import com.java.dc_system.service.ICollectorService;
import com.java.dc_system.util.CodeEnum;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * @Author: zjt
 * @Date: 2022-11-03 15:16
 * @Description:
 */
@Api(tags = "检测人员API")
@RequestMapping("/collector")
@RestController
public class CollectorController {

    @Autowired
    private ICollectorService collectorService;

    //检测人员注册
    @ApiOperation("检测人员注册以及校验")
    @PostMapping("/registerCollector.do")
    public ResultModel<Integer> registerCollector(@RequestBody Collector model) throws BusinessException {
        List<Collector> collector = collectorService.loginCollector(model.getIdCard(),model.getTel(),null);
        if (collector.size() == 0){
            Integer num =  collectorService.registerCollector(model);
            if (num !=0){
                return new ResultModel<>(CodeEnum.SUCCESS, "注册成功", num, true);
            }else {
                return new ResultModel<>(CodeEnum.BUSINESS_ERROR, "注册失败", num, false);
            }
        }else {
            return new ResultModel<>(CodeEnum.BUSINESS_ERROR, "您已经注册", collector.size(), false);
        }
    }

    //检测人员登录
    @ApiOperation("检测人员登录")
    @PostMapping("/loginCollector.do")
    public ResultModel<List<Collector>> loginCollector(@RequestBody Collector collector) throws BusinessException {
        List<Collector> result =  collectorService.loginCollector(null,collector.getTel(), collector.getPassword());
        return new ResultModel<>(CodeEnum.SUCCESS, "登录成功", result, true);
    }

    //获取检测人员信息
    @ApiOperation("获取检测人员信息")
    @PostMapping("/getCollectorById.do")
    public ResultModel<Collector> getCollectorById(Integer collectorId) throws BusinessException {
        Collector result =  collectorService.getCollectorById(collectorId);
        return new ResultModel<>(CodeEnum.SUCCESS, "信息检索成功", result, true);
    }

    //删除检测人员信息
    @ApiOperation("删除检测人员信息")
    @PostMapping("/deleteCollector.do")
    public ResultModel<Integer> deleteCollector(Integer collectorId) throws BusinessException {
        Integer num =  collectorService.deleteCollector(collectorId);
        return new ResultModel<>(CodeEnum.SUCCESS, "信息删除成功", num, true);
    }

    //更新检测人员信息
    @ApiOperation("更新检测人员信息")
    @PostMapping("/updateCollector.do")
    public ResultModel<Integer> updateCollector(@RequestBody Collector model) throws BusinessException {
        Integer num =  collectorService.updateCollector(model);
        return new ResultModel<>(CodeEnum.SUCCESS, "信息更新成功", num, true);
    }

    //获取全部检测人员信息
    @ApiOperation("获取全部检测人员信息")
    @PostMapping("/getAllCollector.do")
    public ResultModel<List<Collector>> getAllCollector() throws BusinessException {
        List<Collector> result =  collectorService.getAllCollector();
        return new ResultModel<>(CodeEnum.SUCCESS, "检索到全部信息", result, true);
    }

}
