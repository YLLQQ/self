package self.yang.web.aops;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import self.yang.web.exception.DefineException;

/**
 * self.yang.web.aops.GlobalExceptionAspect
 *
 * @author eleven
 * @date 2019/03/20
 */
@Slf4j
@RestControllerAdvice
public class GlobalRestControllerExceptionAspect {

    /**
     * 400 - Bad Request
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(DefineException.class)
    public String handleDefineException(DefineException e) {
        log.error("server exception, message is {}", e);

        return "server exception";
    }

    /**
     * 400 - Bad Request
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public String handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {
        log.error("cannot deal the request params, message is {}", e);

        return "cannot deal the request params";
    }
}
