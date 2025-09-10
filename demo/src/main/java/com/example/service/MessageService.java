package com.example.service;

import com.example.dto.MessageDto;

import java.util.List;

public interface MessageService {
    void insertMessage(MessageDto messageDto);
    List<MessageDto> selectMessageByUser(Integer userId);

}
