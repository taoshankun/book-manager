package com.library.domain;

import lombok.Data;

/**
 * @author tsk
 * @create 2023/3/16 - 10:56
 */
@Data
public class User {
    private int id;
    private String name;
    private String gender;
    private int borrowedNum;
    private String phoneNum;
}
