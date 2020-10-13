package idgen;

import java.util.*;

class ID 
{
	
	private Map<String, List<String>> ids =  Collections.synchronizedMap(new HashMap<String, List<String>>());
	private String id;
	
	public ID()
	{
		String id = null;
		this.id = id;
	}
	
	public String genIds(String name)
	{

		String num = "005";
		String cutName = firstThree(name);
		
		
		if(ids.isEmpty() == true)
		{
			num = "005";
			ids.put(cutName, new ArrayList<String>());
			ids.get(cutName).add(num);
			id = cutName + num;
			return id;
		}
		
		Set keySet = ids.keySet();
		List<String> numbers = ids.get(cutName);
		
		if (keySet.contains(cutName))
		{
			num = String.valueOf(Integer.parseInt(numbers.get(numbers.size()-1)) + 5);
			num = addLeadingZero(num);
			numbers.add(num);
			id = cutName + num;
			return id;
		}
		
	
		ids.put(cutName, new ArrayList<String>());
		ids.get(cutName).add(num);
		id = cutName + num;
		return id;
	}
	
	private String firstThree(String name)
	{		
		return name.toUpperCase().substring(0, 3);
	}
	
	public String getId()
	{
		return id;
	}
	
	private String addLeadingZero(String number)
	{
		int leadingZeros = 3;
		int numberCount = number.length();
		String zeros = printZeros(3-numberCount);
		number = zeros + number;
		
		return number;
	}
	
	
	private String printZeros(int count)
	{

		String zeros = "";
		for(int i = 0; i < count; i++)
		{
			zeros += "0";
		}
		
		return zeros;
	}
}
