package com.library.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.library.controller.Utils.Code;
import com.library.controller.Utils.Result;
import com.library.domain.Book;
import com.library.exception.BusinessException;
import com.library.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author tsk
 * @create 2023/3/20 - 20:49
 */
@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private IBookService bookService;

    @GetMapping
    public Result getAll(){
        List<Book> booklist = bookService.list();
        Integer code = booklist !=null ? Code.GET_OK:Code.GET_ERR;
        String msg = booklist != null ? "":"查询失败，请重试";
        return new Result(code,booklist,msg);
    }

    @PostMapping
    public Result save(@RequestBody Book book){
        boolean flag = bookService.save(book);
        return new Result(flag ? Code.SAVE_OK:Code.SAVE_ERR,flag);
    }

    @PutMapping
    public Result update(@RequestBody Book book){
        boolean flag = bookService.updateById(book);
        return new Result(flag ? Code.UPDATE_OK:Code.UPDATE_ERR,flag);
    }

    @DeleteMapping("{id}")
    public Result delete(@PathVariable Integer id){
        boolean flag = bookService.removeById(id);
        return new Result(flag ? Code.DELETE_OK:Code.DELETE_ERR,flag);
    }

    @GetMapping("{id}")
    public Result getById(@PathVariable Integer id){
        Book book = bookService.getById(id);
        Integer code = book !=null ? Code.GET_OK:Code.GET_ERR;
        String msg = book != null ? "":"查询失败，请重试";
        return new Result(code,book,msg);
    }

    @GetMapping("{currentPage}/{pageSize}")
    public Result getPage(@PathVariable int currentPage, @PathVariable int pageSize,Book book){
        IPage<Book> page = bookService.getPage(currentPage, pageSize,book);
        if (currentPage > page.getPages()){
            page=bookService.getPage((int) page.getPages(),pageSize,book);
        }
        return new Result(Code.GET_PAGE_OK,page);
    }
}
