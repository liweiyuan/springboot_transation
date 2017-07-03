package com.tingyun.service.impl;

import com.tingyun.bena.Author;
import com.tingyun.dao.AuthorDao;
import com.tingyun.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by tingyun on 2017/6/28.
 */
@Service("authorService")
public class AuthorServiceImpl implements AuthorService {
    @Autowired
    private AuthorDao authorDao;

    @Override
    public int add(Author author) {
        return this.authorDao.add(author);
    }

    @Override
    public int update(Author author) {
        return this.authorDao.update(author);
    }

    @Override
    public int delete(Long id) {
        return this.authorDao.delete(id);
    }

    @Override
    public Author findAuthor(Long id) {
        return this.authorDao.findAuthor(id);
    }

    @Override
    public List<Author> findAuthorList() {
        return this.authorDao.findAuthorList();
    }
}
