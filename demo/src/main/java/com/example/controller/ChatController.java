package com.example.controller;

import com.alibaba.cloud.ai.dashscope.audio.DashScopeSpeechSynthesisOptions;
import com.alibaba.cloud.ai.dashscope.audio.synthesis.SpeechSynthesisModel;
import com.alibaba.cloud.ai.dashscope.audio.synthesis.SpeechSynthesisPrompt;
import com.alibaba.cloud.ai.dashscope.audio.synthesis.SpeechSynthesisResponse;
import com.alibaba.nacos.shaded.io.grpc.Status;
import com.example.dto.MessageDto;
import com.example.dto.UserDto;
import com.example.service.MessageService;
import org.springframework.ai.image.*;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ssl.SslProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import reactor.core.publisher.Flux;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//将返回的结果从地址路径变为json字符串
@ResponseBody
//控制器类
@Controller
//控制器类访问地址
@RequestMapping("/api/chat")
public class ChatController {

    //引入ai的对话模型
    @Autowired
    private OllamaChatModel ollamaChatModel;
    @Autowired
    private MessageService messageService;
    //引入ai的图片模型
    @Autowired
    private ImageModel imageModel;
    @Autowired
    private SpeechSynthesisModel synthesisModel;
    private static final String FILE_PATH = "src/main/resources/static/audio/";


    /*关于ai的对话方式*/
    @RequestMapping("/call")
    public String call(String question) {
        System.out.println(question);
        String answer = ollamaChatModel.call(question);
        return answer;
    }

    /*
     * 将回答以流的形式返回给
     * */
    @RequestMapping("/stream")
    public Flux<String> stream(String question) {
        if (question == null || question.length() == 0) {
            question = "Hello";
        }


        //保存用户的提问记录
        MessageDto userMsg = new MessageDto();
        userMsg.setUserId(1);
        userMsg.setSender("user");
        userMsg.setContent(question);
        messageService.insertMessage(userMsg);

        //保存所有回答片段的可变字符串
        StringBuffer allMsg = new StringBuffer();

        return ollamaChatModel.stream(question).map(msg -> {
//            System.out.println("回答片段:"+ msg);
            //获取所有回答片段
            allMsg.append(msg);
            return msg;
        }).doOnComplete(() -> {
//            System.out.println("所有回答完成");
            MessageDto aiMsg = new MessageDto();
            aiMsg.setUserId(1);
            aiMsg.setSender("ai");
            aiMsg.setContent(allMsg.toString());
            messageService.insertMessage(aiMsg);
        });

    }
    /*根据用户查询聊天记录*/
    @RequestMapping("/list")
    public Map<String, Object> list(UserDto userDto){
        userDto.setId(1);
        Map<String, Object> map = new HashMap<>();
        try {
            List<MessageDto> list = messageService.selectMessageByUser(userDto.getId());
            map.put("data", list);
            map.put("code", 200);
        }catch (Exception e){
            e.printStackTrace();
            map.put("code", 500);
            map.put("msg", e.getMessage());
        }
        return map;
    }

    /*根据用户描述生成图片*/
    @RequestMapping("/img")
    public Map<String,Object> img(@RequestParam(value = "prompt",defaultValue = "葫芦娃") String prompt){
        //图片生成项
        ImageOptions options = ImageOptionsBuilder.builder().N(1).build();
        //图像生成
        ImageResponse response = imageModel.call(new ImagePrompt(prompt,options));
        Map<String,Object> result = new HashMap<>();
        result.put("code",200);
        result.put("data",response.getResult());
        return result;

    }
    @RequestMapping("/audio")
    public Map<String,Object> audio(@RequestParam(value = "text",defaultValue = "你好，我是吴彦祖") String text){
        //语音生成项
        DashScopeSpeechSynthesisOptions options = DashScopeSpeechSynthesisOptions.builder()
                .volume(60)//音量
                .build();
        SpeechSynthesisResponse response = synthesisModel.call(new SpeechSynthesisPrompt(text,options));
        //音频名称
        String fileName = "output_"+System.currentTimeMillis()+".mp3";

        //音频文件
        File file = new File(FILE_PATH+fileName);

        //字节输出流
        try{
            FileOutputStream fileOutputStream = new FileOutputStream( file);
            //获取返回的音频信息
            ByteBuffer byteBuffer = response.getResult().getOutput().getAudio();
            //将内容写出到指定文件位置
            fileOutputStream.write(byteBuffer.array());

        }catch (Exception e){
            e.printStackTrace();
        }


        Map<String, Object> result = new HashMap<>();
        result.put("code",200);
        result.put("data",fileName);

        return result;

    }
}

