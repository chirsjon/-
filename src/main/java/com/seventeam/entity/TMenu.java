package com.seventeam.entity;

import lombok.Data;

@Data
public class TMenu {
    private Integer menu_id;

    private String menuname;

    private Integer parent_id;

    private Integer order_num;

    private String url;

    private String menu_type;

    private String visible;

    private String perms;

    private String icon;

    private String remark;

//    public Integer getMenuId() {
//        return menuId;
//    }
//
//    public void setMenuId(Integer menuId) {
//        this.menuId = menuId;
//    }
//
//    public String getMenuname() {
//        return menuname;
//    }
//
//    public void setMenuname(String menuname) {
//        this.menuname = menuname == null ? null : menuname.trim();
//    }
//
//    public Integer getParentId() {
//        return parentId;
//    }
//
//    public void setParentId(Integer parentId) {
//        this.parentId = parentId;
//    }
//
//    public Integer getOrderNum() {
//        return orderNum;
//    }
//
//    public void setOrderNum(Integer orderNum) {
//        this.orderNum = orderNum;
//    }
//
//    public String getUrl() {
//        return url;
//    }
//
//    public void setUrl(String url) {
//        this.url = url == null ? null : url.trim();
//    }
//
//    public String getMenuType() {
//        return menuType;
//    }
//
//    public void setMenuType(String menuType) {
//        this.menuType = menuType == null ? null : menuType.trim();
//    }
//
//    public String getVisible() {
//        return visible;
//    }
//
//    public void setVisible(String visible) {
//        this.visible = visible == null ? null : visible.trim();
//    }
//
//    public String getPerms() {
//        return perms;
//    }
//
//    public void setPerms(String perms) {
//        this.perms = perms == null ? null : perms.trim();
//    }
//
//    public String getIcon() {
//        return icon;
//    }
//
//    public void setIcon(String icon) {
//        this.icon = icon == null ? null : icon.trim();
//    }
//
//    public String getRemark() {
//        return remark;
//    }
//
//    public void setRemark(String remark) {
//        this.remark = remark == null ? null : remark.trim();
//    }
}