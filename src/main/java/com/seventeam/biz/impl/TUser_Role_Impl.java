package com.seventeam.biz.impl;

import com.seventeam.biz.TUser_Role_Biz;
import com.seventeam.dao.TUserMapper;
import com.seventeam.dao.TUser_TRoleMapper;
import com.seventeam.entity.TUser;
import com.seventeam.entity.TUser_TRoleKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TUser_Role_Impl implements TUser_Role_Biz

{

    @Autowired
    private TUser_TRoleMapper tUser_tRoleMapper;

    @Override
    public int insertSelective(TUser_TRoleKey record)
    {
        return tUser_tRoleMapper.insertSelective(record) ;
    }

    @Override
    public int deleteByUserId(TUser_TRoleKey key)
    {
        return tUser_tRoleMapper.deleteByUserId(key);
    }


}
