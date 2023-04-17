package com.library.domain;

import lombok.Data;

/**
 * @author tsk
 * @create 2023/3/20 - 11:01
 */
@Data
public class Book {
    private int id;
    private String bookName;
    private String author;
    private String state;
    private String type;
}
