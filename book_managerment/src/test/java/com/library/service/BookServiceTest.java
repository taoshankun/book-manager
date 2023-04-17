package com.library.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.library.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class BookServiceTest {
    @Autowired
    private IBookService bookService;
//    @Test
//    void testsave(){
//        Book book = new Book();
//        book.setId(3);
//        book.setBookName("水浒传");
//        book.setAuthor("施耐庵");
//        bookService.save(book);
//    }
//    @Test
//    void testUpdate(){
//        Book book = new Book();
//        book.setId(2);
//        book.setBookName("百年孤独");
//        book.setAuthor("加西亚·马尔克斯");
//        bookService.updateById(book);
//    }
//    @Test
//    void testGetAll(){
//        System.out.println(bookService.list());
//    }
//    @Test
//    void testGetPage(){
//        IPage<Book> page = new Page(1,5);
//        bookService.page(page);
//        System.out.println(page.getCurrent());
//        System.out.println(page.getPages());
//        System.out.println(page.getSize());
//        System.out.println(page.getTotal());
//        System.out.println(page.getRecords());
//    }
}
