package org.yang.boot.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.StringHttpMessageConverter;

/**
 * org.yang.boot.config.Config
 *
 * @author eleven
 * @date 2019/09/17
 */
@Slf4j
@Configuration
public class Config {


    public class DefineStringHttpMessageConverter extends StringHttpMessageConverter {

    }

}
