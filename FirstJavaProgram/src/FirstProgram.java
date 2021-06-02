import java.util.*;
public class FirstProgram {
public static void main(String args[])
{
	Set<String> set1=new HashSet<>();
	set1.add("one");
	set1.add("Two");
	set1.add("Three");
	set1.add("Seven");
	set1.remove("Seven");
	
	
	Set<String> set2=new LinkedHashSet<>();
	set2.add("Five");
	set2.add("Three");
	set2.add("Two");
	set2.add("Seven");
	set2.add("Thirteen");
	
	System.out.println("Set2" + set2);
	
	
	Set<String> set3=new LinkedHashSet<>();
	set3.addAll(set2);
	set3.addAll(set1);
	System.out.println("Set3 "+set3);
	
	System.out.println("Size of set3 " +set3.size());
	
	System.out.println(set3.contains("Five"));
	
	System.out.println(set3.toArray());
	System.out.println(set3);
	
	
	
	set3.clear();
	System.out.println("Set3 "+set3);
	
	System.out.println(set3.isEmpty());
	
	
	set1.retainAll(set2);
	System.out.println(set1);
	
	set3.containsAll(set2);
	System.out.println("After contains All "+ set3.containsAll(set2));
	
	Set<Integer> ts=new TreeSet<>();
	ts.add(2);
	ts.add(1);
	ts.add(2);
	ts.add(7);
	ts.add(0);
	ts.add(13);
	
	System.out.println("Tree Set "+ts);
	
	
	/*for(String s:set1)
	{
		System.out.println(s);
	}*/
	
	/*
	Iterator<String> i=set1.iterator();
	while(i.hasNext())
	{
		System.out.println(i.next());
	}*/
	
	
}
}
