package com.bpo.cfg.utilities;

import java.awt.image.BufferedImage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Vector;

import javax.imageio.IIOException;
import javax.imageio.ImageIO;
import javax.swing.filechooser.FileSystemView;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;
import com.cfp.exceptions.*;

public class Utility_Functions {
	
	public static boolean isFolder(String s) {
		boolean r = false;
	
		File d = new File(s);
		return d.isDirectory();
	
	}
	
	public static String[] getFilesandFolders(String d, ArrayList<String> fe) {

		File dir = new File(d);
		File[] files = dir.listFiles();
		Comparator comp = new Comparator() {
			  public int compare(Object o1, Object o2) {
			    File f1 = (File) o1;
			    File f2 = (File) o2;
			    if (f1.isDirectory() && !f2.isDirectory()) {
			      // Directory before non-directory
			      return -1;
			    } else if (!f1.isDirectory() && f2.isDirectory()) {
			      // Non-directory after directory
			      return 1;
			    } else {
			      // Alphabetic order otherwise
			      return ((File) o1).compareTo((File) o2);
			    }
			  }
			};
			Arrays.sort(files,comp);
			ArrayList<String> a = new ArrayList();
			a.add("..                                                                                ");
			for (int i = 0; i < files.length; i++) {
				if (!files[i].exists() || !files[i].isAbsolute() || files[i].isHidden() ) continue;
				if (files[i].isDirectory() && files[i].listFiles() == null) continue;
				int ei = files[i].toString().lastIndexOf(".");
				if (files[i].isFile() && (ei == -1  || !fe.contains(files[i].toString().substring(ei)))) continue;
				a.add(files[i].getName());
			}

			String[] b = a.toArray(new String[a.size()]);
			return b;
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
		    if (path.canRead() )
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
	
	public static String validateImageFile(String f, long maximgSize)
	{
		String err = null;
		
		try {
			File fle = new File(f);
			BufferedImage bi = ImageIO.read(fle);
			if (bi == null)
				throw new IllegalArgumentException();
			if (fle.length() > maximgSize)
				throw new imageFileTooLargeException();
				
				
			
		} 
		catch (FileNotFoundException e1)
		{
			err = "File not found";
		}
		catch (IOException e2)
		{
			err = "File not a proper image file";
		}
		catch (IllegalArgumentException e3)
		{
			err = "File is not a recognized image file.";
		}
		catch (imageFileTooLargeException e4)
		{
			err = "The file is too large.";
		}
		catch(Exception ex) 
		{
			err = "Unknown Error When Attempting to Read File.";
		}
		
		return err;
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
