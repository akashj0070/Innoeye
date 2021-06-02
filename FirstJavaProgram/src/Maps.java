import java.util.*;
import java.util.Map.Entry;

public class Maps {
	
	public static void main(String args[])
	{
		Map<Integer, String> m=new HashMap<>();
		
		m.put(1,"one");
		m.put(2,"Two");
		m.put(5,"Six");
		System.out.println(m);
		
		Map<Integer, String> m2=new HashMap<>();
		 
		m2.put(3,"Three");
		m2.put(4,"Four");
		m2.putAll(m);
		
		m2.putIfAbsent(4, "Five");
		
		System.out.println(m2.get(3));
		System.out.println(m2.containsKey(5));
		
		m2.replace(5,"Six","Five");
		
		System.out.println(m2);
		
		System.out.println(m2.keySet());
		System.out.println(m2.values());
		System.out.println(m2.entrySet());
		
		for(Entry<Integer, String> entry:m2.entrySet())
		{
			System.out.println(entry.getKey()+" "+entry.getValue());
		}
		
		
	}

}
