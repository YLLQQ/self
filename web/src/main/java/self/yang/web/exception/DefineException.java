package self.yang.web.exception;

/**
 * self.yang.web.exception.DefineException
 *
 * @author eleven
 * @date 2019/03/20
 */
public class DefineException extends RuntimeException {

    private static final long serialVersionUID = 9166674832535487978L;

    /**
     * 自定义异常
     *
     * @param message
     */
    public DefineException(String message) {
        super(message);
    }
}
