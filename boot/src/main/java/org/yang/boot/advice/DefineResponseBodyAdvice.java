package org.yang.boot.advice;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;
import org.yang.boot.model.BaseResponseModel;

/**
 * org.yang.boot.advice.DefineResponseBodyAdvice
 *
 * @author eleven
 * @date 2019/09/17
 */
@Slf4j
@RestControllerAdvice
public class DefineResponseBodyAdvice implements ResponseBodyAdvice {

    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(
            Object body,
            MethodParameter returnType,
            MediaType selectedContentType,
            Class selectedConverterType,
            ServerHttpRequest request,
            ServerHttpResponse response
    ) {
        if (log.isInfoEnabled()) {
            log.info("current object is {} and class is {}", body, body.getClass());
        }

        BaseResponseModel baseResponseModel = new BaseResponseModel();

        baseResponseModel.setCode(200);
        baseResponseModel.setMessage("SUCCESS");
        baseResponseModel.setResult(body);

        if (body instanceof String) {
            return JSON.toJSONString(baseResponseModel);
        }

        return baseResponseModel;
    }
}
