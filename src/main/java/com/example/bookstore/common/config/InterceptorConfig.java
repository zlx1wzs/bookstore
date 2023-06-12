package com.example.bookstore.common.config;
import com.example.bookstore.utils.AgainLoginException;
import com.example.bookstore.utils.JwtUtil;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class InterceptorConfig extends WebMvcConfigurationSupport {
    public InterceptorConfig() {
    }
    public void addInterceptors(InterceptorRegistry reg) {
        reg.addInterceptor(new HandlerInterceptor() {
            @Override
            public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
                if (request.getMethod().equals("OPTIONS")) {
                    response.setStatus(200);
                    return true;
                } else {
                    try {
                        String token = request.getHeader("token");
                        String id = JwtUtil.validateToken(token);
                        request.setAttribute("UserId", id);
                        request.setAttribute("UserToken", token);
                        return true;
                    } catch (AgainLoginException exception) {
                        throw exception;
                    }
                }
            }
        }).addPathPatterns(new String[]{"FFFFF/**"}).excludePathPatterns(this.excludePattern());
    }

    public List<String> excludePattern() {
        List<String> ret = new ArrayList();
        ret.add("/**/user/login");
        ret.add("/**/user/save");
        ret.add("/**/goods/*");
        ret.add("/**/category/*");
        return ret;
    }
}
