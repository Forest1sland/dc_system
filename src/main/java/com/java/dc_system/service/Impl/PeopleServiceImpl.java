package com.java.dc_system.service.Impl;

import com.java.dc_system.Exception.BusinessException;
import com.java.dc_system.dao.PeopleDao;
import com.java.dc_system.pojo.People;
import com.java.dc_system.service.IPeopleService;
import com.java.dc_system.utils.CodeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author: zjt
 * @Date: 2022-11-04 20:17
 * @Description:
 */
@Component
public class PeopleServiceImpl implements IPeopleService {
    @Autowired
    private PeopleDao peopleDao;

    @Override
    public List<People> getAllPeople(People model) throws BusinessException {
        List<People> peopleList = peopleDao.getPeople(model);
        if (peopleList != null) {
            return peopleList;
        } else {
            throw new BusinessException("没有获取到被检测人员信息", CodeEnum.BUSINESS_ERROR);
        }
    }

    @Override
    public List<People> getOnePeople(People model) throws BusinessException {
        List<People> people = peopleDao.getPeople(model);
        if (people != null) {
            return people;
        } else {
            throw new BusinessException("没有获取到被检测人员信息", CodeEnum.BUSINESS_ERROR);
        }
    }

    @Override
    public int updatePeople(People model) throws BusinessException {
        int num = peopleDao.updatePeople(model);
        if (num != 0) {
            return num;
        } else {
            throw new BusinessException("没有更新检测人员信息", CodeEnum.BUSINESS_ERROR);
        }
    }

    @Override
    public int deletePeople(Integer peopleId) throws BusinessException {
        int num = peopleDao.deletePeople(peopleId);
        if (num != 0) {
            return num;
        } else {
            throw new BusinessException("没有删除被检测人员信息", CodeEnum.BUSINESS_ERROR);
        }
    }

    @Override
    public int registerPeople(People model) throws BusinessException {
        int num = peopleDao.registerPeople(model);
        if (num != 0) {
            return num;
        } else {
            throw new BusinessException("被检测人员信息没有注册", CodeEnum.BUSINESS_ERROR);
        }
    }

    @Override
    public People loginPeople(String idCard, String tel) throws BusinessException {
        People people = peopleDao.loginPeople(idCard, tel);
        if (people != null) {
            return people;
        } else {
            throw new BusinessException("被检测人员没有登录", CodeEnum.LOGIN_FAILED);
        }
    }

    @Override
    public List<People> checkPeopleByIdCardOrTel(String idCard, String tel) throws BusinessException {
        List<People> people = peopleDao.checkPeopleByIdCardOrTel(idCard, tel);
        if (people != null) {
            return people;
        } else {
            throw new BusinessException("没有检索到被检测人员", CodeEnum.LOGIN_FAILED);
        }
    }

    public List<People> checkPeopleByIdCardAndTel(String idCard, String tel) throws BusinessException {
        List<People> people = peopleDao.checkPeopleByIdCardAndTel(idCard, tel);
        if (people != null) {
            return people;
        } else {
            throw new BusinessException("没有检索到被检测人员", CodeEnum.LOGIN_FAILED);
        }

    }
}
