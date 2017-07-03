package com.tingyun.controller;

import com.tingyun.bena.Author;
import com.tingyun.dao.impl.AuthDaoTransation;
import com.tingyun.service.impl.AuthorTransation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by tingyun on 2017/6/29.
 */
@RestController
public class TransationController {


    @Autowired
    private AuthorTransation authDaoTransation;


    @RequestMapping("/test1")
    public void add1() throws Exception {
        authDaoTransation.add1(new Author("北京市", "北京市"));
        authDaoTransation.add1(new Author("LiangGzone", "LiangGzone"));
    }

    @RequestMapping("/test2")
    public void add2() throws Exception {
        authDaoTransation.add2(new Author("天津市", "天津市"));
        authDaoTransation.add2(new Author("LiangGzone", "LiangGzone"));
    }

    @RequestMapping("/test3")
    public String add3() throws Exception {
        authDaoTransation.add3(new Author("重庆市", "重庆市"));
        authDaoTransation.add3(new Author("University", "University"));

        return "success";
    }
}
