package self.yang.tools.responses;

public interface ResponseInterface {

    /**
     * 响应码
     *
     * @return
     */
    int getCode();

    /**
     * 中文描述
     *
     * @return
     */
    String getChDesc();

    /**
     * 英文描述
     *
     * @return
     */
    String getEnDesc();
}
