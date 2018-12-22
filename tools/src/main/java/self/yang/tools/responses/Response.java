package self.yang.tools.responses;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class Response implements Serializable {

    private int code;

    private String desc;

    private Object result;

    public Response(
            ResponseEnum responseEnum,
            Object result
    ) {
        this.code = responseEnum.getCode();
        this.desc = responseEnum.getDesc();
        this.result = result;
    }
}
