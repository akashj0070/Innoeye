import java.util.*;
public class MapImplementation 
{

	public static void main(String[] args) 
	{
		HashMap<Integer,String> hashmap=new HashMap<>();
		LinkedHashMap<Integer,String> lhm=new LinkedHashMap<>();
		TreeMap<Integer, String> treemap=new TreeMap<Integer, String>();
		SortedMap<Integer,String> sortedmap=new TreeMap<Integer,String>();
		
		
		for(int temporary=0;temporary<20;temporary++)
		{
			hashmap.put(temporary+1,"value"+temporary);
			lhm.put(temporary+1,"value"+temporary);
//			treemap.put(temporary+1,"value"+temporary);
		}
		hashmap.remove(4);
		
		
		lhm.remove(3);
		sortedmap.putAll(lhm);
		System.out.println("Sorted map values"+sortedmap.entrySet());
		System.out.println("Entries in linked hash map are \n"+lhm.entrySet());
		System.out.println("Keys in LinkedHashMap are "+lhm.keySet());
		System.out.println("Values in LinkedHashMap are "+lhm.values());
		
		treemap.putAll(hashmap);
		treemap.remove(5);
		treemap.replace(13,"Akash");
		System.out.println(treemap.descendingMap());
		System.out.println(treemap.tailMap(16,true));
		System.out.println(treemap.headMap(5,true));
		System.out.println(treemap.subMap(4, true,14,false));
		System.out.println(treemap.entrySet());
		System.out.println(treemap.get(13));
		System.out.println(treemap.size());
//		for (Map.Entry m:hashmap.entrySet())
//		{
//			System.out.println(m.getKey()+" "+m.getValue());
//		}
	}	
}
