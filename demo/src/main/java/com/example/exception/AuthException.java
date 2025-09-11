package com.example.exception;

public class AuthException extends RuntimeException {
    //无参构造
    public AuthException() {
        super();
    }
    //带有说明信息的有参构造
    public AuthException(String msg) {
        super(msg);
    }
}
