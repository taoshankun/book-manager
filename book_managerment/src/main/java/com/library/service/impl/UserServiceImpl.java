package com.library.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.library.controller.Utils.Code;
import com.library.dao.InformationDao;
import com.library.dao.UserDao;
import com.library.domain.Information;
import com.library.domain.User;
import com.library.exception.BusinessException;
import com.library.service.IUserService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author tsk
 * @create 2023/3/20 - 18:44
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserDao, User>implements IUserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private InformationDao informationDao;
    @Override
    public IPage<User> getPage(int currentPage, int pageSize) {
        IPage page = new Page(currentPage,pageSize);
        userDao.selectPage(page,null);
        return page;
    }

    @Override
    public IPage<User> getPage(int currentPage, int pageSize, User user) {
        LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<>();
        lqw.like(Strings.isNotEmpty(user.getName()),User::getName,user.getName());
        lqw.like(Strings.isNotEmpty(user.getGender()),User::getGender,user.getGender());
        lqw.like(Strings.isNotEmpty(user.getPhoneNum()),User::getPhoneNum,user.getPhoneNum());
        IPage page = new Page(currentPage,pageSize);
        userDao.selectPage(page,lqw);
        return page;
    }

    @Override
    public boolean updateById2(User user) {
        if (user.getPhoneNum().length() != 11){
            throw new BusinessException(Code.BUSINESS_ERR,"手机号格式不正确");
        }else {
            LambdaQueryWrapper<Information> qw = new LambdaQueryWrapper<>();
            qw.eq(Information::getUserId,user.getId());
            List<Information> informationList = informationDao.selectList(qw);
            for (Information information : informationList) {
                if (user.getName() != information.getUserName()){
                    information.setUserName(user.getName());
                    informationDao.updateById(information);
                }
            }
            return 0 < userDao.updateById(user);
        }

    }

    @Override
    public boolean add(User user) {
        String phoneNum = user.getPhoneNum();
        if(11 != phoneNum.length()){
            throw new BusinessException(Code.BUSINESS_ERR,"手机号格式不正确");
        }else {
            return 0 < userDao.insert(user);
        }
    }

}
