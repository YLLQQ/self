package self.yang.tools.guava;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * self.yang.tools.guava.LambdaTest
 *
 * @author eleven
 * @date 2019/03/26
 */
public class LambdaTest {

    public static void main(String[] args) {
        int length = 4;
        int width = 10;
        long[][] countArray = new long[length][width];

        int size = 100;
        List<Integer> integerList = new ArrayList<>(size);

        for (int i = 0; i < size; i++) {
            integerList.add(i);
        }

        List<Integer> list = Lists.newArrayList(integerList);

        for (int j = 0; j < width; j++) {

            long start = System.nanoTime();

            for (int i = 0; i < list.size(); i++) {
                Integer integer = list.get(i);

                integer++;
            }

            long end = System.nanoTime();
            long executeTime = end - start;

            countArray[0][j] = executeTime;

            start = System.nanoTime();

            list.forEach(x -> x++);

            end = System.nanoTime();
            executeTime = end - start;

            countArray[1][j] = executeTime;

            start = System.nanoTime();

            for (Integer integer : list) {
                integer++;
            }

            end = System.nanoTime();
            executeTime = end - start;

            countArray[2][j] = executeTime;

            start = System.nanoTime();

            Iterator<Integer> iterator = list.iterator();

            while (iterator.hasNext()) {
                Integer next = iterator.next();

                next++;
            }

            end = System.nanoTime();
            executeTime = end - start;

            countArray[3][j] = executeTime;
        }

        for (int i1 = 0; i1 < length; i1++) {
            if (i1 == 0) {
                System.out.print(String.format("%8s", "fori") + "\t");
            }
            if (i1 == 1) {
                System.out.print(String.format("%8s", "lambda") + "\t");
            }
            if (i1 == 2) {
                System.out.print(String.format("%8s", "fort") + "\t");
            }
            if (i1 == 3) {
                System.out.print(String.format("%8s", "iterator") + "\t");
            }
            for (int i = 0; i < width; i++) {
                System.out.print(String.format("%8d", countArray[i1][i]) + "\t");
            }
            System.out.println();
        }

    }
}
