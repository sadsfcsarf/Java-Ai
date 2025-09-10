package com.example.service;

import com.example.dto.MessageDto;
import com.example.mapper.MessageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class MessageServiceImpl implements MessageService {
    @Autowired
    private MessageMapper messageMapper;

    @Override
    public void insertMessage(MessageDto messageDto) {
        messageMapper.insertMessage(messageDto);

    }

    @Override
    public List<MessageDto> selectMessageByUser(Integer userId) {
        return messageMapper.selectMessageByUser(userId);
    }
}
