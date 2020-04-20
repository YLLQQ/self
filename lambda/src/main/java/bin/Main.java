package bin;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author yangguoqing
 */
public class Main {

	public static void main(String[] args) {
		List<String> stringList = Arrays.asList("1", "2", "3", "4", "5");

		stringList.forEach(System.out::println);

		List<Integer> integerList = stringList.stream().map(s -> Integer.valueOf(s)).collect(Collectors.toList());

		integerList.forEach(System.out::println);

		boolean anyMatch = stringList.stream().anyMatch(x -> x.equals("4"));

		System.out.println(anyMatch);

		long count = stringList.stream().count();

		System.out.println(count);

		List<String> sortedStringList =
				stringList.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());

		sortedStringList.stream().forEach(System.out::println);

		List<Integer> integerList1 =
				stringList.stream().mapToInt(x -> Integer.valueOf(x) * 2).boxed().collect(Collectors.toList());

		integerList1.stream().forEach(System.out::println);

		stringList.forEach(x -> System.out.println(x + "111"));
		stringList.forEach(x -> System.out.println(x));

		stringList.replaceAll(x -> x + "1");

		stringList.forEach(System.out::println);

		HashMap<String, String> stringStringHashMap = new HashMap<>();

		stringStringHashMap.put("1111", "cvae");

		System.out.println(stringStringHashMap.get("1111"));

		ArrayList<String> strings = new ArrayList<>();


	}
}
