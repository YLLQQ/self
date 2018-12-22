package self.yang.tools.redises;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import self.yang.tools.utils.MainUtil;

/**
 * redis操作工具类
 */
public abstract class AbstractRedisOperation {

    protected abstract RedisTemplate<String, Object> getRedisTemplate();

    /**
     * 删除缓存值
     *
     * @param keyValue
     * @param redisKeyInterface
     */
    protected void deleteK(
            Object keyValue,
            RedisKeyInterface redisKeyInterface
    ) {
        getRedisTemplate().delete(redisKeyInterface.getKeyPre() + keyValue);
    }

    /**
     * 通过key获取value
     *
     * @param keyValue
     * @param redisKeyInterface
     * @param <T>
     * @return
     */
    protected <T> T getVByK(
            Object keyValue,
            RedisKeyInterface redisKeyInterface
    ) {
        return (T) getRedisTemplate().boundValueOps(redisKeyInterface.getKeyPre() + keyValue).get();
    }

    /**
     * 设置String类型
     *
     * @param keyValue          缓存key前缀
     * @param value             缓存具体值
     * @param redisKeyInterface 接口枚举
     */
    protected void setKVRedis(
            Object keyValue,
            Object value,
            RedisKeyInterface redisKeyInterface
    ) {
        ValueOperations<String, Object> stringObjectValueOperations = getRedisTemplate().opsForValue();

        String key = redisKeyInterface.getKeyPre() + keyValue;

        stringObjectValueOperations.set(key, value);

        if (MainUtil.tIsNotNull(redisKeyInterface.getExpireTime())) {
            getRedisTemplate().expire(key, redisKeyInterface.getExpireTime(), redisKeyInterface.getTimeUnit());
        }
    }

}
