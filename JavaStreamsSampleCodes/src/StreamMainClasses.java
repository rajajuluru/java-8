import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.Spliterator;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamMainClasses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
	List<EmployeeClass> emplis=new ArrayList<>();
	emplis.add(new EmployeeClass("raja", 101, 222, 800000, "active"));
	emplis.add(new EmployeeClass("juluru", 102, 223, 1800000, "active"));
	emplis.add(new EmployeeClass("kumar", 103, 222, 100000, "inactive"));
	emplis.add(new EmployeeClass("hareesh", 104, 224, 200000, "active"));
	emplis.add(new EmployeeClass("goli", 105, 225, 600000, "inactive"));
	emplis.add(new EmployeeClass("sampath", 106, 224, 200000, "active"));

	Spliterator<EmployeeClass> spliterator = emplis.spliterator();
	Spliterator<EmployeeClass> trySplit = spliterator.trySplit();
	//System.out.println(spliterator.estimateSize()+"spliterator size");
	spliterator.forEachRemaining(System.out::println);
	
	
	trySplit.forEachRemaining(System.out::println);
	
	//System.out.println(trySplit.estimateSize()+"trySplit size");
	
	
	Map<Integer, EmployeeClass> collect2 = emplis.stream().collect(Collectors.toMap(EmployeeClass::getEmpid, Function.identity()));
	Map<Integer, List<EmployeeClass>> empmapdep =
			emplis.stream().
			collect(Collectors.groupingBy(EmployeeClass::getDepid,Collectors.toList()));
	
	empmapdep.entrySet().stream().forEach(action->{
		System.out.println("key is"+action.getKey());
		System.out.println("value is"+action.getValue());
	});
	
	empmapdep.forEach((k,v)->{
		
		System.out.println(k +"k   "+v+"  empmapdep");
	});
	Map<Integer, Long> countmap = emplis.stream().
			collect(Collectors.
					groupingBy(EmployeeClass::getDepid,Collectors.counting()));
	
	System.out.println(countmap);
	
	Optional<EmployeeClass> max = emplis.stream().max(Comparator.comparing(EmployeeClass::getSalary));
	Optional<EmployeeClass> min = emplis.stream().min(Comparator.comparing(EmployeeClass::getSalary));
	//max.ofNullable(value)
	
	Map<Integer, Optional<EmployeeClass>> collect = emplis.stream().
	collect(
			Collectors.groupingBy
			(EmployeeClass::getDepid,
					Collectors.reducing(
							BinaryOperator.maxBy(
									Comparator.comparing(EmployeeClass::getSalary)))));
	
	
	
	System.out.println("salary bases on department"+collect);
	 OptionalInt findAny = emplis.stream().mapToInt(s->s.getSalary()).findAny();
	
	System.out.println(findAny.getAsInt()+"mapToInt");
	
	Optional<Integer> reduce = emplis.stream().map(s->s.getSalary()).reduce(Integer::sum);
	
String name="java";
IntStream chars = name.chars();
Stream<Character> mapToObj = chars.mapToObj(s->(char)s);
Map<Character, Long> collect3 = mapToObj.collect(Collectors.groupingBy(ch->ch,Collectors.counting()));
collect3.forEach((k,v)->{
	System.out.println(k+"          "+v);
});

Map<String, Integer> budget = new HashMap<>();
budget.put("clothes", 120);
budget.put("grocery", 150);
budget.put("transportation", 100);
budget.put("utility", 130);
budget.put("rent", 1150);
budget.put("miscellneous", 90);

System.out.println("map before sorting: " + budget);


	
	Map<String, Integer> sortedByValue = 
			budget.entrySet().
			stream().
			//sorted(Map.Entry.<String, Integer> comparingByValue()).
			sorted(new Comparator<Map.Entry>() {

				@Override
				public int compare(Entry o1, Entry o2) {
					// TODO Auto-generated method stub
					return ((String)o1.getKey()).compareTo(((String)o2.getKey()));
				}
			}).
			collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (s1,s2)->s1,LinkedHashMap::new));
			//.collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

	Map<String, String> dummy = new LinkedHashMap();
	dummy.put("raja", "data");
	dummy.put(null, "data1");
	dummy.put("null", "data12");
	System.out.println(dummy);
	
	
	}
}