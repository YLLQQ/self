package asserts;

public final class Assert {

    /**
     * 断言字符串为非 empty(可以包含空格)，否则则抛出异常
     *
     * @param string
     */
    public static void stringIsNotEmpty(
            final String string
    ) {
        isNotNull("String cannot be null");

        if (string.isEmpty()) {
            throwException("String cannot be empty");
        }
    }

    /**
     * 断言字符串为empty(可以包含空格)，否则则抛出异常
     *
     * @param string
     */
    public static void stringIsEmpty(
            final String string
    ) {
        isNotNull("String cannot be null");

        if (!string.isEmpty()) {
            throwException("String cannot be not empty");
        }
    }

    /**
     * 断言对象要求为非null，否则则抛出异常
     *
     * @param object
     */
    public static void isNotNull(
            final Object object
    ) {
        if (null == object) {
            throwException("object cannot be null");
        }
    }

    /**
     * 断言对象要求为null，否则则抛出异常
     *
     * @param object
     */
    public static void isNull(
            final Object object
    ) {
        if (null != object) {
            throwException("object cannot be not null");
        }
    }

    /**
     * 断言表达式要求为false，否则则抛出异常
     *
     * @param expression
     * @param message
     */
    public static void isFalse(
            final boolean expression,
            final String message
    ) {
        isTrue(!expression, message);
    }


    /**
     * 断言表达式要求为true，否则则抛出异常
     *
     * @param expression
     * @param message
     */
    public static void isTrue(
            final boolean expression,
            final String message
    ) {
        if (!expression) {
            throwException(message);
        }

    }

    /**
     * 抛出异常
     *
     * @param message
     */
    private static void throwException(
            final String message
    ) {
        throw new AssertException(message);
    }

}
