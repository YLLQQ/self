package self.yang.tools.responses;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class Response implements Serializable {

    private int code;

    private String chDesc;

    private String enDesc;

    private Object result;

    public Response(
            ResponseInterface responseInterface,
            Object result
    ) {
        this.code = responseInterface.getCode();
        this.chDesc = responseInterface.getChDesc();
        this.enDesc = responseInterface.getEnDesc();
        this.result = result;
    }
}
