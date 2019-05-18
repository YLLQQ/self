package self.yang.tools.utils;

import lombok.Data;

/**
 * self.yang.tools.utils.Test
 *
 * @author eleven
 * @date 2019/05/18
 */
public class Test {
    public static void main(String[] args) {

        TestDemo testDemo = null;
        TestDemo1 testDemo1 = null;

        Tool.isNull(null);
        Tool.isNull(testDemo);
        Tool.isNull(testDemo1);

    }

}

class Tool {
    public static boolean isNull(Object o) {
        System.out.println("o");

        return null == o;
    }

    public static <T extends TestDemo> boolean isNull(T t) {
        System.out.println("t");

        return null == t;
    }
}

@Data
class TestDemo {
    private String name;

    private int age;
}

@Data
class TestDemo1 {
    private String name;

    private int age;
}

