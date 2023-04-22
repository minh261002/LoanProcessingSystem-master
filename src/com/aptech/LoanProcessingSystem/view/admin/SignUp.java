package com.aptech.LoanProcessingSystem.view.admin;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Date;
import java.util.regex.Pattern;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import org.mindrot.jbcrypt.BCrypt;

import com.aptech.LoanProcessingSystem.entities.Account;
import com.aptech.LoanProcessingSystem.entities.Authority;
import com.aptech.LoanProcessingSystem.model.AccountModel;
import com.aptech.LoanProcessingSystem.model.AuthorityModel;
import com.aptech.LoanProcessingSystem.service.ShareData;
import com.aptech.LoanProcessingSystem.view.Login;
import com.toedter.calendar.JDateChooser;

public class SignUp extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JRadioButton rdbMale;
	private JRadioButton rdbFemale;
	private ButtonGroup bg;
	private JLabel lblNewLabel_2 = new JLabel("");
	private JTextField txtIdentity;
	private JTextField txtName;
	private JTextField txtEmail;
	private JPasswordField txtPassword;
	private JPasswordField txtConfirmPass;
	private JTextField txtPhone;
	private JDateChooser txtCalendar;
	private JTextField txtAdress;
	private JLabel lblPhone;
	private JLabel lblInden;
	private JLabel txtMessage;
	private String hintName = "Please enter your name";
	private String hintEmail = "Please enter your email";
	private String hintPassword = "Please enter your password";
	private String hintConfirmPass = "Please enter your confirm password";
	private String hintPhone = "Please enter your phone";
	private String hintAddress = "Please enter your address";
	private String hintIdentityCard = "Please enter your identity card";
	private boolean isValidPhone = false;
	private boolean isValidIden = false;
	private JComboBox<Authority> cbbxAuth;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		try {
			if (ShareData.accountLogin == null) {
				Login login = new Login();
				login.setVisible(true);
			} else {
				SignUp dialog = new SignUp();
				dialog.setVisible(true);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */

	public SignUp() {
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent windowEvent) {
				cancelAction();
			}
		});
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(SignUp.class.getResource("/com/aptech/LoanProcessingSystem/images/bank (4).png")));

		bg = new ButtonGroup();

		setFont(new Font("Dialog", Font.BOLD, 12));

		setTitle("Sign Up");
		setBounds(100, 100, 1057, 587);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(224, 255, 255));
		contentPanel.setBorder(new EmptyBorder(0, 0, 0, 0));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		contentPanel.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		setLocationRelativeTo(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.GRAY);
		panel_1.setBounds(190, 30, 824, 451);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel = new JLabel("Register Now");
		lblNewLabel.setIcon(
				new ImageIcon(SignUp.class.getResource("/com/aptech/LoanProcessingSystem/images/registered.png")));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 30));
		lblNewLabel.setBounds(294, 11, 271, 74);
		panel_1.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Full Name *");
		lblNewLabel_1.setBounds(10, 120, 76, 17);
		panel_1.add(lblNewLabel_1);

		txtName = new JTextField();
		txtName.setBorder(new EmptyBorder(0, 5, 0, 5));
		txtName.setBounds(129, 114, 230, 30);
		panel_1.add(txtName);
		txtName.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Email *");
		lblNewLabel_3.setBounds(10, 180, 76, 14);
		panel_1.add(lblNewLabel_3);

		txtEmail = new JTextField();

		txtEmail.setBorder(new EmptyBorder(0, 5, 0, 5));
		txtEmail.setBounds(129, 173, 230, 30);
		panel_1.add(txtEmail);
		txtEmail.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("Password *");
		lblNewLabel_4.setBounds(10, 236, 76, 14);
		panel_1.add(lblNewLabel_4);

		txtPassword = new JPasswordField();
		txtPassword.setBorder(new EmptyBorder(0, 5, 0, 5));
		txtPassword.setBounds(129, 229, 230, 30);
		panel_1.add(txtPassword);

		JLabel lblNewLabel_5 = new JLabel("Confirm Password *");
		lblNewLabel_5.setBounds(10, 288, 120, 14);
		panel_1.add(lblNewLabel_5);

		txtConfirmPass = new JPasswordField();
		txtConfirmPass.setBorder(new EmptyBorder(0, 5, 0, 5));
		txtConfirmPass.setBounds(129, 281, 230, 30);
		panel_1.add(txtConfirmPass);

		JLabel lblNewLabel_6 = new JLabel("Phone *");
		lblNewLabel_6.setBounds(404, 287, 76, 17);
		panel_1.add(lblNewLabel_6);

		cbbxAuth = new JComboBox<Authority>();
		cbbxAuth.setForeground(Color.GRAY);
		cbbxAuth.setBorder(null);
		cbbxAuth.setBackground(Color.WHITE);
		cbbxAuth.setBounds(516, 114, 230, 30);
		panel_1.add(cbbxAuth);

		JLabel lblNewLabel_7 = new JLabel("Gender *");
		lblNewLabel_7.setBounds(10, 340, 76, 14);
		panel_1.add(lblNewLabel_7);

		rdbMale = new JRadioButton("Male");
		rdbMale.setMargin(new Insets(0, 0, 0, 0));
		rdbMale.setAlignmentX(Component.CENTER_ALIGNMENT);
		rdbMale.setIconTextGap(6);
		rdbMale.setVerifyInputWhenFocusTarget(false);
		rdbMale.setFocusable(false);
		rdbMale.setRequestFocusEnabled(false);
		rdbMale.setRolloverEnabled(false);
		rdbMale.setFocusPainted(false);
		rdbMale.setContentAreaFilled(false);
		rdbMale.setBounds(125, 332, 76, 30);
		panel_1.add(rdbMale);
		bg.add(rdbMale);
		bg.add(rdbFemale);
		rdbMale.setSelected(true);

		rdbFemale = new JRadioButton("Female");
		rdbFemale.setMargin(new Insets(0, 0, 0, 0));
		rdbFemale.setAlignmentX(Component.CENTER_ALIGNMENT);
		rdbFemale.setIconTextGap(6);
		rdbFemale.setVerifyInputWhenFocusTarget(false);
		rdbFemale.setFocusable(false);
		rdbFemale.setRequestFocusEnabled(false);
		rdbFemale.setRolloverEnabled(false);
		rdbFemale.setFocusPainted(false);
		rdbFemale.setContentAreaFilled(false);
		rdbFemale.setBounds(234, 332, 76, 30);
		panel_1.add(rdbFemale);
		bg.add(rdbMale);
		bg.add(rdbFemale);
		rdbMale.setSelected(true);

		JLabel lblNewLabel_8 = new JLabel("Dob *");
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_8.setBounds(404, 339, 76, 14);
		panel_1.add(lblNewLabel_8);

		txtCalendar = new JDateChooser();
		txtCalendar.getCalendarButton().setFont(new Font("Tahoma", Font.ITALIC, 10));
		txtCalendar.setBounds(516, 332, 229, 30);
		panel_1.add(txtCalendar);

		JLabel lblNewLabel_9 = new JLabel("Address *");
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_9.setBounds(404, 180, 88, 14);
		panel_1.add(lblNewLabel_9);

		txtPhone = new JTextField();
		txtPhone.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {

				try {
					Integer.parseInt(txtPhone.getText());
					lblPhone.setText("");
					isValidPhone = true;
				} catch (Exception e1) {
					lblPhone.setText("Invalid number");
					isValidPhone = false;
				}
			}
		});
		txtPhone.setFont(new Font("Tahoma", Font.ITALIC, 10));
		txtPhone.setBorder(new EmptyBorder(0, 5, 0, 5));
		txtPhone.setColumns(10);
		txtPhone.setBounds(516, 281, 229, 30);
		panel_1.add(txtPhone);

		txtAdress = new JTextField();
		txtAdress.setFont(new Font("Tahoma", Font.ITALIC, 10));
		txtAdress.setBorder(new EmptyBorder(0, 5, 0, 5));
		txtAdress.setColumns(10);
		txtAdress.setBounds(516, 173, 229, 30);
		panel_1.add(txtAdress);

		JButton btnSignUp = new JButton("Sign Up");
		btnSignUp.setHorizontalAlignment(SwingConstants.LEFT);
		btnSignUp.setBackground(Color.LIGHT_GRAY);
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registerAction();
			}

		});
		btnSignUp.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSignUp.setForeground(Color.BLACK);
		btnSignUp.setIcon(
				new ImageIcon(SignUp.class.getResource("/com/aptech/LoanProcessingSystem/images/sign-up.png")));
		btnSignUp.setBounds(516, 396, 116, 33);
		panel_1.add(btnSignUp);

		JButton btnReset = new JButton("Reset");
		btnReset.setHorizontalAlignment(SwingConstants.LEFT);
		btnReset.setBackground(Color.LIGHT_GRAY);
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				initForm();
			}
		});
		btnReset.setForeground(Color.BLACK);
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnReset.setIcon(
				new ImageIcon(SignUp.class.getResource("/com/aptech/LoanProcessingSystem/images/rotation-lock.png")));
		btnReset.setBounds(653, 396, 99, 33);
		panel_1.add(btnReset);

		JLabel lblNewLabel_11 = new JLabel("Identity Card");
		lblNewLabel_11.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_11.setBounds(404, 236, 88, 14);
		panel_1.add(lblNewLabel_11);

		txtIdentity = new JTextField();
		txtIdentity.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {

				try {
					Integer.parseInt(txtIdentity.getText());
					isValidIden = true;
					lblInden.setText("");

				} catch (Exception e1) {
					isValidIden = false;
					lblInden.setText("Invalid number");

				}

			}
		});
		txtIdentity.setFont(new Font("Tahoma", Font.ITALIC, 10));
		txtIdentity.setBorder(new EmptyBorder(0, 5, 0, 5));
		txtIdentity.setBounds(516, 229, 229, 30);
		panel_1.add(txtIdentity);
		txtIdentity.setColumns(10);

		lblNewLabel_2.setIcon(
				new ImageIcon(SignUp.class.getResource("/com/aptech/LoanProcessingSystem/images/bank (1).png")));
		lblNewLabel_2.setBounds(28, 131, 161, 227);
		panel.add(lblNewLabel_2);

		JPanel buttonPane = new JPanel();
		buttonPane.setBackground(Color.LIGHT_GRAY);
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);

		JButton cancelButton = new JButton("Cancel");
		cancelButton.setPreferredSize(new Dimension(115, 33));
		cancelButton.setBackground(Color.GRAY);
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancelAction();
			}
		});
		cancelButton.setIcon(
				new ImageIcon(SignUp.class.getResource("/com/aptech/LoanProcessingSystem/images/close (2).png")));
		cancelButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		cancelButton.setActionCommand("Cancel");
		buttonPane.add(cancelButton);

		initForm();
		setTextHint(txtName, hintName);
		setTextHint(txtEmail, hintEmail);
		setTextHint(txtPassword, hintPassword);
		setTextHint(txtConfirmPass, hintConfirmPass);
		setTextHint(txtAdress, hintAddress);
		setTextHint(txtIdentity, hintIdentityCard);
		setTextHint(txtPhone, hintPhone);

		lblPhone = new JLabel("");
		lblPhone.setForeground(Color.RED);
		lblPhone.setFont(new Font("Tahoma", Font.ITALIC, 9));
		lblPhone.setBounds(516, 258, 229, 14);
		panel_1.add(lblPhone);

		lblInden = new JLabel("");
		lblInden.setForeground(Color.RED);
		lblInden.setFont(new Font("Tahoma", Font.ITALIC, 9));
		lblInden.setBounds(516, 204, 229, 14);
		panel_1.add(lblInden);

		txtMessage = new JLabel("");
		txtMessage.setForeground(Color.RED);
		txtMessage.setFont(new Font("Tahoma", Font.ITALIC, 10));
		txtMessage.setBounds(516, 372, 263, 20);
		panel_1.add(txtMessage);

		JLabel lblNewLabel_9_1 = new JLabel("Authority *");
		lblNewLabel_9_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_9_1.setBounds(404, 121, 88, 14);
		panel_1.add(lblNewLabel_9_1);
	}

	private void registerAction() {
		String name = txtName.getText();
		int authId = ((Authority) cbbxAuth.getSelectedItem()).getId();
		String email = txtEmail.getText();
		String password = new String(txtPassword.getPassword());
		String confirm_pass = new String(txtConfirmPass.getPassword());
		String phone = txtPhone.getText();
		String address = txtAdress.getText();
		String identityCard = txtIdentity.getText();
		Date dob = txtCalendar.getDate();

		if (!isValidIden || !isValidPhone) {

			txtMessage.setText("Phone or identitty card invalid!");

		} else if (!(Pattern.matches("^[a-zA-Z0-9]+(.+)+[@]{1}+(.+)+[.]{1}+[a-zA-Z0-9]+$", txtEmail.getText()))) {

			txtMessage.setText("Please enter a valid email!");

		} else if (name.trim().equals(hintName) || email.trim().equals(hintEmail)
				|| password.trim().equals(hintPassword) || confirm_pass.trim().equals(hintConfirmPass)
				|| phone.trim().equals(hintPhone) || address.trim().equals(hintAddress)
				|| identityCard.trim().equals(hintIdentityCard)) {

			txtMessage.setText("Please enter full information!");

		} else if (!password.equals(confirm_pass)) {

			txtMessage.setText("Password and Confirm Password must be same!");
			txtPassword.setText("");
			txtConfirmPass.setText("");

		} else if (dob == null) {

			txtMessage.setText("Please select Date of Birthday");
			txtCalendar.grabFocus();

		} else {

			try {

				Account account = new Account();
				account.setAuthId(authId);
				account.setName(name);
				account.setEmail(email);
				String hash = BCrypt.hashpw(password, BCrypt.gensalt());
				account.setPassword(hash);
				account.setPhone(phone);
				account.setAddress(address);
				account.setGender(rdbMale.isSelected());
				account.setDob(dob);
				account.setIdentityCard(identityCard);
				account.setAuthId(authId);
				AccountModel accountModel = new AccountModel();

				if (accountModel.create(account)) {
					JOptionPane.showMessageDialog(null, "Successful account registration!");
					this.dispose();
				} else {
					JOptionPane.showMessageDialog(null, "Please try again!");
				}
			} catch (Exception e2) {

				e2.printStackTrace();
				JOptionPane.showMessageDialog(null, "Please try again!");

			}
		}
	}

	protected void initForm() {
		txtName.setText(hintName);
		txtName.setFont(new Font("Tahoma", Font.ITALIC, 10));
		txtName.setForeground(Color.GRAY);
		txtEmail.setText(hintEmail);
		txtEmail.setFont(new Font("Tahoma", Font.ITALIC, 10));
		txtEmail.setForeground(Color.GRAY);
		txtPassword.setText(hintPassword);
		txtPassword.setFont(new Font("Tahoma", Font.ITALIC, 10));
		txtPassword.setForeground(Color.GRAY);
		txtPassword.setEchoChar((char) 0);
		txtConfirmPass.setText(hintConfirmPass);
		txtConfirmPass.setFont(new Font("Tahoma", Font.ITALIC, 10));
		txtConfirmPass.setForeground(Color.GRAY);
		txtConfirmPass.setEchoChar((char) 0);
		txtPhone.setText(hintPhone);
		txtPhone.setFont(new Font("Tahoma", Font.ITALIC, 10));
		txtPhone.setForeground(Color.GRAY);
		txtAdress.setText(hintAddress);
		txtAdress.setFont(new Font("Tahoma", Font.ITALIC, 10));
		txtAdress.setForeground(Color.GRAY);
		txtCalendar.setDate(new Date());
		txtIdentity.setText(hintIdentityCard);
		txtIdentity.setFont(new Font("Tahoma", Font.ITALIC, 10));
		txtIdentity.setForeground(Color.GRAY);
		rdbMale.setSelected(true);
		initAuth();

	}

	private class AuthorityCellRender extends DefaultListCellRenderer {

		@Override
		public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
				boolean cellHasFocus) {
			Authority authority = (Authority) value;
			return super.getListCellRendererComponent(list, authority.getName(), index, isSelected, cellHasFocus);
		}

	}

	private void initAuth() {
		DefaultComboBoxModel<Authority> authModel = new DefaultComboBoxModel<>();
		for (Authority auth : new AuthorityModel().getAll()) {
			authModel.addElement(auth);
		}
		cbbxAuth.setModel(authModel);
		cbbxAuth.setRenderer(new AuthListCellRenderer());
	}

	@SuppressWarnings("serial")
	private class AuthListCellRenderer extends DefaultListCellRenderer {
		@Override
		public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
				boolean cellHasFocus) {
			Authority auth = (Authority) value;
			return super.getListCellRendererComponent(list, auth.getName(), index, isSelected, cellHasFocus);
		}

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

	private void cancelAction() {
		if (JOptionPane.showConfirmDialog(null, "Are you sure you want to cancel?", "Confirm",
				JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
			this.dispose();
		}
	}
}
