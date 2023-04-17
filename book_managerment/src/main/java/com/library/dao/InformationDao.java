package com.library.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.library.domain.FormD;
import com.library.domain.Information;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author tsk
 * @create 2023/3/22 - 23:43
 */
@Mapper
public interface InformationDao extends BaseMapper<Information> {
    @Select("select user.name,user.gender,book.book_name,information.borrowDate,information.id from user,book,information where user.id = information.user_id and book.id = information.book_id")
    public List<FormD> selectByLink();
    @Insert("insert into information(user_id,book_id,user_name,book_name,return_date)values (#{userId},#{bookId},#{userName},#{bookName},date_add(curdate(),interval 15 day))")
    public boolean add(Information information);
}
