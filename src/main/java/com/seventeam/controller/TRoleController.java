package com.seventeam.controller;

import com.alibaba.fastjson.JSON;
import com.seventeam.biz.TRoleBiz;
import com.seventeam.entity.LayUiTable;
import com.seventeam.entity.TRole;
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
 * @author HB
 * @version 1.0
 * @date 2020/5/30 11:01
 */
@Controller
public class TRoleController {
    //梓凯 角色管理
    @Autowired
    private TRoleBiz tRoleBiz;


    @RequestMapping("/toDisplayRole")
    public String  toShowRole(){
        return "role/displayRole";
    }

    @RequestMapping("/displayRole")
    @ResponseBody
    public LayUiTable showRoleLayui() {
        //开始查询
        List<TRole> roleList = tRoleBiz.selectAllRole();
        LayUiTable layUiTable = new LayUiTable();
        layUiTable.setCode(0);
        layUiTable.setMsg("返回消息");
        layUiTable.setData(roleList);
        return layUiTable;
    }


    //保存添加角色的信息
    @RequestMapping("/saveRole")
    @ResponseBody
    public Object saveUser(TRole tRole)
    {
        System.out.println("角色添加");
        int i= tRoleBiz.insertSelective(tRole);
        Map map =new HashMap<>();

        if(i>0)
        {
            map.put("code", ConstantUtils.successCode);
            map.put("message",ConstantUtils.insertSuccessMsg);

        }
        else
        {
            map.put("code", ConstantUtils.failCode);
            map.put("message",ConstantUtils.insertFailMsg);
        }
        return map;
    }

    //删除用户信息
    @RequestMapping("/delRole")
    @ResponseBody
    public Object delUser( @RequestParam(value = "ids") String ids)
    {
        //将json字符串转换成list对象
        System.out.println("删除中：");
        List<String> list= (List<String>) JSON.parse(ids);
        int i = tRoleBiz.delRoleByID(list);
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


    //修改添加角色的信息
    @RequestMapping("/editRole")
    @ResponseBody
    public Object editUser(TRole tRole)
    {
        int i= tRoleBiz.updateByPrimaryKey(tRole);
        Map map =new HashMap<>();
        if(i>0)
        {
            map.put("code", ConstantUtils.successCode);
            map.put("message",ConstantUtils.editSuccessMsg);

        }
        else
        {
            map.put("code", ConstantUtils.failCode);
            map.put("message",ConstantUtils.editFailMsg);
        }
        return map;
    }
}

