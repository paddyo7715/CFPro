package com.bpo.cfg.resources;

import javax.swing.ImageIcon;

import com.bpo.cfg.application.CFGApplication;
import org.springframework.stereotype.*;

@Component
public class appImages {
	
	private ImageIcon imgMainTitle;
	private ImageIcon imgMiniTitle;
	private ImageIcon imgMonitorBase;
	private ImageIcon imgdefaultImage;
	private ImageIcon imgNewLeague;
	private ImageIcon imgLoadLeague;
	private ImageIcon imgRemoteGame;
	private ImageIcon imgRemoteLeague;
	private ImageIcon imgExit;
	
	public appImages()
	{
		imgMainTitle = new ImageIcon( CFGApplication.curDir + "/images/imgMainTitle.png"); 
		imgMiniTitle = new ImageIcon( CFGApplication.curDir + "/images/minititle.png"); 
		imgMonitorBase = new ImageIcon( CFGApplication.curDir + "/images/monitorBase.png"); 

		imgdefaultImage = new ImageIcon( CFGApplication.curDir + "/images/maindefault.jpg"); 
		imgNewLeague = new ImageIcon( CFGApplication.curDir + "/images/NewLeague.png"); 
		imgLoadLeague = new ImageIcon(CFGApplication.curDir + "/images/loadleague.png"); 
		imgRemoteGame = new ImageIcon(CFGApplication.curDir + "/images/playremotegame.png"); 
		imgRemoteLeague = new ImageIcon(CFGApplication.curDir + "/images/remoteleagues.png"); 
		imgExit = new ImageIcon(CFGApplication.curDir + "/images/exit.png"); 
	}
	

	public ImageIcon getImgdefaultImage() {
		return imgdefaultImage;
	}

	public ImageIcon getImgNewLeague() {
		return imgNewLeague;
	}

	public ImageIcon getImgLoadLeague() {
		return imgLoadLeague;
	}

	public ImageIcon getImgRemoteGame() {
		return imgRemoteGame;
	}

	public ImageIcon getImgRemoteLeague() {
		return imgRemoteLeague;
	}

	public ImageIcon getImgMiniTitle() {
		return imgMiniTitle;
	}
	public ImageIcon getImgExit() {
		return imgExit;
	}

	public ImageIcon getImgMainTitle() {
		return imgMainTitle;
	}


	public ImageIcon getImgMonitorBase() {
		return imgMonitorBase;
	}



}
