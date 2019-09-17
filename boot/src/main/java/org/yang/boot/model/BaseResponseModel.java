package org.yang.boot.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * org.yang.boot.model.BaseResponseModel
 *
 * @author eleven
 * @date 2019/09/17
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseResponseModel {

    /**
     * 响应码
     */
    private int code;

    /**
     * 描述信息
     */
    private String message;

    /**
     * 接口响应信息
     */
    private Object result;

}
