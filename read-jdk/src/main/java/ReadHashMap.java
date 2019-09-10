import java.util.HashMap;
import java.util.Map;

/**
 * PACKAGE_NAME.ReadHashMap
 *
 * @author eleven
 * @date 2019/09/06
 */
public class ReadHashMap {

    public static void main(String[] args) {
        Map<String, Integer> stringIntegerHashMap = new HashMap<>(4);

        System.out.println(stringIntegerHashMap.size());

        stringIntegerHashMap.put("A", 1);
        stringIntegerHashMap.put("B", 2);
        stringIntegerHashMap.put("C", 3);
        stringIntegerHashMap.put("D", 4);

        System.out.println(stringIntegerHashMap);
    }

}
