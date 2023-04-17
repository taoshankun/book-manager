package com.library.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.library.controller.Utils.Result;
import com.library.domain.Book;
import com.library.domain.FormD;
import com.library.domain.Information;

import java.util.List;

/**
 * @author tsk
 * @create 2023/3/20 - 18:42
 */
public interface IInformationService extends IService<Information> {
    IPage<Information> getPage(int currentPage,int pageSize);

    List<FormD> selectByLink();
    IPage<Information> getPage(int currentPage,int pageSize,Information information);

    Result add(Information information);
    boolean updateDate(Information information);
    boolean deleteById(Integer id);
}
