package com.seventeam.entity;

import lombok.Data;

@Data
public class ShowDept{
    //部门id
    private Integer deptId;
    //部门名字
    private String deptname;
    //显示顺序
    private Integer orderNum;
    //状态
    private String status;
    //删除标志
    private char delFlag;
    //备注
    private String remark;
}
