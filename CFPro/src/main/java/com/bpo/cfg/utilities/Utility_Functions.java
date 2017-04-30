package com.bpo.cfg.utilities;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Vector;

import javax.swing.filechooser.FileSystemView;

public class Utility_Functions {
	
	public static boolean isFolder(String s) {
		boolean r = false;
	
		File d = new File(s);
		return d.isDirectory();
	
	}
	
	public static String[] getFilesandFolders(String d) {

		File dir = new File(d + "/");
		String[] files = dir.list();
		return files;
	}
	
	public static ArrayList<String> getalldrives() {
		
		ArrayList<String> r = new ArrayList<String>();
		File[] paths;
		FileSystemView fsv = FileSystemView.getFileSystemView();

		// returns pathnames for files and directory
		paths = File.listRoots();

		// for each pathname in pathname array
		for(File path:paths)
		{
		    // prints file and directory paths
		    r.add(path + " " + fsv.getSystemTypeDescription(path));
		}
		return r;
	}
	
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
