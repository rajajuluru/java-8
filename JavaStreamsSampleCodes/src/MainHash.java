import java.util.HashMap;

import javax.management.ImmutableDescriptor;

public class MainHash {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer i=new Integer(1);
		HashingOfInteger h=new HashingOfInteger();
		h.setAge(i);
		
		System.out.println(h.getAge().hashCode());
		Integer i1=new Integer(1);	
      	h.setAge(i1);
		
		System.out.println(h.getAge().hashCode());
		
		String abc="abc";
		HashMap<String, Object> hashMap = new HashMap<>();
		hashMap.put(new String("abc"),1);
		hashMap.put("abc",1);
		System.out.println(new String("abc").hashCode());
		System.out.println("abc"+abc.hashCode());
		
	
		
		System.out.println(hashMap);
		
		
		HashMap<EmployeeClass, Object> emphash = new HashMap<>();
		emphash.put(new EmployeeClass("raja", 101, 222, 800000, "active"), "raja data");
		emphash.put(new EmployeeClass("raja", 101, 222, 800000, "active"), "raja data1");
		emphash.put(new EmployeeClass("rajajuluru", 102, 222, 800000, "inactive"), "raja data2");
		System.out.println(emphash);
		
		
		
		

	}

}
