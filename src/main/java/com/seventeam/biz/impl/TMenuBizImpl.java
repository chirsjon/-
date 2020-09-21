package com.seventeam.biz.impl;

import com.seventeam.biz.TMenuBiz;
import com.seventeam.dao.TMenuMapper;
import com.seventeam.entity.TMenu;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author HB
 * @version 1.0
 * @date 2020/5/30 10:57
 */
@Service
public class TMenuBizImpl implements TMenuBiz {
    @Autowired
    TMenuMapper tMenuMapper;
    @Override
    public List<TMenu> selectAllMenu() {
        return tMenuMapper.selectAllMenu();
    }

    @Override
    public int deleteByPrimaryKey(TMenu tMenu) {
        return tMenuMapper.deleteByPrimaryKey(tMenu);
    }

    @Override
    public int insertSelective(TMenu record) {
        return tMenuMapper.insertSelective(record);
    }

    @Override
    public int updateByPrimaryKeySelective(TMenu record) {
        return tMenuMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByMenuname(TMenu record) {
        return tMenuMapper.updateByMenuname(record);
    }
}
