import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ListToMapJAva8 {
	
	public static void main(String[] args) {
		
		
		  // create a list
        List<Student> lt = new ArrayList<Student>();
  
        // add the member of list
        lt.add(new Student(1, "Geeks"));
        lt.add(new Student(2, "For"));
        lt.add(new Student(3, "science"));
        lt.add(new Student(4, "mango"));
        
        
       Map<Integer, Student> collect = lt.stream().collect(Collectors.toMap(Student::getId, Function.identity()));
		System.out.println(collect);
		
		
	LinkedHashMap<Integer, Student> collect2 = collect.entrySet().stream().
		 sorted((e1, e2) -> e1.getValue().getName().compareTo(e2.getValue().getName())).
		 collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
		
		System.out.println(collect2);
	
	}

}
