package com.aptech.LoanProcessingSystem.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import org.mindrot.jbcrypt.BCrypt;

import com.aptech.LoanProcessingSystem.entities.Account;
import com.aptech.LoanProcessingSystem.model.AccountModel;
import com.aptech.LoanProcessingSystem.service.ShareData;

@SuppressWarnings("serial")
public class ChangePass extends JDialog {

	Connection conn = null;
	ResultSet rs = null;
	PreparedStatement ps = null;
	private final JPanel contentPanel = new JPanel();
	private JPasswordField txtNewPass;
	private JPasswordField txtVerifyPass;
	private JPasswordField txtCurrentPass;
	private String hintCurrentPass = "Please enter your current password";
	private String hintNewPassword = "Please enter your new password";
	private String hintVerifyPass = "Please enter your confirm password";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		try {
			if (ShareData.accountLogin == null) {
				Login login = new Login();
				login.setVisible(true);
			} else {
				ChangePass dialog = new ChangePass();
				dialog.setVisible(true);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ChangePass() {
		addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent windowEvent) {
				cancelAction();
			}
		});
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(ChangePass.class.getResource("/com/aptech/LoanProcessingSystem/images/bank (4).png")));
		setFont(new Font("Dialog", Font.BOLD, 14));
		setTitle("Update Password ");
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

		JLabel lblNewLabel_1 = new JLabel("Version: 4.10.0.RELEASE");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(10, 52, 156, 22);
		contentPanel.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Build Id: 202103111225");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(10, 73, 135, 14);
		contentPanel.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Copyright (c) 2007 - 2021 Aptech, VN");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setBounds(10, 103, 197, 14);
		contentPanel.add(lblNewLabel_3);

		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(197, 23, 561, 208);
		contentPanel.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_4 = new JLabel("New Password");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_4.setBounds(155, 80, 89, 14);
		panel.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("Verify Password");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_5.setBounds(155, 120, 89, 14);
		panel.add(lblNewLabel_5);

		JButton btnUpdate = new JButton("Update");

		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updatePassAction();
			}
		});

		btnUpdate.setBackground(Color.GRAY);
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnUpdate.setBounds(254, 160, 89, 23);
		panel.add(btnUpdate);

		txtNewPass = new JPasswordField();
		txtNewPass.setFont(new Font("Tahoma", Font.ITALIC, 10));
		txtNewPass.setBounds(254, 77, 203, 20);
		panel.add(txtNewPass);

		txtVerifyPass = new JPasswordField();
		txtVerifyPass.setFont(new Font("Tahoma", Font.ITALIC, 10));
		txtVerifyPass.setBounds(254, 117, 203, 20);
		panel.add(txtVerifyPass);

		txtCurrentPass = new JPasswordField();
		txtCurrentPass.setFont(new Font("Tahoma", Font.ITALIC, 10));
		txtCurrentPass.setBounds(254, 38, 203, 20);
		panel.add(txtCurrentPass);

		JLabel lblNewLabel_4_1 = new JLabel("Current Pass");
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_4_1.setBounds(155, 41, 89, 14);
		panel.add(lblNewLabel_4_1);

		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);

		lblNewLabel_6.setIcon(
				new ImageIcon(ChangePass.class.getResource("/com/aptech/LoanProcessingSystem/images/secure.png")));
		lblNewLabel_6.setBounds(38, 145, 92, 64);
		contentPanel.add(lblNewLabel_6);

		JPanel buttonPane = new JPanel();
		buttonPane.setBackground(Color.LIGHT_GRAY);
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);

		JButton cancelButton = new JButton("Cancel");
		cancelButton.setIcon(
				new ImageIcon(ChangePass.class.getResource("/com/aptech/LoanProcessingSystem/images/close (2).png")));
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancelAction();
			}
		});
		cancelButton.setBackground(Color.GRAY);
		cancelButton.setActionCommand("Cancel");
		buttonPane.add(cancelButton);
		initTextField();
		setTextHint(txtCurrentPass, hintCurrentPass);
		setTextHint(txtNewPass, hintNewPassword);
		setTextHint(txtVerifyPass, hintVerifyPass);
	}

	private void updatePassAction() {
		Account account = ShareData.accountLogin;
		String currentPass = new String(txtCurrentPass.getPassword()).trim();
		String newPass = new String(txtNewPass.getPassword()).trim();
		String verifyPass = new String(txtVerifyPass.getPassword()).trim();
		if (currentPass.equals(hintCurrentPass) || newPass.equals(hintNewPassword)
				|| verifyPass.equals(hintVerifyPass)) {
			JOptionPane.showMessageDialog(null, "Please enter full information!");
		} else if (!BCrypt.checkpw(currentPass, account.getPassword())) {
			JOptionPane.showMessageDialog(null, "Invalid current password!");
		} else if (currentPass.equals(newPass)) {
			JOptionPane.showMessageDialog(null, "The new password cannot be the same as the current password!");
		} else if (!newPass.equals(verifyPass)) {
			JOptionPane.showMessageDialog(null, "Password not match!");
		} else {
			String hash = BCrypt.hashpw(newPass, BCrypt.gensalt());
			account.setPassword(hash);
			if (new AccountModel().changePass(account)) {
				JOptionPane.showMessageDialog(null, "Update successful!");
				this.dispose();
			} else {
				JOptionPane.showMessageDialog(null, "Update failed!");
			}
		}
	}

	private void cancelAction() {
		if (JOptionPane.showConfirmDialog(null, "Are you sure you want to cancel?", "Confirm",
				JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
			this.dispose();
		}
	}

	private void initTextField() {
		txtCurrentPass.setText(hintCurrentPass);
		txtCurrentPass.setForeground(Color.GRAY);
		txtCurrentPass.setEchoChar((char) 0);

		txtNewPass.setText(hintNewPassword);
		txtNewPass.setForeground(Color.GRAY);
		txtNewPass.setEchoChar((char) 0);

		txtVerifyPass.setText(hintVerifyPass);
		txtVerifyPass.setForeground(Color.GRAY);
		txtVerifyPass.setEchoChar((char) 0);
	}

	private void setTextHint(JTextField textField, String hint) {
		textField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (textField.getText().equals(hint)) {
					textField.setText("");
					if (textField instanceof JPasswordField) {
						((JPasswordField) textField).setEchoChar('*');
					}
					textField.setForeground(Color.DARK_GRAY);
				} else {
					textField.selectAll();
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (textField.getText().equals("")) {
					textField.setText(hint);
					txtVerifyPass.setForeground(Color.GRAY);
					if (textField instanceof JPasswordField) {
						((JPasswordField) textField).setEchoChar((char) 0);
					}
				}
			}
		});
	}
}
