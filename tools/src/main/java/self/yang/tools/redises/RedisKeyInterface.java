package self.yang.tools.redises;

import java.util.concurrent.TimeUnit;

/**
 * 缓存Key配置接口
 */
public interface RedisKeyInterface {

    /**
     * 缓存key值前缀
     */
    String getKeyPre();

    /**
     * 有效期
     */
    Long getExpireTime();

    /**
     * 单位
     */
    TimeUnit getTimeUnit();

}
