package self.yang.tools.guava;

import com.google.common.collect.ImmutableSet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * self.yang.tools.guava.ImmutableTest
 * <p>
 * 不可变对象有很多优点，包括：
 * <p>
 * 当对象被不可信的库调用时，不可变形式是安全的；
 * 不可变对象被多个线程调用时，不存在竞态条件问题
 * 不可变集合不需要考虑变化，因此可以节省时间和空间。所有不可变的集合都比它们的可变形式有更好的内存利用率（分析和测试细节）；
 * 不可变对象因为有固定不变，可以作为常量来安全使用。
 * <p>
 * 可变集合接口	            属于JDK还是Guava	    不可变版本
 * Collection	            JDK	                ImmutableCollection
 * List	                    JDK	                ImmutableList
 * Set	                    JDK	                ImmutableSet
 * SortedSet/NavigableSet	JDK     	        ImmutableSortedSet
 * Map	                    JDK	                ImmutableMap
 * SortedMap	            JDK	                ImmutableSortedMap
 * Multiset	                Guava	            ImmutableMultiset
 * SortedMultiset	        Guava	            ImmutableSortedMultiset
 * Multimap	                Guava	            ImmutableMultimap
 * ListMultimap	            Guava	            ImmutableListMultimap
 * SetMultimap	            Guava	            ImmutableSetMultimap
 * BiMap	                Guava	            ImmutableBiMap
 * ClassToInstanceMap	    Guava	            ImmutableClassToInstanceMap
 * Table	                Guava	            ImmutableTable
 *
 * @author eleven
 * @date 2019/03/20
 */
public class ImmutableTest {

    /**
     * 不可变对象
     */
    public static final ImmutableSet<String> COLOR_NAMES = ImmutableSet.of(
            "red",
            "orange",
            "yellow",
            "green",
            "blue",
            "purple");

    public static final List<String> LIST = Arrays.asList("1", "2", "3");
    public static final List<String> LIST1 = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println(COLOR_NAMES);

        LIST1.add("1");
        LIST1.add("2");

        System.out.println(LIST1);

        LIST.add("45");

        System.out.println(LIST);

    }
}
