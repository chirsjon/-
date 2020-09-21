package com.seventeam.dao;

import com.seventeam.entity.TMenu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.awt.*;
import java.util.List;
@Mapper
@Repository
public interface TMenuMapper {
    int deleteByPrimaryKey(TMenu tMenu);

    int insert(TMenu record);

    int insertSelective(TMenu record);

    TMenu selectByPrimaryKey(Integer menuId);

    int updateByPrimaryKeySelective(TMenu record);
    List<TMenu> selectAllMenu();
    int updateByPrimaryKey(TMenu record);
    int updateByMenuname(TMenu record);
}