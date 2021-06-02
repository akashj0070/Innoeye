import java.util.*;

public class practice {
	
	public static void main(String ars[])
	{
		String s="This is a good boy he went to school for study he is more"
				+ " smart than other so he is more intelligent";
		
		
		Set<String> set=new HashSet<>();
		Map<String, Integer> m=new HashMap<>();
		ArrayList<String> al=new ArrayList<>();
		
		
		String arr[];
		//s.replaceAll(".", " ");
		//System.out.println(s);
		arr=s.split(" ");
		//System.out.println(s);
		
		/*
		String count[]=s.split(" ");
		for(int i=0;i<arr.length;i++)
		{   
			if(count==arr[i])
			m.put(arr[i],count[arr[i]++);
		}*/
		
		for(String a:arr) {
			al.add(a);
		}
		
		
		for(int i=0;i<arr.length;i++)
		{  int count=0;
			//System.out.println(arr[i]);
				set.add(arr[i]);
				for(int j=0;j<arr.length;j++)
				{
					if(arr[i].equals(arr[j]))
					{
						count++;
						//System.out.println(arr[i]+arr[j]+count);
					}					
				}
				
				if(!(m.containsKey(arr[i])))
				{
				//continue;	
					m.put(arr[i],count);
				}
				
				
				
				//Integer count2=count;
			}
		
		System.out.println( "Set is :" +set);
		 for(Map.Entry mm:m.entrySet()){  
			   System.out.println(mm.getKey()+" "+mm.getValue());  
			  }  

		System.out.println("ArrayList "+al);
		
	
		
	}



	}

