package com.aptech.LoanProcessingSystem.service;


import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JLabel;

public class ClockThread extends Thread {
	private JLabel clock;

	public ClockThread(JLabel jLabel) {
		this.clock = jLabel;
	}
	
	  public void run() {
	        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss aa");
	        
	        while(true){
	        	 java.util.Date now = new java.util.Date();
	            String st = sdf.format(now);
	            
	           clock.setText(st);
	           
	            try {
	                Thread.sleep(1000);
	            } catch (InterruptedException ex) {
	                Logger.getLogger(ClockThread.class.getName()).log(Level.SEVERE, null, ex);
	            }
	        }
	    }
}
