package com.example.mapper;

import com.example.dto.MessageDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MessageMapper {
    //插入聊天历史
    void insertMessage(MessageDto messageDto);
    //根据用户查询聊天记录
    List<MessageDto> selectMessageByUser(Integer userId);


}
