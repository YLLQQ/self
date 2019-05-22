package self.yang.tools.utils;

import java.util.Scanner;

/**
 * self.yang.tools.utils.CalculationTest
 *
 * @author eleven
 * @date 2019/05/21
 */
public class CalculationTest {

    public static void main(String[] args) {
        int A = getIntValue();

        System.out.println("input A=" + A);

        int B = getIntValue();

        System.out.println("input B=" + B);

    }

    private static Integer getIntValue() {
        System.out.print("input int value: ");
        Scanner scanner = new Scanner(System.in);
        String inputValue = scanner.next();
        System.out.println();

        Integer intValue = null;

        boolean flag = true;

        while (flag) {
            try {
                intValue = Integer.valueOf(inputValue);

                flag = false;
            } catch (Exception e) {
                System.out.print("input int value: ");
                scanner = new Scanner(System.in);
                inputValue = scanner.next();
                System.out.println();
            }
        }

        return intValue;
    }
}
