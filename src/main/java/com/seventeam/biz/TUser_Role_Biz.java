package com.seventeam.biz;


import com.seventeam.entity.TUser_TRoleKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TUser_Role_Biz
{

    //建立用户ID与角色ID的联系
    int insertSelective(TUser_TRoleKey record);

    //通过userid 进行删除表中的关联数据
    int deleteByUserId(TUser_TRoleKey key);
}
