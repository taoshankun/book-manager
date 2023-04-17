package com.library.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.library.controller.Utils.Code;
import com.library.controller.Utils.Result;
import com.library.dao.BookDao;
import com.library.dao.InformationDao;
import com.library.dao.UserDao;
import com.library.domain.Book;
import com.library.domain.FormD;
import com.library.domain.Information;
import com.library.domain.User;
import com.library.service.IInformationService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * @author tsk
 * @create 2023/3/20 - 18:44
 */
@Service
public class InformationServiceImpl extends ServiceImpl<InformationDao, Information>implements IInformationService {
    @Autowired
    private InformationDao informationDao;
    @Autowired
    private BookDao bookDao;
    @Autowired
    private UserDao userDao;
    @Override
    public IPage<Information> getPage(int currentPage, int pageSize) {
        IPage page = new Page(currentPage,pageSize);
        informationDao.selectPage(page,null);
        return page;
    }


    @Override
    public List<FormD> selectByLink() {
        List<FormD> formDS = informationDao.selectByLink();
        return formDS;
    }

    @Override
    public IPage<Information> getPage(int currentPage, int pageSize, Information information) {
        LambdaQueryWrapper<Information> lqw = new LambdaQueryWrapper<>();
        lqw.like(Strings.isNotEmpty(information.getUserName()),Information::getUserName,information.getUserName());
        IPage page = new Page(currentPage,pageSize);
        informationDao.selectPage(page,lqw);
        return page;
    }

    @Override
    public Result add(Information information) {

        //获取对应的图书对象
        LambdaQueryWrapper<Book> qw1 = new LambdaQueryWrapper<>();
        qw1.eq(Book::getBookName, information.getBookName());
        Book book = bookDao.selectOne(qw1);
        if (book == null) {
            return new Result(Code.SAVE_ERR, null, "书库中还未存入该书，请检查书名是否正确");
        }
        //获取对应的读者对象
        LambdaQueryWrapper<User> qw2 = new LambdaQueryWrapper<>();
        qw2.eq(User::getName, information.getUserName());
        User user = userDao.selectOne(qw2);
        if (user == null) {
            return new Result(Code.SAVE_ERR, null, "该读者未登记，请登记后再办理借书");
        }
        int borrowedNum = user.getBorrowedNum();
        if ("已借出".equals(book.getState())) {
            return new Result(Code.SAVE_ERR, null, "该书已借出");
        } else if (5 <= borrowedNum) {
            return new Result(Code.SAVE_ERR, null, "该读者已借出5本书，请归还后再借");
        } else {
            book.setState("已借出");
            bookDao.updateById(book);
            user.setBorrowedNum(borrowedNum + 1);
            userDao.updateById(user);
            information.setUserId(user.getId());
            information.setBookId(book.getId());
            boolean flag = informationDao.add(information);
            return new Result(flag ? Code.SAVE_OK:Code.SAVE_ERR,flag);
        }
    }

    @Override
    public boolean updateDate(Information information) {
        Date returnDate = information.getReturnDate();
        Calendar uptime = new GregorianCalendar();
        uptime.setTime(returnDate);
        uptime.add(Calendar.DAY_OF_YEAR,15);
        java.util.Date uptimeTime = uptime.getTime();
        Date newrd = new Date(uptimeTime.getTime());
        information.setReturnDate(newrd);
        return 0 < informationDao.updateById(information);
    }

    @Override
    public boolean deleteById(Integer id) {
        Information information = informationDao.selectById(id);
        User user = userDao.selectById(information.getUserId());
        int borrowedNum = user.getBorrowedNum();
        user.setBorrowedNum(borrowedNum-1);
        userDao.updateById(user);
        Book book = bookDao.selectById(information.getBookId());
        book.setState("未借出");
        bookDao.updateById(book);
        return 0 < informationDao.deleteById(id);
    }

}
