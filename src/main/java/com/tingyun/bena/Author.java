package com.tingyun.bena;

/**
 * Created by tingyun on 2017/6/28.
 */
public class Author {
    private Long id;
    private String realName;
    private String nickName;

    /**
     *事务处理
     */
    public Author() {}
    public Author(String realName, String nickName) {
        this.realName = realName;
        this.nickName = nickName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
}
