package test;

import java.util.Arrays;

/**
 * @author yangguoqing
 */
public class Main {

	public static void main(String[] args) {


		String temp = "330100/A33828536@@33010420100716412X";
		String temp1 = "1111";

		String[] split = temp.split("[/@]");
		System.out.println(split.length);
		Arrays.stream(split).forEach(System.out::println);

	}

	public static void print(Model model) {
		new Thread(() -> {
			model.setMessage("2222");

			System.out.println(Thread.currentThread().getId() + "->" + model);
		}).start();
	}
}
