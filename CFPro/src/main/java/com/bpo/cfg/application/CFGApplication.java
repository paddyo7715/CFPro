package com.bpo.cfg.application;

import javax.swing.JFrame;
import com.bpo.cfp.gui.cfpJFrame;
import com.bpo.cfg.resources.appImages;
import com.bpo.cfg.resources.appSounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;

@Component
public class CFGApplication {

	public static String curDir;
	
//	private cfpJFrame f;
	
	@Autowired
	private appSounds sp;
	@Autowired
	private appImages ai;

	public appImages getAi() {
		return ai;
	}
//	public cfpJFrame getF() {
//		return f;
//	}
	public appSounds getSp() {
		return sp;
	}
	public CFGApplication() throws Exception
	{
//		this.f = f;
		curDir = System.getProperty("user.dir");
		
//		sp = new appSounds();
//		ai = new appImages();

	}

	
}
