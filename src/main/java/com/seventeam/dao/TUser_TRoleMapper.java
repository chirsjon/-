package com.seventeam.dao;


import com.seventeam.entity.TUser_TRoleKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TUser_TRoleMapper {
    int deleteByPrimaryKey(TUser_TRoleKey key);

    //通过userid 进行删除表中的关联数据
    int deleteByUserId(TUser_TRoleKey key);

    int insert(TUser_TRoleKey record);

   //插入用户角色关联进表中****
    int insertSelective(TUser_TRoleKey tUser_tRoleKey);
}