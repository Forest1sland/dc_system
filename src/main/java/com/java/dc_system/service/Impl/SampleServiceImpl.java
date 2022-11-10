package com.java.dc_system.service.Impl;

import com.java.dc_system.Exception.BusinessException;
import com.java.dc_system.dao.SampleDao;
import com.java.dc_system.pojo.Sample;
import com.java.dc_system.service.ISampleService;
import com.java.dc_system.until.CodeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author: zjt
 * @Date: 2022-11-07 17:37
 * @Description:
 */
@Component
public class SampleServiceImpl implements ISampleService {

    @Autowired
    private SampleDao sampleDao;

    @Override
    public List<Sample> selectSample(Sample sample) throws BusinessException {
        List<Sample> sampleList = sampleDao.selectSample(sample);
        if (sampleList != null){
            return sampleList;
        } else{
            throw new BusinessException("没有获取样本数据", CodeEnum.BUSINESS_ERROR);
        }
    }

    @Override
    public int insertSample(Sample sample) throws BusinessException {
        int num = sampleDao.insertSample(sample);
        if (num != 0){
            return num;
        } else{
            throw new BusinessException("没有添加样本数据", CodeEnum.BUSINESS_ERROR);
        }
    }

    @Override
    public Integer checkSampleTestTubeId(Integer testTubeId) throws BusinessException {
        Integer num = sampleDao.checkSampleTestTubeId(testTubeId);
        if (num != 0){
            return num;
        } else{
            throw new BusinessException("没有获取样本中同一试管数量", CodeEnum.BUSINESS_ERROR);
        }
    }

    @Override
    public List<Sample> selectInfoUnderSample(Integer testTubeId) throws BusinessException {
        List<Sample> sampleList = sampleDao.selectInfoUnderSample(testTubeId);
        if (sampleList.size()!= 0){
            return sampleList;
        } else{
            throw new BusinessException("没有获取样本中同一试管数量", CodeEnum.BUSINESS_ERROR);
        }
    }

    @Override
    public Integer deleteOneByPeopleId(Integer peopleId) {
        return sampleDao.deleteOneByPeopleId(peopleId);
    }
}
