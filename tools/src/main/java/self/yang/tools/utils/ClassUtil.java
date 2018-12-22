package self.yang.tools.utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ClassUtil {

    /**
     * 调用类的无参方法
     *
     * @param object
     * @param methodName
     * @return
     */
    public static Object invokeModelNoParametersMethod(
            Object object,
            String methodName
    ) {
        try {
            Method method = object.getClass().getMethod(methodName);

            return method.invoke(object);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        return null;
    }
}
