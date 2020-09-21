package com.seventeam.biz.impl;

import com.seventeam.biz.TRoleBiz;
import com.seventeam.dao.TRoleMapper;
import com.seventeam.entity.TRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author HB
 * @version 1.0
 * @date 2020/5/30 10:58
 */
@Service
public class TRoleBizImpl implements TRoleBiz {
    //梓凯 角色管理
    @Autowired
    private TRoleMapper tRoleMapper;

    @Override
    public List<TRole> selectAllRole() {
        return tRoleMapper.selectAllRole();
    }

    //添加角色
    @Override
    public int insertSelective(TRole tRole)
    {
        tRole.setStatus('0');//初始化状态
        tRole.setDelFlag('0');//初始化逻辑删除
        return tRoleMapper.insertSelective(tRole);
    }

    //删除角色
    @Override
    public int delRoleByID(List<String> ids)
    {
        return tRoleMapper.delRoleByID(ids);
    }

    //修改用户信息
    @Override
    public int updateByPrimaryKey(TRole record)
    {
        return tRoleMapper.updateByPrimaryKey(record);
    }



}
