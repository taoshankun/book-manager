package com.library.dao;

import com.library.domain.Information;
import com.library.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;



@SpringBootTest
public class infoDaoTest {
    @Autowired
    private InformationDao informationDao;
    @Autowired
    private UserDao userDao;
//    @Test
//    void savetest(){
//        Information information = new Information();
//        information.setBookId(5);
//        information.setUserId(1);
//        information.setUserName("xianming");
//        information.setBookName("水浒传");
//        informationDao.insert(information);
//    }
//    @Test
//    void saveuser(){
//        User user = new User();
//        user.setName("lihua");
//        user.setGender("男");
//        userDao.insert(user);
//    }
//    @Test
//    void save2(){
//        Information information = new Information();
//        information.setBookId(1);
//        information.setUserId(1);
//        information.setUserName("陈洁");
//        information.setBookName("老人与海");
//        informationDao.add(information);
//
//    }
//
//    @Test
//    void selectByLinkTest(){
//        System.out.println(informationDao.selectByLink());
//    }
//    @Test
//    void selectAllTest(){
//        System.out.println(informationDao.selectList(null));
//    }
//    @Test
//    void selectBy1(){
//        Information information = informationDao.selectById(21);
//        System.out.println(information.getBorrowDate());
//    }

}
