package self.yang.web.config;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import self.yang.tools.responses.Response;
import self.yang.tools.utils.HttpUtil;
import self.yang.web.desc.ResponseMessageEnum;


import java.util.List;

/**
 * 全局异常捕捉
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    private static final int DEFAULT_STRING_BUILDER_LENGTH = 128;

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseBody
    public Response methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException exception) {

        List<ObjectError> allErrors = exception.getBindingResult().getAllErrors();

        StringBuilder stringBuilder = new StringBuilder(DEFAULT_STRING_BUILDER_LENGTH);

        allErrors.stream().forEach(x -> {
            stringBuilder.append(x.getObjectName());
            stringBuilder.append(" has wrong param, message is ");
            stringBuilder.append(x.getDefaultMessage());
            stringBuilder.append(";");
        });

        if (log.isDebugEnabled()) {
            log.debug("catch MethodArgumentNotValidException, message is {}", stringBuilder.toString());
        }

        return HttpUtil.getFailResponse(ResponseMessageEnum.INPUT_STRING_CANNOT_MATCH_REQUEST);
    }

    @ExceptionHandler(value = InvalidFormatException.class)
    @ResponseBody
    public Response invalidFormatExceptionHandler(InvalidFormatException exception) {

        String message = exception.getMessage();

        log.error("catch InvalidFormatException, message is {}", message);

        return HttpUtil.getFailResponse(ResponseMessageEnum.INPUT_STRING_CANNOT_CONVERT_TO_JSON);
    }
}
