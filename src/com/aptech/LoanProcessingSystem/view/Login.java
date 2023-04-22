package com.aptech.LoanProcessingSystem.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.regex.Pattern;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.aptech.LoanProcessingSystem.entities.Account;
import com.aptech.LoanProcessingSystem.model.AccountModel;
import com.aptech.LoanProcessingSystem.service.ShareData;
import com.aptech.LoanProcessingSystem.view.admin.Admin;

@SuppressWarnings("serial")
public class Login extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtUsername;
	private JPasswordField txtPassword;
	private JLabel txtMessage = new JLabel("");
	private String hintUserName = "Enter your email";
	private String hintPassword = "Enter your password";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Login dialog = new Login();
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Login() {
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent windowEvent) {
				closeAction();
			}
		});
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(Login.class.getResource("/com/aptech/LoanProcessingSystem/images/bank (4).png")));
		setFont(new Font("Dialog", Font.BOLD, 12));

		setTitle("Login");
		setBounds(100, 100, 688, 357);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(224, 255, 255));
		contentPanel.setBorder(new EmptyBorder(0, 0, 0, 0));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		setLocationRelativeTo(null);
		panel.setBackground(Color.DARK_GRAY);
		contentPanel.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.GRAY);
		panel_1.setBounds(212, 25, 442, 233);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel = new JLabel("Usename");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(66, 37, 82, 20);
		panel_1.add(lblNewLabel);

		txtUsername = new JTextField();
		txtUsername.setBorder(new EmptyBorder(0, 5, 0, 5));
		txtUsername.setFont(new Font("Tahoma", Font.ITALIC, 11));
		setTextHint(txtUsername, hintUserName);

		txtUsername.setBounds(158, 34, 263, 30);
		panel_1.add(txtUsername);
		txtUsername.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(66, 95, 71, 16);
		panel_1.add(lblNewLabel_1);

		txtPassword = new JPasswordField();
		txtPassword.setBorder(new EmptyBorder(0, 5, 0, 5));
		txtPassword.setFont(new Font("Tahoma", Font.ITALIC, 11));
		setTextHint(txtPassword, hintPassword);
		txtPassword.setBounds(158, 90, 263, 30);
		panel_1.add(txtPassword);

		JButton btnLogin = new JButton("Login");
		btnLogin.setPreferredSize(new Dimension(120, 30));
		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				loginAction();
			}
		});

		btnLogin.setIcon(new ImageIcon(Login.class.getResource("/com/aptech/LoanProcessingSystem/images/enter.png")));
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnLogin.setBounds(158, 151, 263, 30);
		panel_1.add(btnLogin);

		txtMessage.setFont(new Font("Tahoma", Font.ITALIC, 10));
		txtMessage.setForeground(new Color(255, 0, 0));
		txtMessage.setBounds(158, 129, 263, 20);
		panel_1.add(txtMessage);

		JLabel txtForgotPass = new JLabel("Forgot Password ?");
		txtForgotPass.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				SendCode send_Code = new SendCode();
				send_Code.setVisible(true);
				Login.this.dispose();
			}
		});
		txtForgotPass.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				txtForgotPass.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
		});
		txtForgotPass.setForeground(Color.BLUE);
		txtForgotPass.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		txtForgotPass.setBounds(238, 198, 122, 20);
		panel_1.add(txtForgotPass);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(
				new ImageIcon(Login.class.getResource("/com/aptech/LoanProcessingSystem/images/bank (1).png")));
		lblNewLabel_2.setBounds(35, 25, 161, 227);
		panel.add(lblNewLabel_2);

		JPanel buttonPane = new JPanel();
		buttonPane.setBackground(Color.LIGHT_GRAY);
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);

		JButton cancelButton = new JButton("Close");
		buttonPane.add(cancelButton);
		cancelButton.setPreferredSize(new Dimension(120, 30));
		cancelButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				closeAction();
			}
		});
		cancelButton.setIcon(
				new ImageIcon(Login.class.getResource("/com/aptech/LoanProcessingSystem/images/close (2).png")));
		cancelButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		cancelButton.setActionCommand("Cancel");
		initForm();
	}

	protected void loginAction() {
		AccountModel accountModel = new AccountModel();
		Account account;
		String username = txtUsername.getText().trim();

		String password = new String(txtPassword.getPassword());

		if (txtUsername.getText().equals(hintUserName)
				|| (new String(txtPassword.getPassword())).equals(hintPassword)) {
			txtMessage.setText("Please enter full information");
		} else if (!(Pattern.matches("^[a-zA-Z0-9]+(.+)+[@]{1}+(.+)+[.]{1}+[a-zA-Z0-9]+$", txtUsername.getText()))) {
			txtMessage.setText("Please enter a valid email");
		} else if ((account = accountModel.login(username, password)) != null) {
			JOptionPane.showMessageDialog(null, "Login Successful");
			ShareData.accountLogin = account;
			if (account.getAuthId() == 2) {
				Admin admin = new Admin();
				admin.setVisible(true);
			} else {
				Home home = new Home();
				home.setVisible(true);
			}
			this.dispose();
		} else {
			txtMessage.setText("Incorrect username or password");
		}
	}

	private void closeAction() {
		if (JOptionPane.showConfirmDialog(null, "Are you sure you want to close Application ?", "Confirm",
				JOptionPane.YES_NO_OPTION) == 0) {
			this.dispose();
		}
	}

	protected void initForm() {
		txtUsername.setText(hintUserName);
		txtUsername.setForeground(Color.GRAY);
		txtPassword.setText(hintPassword);
		txtUsername.setForeground(Color.GRAY);
		txtPassword.setEchoChar((char) 0);
	}

	private void setTextHint(JTextField textField, String hint) {
		textField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (textField.getText().equals(hint)) {
					textField.setText("");
					textField.setFont(new Font("Tahoma", Font.PLAIN, 10));
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
					textField.setFont(new Font("Tahoma", Font.ITALIC, 10));
					textField.setForeground(Color.GRAY);
					if (textField instanceof JPasswordField) {
						((JPasswordField) textField).setEchoChar((char) 0);
					}
				}
			}
		});
	}
}
