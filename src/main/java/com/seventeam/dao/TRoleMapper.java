package com.seventeam.dao;

import com.seventeam.entity.TRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TRoleMapper {
    int deleteByPrimaryKey(Integer roleId);

    int insert(TRole record);

    TRole selectByPrimaryKey(Integer roleId);

    //梓凯 角色管理
    //查询所有用户
    List<TRole> selectAllRole();
    //添加角色
    int insertSelective(TRole record);
    //删除角色
    int delRoleByID( @Param("ids") List<String> ids); //删除选中的用户
    //修改角色
    int updateByPrimaryKey(TRole record);

}