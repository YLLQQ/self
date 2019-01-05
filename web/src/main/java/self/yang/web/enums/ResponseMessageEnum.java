package self.yang.web.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import self.yang.tools.responses.ResponseInterface;

@Getter
@AllArgsConstructor
public enum ResponseMessageEnum implements ResponseInterface {

    SUCCESS(200, "成功", "success"),

    INPUT_STRING_CANNOT_CONVERT_TO_JSON(1000000, "请求体数据无法转换为json", "input string convert to json"),
    INPUT_STRING_CANNOT_MATCH_REQUEST(100001, "属性值非法", "attribute is illegal"),

    ;

    private int code;

    private String chDesc;

    private String enDesc;

}
