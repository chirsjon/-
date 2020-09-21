package com.seventeam.biz.impl;

import com.seventeam.biz.TDeptBiz;
import com.seventeam.dao.TDeptMapper;
import com.seventeam.entity.ShowDept;
import com.seventeam.entity.TDept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author ZR
 * @version 1.0
 * @date 2020/5/30 10:56
 */
@Service
public class TDeptBizImpl implements TDeptBiz {

    @Autowired
    private TDeptMapper tDeptMapper;
    @Override
    public List<ShowDept> findAllDept() {
        //return tDeptMapper.findAllDept();
        //创建一个展示用的list，以便于对数据进行处理（例如status）
        List<ShowDept> showData=new ArrayList<>();
        for (TDept dbData:tDeptMapper.findAllDept()){
            ShowDept showDept=new ShowDept();
            showDept.setDeptId(dbData.getDeptId());
            showDept.setDeptname(dbData.getDeptname());
            showDept.setOrderNum(dbData.getOrderNum());
            showDept.setRemark(dbData.getRemark());
            if(dbData.getStatus()=='0'){
                showDept.setStatus("正常");
            }else if(dbData.getStatus()=='1'){
                showDept.setStatus("停用");
            }
            showData.add(showDept);
        }
        return showData;
    }

    @Override
    public int insertDept(TDept tDept) {
        tDept.setStatus('0');//初始化状态
        tDept.setDelFlag('0');//初始化逻辑删除
        return tDeptMapper.insertDept(tDept);
    }

    @Override
    public int updateDept(TDept tDept) {
        return tDeptMapper.updateDept(tDept);
    }

    @Override
    public int forbiddenDept(Integer id) {
        return tDeptMapper.forbiddenDept(id);
    }

    @Override
    public int deleteDept(List<String> ids) {
        //做一个判断，如果是超级管理员就调用物理删除，如果是其他用户就调用逻辑删除
        //if()
        //return tDeptMapper.deleteDept(ids);//这个是逻辑删除
        return tDeptMapper.logicalDelDept(ids);
    }

    @Override
    public int Lift_a_Ban(int id) {
        return 0;
    }
}
