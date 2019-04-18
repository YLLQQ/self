package self.yang.web.filters;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * self.yang.web.filters.DefineHttpFilter
 *
 * @author eleven
 * @date 2019/04/18
 */
@Slf4j
@WebFilter(urlPatterns = {DefineHttpFilter.URL_PATTERN})
@Configuration
public class DefineHttpFilter extends HttpFilter {

    static final String URL_PATTERN = "/**";

    @Override
    protected void doFilter(
            HttpServletRequest request, HttpServletResponse response, FilterChain chain
    ) throws IOException, ServletException {
        if (log.isDebugEnabled()) {
            log.debug("enter do filter");
        }

        super.doFilter(request, response, chain);
    }
}
