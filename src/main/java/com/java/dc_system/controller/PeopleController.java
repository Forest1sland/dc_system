package com.java.dc_system.controller;

import com.java.dc_system.Exception.BusinessException;
import com.java.dc_system.pojo.People;
import com.java.dc_system.pojo.vo.ResultModel;
import com.java.dc_system.service.IPeopleService;
import com.java.dc_system.until.CodeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: zjt
 * @Date: 2022-11-04 22:52
 * @Description:
 */
@RestController
@RequestMapping("/people")
public class PeopleController {
    @Autowired
    private IPeopleService peopleService;
    //获取全部被检测人员信息
    @PostMapping("/getAllPeople.do")
    public ResultModel<List<People>> getAllPeople() throws BusinessException {
        List<People> peopleList = peopleService.getAllPeople(null);
        return new ResultModel<>(CodeEnum.SUCCESS, "查询到被检测人员信息", peopleList, true);
    }
    //被检测人员注册
    @PostMapping("/registerPeople.do")
    public ResultModel<Object> registerPeople(@RequestBody People model) throws BusinessException {
        List<People> people = peopleService.checkPeople(model.getIdCard(), model.getTel());
        if (people.size() == 0){
            int num = peopleService.registerPeople(model);
            if(num !=0){
                return new ResultModel<>(CodeEnum.SUCCESS, "注册成功", num, true);
            }else {
                return new ResultModel<>(CodeEnum.BUSINESS_ERROR, "注册失败", num, false);
            }
        }else {
            return new ResultModel<>(CodeEnum.BUSINESS_ERROR, "注册失败", "您已经已注册", false);
        }
    }
    //更新被检测人员信息
    @PostMapping("/updatePeople.do")
    public ResultModel<Integer> updatePeople(@RequestBody People model) throws BusinessException {
        int num = peopleService.updatePeople(model);
        return new ResultModel<>(CodeEnum.SUCCESS,"成功更新检测人员信息",num,true);
    }
    //删除被检测人员信息
    @PostMapping("/deletePeople.do")
    public ResultModel<Integer> deletePeople(Integer peopleId) throws BusinessException {
        int num = peopleService.deletePeople(peopleId);
        return new ResultModel<>(CodeEnum.SUCCESS,"成功删除被检测人员信息",num,true);
    }
    //被检测人员登录
    @PostMapping("/loginPeople.do")
    public ResultModel<People> loginPeople(String idCard,String tel) throws BusinessException {
        People people = peopleService.loginPeople(idCard, tel);
        return new ResultModel<>(CodeEnum.SUCCESS,"成功更新被检测人员信息",people,true);
    }
    //获取检测人员信息
    @PostMapping("/getOnePeople.do")
    public ResultModel<Object> getOnePeople(@RequestBody People model) throws BusinessException {
        if (model.getPeopleId() != null){
            List<People> people = peopleService.getOnePeople(model);
            return new ResultModel<>(CodeEnum.SUCCESS,"检索到被检测人员信息",people,true);
        }else {
            return new ResultModel<>(CodeEnum.BUSINESS_ERROR,"没有检索到被检测人员信息","没有请求参数",true);
        }
    }
}
