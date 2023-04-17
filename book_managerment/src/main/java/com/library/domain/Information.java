package com.library.domain;

import lombok.Data;

import java.util.Calendar;
//import java.util.Date;
import java.sql.Date;

/**
 * @author tsk
 * @create 2023/3/16 - 11:00
 */
@Data
public class Information {
    private int id;
    private String userName;
    private String bookName;
    private int userId;
    private int bookId;
    private Date borrowDate;
    private Date returnDate;
}
