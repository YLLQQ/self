package self.yang.tools.guava;

import com.google.common.collect.*;

import java.util.*;

/**
 * self.yang.tools.guava.NewCollectionsTest
 *
 * @author eleven
 * @date 2019/03/20
 */
public class NewCollectionsTest {

    public static void main(String[] args) {
        List<Integer> arrayList = Arrays.asList(1, 2, 3, 4, 3, 2, 4, 3, 1);

        //Multiset
        //请注意，Multiset<E>不是Map<E, Integer>，虽然Map可能是某些Multiset实现的一部分。准确来说Multiset是一种Collection类型，并履行了Collection接口相关的契约。关于Multiset和Map的显著区别还包括：
        //
        //Multiset中的元素计数只能是正数。任何元素的计数都不能为负，也不能是0。elementSet()和entrySet()视图中也不会有这样的元素。
        //multiset.size()返回集合的大小，等同于所有元素计数的总和。对于不重复元素的个数，应使用elementSet().size()方法。（因此，add(E)把multiset.size()增加1）
        //multiset.iterator()会迭代重复元素，因此迭代长度等于multiset.size()。
        //Multiset支持直接增加、减少或设置元素的计数。setCount(elem, 0)等同于移除所有elem。
        //对multiset 中没有的元素，multiset.count(elem)始终返回0。
        Multiset multiset = HashMultiset.create(arrayList);

        Iterator iterator = multiset.iterator();

        //1
        //1
        //2
        //2
        //3
        //3
        //3
        //4
        //4
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        Set elementSet = multiset.elementSet();

        //1
        //2
        //3
        //4
        for (Object o : elementSet) {
            System.out.println(o);
        }

        Iterator iterator1 = multiset.entrySet().iterator();

        //1 x 2
        //element is 1 and count is 2
        //2 x 2
        //element is 2 and count is 2
        //3 x 3
        //element is 3 and count is 3
        //4 x 2
        //element is 4 and count is 2
        while (iterator1.hasNext()) {
            Object next = iterator1.next();

            System.out.println(next);

            Multiset.Entry entry = (Multiset.Entry) next;

            System.out.println("element is " + entry.getElement() + " and count is " + entry.getCount());
        }

        //2
        System.out.println(multiset.count(1));
        //2
        System.out.println(multiset.count(2));
        //3
        System.out.println(multiset.count(3));
        //2
        System.out.println(multiset.count(4));

        //Multimap<K, V>不是Map<K,Collection<V>>，虽然某些Multimap实现中可能使用了map。它们之间的显著区别包括：
        //
        //Multimap.get(key)总是返回非null、但是可能空的集合。这并不意味着Multimap为相应的键花费内存创建了集合，而只是提供一个集合视图方便你为键增加映射值——译者注：如果有这样的键，返回的集合只是包装了Multimap中已有的集合；如果没有这样的键，返回的空集合也只是持有Multimap引用的栈对象，让你可以用来操作底层的Multimap。因此，返回的集合不会占据太多内存，数据实际上还是存放在Multimap中。
        //如果你更喜欢像Map那样，为Multimap中没有的键返回null，请使用asMap()视图获取一个Map<K, Collection<V>>。（或者用静态方法Multimaps.asMap()为ListMultimap返回一个Map<K, List<V>>。对于SetMultimap和SortedSetMultimap，也有类似的静态方法存在）
        //当且仅当有值映射到键时，Multimap.containsKey(key)才会返回true。尤其需要注意的是，如果键k之前映射过一个或多个值，但它们都被移除后，Multimap.containsKey(key)会返回false。
        //Multimap.entries()返回Multimap中所有”键-单个值映射”——包括重复键。如果你想要得到所有”键-值集合映射”，请使用asMap().entrySet()。
        //Multimap.size()返回所有”键-单个值映射”的个数，而非不同键的个数。要得到不同键的个数，请改用Multimap.keySet().size()。
        Multimap<String, String> multimap = HashMultimap.create();

        multimap.put("1", "2");
        multimap.put("1", "3");
        multimap.put("1", "3");
        multimap.put("1", "5");
        multimap.put("2", "2");
        multimap.put("3", "3");
        multimap.put("2", "4");
        multimap.put("3", "5");

        //{1=[5, 2, 3], 2=[4, 2], 3=[5, 3]}
        System.out.println(multimap);

        Map<String, Collection<String>> collectionMap = multimap.asMap();

        //{1=[5, 2, 3], 2=[4, 2], 3=[5, 3]}
        System.out.println(collectionMap);

        Collection<String> strings = multimap.get("1");

        //5
        //2
        //3
        for (String string : strings) {
            System.out.println(string);
        }

        //传统上，实现键值对的双向映射需要维护两个单独的map，并保持它们间的同步。但这种方式很容易出错，而且对于值已经在map中的情况，会变得非常混乱。
        //BiMap<K, V>是特殊的Map：
        //
        //可以用 inverse()反转BiMap<K, V>的键值映射
        //保证值是唯一的，因此 values()返回Set而不是普通的Collection
        //在BiMap中，如果你想把键映射到已经存在的值，会抛出IllegalArgumentException异常。如果对特定值，你想要强制替换它的键，请使用 BiMap.forcePut(key, value)。
        BiMap<String, Integer> biMap = HashBiMap.create();

        biMap.put("a", 1);
        biMap.put("b", 2);
        biMap.put("c", 3);
        biMap.put("d", 4);

        Integer a = biMap.get("a");

        //1
        System.out.println(a);

        String s = biMap.inverse().get(a);

        //a
        System.out.println(s);

    }
}
