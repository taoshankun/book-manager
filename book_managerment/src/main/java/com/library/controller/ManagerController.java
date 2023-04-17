package com.library.controller;

import com.library.controller.Utils.Code;
import com.library.controller.Utils.Result;
import com.library.domain.Manager;
import com.library.service.IManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tsk
 * @create 2023/3/23 - 17:05
 */
@RestController
@RequestMapping("/managers")
public class ManagerController {
    @Autowired
    private IManagerService managerService;
    @PostMapping
    public Result login(@RequestBody Manager manager){
        boolean flage = managerService.login(manager);
        return new Result(flage ? Code.LOGIN_OK:Code.LOGIN_ERR,flage);
    }
}
