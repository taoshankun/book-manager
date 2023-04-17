package com.library.domain;

import lombok.Data;

import java.util.Date;

/**
 * @author tsk
 * @create 2023/3/25 - 20:14
 */
@Data
public class FormD {
    private int id;
    private String name;
    private String gender;
    private String bookName;
    private String borrowdate;
}
