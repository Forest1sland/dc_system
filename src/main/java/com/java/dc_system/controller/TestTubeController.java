package com.java.dc_system.controller;

import com.java.dc_system.Exception.BusinessException;
import com.java.dc_system.pojo.TestTube;
import com.java.dc_system.pojo.vo.ResultModel;
import com.java.dc_system.service.ITestTubeService;
import com.java.dc_system.utils.CodeEnum;
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
@RequestMapping("/testTube")
public class TestTubeController {

    @Autowired
    private ITestTubeService testTubeService;
    //开管
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
            return new ResultModel<>(CodeEnum.BUSINESS_ERROR, "该试管已存在", tubeList.get(0).getTestTubeCode(), false);
        }
    }
    //检索试管信息
    @PostMapping("/selectTestTube.do")
    public ResultModel<List<TestTube>> selectTestTube(@RequestBody TestTube model) throws BusinessException {
        List<TestTube> tubeList = testTubeService.selectTestTube(model);
        return new ResultModel<>(CodeEnum.SUCCESS, "检索到试管信息", tubeList, true);
    }
    //封管
    @PostMapping("/updateTestTube.do")
    public ResultModel<Integer> updateTestTube(@RequestBody TestTube model) throws BusinessException {
        int num = testTubeService.updateTestTube(model);
        return new ResultModel<>(CodeEnum.SUCCESS, "封管成功", num, true);
    }
}
