package com.example.interceptor;


import com.example.dto.UserDto;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
/*
 * 登录验证
 * */
//将当前类的对象放入到框架容器中和@Controller，@Service,@Mapper作用一样
@Component

public class AuthInterceptor implements HandlerInterceptor {
    /*返回布尔值，如果返回的为true，放行接口（正常询问目标资源），如果false，进行拦截*/
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //获取session中保存的用户信息
        HttpSession session = request.getSession();
        UserDto userDto = (UserDto) session.getAttribute("user");
        if (userDto==null) {
            return false;
        }

        return true;
    }



}
