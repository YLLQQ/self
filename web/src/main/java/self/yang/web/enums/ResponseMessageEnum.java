package self.yang.web.enums;

import com.google.common.base.Optional;
import com.google.common.collect.Maps;
import lombok.AllArgsConstructor;
import lombok.Getter;
import self.yang.tools.responses.ResponseInterface;

import java.util.Arrays;
import java.util.HashMap;

@Getter
@AllArgsConstructor
public enum ResponseMessageEnum implements ResponseInterface {

    SUCCESS(200, "成功", "success"),

    INPUT_STRING_CANNOT_CONVERT_TO_JSON(1000000, "请求体数据无法转换为json", "input string convert to json"),
    INPUT_STRING_CANNOT_MATCH_REQUEST(100001, "属性值非法", "attribute is illegal"),

    CANNOT_GET_ENUM_BYE_CODE(99999, "code无法识别", "cannot get enum bye code");

    private static HashMap<Integer, ResponseMessageEnum> responseMessageMap;

    private int code;

    private String chDesc;

    private String enDesc;

    /**
     * 初始化枚举对象
     */
    static {
        ResponseMessageEnum[] messageEnums = ResponseMessageEnum.values();

        responseMessageMap = Maps.newHashMapWithExpectedSize(messageEnums.length);

        Arrays.stream(messageEnums).forEach(responseMessageEnum -> responseMessageMap.put(responseMessageEnum.code, responseMessageEnum));
    }

    /**
     * 通过code获取对应的枚举信息
     *
     * @param code
     * @return
     */
    public static final ResponseMessageEnum getResponseMessageEnumByCode(int code) {
        ResponseMessageEnum responseMessageEnum = responseMessageMap.get(code);

        return Optional.fromNullable(responseMessageEnum).or(ResponseMessageEnum.CANNOT_GET_ENUM_BYE_CODE);
    }

}
