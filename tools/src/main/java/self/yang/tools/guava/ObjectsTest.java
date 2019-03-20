package self.yang.tools.guava;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.collect.ComparisonChain;

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

        //ObjectsTest{x=1}
        String toString = MoreObjects.toStringHelper(new ObjectsTest()).add("x", 1).toString();

        System.out.println(toString);

        //ObjectsTest{x=1}
        toString = MoreObjects.toStringHelper("ObjectsTest").add("x", 1).toString();

        System.out.println(toString);

        //{x=1}
        toString = MoreObjects.toStringHelper("").add("x", 1).toString();

        System.out.println(toString);

        //1
        int result = ComparisonChain.start().compareFalseFirst(true, false).result();

        System.out.println(result);

        //-1
        result = ComparisonChain.start().compareFalseFirst(false, true).result();

        System.out.println(result);

        //0
        result = ComparisonChain.start().compareFalseFirst(false, false).result();

        System.out.println(result);

        //0
        result = ComparisonChain.start().compareFalseFirst(true, true).result();

        System.out.println(result);
    }
}
