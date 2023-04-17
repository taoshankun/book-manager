package com.library.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.library.controller.Utils.Code;
import com.library.controller.Utils.Result;
import com.library.domain.Information;
import com.library.domain.User;
import com.library.exception.BusinessException;
import com.library.service.IInformationService;
import com.library.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author tsk
 * @create 2023/3/20 - 20:49
 */
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private IUserService userService;


    @GetMapping
    public Result getAll(){
        List<User> userList = userService.list();
        Integer code = userList !=null ? Code.GET_OK:Code.GET_ERR;
        String msg = userList != null ? "":"查询失败，请重试";
        return new Result(code,userList,msg);
    }

    @PostMapping
    public Result save(@RequestBody User user){
        boolean flag = userService.add(user);
        return new Result(flag ? Code.SAVE_OK:Code.SAVE_ERR,flag);
    }

    @PutMapping
    public Result update(@RequestBody User user){
//        LambdaQueryWrapper<Information> qw = new LambdaQueryWrapper<>();
//        qw.eq(Information::getUserId,user.getId());
//        Information information = informationService.getOne(qw);
//        information.setUserName(user.getName());
//        informationService.updateById(information);
        boolean flag = userService.updateById2(user);
        return new Result(flag ? Code.UPDATE_OK:Code.UPDATE_ERR,flag);
    }

    @DeleteMapping("{id}")
    public Result delete(@PathVariable Integer id){
        User user = userService.getById(id);
        if (0 ==user.getBorrowedNum()){
            boolean flag = userService.removeById(id);
            return new Result(flag ? Code.DELETE_OK:Code.DELETE_ERR,flag);
        }else {
            throw new BusinessException(Code.BUSINESS_ERR,"该读者还有书未还，还完后才能删除");
        }

    }

    @GetMapping("{id}")
    public Result getById(@PathVariable Integer id){
        User user = userService.getById(id);
        Integer code = user !=null ? Code.GET_OK:Code.GET_ERR;
        String msg = user != null ? "":"查询失败，请重试";
        return new Result(code,user,msg);
    }

    @GetMapping("{currentPage}/{pageSize}")
    public Result getPage(@PathVariable int currentPage, @PathVariable int pageSize,User user){
        IPage<User> page = userService.getPage(currentPage, pageSize,user);
        if (currentPage > page.getPages()){
            page=userService.getPage((int) page.getPages(),pageSize,user);
        }
        return new Result(Code.GET_PAGE_OK,page);
    }
}
