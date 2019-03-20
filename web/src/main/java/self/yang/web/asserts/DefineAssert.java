package self.yang.web.asserts;

import com.google.common.base.Throwables;
import self.yang.web.exception.DefineException;

/**
 * self.yang.web.asserts.DefineAssert
 *
 * @author eleven
 * @date 2019/03/20
 */
public class DefineAssert {

    /**
     * 不允许为null
     *
     * @param t
     * @param <T>
     */
    public static <T> void checkNotNull(T t) {
        if (null == t) {
            Throwables.throwIfUnchecked(new DefineException("input params must be not null"));
        }
    }
}
