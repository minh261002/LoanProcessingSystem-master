package com.aptech.LoanProcessingSystem.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.aptech.LoanProcessingSystem.service.ShareData;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.Desktop;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class Help extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		try {
			if (ShareData.accountLogin == null) {
				Login login = new Login();
				login.setVisible(true);
			} else {
				Help dialog = new Help();
				dialog.setVisible(true);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Help() {

		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent windowEvent) {
				cancelAction();
			}
		});
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(Help.class.getResource("/com/aptech/LoanProcessingSystem/images/bank (4).png")));
		setFont(new Font("Dialog", Font.BOLD, 14));
		setTitle("Help");
		setBounds(100, 100, 976, 368);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(105, 105, 105));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Loan Processing System");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(10, 11, 240, 30);
		contentPanel.add(lblNewLabel);
		setLocationRelativeTo(null);
		{
			JLabel lblNewLabel_1 = new JLabel("Version: 4.10.0.RELEASE");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
			lblNewLabel_1.setForeground(Color.WHITE);
			lblNewLabel_1.setBounds(10, 52, 156, 22);
			contentPanel.add(lblNewLabel_1);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("Build Id: 202103111225");
			lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 10));
			lblNewLabel_2.setForeground(Color.WHITE);
			lblNewLabel_2.setBounds(10, 73, 135, 14);
			contentPanel.add(lblNewLabel_2);
		}
		{
			JLabel lblNewLabel_3 = new JLabel("Copyright (c) 2007 - 2021 Aptech, VN");
			lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 10));
			lblNewLabel_3.setForeground(Color.WHITE);
			lblNewLabel_3.setBounds(10, 103, 197, 14);
			contentPanel.add(lblNewLabel_3);
		}

		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(197, 23, 755, 245);
		contentPanel.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_4 = new JLabel("Using the help system");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_4.setBounds(181, 11, 174, 26);
		panel.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("Browse topics in the Contents frame (Contents icon) onthe left. ");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.ITALIC, 10));
		lblNewLabel_5.setBounds(41, 43, 304, 14);
		panel.add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel(
				"Use the Back and Forward buttons to navigate within the history of viewed topics. ");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.ITALIC, 10));
		lblNewLabel_6.setBounds(41, 68, 466, 14);
		panel.add(lblNewLabel_6);

		JLabel lblNewLabel_7 = new JLabel("Searching");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_7.setBounds(41, 93, 75, 14);
		panel.add(lblNewLabel_7);

		JLabel lblNewLabel_8 = new JLabel(
				"To quickly locate topics on a particular subject in the documentation, enter aquery in the Search field. Use the Search frame (Search icon)to display the ...");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.ITALIC, 10));
		lblNewLabel_8.setBounds(37, 118, 708, 14);
		panel.add(lblNewLabel_8);

		JLabel lblNewLabel_9 = new JLabel("Keyword Index");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_9.setBounds(41, 155, 87, 14);
		panel.add(lblNewLabel_9);

		JLabel lblNewLabel_10 = new JLabel(
				"To show an alphabetically sorted index of keywords select the Index Frame (Index icon)");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.ITALIC, 10));
		lblNewLabel_10.setBounds(39, 180, 653, 14);
		panel.add(lblNewLabel_10);

		JLabel lblNewLabel_11 = new JLabel(" Not all products contain an index.");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.ITALIC, 10));
		lblNewLabel_11.setBounds(41, 205, 363, 14);
		panel.add(lblNewLabel_11);

		JPanel buttonPane = new JPanel();
		buttonPane.setBackground(Color.LIGHT_GRAY);
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);

		JButton cancelButton = new JButton("Close");
		cancelButton.setIcon(
				new ImageIcon(Help.class.getResource("/com/aptech/LoanProcessingSystem/images/close (2).png")));
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancelAction();
			}
		});
		cancelButton.setBackground(Color.GRAY);
		cancelButton.setActionCommand("Cancel");
		buttonPane.add(cancelButton);

	}

	protected void cancelAction() {
		this.dispose();
	}
}
