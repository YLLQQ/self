package self.yang.tools.guava;

import com.google.common.collect.Lists;
import com.google.common.reflect.TypeToken;

import java.util.ArrayList;

/**
 * self.yang.tools.guava.ReflectionTest
 * <p>
 * http://ifeve.com/guava-reflection/
 *
 * @author eleven
 * @date 2019/03/20
 */
public class ReflectionTest {
    public static void main(String[] args) {
        ArrayList<String> stringArrayList = Lists.newArrayList();
        ArrayList<Integer> integerArrayList = Lists.newArrayList();

        boolean assignableFrom = integerArrayList.getClass().isAssignableFrom(stringArrayList.getClass());

        //由于类型擦除，你不能够在运行时传递泛型类对象——你可能想强制转换它们，并假装这些对象是有泛型的，但实际上它们没有。
        //Java不能在运行时保留对象的泛型类型信息。
        //如果你在运行时有一个ArrayList<String>对象，你不能够判定这个对象是有泛型类型ArrayList<String>的 —— 并且通过不安全的原始类型，
        //你可以将这个对象强制转换成ArrayList<Object>。
        //但是，反射允许你去检测方法和类的泛型类型。如果你实现了一个返回List的方法，并且你用反射获得了这个方法的返回类型，你会获得代表List<String>的ParameterizedType。
        //even though ArrayList<String> is not assignable from ArrayList<Integer>
        //true
        System.out.println(assignableFrom);

        TypeToken<? extends ArrayList> typeToken = TypeToken.of(stringArrayList.getClass());
        TypeToken<? extends ArrayList> typeToken2 = TypeToken.of(integerArrayList.getClass());

        System.out.println(typeToken);
        System.out.println(typeToken2);
        System.out.println(typeToken.getComponentType());
        System.out.println(typeToken2.getComponentType());
        System.out.println(typeToken.equals(typeToken2));
    }
}
