package com.bpo.cfp.gui;

import javax.swing.JDialog;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import com.bpo.cfg.constants.appConstants;


public class customerMSQBox extends JDialog  {


    private JLabel lImage;
    private JLabel lMessage;
    private JButton btnOK;

	
	public customerMSQBox(Frame parent, String msq, )
	{
	    super(parent, "Create Password", true);

	    JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(appConstants.MINIPANERADIOBGCOLOR);
	    GridBagConstraints cs = new GridBagConstraints();
	 
	    cs.fill = GridBagConstraints.HORIZONTAL;
	    cs.insets = new Insets(5, 15, 5, 15);
	    cs.gridx = 0;
	    cs.gridy = 0;	 
	    cs.gridwidth = 3;
	    panel.add(new JLabel("  "), cs);	    
	    cs.gridwidth = 1;
	    
	    lfirstPW = new JLabel("New Password: ");
	    lfirstPW.setForeground(appConstants.MINILABELFG);
	    cs.gridx = 0;
	    cs.gridy++;
	    cs.gridwidth = 1;
	    panel.add(lfirstPW, cs);
	 
	    pfirstPW = new JPasswordField(12);
	    cs.gridx = 1;
	    cs.gridwidth = 2;
	    panel.add(pfirstPW, cs);
	 
	    lsecondPW = new JLabel("Reendter Password: ");
	    lsecondPW.setForeground(appConstants.MINILABELFG);
	    cs.gridx = 0;
	    cs.gridy++;
	    cs.gridwidth = 1;
	    panel.add(lsecondPW, cs);
	 
	    pSecondPW = new JPasswordField(12);
	    cs.gridx = 1;
	    cs.gridwidth = 2;
	    panel.add(pSecondPW, cs);

	    lerrorMessage = new JLabel("      ");
	    lerrorMessage.setForeground(appConstants.ALERTCOLOR);
	    cs.gridx = 0;
	    cs.gridy++;
	    cs.gridwidth = 3;
	    panel.add(lerrorMessage, cs);
	    cs.gridwidth = 1;
//	    getRootPane().setBorder( BorderFactory.createLineBorder(appConstants.DIALOGBORDERCOLOR) );
	    getRootPane().setBorder( BorderFactory.createRaisedBevelBorder());

	    btnSave = new JButton("Save");
	    btnSave.setBackground(appConstants.MAINBGCOLOR);
	    btnSave.setForeground(appConstants.NORMALBTNFOREGROUNDCOLOR);

	 
	    btnSave.addActionListener(new ActionListener() {
	    	@Override
	    	public void actionPerformed(ActionEvent arg0) {
	    		password = null;
	    		errormsg = null;
	    		String p2 = null;
	    		String p1 = null;
	    		if (pfirstPW.getPassword().length == 0) {
	    			errormsg = "Please enter a password";
	    		} else if (pfirstPW.getPassword().length < appConstants.MINPASSWORDLENGTH ||
						pfirstPW.getPassword().length > appConstants.MAXPASSWORDLENGTH) {
	    			errormsg = "Password must be between " + appConstants.MINPASSWORDLENGTH + " and " + appConstants.MAXPASSWORDLENGTH + " characters.";
				} else if (pSecondPW.getPassword().length == 0) {
					errormsg = "You must reenter the password.";
				} else {
					p1 = new String(pfirstPW.getPassword());
					p2 = new String(pSecondPW.getPassword());
					
					if (!p1.equals(p2)) {
						errormsg = "The two passwords must be equal.";
					} 
					

				}
				if (errormsg != null) {
					lerrorMessage.setText(errormsg);
				} else {
					 password = p1;
	                 dispose();
				}
	    	}
	    });
	    
        btnCancel = new JButton("Cancel");
        btnCancel.setBackground(appConstants.MAINBGCOLOR);
        btnCancel.setForeground(appConstants.NORMALBTNFOREGROUNDCOLOR);
        btnCancel.addActionListener(new ActionListener() {
	   	@Override
        public void actionPerformed(ActionEvent e) {
               dispose();
        }
        });
        
        JPanel bp = new JPanel();
        
        bp.add(btnCancel);
        bp.add(btnSave);

        bp.setBackground(appConstants.MINIPANERADIOBGCOLOR);
        getContentPane().add(panel, BorderLayout.CENTER);
        getContentPane().add(bp, BorderLayout.PAGE_END);
	    setUndecorated(true); 
        pack();
        setResizable(false);
        
        setLocationRelativeTo(parent);
	    setLocation(xloc, yloc);


		}

		public String getPassword() {
			return password;
		}

		public String getErrormsg() {
			return errormsg;
		}

	
}
