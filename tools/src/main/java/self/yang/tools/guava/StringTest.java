package self.yang.tools.guava;

import com.google.common.base.*;

import java.util.Arrays;

/**
 * self.yang.tools.guava.StringTest
 *
 * @author eleven
 * @date 2019/03/20
 */
public class StringTest {

    public static void main(String[] args) {
        //连接器[Joiner]
        Joiner joiner = Joiner.on(",").skipNulls();

        String string = joiner.join("1", "a", null, "@");

        //1,a,@
        System.out.println(string);

        String str = ",a,,b,";

        String[] split = str.split(",");

        //4
        System.out.println(split.length);

        //,
        //a,
        //,
        //b,
        Arrays.stream(split).forEach(x -> System.out.println(x + ","));

        //拆分器[Splitter]
        Iterable<String> split1 = Splitter.on(",").trimResults().omitEmptyStrings().split(str);

        //a;
        //b;
        split1.forEach(x -> System.out.println(x + ";"));

        //字符匹配器[CharMatcher]
        String testString = "1234\nabcdABCD";

        //1234
        //abcdABCD
        System.out.println(testString);

        //移除control字符
        String noControl = CharMatcher.javaIsoControl().removeFrom(testString);

        //1234abcdABCD
        System.out.println(noControl);

        //只保留数字字符
        String retainFrom = CharMatcher.digit().retainFrom(testString);

        //1234
        System.out.println(retainFrom);

        //只保留数字和小写字母
        String lowerAndDigit = CharMatcher.digit().or(CharMatcher.javaLowerCase()).retainFrom(testString);

        //1234abcd
        System.out.println(lowerAndDigit);

        //字符集[Charsets]
        //Charsets针对所有Java平台都要保证支持的六种字符集提供了常量引用。尝试使用这些常量，而不是通过名称获取字符集实例。
        //[B@4dcbadb4
        System.out.println(lowerAndDigit.getBytes(Charsets.UTF_8));

        //大小写格式[CaseFormat]
        //CaseFormat被用来方便地在各种ASCII大小写规范间转换字符串——比如，编程语言的命名规范。
        String constantName = CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, "CONSTANT_NAME");

        //constantName
        System.out.println(constantName);

        constantName = CaseFormat.LOWER_CAMEL.to(CaseFormat.UPPER_UNDERSCORE, "constantName");

        //CONSTANT_NAME
        System.out.println(constantName);

        constantName = CaseFormat.LOWER_CAMEL.to(CaseFormat.UPPER_CAMEL, "constantName");

        //ConstantName
        System.out.println(constantName);

        constantName = CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, "constantName");

        //constant_name
        System.out.println(constantName);
    }
}
