package com.tingyun.dao;

import com.tingyun.bena.Author;

import java.util.List;

/**
 * Created by tingyun on 2017/6/28.
 */
public interface AuthorDao {
    int add(Author author);
    int update(Author author);
    int delete(Long id);
    Author findAuthor(Long id);
    List<Author> findAuthorList();
}
