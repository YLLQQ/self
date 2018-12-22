package self.yang.tools.utils;

import com.fasterxml.uuid.Generators;
import org.springframework.util.Base64Utils;

import java.io.UnsupportedEncodingException;

public class MainUtil {

    /**
     * base64编码
     *
     * @param string
     * @return
     */
    public static String encodeByBase64(String string) {
        return Base64Utils.encodeToString(string.getBytes());
    }

    /**
     * base64解码
     *
     * @param string
     * @return
     */
    public static String decodeByBase64(String string) {
        try {
            return new String(Base64Utils.decodeFromString(string), "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();

            return null;
        }
    }

    /**
     * 获取UUID
     *
     * @return
     */
    public static String getUUID() {
        return Generators.timeBasedGenerator().generate().toString();
    }

    /**
     * 将字符串首字母大写
     *
     * @param string
     * @return
     */
    public static String getTopUpperString(String string) {
        return string.substring(0, 1).toUpperCase() + string.substring(1);
    }

    /**
     * 对象是否非null
     *
     * @param t
     * @param <T>
     * @return
     */
    public static <T> boolean tIsNotNull(T t) {
        return !tIsNull(t);
    }

    /**
     * 对象是否为null
     *
     * @param t
     * @param <T>
     * @return
     */
    public static <T> boolean tIsNull(T t) {
        return t == null;
    }
}
