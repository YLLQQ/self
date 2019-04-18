package self.yang.web.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * self.yang.web.interceptor.DefineWebMvcConfig
 *
 * @author eleven
 * @date 2019/04/18
 */
@Configuration
public class DefineWebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new DefineInterceptor())
                .addPathPatterns("/**");
    }
}
