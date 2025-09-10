package com.example.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class MessageDto {
    private Integer id;
    //对话人
    private Integer userId;
    //发送者
    private String sender;
    //对话内容
    private String content;
    /*
    * yyyy：年
    * MM：月
    * dd：日
    * HH：24时制 hh：12时制
    * mm：分
    * ss：秒
    * */
    //创建 时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
    private String nickName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
}
