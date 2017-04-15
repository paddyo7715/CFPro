package com.bpo.cfg.utilities;

import java.util.Collections;
import java.util.Vector;

public class Utility_Functions {
	
	public static void ShuffleSpecificElements(Vector v,int bindex, int eindex) 
	{
		String Func = "ShuffleSpecificElements";
		
		Vector n = new Vector();
		
		for (int i=bindex; i<= eindex; i++)
		{
			n.add(v.get(i));
		}
		
		Collections.shuffle(n);
		
		int z = 0;
		for (int i=bindex; i<= eindex; i++)
		{
			v.set(i, n.get(z++));
		}
		

	}

	public static void main(String[] args) {
		
		Vector v = new Vector();
		v.add("0");
		v.add("1");
		v.add("2");
		v.add("3");
		v.add("4");
		v.add("5");
		v.add("6");
		v.add("7");
		v.add("8");
		v.add("9");
		
	
		System.out.println("Before shuffling, Vector contains : " + v);
		
		try {
			Utility_Functions.ShuffleSpecificElements(v, 5, 9);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 System.out.println("After shuffling, Vector contains : " + v);

	}

}
