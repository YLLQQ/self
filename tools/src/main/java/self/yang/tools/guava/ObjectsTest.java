package self.yang.tools.guava;

import com.google.common.base.Objects;

public class ObjectsTest {

    public static void main(String[] args) {
        //false
        System.out.println(Objects.equal("a", "b"));

        //false
        System.out.println(Objects.equal("a", null));

        //true
        System.out.println(Objects.equal(null, null));

        //true
        System.out.println(Objects.equal("a", "a"));

        //false
        System.out.println(Objects.equal(null, "b"));

//        String toString = Objects.toStringHelper(this).add("x", 1).toString();
//
//        System.out.println(toString);
    }
}
