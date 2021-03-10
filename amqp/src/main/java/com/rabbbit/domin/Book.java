package com.rabbbit.domin;

import java.io.Serializable;

/**
 * @author : gelianbin
 * @createDate : 2021/3/10
 */
public class Book implements Serializable {
    private String name;
    private String totle;

    public Book() {
    }

    public Book(String name, String totle) {
        this.name = name;
        this.totle = totle;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTotle() {
        return totle;
    }

    public void setTotle(String totle) {
        this.totle = totle;
    }
}
