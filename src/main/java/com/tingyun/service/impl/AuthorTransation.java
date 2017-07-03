package com.tingyun.service.impl;

import com.tingyun.bena.Author;
import com.tingyun.dao.impl.AuthDaoTransation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by tingyun on 2017/6/29.
 */
@Service
public class AuthorTransation {


    @Autowired
    private AuthDaoTransation authDaoTransation;

    /**
     * 主要的逻辑是判断输入的名字长度是否大于5，大于5就回滚
     * @param author
     * @return
     */
    public int add1(Author author){
        int n= this.authDaoTransation.add(author);
        if(author.getRealName().length() > 5){
            throw new IllegalArgumentException("author real name is too long.");
        }
        return n;
    }

    @Transactional(noRollbackFor = {IllegalArgumentException.class})
    public int add2(Author author){
        int n =authDaoTransation.add(author);
        if(author.getRealName().length() > 5){
            throw new IllegalArgumentException("author real name is too long.");
        }
        return n;
    }


    @Transactional(rollbackFor={IllegalArgumentException.class})
    public int add3(Author author) {
        int n = this.authDaoTransation.add(author);
       /* if(author.getRealName().length() > 5){
            throw new IllegalArgumentException("author real name is too long.");
        }*/
        return n;
    }

    @Transactional()
    public int add4(Author author) {
        int n = this.authDaoTransation.add(author);
        if(author.getRealName().length() > 5){
            throw new IllegalArgumentException("author real name is too long.");
        }
        return n;
    }
}
