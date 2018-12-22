package self.yang.tools.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResponseEnum implements ResponseInterface {

    /**
     * 访问成功
     */
    SUCCESS(200, "访问成功", "visit success"),

    /**
     * 接口暂时无法提供服务
     */
    API_STOP(100000, "接口暂时无法提供服务", "api has some exceptions"),

    ;

    private int code;

    private String chDesc;

    private String enDesc;
}
