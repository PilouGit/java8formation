package com.neuresys.formation.java8.lambda.simple;

public class Test1 {

	public static void main(String [] args)
	{
		NameParser parser = new NameParser();

		String res = parser.parse("Eric Clapton", new Creator() {
		    @Override
		    public String create(String firstName, String lastName) {
		        return firstName+lastName;
		    }
		});
		String res2 = parser.parse("Eric Clapton", (a,b)->{
			return a+b;
		});
		Factory factory = new Factory();
		String res3 = parser.parse("Eric Clapton", factory::createName);

		String res4 = parser.parse("Eric Clapton", Factory::createNameStatic);

	}
}

