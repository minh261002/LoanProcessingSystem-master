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

public class About extends JDialog {

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
				About dialog = new About();
				dialog.setVisible(true);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public About() {

		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent windowEvent) {
				cancelAction();
			}
		});
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(About.class.getResource("/com/aptech/LoanProcessingSystem/images/bank (4).png")));
		setFont(new Font("Dialog", Font.BOLD, 14));
		setTitle("About");
		setBounds(100, 100, 782, 312);
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
		panel.setBounds(197, 23, 561, 208);
		contentPanel.add(panel);
		panel.setLayout(null);
		{
			JLabel lblNewLabel_4 = new JLabel(
					"\u201CQuickLoan\u201D is a company involved in providing loans to its customers.");
			lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 10));
			lblNewLabel_4.setBounds(22, 23, 529, 21);
			panel.add(lblNewLabel_4);
		}
		{
			JLabel lblNewLabel_5 = new JLabel("They have branches set up at different parts of the city.");
			lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 10));
			lblNewLabel_5.setBounds(22, 43, 291, 21);
			panel.add(lblNewLabel_5);
		}
		{
			JLabel lblNewLabel_6 = new JLabel(
					"They cater to different types of loans like the vehicle loan, house loan, personal loan and loan to");
			lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 10));
			lblNewLabel_6.setBounds(22, 67, 446, 14);
			panel.add(lblNewLabel_6);
		}
		{
			JLabel lblNewLabel_7 = new JLabel("students higher studies.");
			lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 10));
			lblNewLabel_7.setBounds(22, 86, 130, 14);
			panel.add(lblNewLabel_7);
		}
		{
			JButton btnNewButton = new JButton("Installation Details");
			btnNewButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					String url = "https://www.homecredit.vn";

					if (Desktop.isDesktopSupported()) {
						Desktop desktop = Desktop.getDesktop();
						try {
							desktop.browse(new URI(url));
						} catch (IOException | URISyntaxException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					} else {
						Runtime runtime = Runtime.getRuntime();
						try {
							runtime.exec("xdg-open " + url);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}

				}
			});
			btnNewButton.setForeground(Color.WHITE);
			btnNewButton.setBackground(new Color(64, 64, 64));
			btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 10));
			btnNewButton.setBounds(25, 174, 130, 23);
			panel.add(btnNewButton);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(Color.LIGHT_GRAY);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("Close");
				cancelButton.setIcon(new ImageIcon(
						About.class.getResource("/com/aptech/LoanProcessingSystem/images/close (2).png")));
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						cancelAction();
					}
				});
				cancelButton.setBackground(Color.GRAY);
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	protected void cancelAction() {
			this.dispose();
	}
}
