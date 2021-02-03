package idgen;

import java.util.*;

/*
*@author Isaac Duah-Acheampong
*/

class ID 
{
	
	private final Map<String, List<String>> ids =  Collections.synchronizedMap(new HashMap<>());
	private String id;
	private static final int INCREMENT = 5;
	private static final String STARTINGNUM = "005";
	
	public ID()
	{
		this.id = null;
	}

	/*
	*@return String id
	 */
	public String getId()
	{
		return this.id;
	}

	public String getId(String firstThreeLetters, String num)
	{
		return firstThreeLetters + num;
	}
	
	@SuppressWarnings("rawtypes")
	public String genIds(String name)
	{

		String num = STARTINGNUM;
		String firstThreeLetters = firstThree(name);

		Set keySet = ids.keySet();
		
		
		//if(ids.isEmpty() == true)
		//{
			//num = "005";
			//ids.put(firstThreeLetters, new ArrayList<String>());
			//ids.get(firstThreeLetters).add(num);
			//id = firstThreeLetters + num;
			//return id;
		//}

		List<String> numbers;
		if (keySet.contains(firstThreeLetters))
		{
			numbers = ids.get(firstThreeLetters);
			num = String.valueOf(Integer.parseInt(numbers.get(numbers.size()-1)) + INCREMENT);
			num = addLeadingZero(num);
		}

		else if (!(keySet.contains(firstThreeLetters)) || ids.isEmpty())
		{
			ids.put(firstThreeLetters, new ArrayList<>());
		}
		
	
		//ids.put(firstThreeLetters, new ArrayList<String>());
		//ids.get(firstThreeLetters).add(num);
		//id = firstThreeLetters + num;

		ids.get(firstThreeLetters).add(num);
		id = getId(firstThreeLetters,num);
		return id;
	}
	
	private String firstThree(String name)
	{		
		return name.toUpperCase().substring(0, 3);
	}

	private String addLeadingZero(String number)
	{
		int maxZeros = 2;
		String resultNum;

		//numberLength -> Length of the String argument
		int numberLength = number.length();

		//amountOfZeros -> amount of zeros that will be printed
		int difference = maxZeros-numberLength;
		if(difference+1 <= 0)
		{
			resultNum = number;
		}

		else {
			String amountOfZeros = printZeros(difference);
			resultNum = amountOfZeros + number;
		}

		return resultNum;
	}
	
	
	private String printZeros(int count)
	{
		return "0".repeat(Math.max(0, count + 1));

		//for(int i = 0; i < count+1; i++)
		//{
		//	zeros.append("0") or zeros += "0";
		//}
	}
}
