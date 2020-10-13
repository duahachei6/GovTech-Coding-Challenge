package idgen;

class Test {

	public static void main(String[] args) 
	{
		String person1 = "Jen";
		String person2 = "Kara";
		String person3 = "Jennifer";
		String person4 = "Kar";
		String person5 = "Joseph";
		
		
		
		ID idGen = new ID();
		
		try {
			System.out.println(idGen.genIds(person1));
			System.out.println(idGen.genIds(person2));
			System.out.println(idGen.genIds(person3));
			System.out.println(idGen.genIds(person4));
			System.out.println(idGen.genIds(person5));
			System.out.println(idGen.genIds(person3));
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

}
