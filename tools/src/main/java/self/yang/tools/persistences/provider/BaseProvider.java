package self.yang.tools.persistences.provider;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.ibatis.jdbc.SQL;
import self.yang.tools.persistences.dos.BaseDO;
import self.yang.tools.utils.ClassUtil;
import self.yang.tools.utils.MainUtil;

import javax.persistence.Column;
import java.lang.reflect.Field;

public class BaseProvider {

    /**
     * 通过ID修改数据
     *
     * @param baseDO
     * @return
     */
    public String updateTById(final BaseDO baseDO) {
        return new SQL() {{
            UPDATE(baseDO.tableName());

            Class<?> aClass = baseDO.getClass();

            // 获取所有属性
            Field[] declaredFields = aClass.getDeclaredFields();

            for (Field declaredField : declaredFields) {
                Model check = check(declaredField, baseDO);

                if (null == check) {
                    continue;
                }

                SET("`" + check.getName() + "`" + "=#{" + check.getKey() + "}");
            }

            WHERE("id = #{id}");
        }}.toString();
    }

    /**
     * 向数据库中插入数据
     *
     * @param baseDO
     * @return
     */
    public String insertT(final BaseDO baseDO) {
        return new SQL() {{

            INSERT_INTO(baseDO.tableName());

            Class<?> aClass = baseDO.getClass();

            // 获取所有属性
            Field[] declaredFields = aClass.getDeclaredFields();

            for (Field declaredField : declaredFields) {

                Model check = check(declaredField, baseDO);

                if (null == check) {
                    continue;
                }

                VALUES("`" + check.getName() + "`", "#{" + check.getKey() + "}");
            }
        }}.toString();
    }

    private Model check(Field declaredField, Object object) {
        Column annotation = declaredField.getAnnotation(Column.class);

        if (null == annotation) {
            return null;
        }

        // 获取属性名以及相关的get方法
        String key = declaredField.getName();

        Object value = ClassUtil.invokeModelNoParametersMethod(object, "get" + MainUtil.getTopUpperString(key));

        if (null == value) {
            return null;
        }

        return new Model(annotation.name(), value, key);
    }

    @Getter
    @AllArgsConstructor
    private class Model {
        private String name;

        private Object value;

        private String key;
    }

}
