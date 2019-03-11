package asserts;

public final class Assert {

    /**
     * 断言表达式要求为false，如果否则则抛出异常
     *
     * @param expression
     * @param message
     * @param objects
     */
    public static void isFalse(
            final boolean expression,
            final String message,
            final Object... objects
    ) {
        isTrue(!expression, message, objects);
    }


    /**
     * 断言表达式要求为true，如果否则则抛出异常
     *
     * @param expression
     * @param message
     * @param objects
     */
    public static void isTrue(
            final boolean expression,
            final String message,
            final Object... objects
    ) {
        if (!expression) {
            if (objects.length == 0) {
                throw new AssertException(message);
            }

            throw new AssertException(String.format(message, objects));
        }
    }

}
