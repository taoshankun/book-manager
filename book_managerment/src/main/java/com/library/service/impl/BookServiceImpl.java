package com.library.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.library.controller.Utils.Code;
import com.library.dao.BookDao;
import com.library.domain.Book;
import com.library.exception.BusinessException;
import com.library.service.IBookService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author tsk
 * @create 2023/3/20 - 18:44
 */
@Service
public class BookServiceImpl extends ServiceImpl<BookDao, Book>implements IBookService {
    @Autowired
    private BookDao bookDao;
    @Override
    public IPage<Book> getPage(int currentPage, int pageSize) {
        IPage page = new Page(currentPage,pageSize);
        bookDao.selectPage(page,null);
        return page;
    }

    @Override
    public IPage<Book> getPage(int currentPage, int pageSize, Book book) {
        LambdaQueryWrapper<Book> lqw = new LambdaQueryWrapper<>();
        lqw.like(Strings.isNotEmpty(book.getBookName()),Book::getBookName,book.getBookName());
        lqw.like(Strings.isNotEmpty(book.getAuthor()),Book::getAuthor,book.getAuthor());
        lqw.like(Strings.isNotEmpty(book.getType()),Book::getType,book.getType());
        lqw.like(Strings.isNotEmpty(book.getState()),Book::getState,book.getState());
        IPage page = new Page(currentPage,pageSize);
        bookDao.selectPage(page,lqw);
        return page;
    }
    public boolean save(Book book){
        if (book.getAuthor().length() > 20){
            throw new BusinessException(Code.BUSINESS_ERR,"作者姓名不能超过20个字");
        }
        return 0 < bookDao.insert(book);
    }
}
