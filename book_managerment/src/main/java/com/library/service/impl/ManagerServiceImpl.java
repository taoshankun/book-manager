package com.library.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.library.dao.BookDao;
import com.library.dao.ManagerDao;
import com.library.domain.Book;
import com.library.domain.Manager;
import com.library.service.IBookService;
import com.library.service.IManagerService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author tsk
 * @create 2023/3/20 - 18:44
 */
@Service
public class ManagerServiceImpl extends ServiceImpl<ManagerDao,Manager> implements IManagerService {
    @Autowired
    private ManagerDao managerDao;

    @Override
    public boolean login(Manager manager) {
        return managerDao.select(manager)!=null;
    }
}
