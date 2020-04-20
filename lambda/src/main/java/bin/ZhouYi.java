package bin;

import java.util.HashSet;
import java.util.Random;

/**
 * @author yangguoqing
 */
public class ZhouYi {

	public static void main(String[] args) {

		// 求要不要继续留在九牛
		// 111001 乾下艮上
//		printGua();

		// 求九牛什么时候扭亏为盈
		// 101001
//		printGua();

		// 求王一鸣适不适合留在九牛
		// 001011
//		printGua();

		// 求这一期的大乐透号码
		printGua();// 100010 1 16         17 	1
		printGua();// 011011 2 4 16 32    54 	19
		printGua();// 001111 4 8 16 32    60 	25
		printGua();// 101001 1 4 32       37 	2
		printGua();// 111100 1 2 4 8      15 	20
		printGua();// 101001 1 4 32       37 	1
		printGua();// 100101 1 8 32       41 	5

		HashSet<String> strings = new HashSet<>();

		strings.add("1");

	}

	public static void printGua() {
		Random random = new Random();
		StringBuilder stringBuilder = new StringBuilder();

		for (int i = 0; i < 6; i++) {
			stringBuilder.append(random.nextInt(10000) % 2);
		}

		System.out.println(stringBuilder.toString());
	}
}
