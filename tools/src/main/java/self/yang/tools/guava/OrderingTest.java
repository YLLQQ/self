package self.yang.tools.guava;

import com.google.common.collect.Ordering;
import com.google.common.primitives.Ints;

import java.util.Arrays;
import java.util.List;

/**
 * self.yang.tools.guava.OrderingTest
 *
 * @author eleven
 * @date 2019/03/20
 */
public class OrderingTest {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("1", "2", "3");

        String listMax = Ordering.natural().nullsFirst().max(list.iterator());

        //3
        System.out.println(listMax);

        //自定义排序
        Ordering<String> stringOrderingByLength = new Ordering<String>() {
            @Override
            public int compare(String left, String right) {
                return Ints.compare(left.length(), right.length());
            }
        };

        List<String> listMaxes = Ordering.natural().nullsFirst().greatestOf(list.iterator(), 3);

        //[3, 2, 1]
        System.out.println(listMaxes);

        String max = stringOrderingByLength.max("abc", "bcd");

        //abc
        System.out.println(max);

        max = stringOrderingByLength.max("bcd", "abc");

        //bcd
        System.out.println(max);

        max = stringOrderingByLength.max("abcd", "abc");

        //abcd
        System.out.println(max);

        max = stringOrderingByLength.max("abcd", "abcde");

        //abcde
        System.out.println(max);

    }
}
