package com.seventeam.util;

import com.seventeam.entity.LayUiTreeTable;
import com.seventeam.entity.TMenu;

public class TmenuUtils {
    public static TMenu getTmenu(String menu_type,String menuname,String url,String perms,int order_num){
        TMenu tMenu=new TMenu();
        tMenu.setMenu_type(menu_type);
        tMenu.setMenuname(menuname);
        tMenu.setUrl(url);
        tMenu.setPerms(perms);
        tMenu.setOrder_num(order_num);
        if(tMenu.getMenu_type().equals("C")){
            tMenu.setParent_id(1);
        }
        return tMenu;
    }
}
