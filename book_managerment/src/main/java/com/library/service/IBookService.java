package com.library.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.library.domain.Book;

/**
 * @author tsk
 * @create 2023/3/20 - 18:42
 */
public interface IBookService extends IService<Book> {
    IPage<Book> getPage(int currentPage,int pageSize);
    IPage<Book> getPage(int currentPage,int pageSize,Book book);
//    boolean add(Book book);
}
