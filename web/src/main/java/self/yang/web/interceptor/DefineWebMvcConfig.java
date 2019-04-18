package self.yang.web.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * self.yang.web.interceptor.DefineWebMvcConfig
 *
 * @author eleven
 * @date 2019/04/18
 */
@Slf4j
@Configuration
public class DefineWebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new HandlerInterceptor() {
            @Override
            public boolean preHandle(
                    HttpServletRequest request, HttpServletResponse response, Object handler
            ) throws Exception {
                if (log.isDebugEnabled()) {
                    log.debug("enter pre handle");
                }

                return true;
            }

            @Override
            public void postHandle(
                    HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView
            ) throws Exception {
                if (log.isDebugEnabled()) {
                    log.debug("enter post handle");
                }
            }

            @Override
            public void afterCompletion(
                    HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex
            ) throws Exception {
                if (log.isDebugEnabled()) {
                    log.debug("after pre handle");
                }
            }
        }).addPathPatterns("/**");
    }
}
