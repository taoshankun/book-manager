package com.library.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.library.domain.Book;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author tsk
 * @create 2023/3/20 - 11:22
 */
@Mapper
public interface BookDao extends BaseMapper<Book> {

}
