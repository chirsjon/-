package com.seventeam.biz;

import com.seventeam.entity.TRole;

import java.util.List;

/**
 * @author HB
 * @version 1.0
 * @date 2020/5/30 10:58
 */
public interface TRoleBiz {
    //梓凯 角色管理
    List<TRole> selectAllRole();

    public int insertSelective(TRole tRole);

    public int delRoleByID(List<String> ids);

    public int updateByPrimaryKey(TRole record);
}
