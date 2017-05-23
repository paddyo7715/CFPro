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
	private ImageIcon imgFolder;
	private ImageIcon imgMSGError;
	private ImageIcon imgMSGWarning;
	private ImageIcon imgMSGQuestion;
	private ImageIcon imgMSGInfo;
	
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
		imgFolder = new ImageIcon(CFGApplication.curDir + "/images/folder-yellow_T.png"); 
		
		imgMSGError = new ImageIcon(CFGApplication.curDir + "/images/error.png"); 
		imgMSGWarning = new ImageIcon(CFGApplication.curDir + "/images/warning.png"); 
		imgMSGQuestion = new ImageIcon(CFGApplication.curDir + "/images/question.png"); 
		imgMSGInfo = new ImageIcon(CFGApplication.curDir + "/images/info.png"); 

		
	}
	

	public ImageIcon getImgMSGError() {
		return imgMSGError;
	}


	public ImageIcon getImgMSGWarning() {
		return imgMSGWarning;
	}


	public ImageIcon getImgMSGQuestion() {
		return imgMSGQuestion;
	}


	public ImageIcon getImgMSGInfo() {
		return imgMSGInfo;
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


	public ImageIcon getImgFolder() {
		return imgFolder;
	}



}
