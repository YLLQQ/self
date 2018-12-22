package self.yang.tools.utils;

import self.yang.tools.responses.Response;
import self.yang.tools.responses.ResponseEnum;
import self.yang.tools.responses.ResponseInterface;

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
     * @param responseInterface
     * @return
     */
    public static Response getFailResponse(
            ResponseInterface responseInterface
    ) {
        return getFailResponse(responseInterface, null);
    }

    /**
     * 获取失败响应
     *
     * @param responseInterface
     * @param result
     * @return
     */
    public static Response getFailResponse(
            ResponseInterface responseInterface,
            Object result
    ) {
        return new Response(responseInterface, result);
    }
}
