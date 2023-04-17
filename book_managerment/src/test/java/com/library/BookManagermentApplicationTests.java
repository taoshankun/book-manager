package com.library;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.library.controller.InformationController;
import com.library.dao.BookDao;
import com.library.dao.InformationDao;
import com.library.domain.Book;
import com.library.domain.Information;
import com.library.domain.User;
import com.library.service.IBookService;
import com.library.service.IInformationService;
import com.library.service.IUserService;
import org.apache.logging.log4j.util.Strings;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;

@SpringBootTest
class BookManagermentApplicationTests {

    @Autowired
    private IUserService userService;
    @Autowired
    IBookService bookService;
    @Autowired
    IInformationService informationService;
    @Autowired
    InformationDao informationDao;
    @Autowired
    InformationController informationController;
//    @Test
//    void getBookObj(){
//        Information information = new Information();
//        information.setBookName("百年");
//        LambdaQueryWrapper<Book> qw1 = new LambdaQueryWrapper<>();
//        qw1.eq(Book::getBookName,information.getBookName());
//        Book book = bookService.getOne(qw1);
//        if (book == null){
//            System.out.println("null book");
//        }
//    }
//    @Test
//    void getPageTest(){
//        Information information = new Information();
//        information.setUserName("x");
//        LambdaQueryWrapper<Information> lqw = new LambdaQueryWrapper<>();
//        lqw.like(Strings.isNotEmpty(information.getUserName()),Information::getUserName,information.getUserName());
//        IPage page = new Page(1,10);
//        informationDao.selectPage(page, lqw);
//        System.out.println(page.getRecords());
//    }
//    @Test
//    void getPageSer(){
//        Information information = new Information();
//        information.setUserName("x");
//        IPage<Information> page = informationService.getPage(1, 10,information);
//        if (1 > page.getPages()){
//            page=informationService.getPage((int) page.getPages(),10,information);
//        }
//        System.out.println(page.getRecords());
//    }
//    @Test
//    void updateTest(){
//        Information information = informationDao.selectById(21);
//        Date returnDate = information.getReturnDate();
//        Calendar calendar = new GregorianCalendar();
//        calendar.setTime(returnDate);
//        calendar.add(Calendar.DATE,30);
//        java.util.Date udate = calendar.getTime();
//        Date newdt = new Date(udate.getTime());
//        System.out.println(newdt);
//    }
//    @Test
//    void XuJieTest(){
//        Information information = informationDao.selectById(21);
//        informationController.update(information);
//    }
//    @Test
//    void selectByidTest(){
//        System.out.println(informationService.getById(20));
//    }
}
