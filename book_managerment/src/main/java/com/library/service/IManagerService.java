package com.library.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.library.domain.Book;
import com.library.domain.Manager;

/**
 * @author tsk
 * @create 2023/3/20 - 18:42
 */
public interface IManagerService extends IService<Manager> {
    boolean login (Manager manager);
}
