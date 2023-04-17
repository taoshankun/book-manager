package com.library.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.library.controller.Utils.Code;
import com.library.controller.Utils.Result;
import com.library.domain.Book;
import com.library.domain.Information;
import com.library.domain.User;
import com.library.service.IBookService;
import com.library.service.IInformationService;
import com.library.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * @author tsk
 * @create 2023/3/20 - 20:49
 */
@RestController
@RequestMapping("/informations")
public class InformationController {
    @Autowired
    private IInformationService informationService;

    @GetMapping
    public Result getAll(){
        List<Information> informationList = informationService.list();
        Integer code = informationList !=null ? Code.GET_OK:Code.GET_ERR;
        String msg = informationList != null ? "":"查询失败，请重试";
        return new Result(code,informationList,msg);
    }

    @PostMapping
    public Result save(@RequestBody Information information){
       return informationService.add(information);
    }

    @PutMapping
    public Result update(@RequestBody Information information){
        boolean flag = informationService.updateDate(information);
        return new Result(flag ? Code.UPDATE_OK:Code.UPDATE_ERR,flag);
    }

    @DeleteMapping("{id}")
    public Result delete(@PathVariable Integer id){
        boolean flag = informationService.deleteById(id);
        return new Result(flag ? Code.DELETE_OK:Code.DELETE_ERR,flag);
    }

    @GetMapping("{id}")
    public Result getById(@PathVariable Integer id){
        Information information = informationService.getById(id);
        Integer code = information !=null ? Code.GET_OK:Code.GET_ERR;
        String msg = information != null ? "":"查询失败，请重试";
        return new Result(code,information,msg);
    }

    @GetMapping("{currentPage}/{pageSize}")
    public Result getPage(@PathVariable int currentPage, @PathVariable int pageSize,Information information){
        IPage<Information> page = informationService.getPage(currentPage, pageSize,information);
        if (currentPage > page.getPages()){
            page=informationService.getPage((int) page.getPages(),pageSize,information);
        }
        return new Result(Code.GET_PAGE_OK,page);
    }
}
