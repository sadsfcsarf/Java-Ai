package com.example.exception;

//自定义异常类
public class MyException extends RuntimeException {
    //无参构造
    public MyException() {
        super();
    }

    //带有说明信息的有参构造
    public MyException(String msg) {
        super(msg);
    }

}
