package com.library.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.library.dao.InformationDao;
import com.library.domain.Information;
import com.library.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

/**
 * @author tsk
 * @create 2023/4/5 - 13:51
 */
@SpringBootTest
public class infoServiceTest {
    @Autowired
    private IInformationService informationService;
    @Autowired
    private IUserService userService;
    @Autowired
    private InformationDao informationDao;
//    @Test
//    void infoUpDateTest(){
//        User user = new User();
//        user.setId(1);
//        user.setName("陈洁");
//        user.setGender("女");
//        user.setBorrowedNum(3);
//        user.setPhoneNum("12345612346");
//        userService.updateById2(user);
//    }
//    @Test
//    void selectinfo(){
//        User user = new User();
//        user.setId(1);
//        LambdaQueryWrapper<Information> qw = new LambdaQueryWrapper<>();
//        qw.eq(Information::getUserId,user.getId());
//        List<Information> informationList = informationDao.selectList(qw);
//        for (Information information : informationList) {
//            informationDao.updateById(information);
//        }
//    }
}
