package com.library.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.library.domain.User;

/**
 * @author tsk
 * @create 2023/3/22 - 23:45
 */
public interface IUserService extends IService<User> {
    IPage<User> getPage(int currentPage, int pageSize);
    IPage<User> getPage(int currentPage,int pageSize,User user);
    boolean updateById2(User user);
    boolean add(User user);
}
