package com.aptech.LoanProcessingSystem.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.aptech.LoanProcessingSystem.model.AccountModel;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.Desktop;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Provider;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.security.Security;
import java.util.Properties;
import java.util.Random;

import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class SendCode extends JDialog {

	int randomCode;

	private final JPanel contentPanel = new JPanel();
	private JTextField txtEmail;
	private JTextField txtCode;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		
		
		try {
			SendCode dialog = new SendCode();
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public SendCode() {
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent windowEvent) {
				cancelAction();
			}
		});
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(SendCode.class.getResource("/com/aptech/LoanProcessingSystem/images/bank (4).png")));
		setFont(new Font("Dialog", Font.BOLD, 14));
		setTitle("Send Email");
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

		JLabel lblNewLabel_4 = new JLabel("Enter Email");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_4.setBounds(163, 37, 81, 14);
		panel.add(lblNewLabel_4);

		txtEmail = new JTextField();
		txtEmail.setBounds(254, 34, 203, 20);
		panel.add(txtEmail);
		txtEmail.setColumns(10);

		JButton btnSend = new JButton("Send");
		btnSend.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					
					if(!new AccountModel().checkEmail(txtEmail.getText().trim())) {
						JOptionPane.showMessageDialog(null, "Email does not exist!");
						return;
					}
					Random rand = new Random();
					randomCode = rand.nextInt(999999);
					String host = "smtp.gmail.com";
					String user = "quickloansystem@gmail.com";
					String pass = "Abcd@1234";
					String to = txtEmail.getText();
					String subject = "Reseting Code";
					String message = "Your reset code is: " + randomCode;
					boolean sessionDebug = false;
					Properties pros = new Properties();
					pros.put("mail.smtp.starttls.enable", "true");
					pros.put("mail.smtp.host", host);
					pros.put("mail.smtp.port", "587");
					pros.put("mail.smtp.auth", "true");
					pros.put("mail.smtp.starttls.required", "true");
			
					Session mailSession = Session.getDefaultInstance(pros,  new Authenticator() {
						@Override
						protected PasswordAuthentication getPasswordAuthentication() {
							return new PasswordAuthentication(user, pass);
						}
					});
					mailSession.setDebug(sessionDebug);
					Message msg = new MimeMessage(mailSession);
					msg.setFrom(new InternetAddress(user));
					InternetAddress[] address = { new InternetAddress(to) };
					msg.setRecipients(Message.RecipientType.TO, address);
					msg.setSubject(subject);
					msg.setText(message);
					Transport transport = mailSession.getTransport("smtp");
					transport.connect(host, user, pass);
					transport.sendMessage(msg, msg.getAllRecipients());
					transport.close();
					JOptionPane.showMessageDialog(null, "Code has been send to the email");
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(rootPane, ex.getMessage());
				}
			}
		});
		
		
		btnSend.setBackground(new Color(224, 255, 255));
		btnSend.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnSend.setBounds(319, 72, 89, 23);
		panel.add(btnSend);

		JLabel lblNewLabel_5 = new JLabel("Verify Code");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_5.setBounds(163, 120, 81, 14);
		panel.add(lblNewLabel_5);

		txtCode = new JTextField();
		txtCode.setBounds(254, 117, 203, 20);
		panel.add(txtCode);
		txtCode.setColumns(10);

		JButton btnVerifyCode = new JButton("Verify Code");
		btnVerifyCode.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if (Integer.valueOf(txtCode.getText()) == randomCode) {
					ForgotPass forgotPass = new ForgotPass(txtEmail.getText());
					forgotPass.setVisible(true);
					SendCode.this.dispose();
				} else {
					JOptionPane.showMessageDialog(null, "Code do not match");
				}
			}
		});
		
		btnVerifyCode.setBackground(new Color(224, 255, 255));
		btnVerifyCode.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnVerifyCode.setBounds(319, 157, 89, 23);
		panel.add(btnVerifyCode);

		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setIcon(
				new ImageIcon(SendCode.class.getResource("/com/aptech/LoanProcessingSystem/images/secure.png")));
		lblNewLabel_6.setBounds(38, 145, 92, 64);
		contentPanel.add(lblNewLabel_6);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(Color.LIGHT_GRAY);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setIcon(new ImageIcon(
						SendCode.class.getResource("/com/aptech/LoanProcessingSystem/images/close (2).png")));
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

	private void cancelAction() {
		if (JOptionPane.showConfirmDialog(null, "Are you sure you want to cancel?", "Confirm",
				JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
			Login login = new Login();
			login.setVisible(true);
			this.dispose();
		}
	}
}
