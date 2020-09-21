package com.seventeam.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.seventeam.biz.TUserBiz;
import com.seventeam.biz.TUser_Role_Biz;
import com.seventeam.entity.LayUiTable;
import com.seventeam.entity.TUser;
import com.seventeam.entity.TUser_TRoleKey;
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
 * @date 2020/5/30 11:02
 */

@Controller
public class TUserController
{
    @Autowired
    private TUserBiz tUserBiz;

    @Autowired
    private TUser_Role_Biz tUser_role_biz;


    //
    @RequestMapping("/toDisPlayUser")
    public String toDisPlayUser()
    {
        return "user/displayUser";
    }


    //查询所有用户并展示页面
    @RequestMapping("/displayUser")
    @ResponseBody
    public LayUiTable displayUser(int page, int limit)
    {
        System.out.println("来到这里-------");

        PageInfo<TUser> pageInfo= tUserBiz.queryAllUser(page,limit);

        LayUiTable layuiTable=new LayUiTable();

        layuiTable.setCode(0);
        layuiTable.setCount(pageInfo.getTotal());
        layuiTable.setMsg("返回消息");
        layuiTable.setData(pageInfo.getList());
        return   layuiTable;
    }

    //保存添加用户的信息
    @RequestMapping("/saveUser")
    @ResponseBody
    public Object saveUser(TUser tUser)
    {
        System.out.println("用户添加");
        int i= tUserBiz.insertSelective(tUser);

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

    //保存添加用户的信息
    @RequestMapping("/saveUserRole")
    @ResponseBody
    public Object saveUserRole(@RequestParam(value = "ids") String  ids)
    {
        System.out.println("角色添加");
        //查询目前数据库tbl_user表中最后一行即刚刚新加入的数据。
        TUser tUser1=tUserBiz.queryLastUser();
        Integer userid= Integer.valueOf(tUser1.getUserId());
        System.out.println("++++"+userid);
        List<String> list= (List<String>) JSON.parse(ids);
        System.out.println(list);
        int roleid = Integer.parseInt(list.get(list.size()-1));
        System.out.println(roleid);

        TUser_TRoleKey tUser_tRoleKey=new TUser_TRoleKey();
        tUser_tRoleKey.setUserId(userid);
        tUser_tRoleKey.setRoleId(roleid);
        Map map= new HashMap<>();
        int i =tUser_role_biz.insertSelective(tUser_tRoleKey);
        if(i>0)
        {
            map.put("code", ConstantUtils.successCode);
            map.put("message",ConstantUtils.insertUserRoleSuccessMsg);

        }
        else
        {
            map.put("code", ConstantUtils.failCode);
            map.put("message",ConstantUtils.insertUserRoleFailMsg);
        }
        return map;
    }
    //删除用户信息
    @RequestMapping("/delUser")
    @ResponseBody
    public Object delUser( @RequestParam(value = "ids") String  ids)
    {
        //将json字符串转换成list对象
        System.out.println("删除中：");
        List<String> list= (List<String>) JSON.parse(ids);
        int i = tUserBiz.delUserByID(list);
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

    //删除用户关联的角色信息
    @RequestMapping("/delUserRole")
    @ResponseBody
    public Object delUserRole( @RequestParam(value = "ids") String  ids)
    {
        //将json字符串转换成list对象
        System.out.println("删除用户角色中：");
        List<String> list= (List<String>) JSON.parse(ids);
        System.out.println("----:"+list);
        int j;
        Map map= new HashMap<>();
        for (j=0;j<list.size();j++)
        {
            String userid = list.get(j);
            System.out.println(userid);
            int userId= Integer.parseInt(userid);
            TUser_TRoleKey tUser_tRoleKey=new TUser_TRoleKey();
            tUser_tRoleKey.setUserId(userId);
            int i=tUser_role_biz.deleteByUserId(tUser_tRoleKey);
            if(i>0){
                map.put("code",ConstantUtils.successCode);
                map.put("message",ConstantUtils.delUserRoleSuccessMsg);
            }else {
                map.put("code",ConstantUtils.failCode);
                map.put("message",ConstantUtils.delUserRoleFailMsg);
            }
        }
        return map;
    }

    //保存添加用户的信息
    @RequestMapping("/editUser")
    @ResponseBody
    public Object editUser(TUser tUser)
    {
        int i= tUserBiz.updateByPrimaryKeySelective(tUser);
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
