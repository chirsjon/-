package com.seventeam.dao;

import com.seventeam.entity.TUser;
import com.seventeam.entity.TUser_TRoleKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TUserMapper
{
    int deleteByPrimaryKey(Integer userId);

    int insert(TUser record);

    int insertSelective(TUser record);//保存添加的用户

    TUser selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(TUser record);//修改用户的信息（可以不修改密码）

    int updateByPrimaryKey(TUser record);

    List<TUser> queryAllUser();//查询所有用户

    int delUserByID( @Param("ids") List<String> ids); //删除选中的用户

    TUser queryLastUser(); //查询最后一条数据


    TUser selectUserByName(String name);
}