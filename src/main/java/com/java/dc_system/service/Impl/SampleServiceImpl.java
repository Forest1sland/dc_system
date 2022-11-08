package com.java.dc_system.service.Impl;

import com.java.dc_system.dao.SampleDao;
import com.java.dc_system.pojo.Sample;
import com.java.dc_system.service.ISampleService;
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
    public List<Sample> selectSample(Sample sample) {
        return sampleDao.selectSample(sample);
    }

    @Override
    public int insertSample(Sample sample) {
        return sampleDao.insertSample(sample);
    }

    @Override
    public Integer checkSampleTestTubeId(Integer testTube) {
        return sampleDao.checkSampleTestTubeId(testTube);
    }

    @Override
    public List<Sample> selectInfoUnderSample(Integer testTubeId) {
        return sampleDao.selectInfoUnderSample(testTubeId);
    }

    @Override
    public Integer deleteOneByPeopleId(Integer peopleId) {
        return sampleDao.deleteOneByPeopleId(peopleId);
    }
}
