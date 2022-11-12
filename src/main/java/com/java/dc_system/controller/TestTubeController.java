package com.java.dc_system.controller;

import com.java.dc_system.Exception.BusinessException;
import com.java.dc_system.pojo.TestTube;
import com.java.dc_system.pojo.vo.ResultModel;
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
 * @Date: 2022-11-06 21:31
 * @Description:
 */
@RestController
@Api(tags = "检测试管API")
@RequestMapping("/testTube")
public class TestTubeController {
    @Autowired
    private ITestTubeService testTubeService;

    //开管
    @ApiOperation("开管")
    @PostMapping("/insertTestTube.do")
    public ResultModel<Object> insertTestTube(@RequestBody TestTube model) throws BusinessException {
        TestTube testTube = new TestTube();
        testTube.setTestTubeCode(model.getTestTubeCode());
        List<TestTube> tubeList = testTubeService.selectTestTube(testTube);
        if (tubeList.isEmpty()){
            int num = testTubeService.insertTestTube(model);
            if (num != 0){
                return new ResultModel<>(CodeEnum.SUCCESS, "开管成功", model.getTestTubeId(), true);
            }else {
                return new ResultModel<>(CodeEnum.SUCCESS, "开管失败", model.getTestTubeId(), false);
            }
        }else {
            return new ResultModel<>(CodeEnum.BUSINESS_ERROR, "该试管已存在", tubeList.get(0).getTestTubeId(), false);
        }
    }

    //检索试管信息
    @ApiOperation("检索试管信息")
    @PostMapping("/selectTestTube.do")
    public ResultModel<List<TestTube>> selectTestTube(@RequestBody TestTube model) throws BusinessException {
        List<TestTube> tubeList = testTubeService.selectTestTube(model);
        return new ResultModel<>(CodeEnum.SUCCESS, "检索到试管信息", tubeList, true);
    }

    //更新试管信息（封管）
    @ApiOperation("更新试管信息（封管）")
    @PostMapping("/updateTestTube.do")
    public ResultModel<Integer> updateTestTube(@RequestBody TestTube model) throws BusinessException {
        int num = testTubeService.updateTestTube(model);
        return new ResultModel<>(CodeEnum.SUCCESS, "封管成功", num, true);
    }

    //该箱子下获取试管数量
    @ApiOperation("该箱子下获取试管数量")
    @PostMapping("/checkTestTube.do")
    public ResultModel<Integer> checkTestTube(@RequestBody TestTube model) throws BusinessException {
        int num = testTubeService.checkTestTube(model.getBoxId());
        if (num <= 50) {
            return new ResultModel<>(CodeEnum.SUCCESS, "试管数量", num, true);
        } else {
            return new ResultModel<>(CodeEnum.BUSINESS_ERROR, "试管数量已最大", num, false);
        }

    }

    //删除试管数据
    @ApiOperation("删除试管数据")
    @PostMapping("/deleteTestTube.do")
    public ResultModel<Integer> deleteTestTube(@RequestBody TestTube model) throws BusinessException {
        int num = testTubeService.deleteTestTube(model.getTestTubeId());
        return new ResultModel<>(CodeEnum.BUSINESS_ERROR, "试管信息已删除", num, false);
    }

}
