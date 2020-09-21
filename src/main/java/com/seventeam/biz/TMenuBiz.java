package com.seventeam.biz;

import com.seventeam.entity.TMenu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author HB
 * @version 1.0
 * @date 2020/5/30 10:57
 */
public interface TMenuBiz {
    List<TMenu> selectAllMenu();
    int deleteByPrimaryKey(TMenu tMenu);
    int insertSelective(TMenu record);
    int updateByPrimaryKeySelective(TMenu record);
    int updateByMenuname(TMenu record);
}
