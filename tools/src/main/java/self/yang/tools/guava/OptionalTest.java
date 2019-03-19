package self.yang.tools.guava;

import com.google.common.base.Optional;

public class OptionalTest {
    public static void main(String[] args) {
        Integer num = 5;

        Optional<Integer> optional = Optional.of(num);

        // true
        System.out.println(optional.isPresent());
        // 5
        System.out.println(optional.get());

        Optional<Object> absent = Optional.absent();

        // false
        System.out.println(absent.isPresent());
        //Exception in thread "main" java.lang.IllegalStateException: Optional.get() cannot be called on an absent value
        //	at com.google.common.base.Absent.get(Absent.java:45)
        //	at self.yang.tools.guava.OptionalTest.main(OptionalTest.java:23)
        System.out.println(absent.get());

        // 创建指定引用的Optional实例，若引用为null则快速失败
        //Exception in thread "main" java.lang.NullPointerException
        //	at com.google.common.base.Preconditions.checkNotNull(Preconditions.java:770)
        //	at com.google.common.base.Optional.of(Optional.java:105)
        //	at self.yang.tools.guava.OptionalTest.main(OptionalTest.java:16)
        optional = Optional.of(null);

        System.out.println(optional.isPresent());
        System.out.println(optional.get());
    }
}
