package self.yang.tools.utils;

import self.yang.tools.responses.Response;
import self.yang.tools.responses.ResponseEnum;

public class HttpUtil {

    /**
     * 获取成功响应
     *
     * @param result
     * @return
     */
    public static Response getSuccessResponse(Object result) {
        return new Response(ResponseEnum.SUCCESS, result);
    }

    /**
     * 获取失败响应
     *
     * @param responseEnum
     * @param result
     * @return
     */
    public static Response getFailResponse(
            ResponseEnum responseEnum,
            Object result
    ) {
        return new Response(responseEnum, result);
    }
}
