package com.seventeam.dao;

import com.seventeam.entity.TDept;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface TDeptMapper {
    //查询所有部门
    List<TDept> findAllDept();
    //添加部门
    int insertDept(TDept tDept);
    //修改部门
    int updateDept(TDept tDept);
    //禁用部门
    int forbiddenDept(Integer id);
    //解禁部门
    int Lift_a_Ban(int id);
    //删除部门(物理删除)
    int deleteDept(@Param("ids") List<String> ids);
    //删除部门（逻辑删除）
    int logicalDelDept(@Param("ids") List<String> ids);
}