package com.bpo.cfg.resources;


import java.io.FileInputStream;

import java.io.InputStream;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import org.springframework.stereotype.*;

import java.io.*;

@Component
public class appSounds 
{
	
	private File sndfmouseoverbtn;
		
	public File getSndfmouseoverbtn() {
		return sndfmouseoverbtn;
	}

	public appSounds() throws Exception
	{
		String sndmenumouseover = "sounds/sndbtnmouseover.wav";
		sndfmouseoverbtn = new File(sndmenumouseover);
		if ( sndfmouseoverbtn.exists() == false)
			throw new Exception("Error unable to load menu mouseover sound");	
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
