package com.seventeam.controller;

import com.alibaba.fastjson.JSON;
import com.seventeam.biz.TMenuBiz;
import com.seventeam.entity.LayUiTreeTable;
import com.seventeam.entity.TMenu;
import com.seventeam.util.ConstantUtils;
import com.seventeam.util.TmenuUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

public class TMenuController {
    @Autowired
    TMenuBiz tMenuBizImpl;
    @RequestMapping("/toDisplayMenu")
    public String toShowMenu(){
        return "menu/displayMenu";
    }

    @RequestMapping("/selectAllMenu")
    @ResponseBody
    public LayUiTreeTable selectAllMenu(){
        List<TMenu> tMenus = tMenuBizImpl.selectAllMenu();
        LayUiTreeTable layUiTreeTable=new LayUiTreeTable();
        layUiTreeTable.setCode(0);
        layUiTreeTable.setMsg("返回消息");
        layUiTreeTable.setData(tMenus);
        return layUiTreeTable;
    }
    @RequestMapping("/delMenu")
    @ResponseBody
    public Object delMenu(TMenu tMenu){
        int i = tMenuBizImpl.deleteByPrimaryKey(tMenu);
        Map map= new HashMap<>();
        if(i>0){
            map.put("code", ConstantUtils.successCode);
            map.put("message",ConstantUtils.delSuccessMsg);
        }else {
            map.put("code",ConstantUtils.failCode);
            map.put("message",ConstantUtils.delFailMsg);
        }
        return map;
    }
    @RequestMapping("/saveMenu")
    @ResponseBody
    public Object saveUser(String menu_type,String menuname,String url,String perms,int order_num){
        TMenu tMenu= TmenuUtils.getTmenu(menu_type,menuname,url,perms,order_num);
        int i = tMenuBizImpl.insertSelective(tMenu);
        Map map=new HashMap<>();
        if(i>0){
            map.put("code", ConstantUtils.successCode);
            map.put("message",ConstantUtils.insertSuccessMsg);
        }
        else {
            map.put("code",ConstantUtils.failCode);
            map.put("message",ConstantUtils.insertFailMsg);
        }
        return map;
    }
    @RequestMapping("/editMenu")
    @ResponseBody
    public Object editUser(TMenu tMenu){
        int i=tMenuBizImpl.updateByPrimaryKeySelective(tMenu);
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
