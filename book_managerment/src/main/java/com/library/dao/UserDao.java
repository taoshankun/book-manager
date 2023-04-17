package com.library.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.library.domain.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author tsk
 * @create 2023/3/22 - 23:41
 */
@Mapper
public interface UserDao extends BaseMapper<User> {
}
