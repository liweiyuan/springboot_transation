package com.tingyun.dao.impl;

import com.tingyun.bena.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * Created by tingyun on 2017/6/29.
 */


//简单事务处理，增加一个方法
@Repository
public class AuthDaoTransation {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int add(Author author) {
        return jdbcTemplate.update("insert into t_author(real_name, nick_name) values(?, ?)",
                author.getRealName(), author.getNickName());
    }
}
