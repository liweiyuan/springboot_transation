package com.tingyun.controller;

import com.tingyun.bena.Author;
import com.tingyun.service.AuthorService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by tingyun on 2017/6/29.
 */

@RestController
@RequestMapping(value="/data/jdbc/author")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    /**
     * 查询用户的列表
     */
    @RequestMapping(method = RequestMethod.GET,value = "/")
    public Map<String,Object> getAuthorList(){
        List<Author> authorList=authorService.findAuthorList();
        Map<String,Object> param=new HashMap<String,Object>();
        param.put("total",authorList.size());
        param.put("rows",authorList);
        return param;
    }

    /**
     * 查询用户信息
     */
    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    public Author getAuthor(@PathVariable Long userId, HttpServletRequest request) {
        Author author = this.authorService.findAuthor(userId);
        if(author == null){
            throw new RuntimeException("查询错误");
        }
        return author;
    }

    /**
     * 新增方法
     */
    @RequestMapping(method = RequestMethod.POST,value = "/add")
    public void add() {
        //String userId = jsonObject.getString("user_id");
        //String realName = jsonObject.getString("real_name");
        //String nickName = jsonObject.getString("nick_name");
        Author author = new Author();
        if (author!=null) {
            author.setId(Long.valueOf(1));
        }
        author.setRealName("wade");
        author.setNickName("bosh");
        try{
            this.authorService.add(author);
        }catch(Exception e){
            e.printStackTrace();
            throw new RuntimeException("新增错误");
        }
    }

    /**
     * 更新方法
     */
    @RequestMapping(value = "/{userId}", method = RequestMethod.PUT)
    public void update(@PathVariable Long userId) {
        Author author = this.authorService.findAuthor(userId);
        author.setRealName("china");
        author.setNickName("china");
        try{
            this.authorService.update(author);
        }catch(Exception e){
            e.printStackTrace();
            throw new RuntimeException("更新错误");
        }
    }

    /**
     * 删除方法
     */
    @RequestMapping(value = "/{userId}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long userId) {
        try{
            this.authorService.delete(userId);
        }catch(Exception e){
            throw new RuntimeException("删除错误");
        }
    }
}
