package com.java.dc_system.controller;

import com.java.dc_system.Exception.BusinessException;
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
    //查询样本信息
    @PostMapping("/selectSample.do")
    public ResultModel<List<Sample>> selectSample(@RequestBody Sample sample) throws BusinessException {
        List<Sample> sampleList = sampleService.selectSample(sample);
        return new ResultModel<>(CodeEnum.SUCCESS, "检索到样本信息" ,sampleList , true);
    }
    //添加样本信息
    @PostMapping("/insertSample.do")
    public ResultModel<Integer> insertSample(@RequestBody Sample sample) throws BusinessException {
        int num = sampleService.insertSample(sample);
        return new ResultModel<>(CodeEnum.SUCCESS, "样本信息已添加" ,num , true);
    }
    //获取试管下样本数量
    @PostMapping("/checkSampleTestTubeId.do")
    public ResultModel<Integer> checkSampleTestTubeId(@RequestBody Sample sample) throws BusinessException{
        int num = sampleService.checkSampleTestTubeId(sample.getTestTubeId());
        return new ResultModel<>(CodeEnum.SUCCESS, "该试管下样本数量" ,num , true);
    }
    //获取试管下的样本数据
    @PostMapping("/selectInfoUnderSample.do")
    public ResultModel<List<Sample>> selectInfoUnderSample(@RequestBody Sample sample) throws BusinessException{
        List<Sample> sampleList = sampleService.selectInfoUnderSample(sample.getTestTubeId());
        return new ResultModel<>(CodeEnum.SUCCESS, "该试管下样本信息" ,sampleList , true);
    }
}
