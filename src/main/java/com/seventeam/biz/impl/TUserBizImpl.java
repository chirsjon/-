package com.seventeam.biz.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.seventeam.biz.TUserBiz;
import com.seventeam.dao.TUserMapper;
import com.seventeam.entity.TUser;
import com.seventeam.shiro.ShiroUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * @author HB
 * @version 1.0
 * @date 2020/5/30 10:59
 */

@Service
public class TUserBizImpl implements TUserBiz {

    @Autowired
    private TUserMapper tUserMapper;

    @Override
    public TUser selectUserByName(String name) {
        return tUserMapper.selectUserByName(name);
    }
//请求-controller-service(biz)-dao-db
    //查询所有用户
    @Override
    public PageInfo<TUser> queryAllUser(int page, int limit)
    {
        //开始分页,第一个参数是当前第几页，第二个参数是一页显示多少行
        PageHelper.startPage(page,limit);
        //开始查询
        List<TUser> userInfoList = tUserMapper.queryAllUser();
        //结束分页,封装了分页之后所有数据
        PageInfo<TUser> pageInfo=new PageInfo(userInfoList);
        return pageInfo;
    }

    //添加用户帅比
    @Override
    public int insertSelective(TUser record)
    {

        //此处密码做加盐加密

        String salt= UUID.randomUUID().toString();
        String message=record.getPassword();

        String encryption= ShiroUtil.encryptionBySalt(salt,message);
        record.setPassword(encryption);
        record.setSalt(salt);
        return tUserMapper.insertSelective(record);
    }

    //删除用户
    @Override
    public int delUserByID(List<String> ids)
    {
        return tUserMapper.delUserByID(ids);
    }


    //修改用户信息
    @Override
    public int updateByPrimaryKeySelective(TUser record)
    {
        return tUserMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public TUser queryLastUser()
    {
        return tUserMapper.queryLastUser();
    }


}
