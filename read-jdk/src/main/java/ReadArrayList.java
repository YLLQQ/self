import java.util.ArrayList;
import java.util.List;

/**
 * PACKAGE_NAME.ReadArrayList
 *
 * @author eleven
 * @date 2019/09/06
 */
public class ReadArrayList {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>(3);

        list.add("A");
        list.add("B");
        list.add("C");

        System.out.println(list.size());
    }
}
