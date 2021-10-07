import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class duplicatesusinstreams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> integer = new ArrayList<Integer>();
		integer.add(1);
		integer.add(1);
		integer.add(2);
		integer.add(2);
		integer.add(3);
		integer.add(4);
		integer.add(3);

		Map<Integer, List<Integer>> collect = integer.stream().collect(Collectors.groupingBy(Function.identity()));
		System.out.println(collect);
		Map<Integer, Integer> collect2=new HashMap<>();
		collect.forEach((keys,values)->values.forEach((value)->collect2.put(keys, value)));
		
		System.out.println(collect2);
		
		
		Map<Integer, Long> collect3 = integer.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		System.out.println(collect3);
		
		
	
	}

}
