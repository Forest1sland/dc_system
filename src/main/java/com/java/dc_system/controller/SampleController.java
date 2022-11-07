package com.java.dc_system.controller;

import com.java.dc_system.pojo.Sample;
import com.java.dc_system.pojo.vo.ResultModel;
import com.java.dc_system.service.ISampleService;
import com.java.dc_system.until.CodeEnum;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: zjt
 * @Date: 2022-11-07 17:47
 * @Description:
 */
@RestController
@RequestMapping("/sample")
public class SampleController {
    @Autowired
    private ISampleService sampleService;

    @PostMapping("/selectSample.do")
    public ResultModel<List<Sample>> selectSample(@RequestBody Sample sample){
        List<Sample> sampleList = sampleService.selectSample(sample);
        return new ResultModel<>(CodeEnum.SUCCESS, "检索到样本信息" ,sampleList , true);
    }

    @PostMapping("/insertSample.do")
    public ResultModel<Integer> insertSample(@RequestBody Sample sample){
        int num = sampleService.insertSample(sample);
        return new ResultModel<>(CodeEnum.SUCCESS, "样本信息已添加" ,num , true);
    }

    @PostMapping("/checkSampleTestTubeId.do")
    public ResultModel<Integer> checkSampleTestTubeId(@RequestBody Sample sample){
        int num = sampleService.checkSampleTestTubeId(sample.getTestTubeId());
        return new ResultModel<>(CodeEnum.SUCCESS, "该试管下样本数量" ,num , true);
    }

    @PostMapping("/selectInfoUnderSample.do")
    public ResultModel<List<Sample>> selectInfoUnderSample(@RequestBody Sample sample){
        List<Sample> sampleList = sampleService.selectInfoUnderSample(sample.getTestTubeId());
        return new ResultModel<>(CodeEnum.SUCCESS, "该试管下样本信息" ,sampleList , true);
    }
}
