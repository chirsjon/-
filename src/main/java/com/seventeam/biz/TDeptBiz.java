package com.seventeam.biz;

import com.seventeam.entity.ShowDept;
import com.seventeam.entity.TDept;

import java.util.List;

/**
 * @author HB
 * @version 1.0
 * @date 2020/5/30 10:56
 */
public interface TDeptBiz {
    //查询所有部门
    List<ShowDept> findAllDept();
    //添加部门
    int insertDept(TDept tDept);
    //修改部门
    int updateDept(TDept tDept);
    //禁用部门
    int forbiddenDept(Integer id);
    //删除部门
    int deleteDept(List<String> ids);
    //解禁部门
    int Lift_a_Ban(int id);
}
