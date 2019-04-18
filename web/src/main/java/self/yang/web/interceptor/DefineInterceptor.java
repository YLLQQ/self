package self.yang.web.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * self.yang.web.interceptor.DefineInterceptor
 *
 * @author eleven
 * @date 2019/04/18
 */
@Slf4j
public class DefineInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(
            HttpServletRequest request, HttpServletResponse response, Object handler
    ) throws Exception {
        if (log.isDebugEnabled()) {
            log.debug("pre handler");
        }

        return true;
    }

    @Override
    public void postHandle(
            HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView
    ) throws Exception {
        if (log.isDebugEnabled()) {
            log.debug("post handler");
        }

    }

    @Override
    public void afterCompletion(
            HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex
    ) throws Exception {
        if (log.isDebugEnabled()) {
            log.debug("after handler");
        }
    }
}
