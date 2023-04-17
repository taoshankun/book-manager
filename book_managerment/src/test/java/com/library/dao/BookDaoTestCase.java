package com.library.dao;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.library.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookDaoTestCase {
    @Autowired
    private BookDao bookDao;
//    @Test
//    void testGetById(){
//        System.out.println(bookDao.selectById(1));
//    }
//    @Test
//    void testsave(){
//        Book book = new Book();
//        book.setBookName("红楼梦");
//        book.setAuthor("曹雪芹");
//        bookDao.insert(book);
//    }
//    @Test
//    void testDelete(){
//        bookDao.deleteById(3);
//    }
//    @Test
//    void testUpdate(){
//        Book book = new Book();
//        book.setId(2);
//        book.setState("百年孤独");
//        book.setAuthor("加西亚·马尔克斯");
//        bookDao.updateById(book);
//    }
//    @Test
//    void testGetAll(){
//        System.out.println(bookDao.selectList(null));
//    }
//    @Test
//    void testGetPage(){
//        IPage page = new Page(1,5);
//        bookDao.selectPage(page,null);
//        System.out.println(page.getCurrent());
//        System.out.println(page.getPages());
//        System.out.println(page.getSize());
//        System.out.println(page.getTotal());
//        System.out.println(page.getRecords());
//    }
//    @Test
//    void testGetBy2(){
//        String name = "百";
//        LambdaQueryWrapper<Book> lqw = new LambdaQueryWrapper<Book>();
//        //lqw.like(Book::getName,"百");
//        lqw.like(name !=null,Book::getBookName,name);
//        bookDao.selectList(lqw);
//    }
}
