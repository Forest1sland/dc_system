package com.java.dc_system.controller;

import com.java.dc_system.Exception.BusinessException;
import com.java.dc_system.pojo.Box;
import com.java.dc_system.pojo.TestTube;
import com.java.dc_system.pojo.vo.ResultModel;
import com.java.dc_system.service.IBoxService;
import com.java.dc_system.service.ITestTubeService;
import com.java.dc_system.utils.CodeEnum;
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
 * @Date: 2022-11-06 17:44
 * @Description:
 */
@RestController
@Api(tags = "转运箱API")
@RequestMapping("/box")
public class BoxController {
    @Autowired
    private IBoxService boxService;

    @Autowired
    private ITestTubeService testTubeService;

    //获取当前转运箱下的试管数量
    @ApiOperation("获取当前转运箱下的试管数量")
    @PostMapping("/checkTestTubeNum.do")
    public ResultModel<Integer> checkTestTubeId(@RequestBody Box model) throws BusinessException {
        int num = testTubeService.checkTestTube(model.getBoxId());
        return new ResultModel<>(CodeEnum.SUCCESS, "该转运箱下试管数量", num, true);
    }

    //开箱
    @ApiOperation("开箱")
    @PostMapping("/insertBox.do")
    public ResultModel<Integer> insertBox(@RequestBody Box model) throws BusinessException {
        Box box = new Box();
        box.setBoxCode(model.getBoxCode());
        List<Box> boxList = boxService.getBox(box);
        if (boxList.isEmpty()) {
            boxService.insertBox(model);
            return new ResultModel<>(CodeEnum.SUCCESS, "开箱成功", model.getBoxId(), true);
        } else {
            return new ResultModel<>(CodeEnum.BUSINESS_ERROR, "该转运箱已存在", boxList.get(0).getBoxId(), true);
        }
    }

    //更新转运箱信息
    @ApiOperation("更新转运箱信息")
    @PostMapping("/updateBox.do")
    public ResultModel<Integer> updateBox(@RequestBody Box model) throws BusinessException {
        int num = boxService.updateBox(model);
        return new ResultModel<>(CodeEnum.SUCCESS, "已更新转运箱信息", num, true);
    }

    //获取转运箱信息
    @ApiOperation("获取转运箱信息")
    @PostMapping("/getBox.do")
    public ResultModel<List<Box>> getBox(@RequestBody Box model) throws BusinessException {
        List<Box> boxList = boxService.getBox(model);
        return new ResultModel<>(CodeEnum.SUCCESS, "检索到转运箱信息", boxList, true);
    }

    //获取当前转运箱下的试管
    @ApiOperation("获取当前转运箱下的试管")
    @PostMapping("/getBoxTestTube.do")
    public ResultModel<List<TestTube>> getBoxTestTube(@RequestBody Box model) throws BusinessException {
        TestTube testTube = new TestTube();
        testTube.setBoxId(model.getBoxId());
        List<TestTube> testTubes = testTubeService.selectTestTube(testTube);
        return new ResultModel<>(CodeEnum.SUCCESS, "检索到本转运箱下的试管信息", testTubes, true);
    }

    //删除转运箱信息
    @ApiOperation("删除转运箱信息")
    @PostMapping("/deleteBox.do")
    public ResultModel<Integer> deleteBox(@RequestBody Box model) throws BusinessException {
        int num = boxService.deleteBox(model);
        return new ResultModel<>(CodeEnum.SUCCESS, "转运箱信息已删除", num, true);
    }
}
