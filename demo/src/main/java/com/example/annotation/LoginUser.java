package com.example.annotation;

import java.lang.annotation.*;

/*用于如果参数被当前注解修饰，给被修饰的参数赋值*/
@Target(ElementType.PARAMETER)//修饰参数
@Retention(RetentionPolicy.RUNTIME)//在runtime时期生效
@Documented//可以生成关于注解的文档
public @interface LoginUser {

}
