package com.aptech.LoanProcessingSystem.view.admin;

import javax.swing.JPanel;

import com.aptech.LoanProcessingSystem.entities.Account;

import javax.swing.BoxLayout;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.border.EmptyBorder;

public class jpanelHomePage extends JPanel {
	private Account account = new Account();
	private JLabel lblHello;
	/**
	 * Create the panel.
	 */
	public jpanelHomePage() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JPanel jpanelHomeTop = new JPanel();
		jpanelHomeTop.setBackground(new Color(21, 25, 28));
		add(jpanelHomeTop);
		FlowLayout fl_jpanelHomeTop = new FlowLayout(FlowLayout.LEFT, 5, 5);
		jpanelHomeTop.setLayout(fl_jpanelHomeTop);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(jpanelHomePage.class.getResource("/com/aptech/LoanProcessingSystem/images/icons8_home_20px_3.png")));
		jpanelHomeTop.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("Loan Processing System");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblNewLabel.setForeground(SystemColor.text);
		jpanelHomeTop.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(100, 100));
		panel.setBackground(new Color(34, 40, 44));
		panel_1.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new EmptyBorder(0, 30, 0, 0));
		FlowLayout flowLayout = (FlowLayout) panel_2.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panel_2.setBackground(new Color(34,40,44));
		panel.add(panel_2);
		
		lblHello = new JLabel("Hello");
		lblHello.setFont(new Font("Roboto", Font.PLAIN, 30));
		lblHello.setForeground(new Color(192, 192, 192));
		panel_2.add(lblHello);
		
		
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(34, 40, 44));
		panel.add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));

	}
	public jpanelHomePage(Account account) {
		this();
		this.account = account;
		loadData();
	}
	
	public void loadData() {
		lblHello.setText("Hello " + this.account.getName());
	}
}
