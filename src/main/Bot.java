package main;
import java.util.HashMap;
import java.util.Map;

public class Bot
{

	public static void main(String[] args)
	{
		System.out.println("Hello world");
		Map<Integer,String> will = new HashMap<>();
		will.put(12, "Will Win");
		System.out.println(will.get(12));
		System.out.println(will);
		Test howard = new Test();
		Test danny = new Test();
		howard.wade = 2;
		System.out.println(howard.wade);
		System.out.println(danny.wade);
		howard.ethan = 3;
		System.out.println(danny.ethan);
	}
}
