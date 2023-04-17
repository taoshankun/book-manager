package com.library.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.library.domain.Manager;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author tsk
 * @create 2023/3/15 - 20:35
 */
@Mapper
public interface ManagerDao extends BaseMapper<Manager> {
    @Select("select * from manager where id = #{id} and password = #{password}")
    public Manager select(Manager manager);
}
