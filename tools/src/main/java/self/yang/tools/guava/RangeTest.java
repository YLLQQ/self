package self.yang.tools.guava;

import com.google.common.collect.BoundType;
import com.google.common.collect.Range;

/**
 * self.yang.tools.guava.RangeTest
 *
 * @author eleven
 * @date 2019/03/20
 */
public class RangeTest {

    public static void main(String[] args) {
        //区间，有时也称为范围，是特定域中的凸性（非正式说法为连续的或不中断的）部分。在形式上，凸性表示对a<=b<=c, range.contains(a)且range.contains(c)意味着range.contains(b)。
        //
        //区间可以延伸至无限——例如，范围”x>3″包括任意大于3的值——也可以被限制为有限，如” 2<=x<5″。Guava用更紧凑的方法表示范围，有数学背景的程序员对此是耳熟能详的：
        //
        //(a..b) = {x | a < x < b}
        //[a..b] = {x | a <= x <= b}
        //[a..b) = {x | a <= x < b}
        //(a..b] = {x | a < x <= b}
        //(a..+∞) = {x | x > a}
        //[a..+∞) = {x | x >= a}
        //(-∞..b) = {x | x < b}
        //(-∞..b] = {x | x <= b}
        //(-∞..+∞) = 所有值
        //上面的a、b称为端点 。为了提高一致性，Guava中的Range要求上端点不能小于下端点。上下端点有可能是相等的，但要求区间是闭区间或半开半闭区间（至少有一个端点是包含在区间中的）：
        //
        //[a..a]：单元素区间
        //[a..a); (a..a]：空区间，但它们是有效的
        //(a..a)：无效区间
        Range<Integer> integerRange = Range.open(1, 3);

        //(1..3)
        System.out.println(integerRange);
        //false
        System.out.println(integerRange.contains(1));
        //true
        System.out.println(integerRange.contains(2));
        //false
        System.out.println(integerRange.contains(3));

        Range<Integer> integerRange1 = Range.range(1, BoundType.CLOSED, 4, BoundType.OPEN);

        //[1..4)
        System.out.println(integerRange1);

    }
}
