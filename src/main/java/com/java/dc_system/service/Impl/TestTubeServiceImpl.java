package com.java.dc_system.service.Impl;

import com.java.dc_system.Exception.BusinessException;
import com.java.dc_system.dao.TestTubeDao;
import com.java.dc_system.pojo.TestTube;
import com.java.dc_system.service.ITestTubeService;
import com.java.dc_system.until.CodeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author: zjt
 * @Date: 2022-11-06 21:29
 * @Description:
 */
@Component
public class TestTubeServiceImpl implements ITestTubeService {
    @Autowired
    private TestTubeDao testTubeDao;
    @Override
    public int insertTestTube(TestTube testTube) throws BusinessException {
        int num = testTubeDao.insertTestTube(testTube);
        if (num != 0){
            return num;
        } else{
            throw new BusinessException("没有添加试管数据", CodeEnum.BUSINESS_ERROR);
        }
    }

    @Override
    public List<TestTube> selectTestTube(TestTube testTube) throws BusinessException {
        List<TestTube> tubeList = testTubeDao.selectTestTube(testTube);
        if (tubeList != null){
            return tubeList;
        } else{
            throw new BusinessException("没有检索到到试管数据", CodeEnum.BUSINESS_ERROR);
        }
    }

    @Override
    public int updateTestTube(TestTube testTube) throws BusinessException {
        int num = testTubeDao.updateTestTube(testTube);
        if (num != 0){
            return num;
        } else{
            throw new BusinessException("没有更新试管数据", CodeEnum.BUSINESS_ERROR);
        }
    }

    @Override
    public int checkTestTube(Integer boxId) throws BusinessException {
        int num = testTubeDao.checkTestTube(boxId);
        if (num != 0) {
            return num;
        } else {
            throw new BusinessException("没有检索到试管数量", CodeEnum.BUSINESS_ERROR);
        }
    }

    @Override
    public int deleteTestTube(Integer testTubeId) throws BusinessException {
        int num = testTubeDao.deleteTestTube(testTubeId);
        if (num != 0) {
            return num;
        } else {
            throw new BusinessException("没有删除试管数量", CodeEnum.BUSINESS_ERROR);
        }
    }
}
