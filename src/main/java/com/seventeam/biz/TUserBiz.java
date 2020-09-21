package com.seventeam.biz;

import com.github.pagehelper.PageInfo;
import com.seventeam.entity.TUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author HB
 * @version 1.0
 * @date 2020/5/30 10:59
 */
public interface TUserBiz {

    TUser selectUserByName(String name);

    //查询所有用户
    PageInfo<TUser> queryAllUser(int page, int limit);

    //保存添加的用户
    int insertSelective(TUser record);

    //删除用户信息
    int delUserByID( @Param("ids") List<String> ids);

    //修改用户的信息（可以不修改密码）
    int updateByPrimaryKeySelective(TUser record);

    //查询最后一条数据
    TUser queryLastUser();


}
