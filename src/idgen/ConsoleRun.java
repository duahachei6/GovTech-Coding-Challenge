package idgen;

import java.util.*;

public class ConsoleRun {

	public static void main(String[] args) 
	{
		ID idgen = new ID();
		Scanner sc = new Scanner(System.in);
		String name = "";
		
		do
		{
			System.out.println("Enter a name for a generated ID: ");
			name = sc.next();
			System.out.println(idgen.genIds(name));
		}	while (name != "" || name != null);
		
		sc.close();

	}

}
