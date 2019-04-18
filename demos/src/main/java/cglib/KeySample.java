package cglib;

import net.sf.cglib.core.KeyFactory;

/**
 * cglib.KeySample
 *
 * @author eleven
 * @date 2019/04/18
 */
public class KeySample {
    public static void main(String[] args) {
        MyFactory f = (MyFactory) KeyFactory.create(MyFactory.class);

        Object key1 = f.newInstance(20, new char[]{'a', 'b'}, "hello");
        Object key2 = f.newInstance(20, new char[]{'a', 'b'}, "hello");
        Object key3 = f.newInstance(20, new char[]{'a', '_'}, "hello");

        System.out.println(key1);
        System.out.println(key2);
        System.out.println(key3);

        System.out.println(key1.equals(key2));
        System.out.println(key2.equals(key3));

        MyFactory f1 = (MyFactory) KeyFactory.create(MyFactory.class);

        Object key4 = f1.newInstance(20, new char[]{'a', 'b'}, "hello");

        System.out.println(key1.equals(key4));

        System.out.println(key1.hashCode());
        System.out.println(key4.hashCode());
    }

    private interface MyFactory {
        Object newInstance(int a, char[] b, String d);
    }
}
