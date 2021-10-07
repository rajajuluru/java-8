import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StartingMain {

	public static void main(String[] args) throws SQLException {
		
		
		
		Sample sample = new Sample() {
			
			@Override
			public String abce3() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public String abce2() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public String abce1() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public String abce() {
				// TODO Auto-generated method stub
				return null;
			}
		};
		// TODO Auto-generated method stub
		Runnable run=()->{
			System.out.println("runnable");
		};

		Thread t=new Thread(run);
		t.start();
		
		
		List<Integer> asList = Arrays.asList(5,6,8,10);
		//asList.stream().
		Predicate<Integer> even= a -> a%2==0;
		Predicate<Integer> odd= a -> a%2!=0;
		
		Consumer<String> con=(s)->System.out.println(s);
		
	
		
		Supplier<String> sup=()->"";
		
		asList.stream().filter(even).forEach(System.out::println);
		asList.stream().filter(odd).forEach(System.out::println);
		
		
		
		
				
		 IntStream.rangeClosed(1, 100).skip(101).peek(s-> System.out.println(s)).average().ifPresent(System.out::println);
		
		 List<List<Integer>> listoflist=new ArrayList<>();
		 listoflist.add(asList);
		 listoflist.add(asList);
		 List<Integer> collect = listoflist.stream().flatMap(s->s.stream()).collect(Collectors.toList());
		 
		 System.out.println(collect);
		 
		 Integer reduce = collect.stream().reduce(0, Integer::sum);
		 
		 System.out.println(reduce);
		 
		 
		 Stream.iterate(0, (a)->a+1).limit(20).peek(System.out::println);
		 
		 Stream.of(1,2,3);
		// Arrays.stream();
	
			Function<String, String> fun=(s)-> {
				System.out.println("function called");
				return s+"abcd";};
		 
		 //String apply = fun.compose(s->s.toString().toUpperCase()).apply("appling");
		// System.out.println(apply);
	Function<Object, String> andThen = fun.compose(s->{
		System.out.println("inside compose");
	return	s.toString().toUpperCase();}).andThen(a->{
		System.out.println("amd then");
		return a+"function";});
	
	System.out.println(andThen.apply("sadh"));
	
	
	
	 
		 
		 
		 
		 
		
		
		
		
		
		
		
		
		
	}

}
