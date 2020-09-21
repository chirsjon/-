package com.seventeam.controller;

import com.alibaba.fastjson.JSON;
import com.seventeam.biz.impl.TDeptBizImpl;
import com.seventeam.entity.LayUiTable;
import com.seventeam.entity.ShowDept;
import com.seventeam.entity.TDept;
import com.seventeam.util.ConstantUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Busket
 * @version 1.0
 * @date 2020/5/30 11:01
 */
@Controller
public class TDeptController {
    @Autowired
    private TDeptBizImpl tDeptBizImpl;
    @RequestMapping("/toShowDept")
    public String  toShowDept(){
        return "dept/displayDept";
    }

    @RequestMapping("/showDept")
    @ResponseBody
    public LayUiTable showDept() {
        //开始查询
        List<ShowDept> showDeptList = tDeptBizImpl.findAllDept();
        LayUiTable layUiTable = new LayUiTable();
        layUiTable.setCode(0);
        layUiTable.setMsg("返回消息");
        layUiTable.setData(showDeptList);
        return layUiTable;
    }

    @RequestMapping("/insertDept")
    @ResponseBody
    public Object insertDept(TDept tDept){
        int i = tDeptBizImpl.insertDept(tDept);
        Map map= new HashMap<>();
        if(i>0){
            map.put("code", ConstantUtils.successCode);
            map.put("message",ConstantUtils.insertSuccessMsg);
        }else {
            map.put("code",ConstantUtils.failCode);
            map.put("message",ConstantUtils.insertFailMsg);
        }
        return map;
    }

    @RequestMapping("/delTDept")
    @ResponseBody
    public Object delUser( @RequestParam(value = "ids") String  ids){
        //将json字符串转换成list对象
        List<String> list= (List<String>)JSON.parse(ids);
        int i = tDeptBizImpl.deleteDept(list);
        Map map= new HashMap<>();
        if(i>0){
            map.put("code",ConstantUtils.successCode);
            map.put("message",ConstantUtils.delSuccessMsg);
        }else {
            map.put("code",ConstantUtils.failCode);
            map.put("message",ConstantUtils.delFailMsg);
        }
        return map;
    }

    @RequestMapping("/forbiddenDept")
    @ResponseBody
    public Object forbiddenDept( @RequestParam(value = "ids") String ide){
        //将json字符串转换成list对象
        Integer id=(Integer) JSON.parse(ide);
        //System.out.println(ide);
        int i = tDeptBizImpl.forbiddenDept(id);
        Map map= new HashMap<>();
        if(i>0){
            map.put("code",ConstantUtils.successCode);
            map.put("message",ConstantUtils.forbiddenSuccessMsg);
        }else {
            map.put("code",ConstantUtils.failCode);
            map.put("message",ConstantUtils.forbiddenFailMsg);
        }
        return map;
    }

    @RequestMapping("/updateDetpt")
    @ResponseBody
    public Object editUser(TDept tDept){
        int i = tDeptBizImpl.updateDept(tDept);
        Map map= new HashMap<>();
        if(i>0){
            map.put("code",ConstantUtils.successCode);
            map.put("message",ConstantUtils.editSuccessMsg);
        }else {
            map.put("code",ConstantUtils.failCode);
            map.put("message",ConstantUtils.editFailMsg);
        }
        return map;
    }
}
