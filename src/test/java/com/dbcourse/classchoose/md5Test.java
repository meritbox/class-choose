package com.dbcourse.classchoose;

import org.springframework.util.DigestUtils;

public class md5Test {
    public static void main(String[] args) {
        String password = "10001";
        String md5 = DigestUtils.md5DigestAsHex(password.getBytes());
        System.out.println(md5);
    }
}
