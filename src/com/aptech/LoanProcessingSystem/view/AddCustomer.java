package com.aptech.LoanProcessingSystem.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Insets;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Pattern;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.aptech.LoanProcessingSystem.entities.Customer;
import com.aptech.LoanProcessingSystem.model.CustomerModel;
import com.aptech.LoanProcessingSystem.service.Common;
import com.aptech.LoanProcessingSystem.service.ShareData;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;

@SuppressWarnings("serial")
public class AddCustomer extends JDialog {

	private ButtonGroup bg;
	private Customer customer = new Customer();

	private final JPanel contentPanel = new JPanel();
	private JTextField txtName;
	private JTextField txtAddress;
	private JTextField txtEmail;
	private JTextField txtPhone;
	private JTextField txtSalary;
	private JTextField txtJob;
	private JTextField txtCompany;
	private JTextField txtIdentity;
	private JDateChooser txtDob;
	private JRadioButton rdbMale;
	private JRadioButton rdbFemale;
	private String hintName = "Please enter customer name";
	private String hintEmail = "Please enter customer email";
	private String hintAddress = "Please enter customer address";
	private String hintCompany = "Please enter customer company";
	private String hintIdentity = "Please enter customer identity";
	private String hintPhone = "Please enter customer phone";
	private String hintSalary = "Please enter customer salary";
	private String hintJob = "Please enter customer job";
	private boolean isUpdate = false;
	private String name;
	private String email;
	private String address;
	private String phone;
	private String company;
	private String job;
	private double salary;
	private String identity_card;
	private Date dob;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		try {
			if (ShareData.accountLogin == null) {
				Login login = new Login();
				login.setVisible(true);
			} else {
				AddCustomer dialog = new AddCustomer();
				dialog.setVisible(true);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public AddCustomer(int customerId) {
		this();
		isUpdate = true;
		this.customer = new CustomerModel().findById(customerId);
		initForm();
	}

	/**
	 * Create the dialog.
	 */
	public AddCustomer() {
		setMinimumSize(new Dimension(1200, 580));
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent windowEvent) {
				cancelAction();
			}
		});
		bg = new ButtonGroup();
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(AddCustomer.class.getResource("/com/aptech/LoanProcessingSystem/images/bank (4).png")));
		setFont(new Font("Dialog", Font.BOLD, 14));
		setTitle("New Customer");
		setBounds(100, 100, 1054, 576);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(105, 105, 105));
		contentPanel.setBorder(new EmptyBorder(50, 20, 30, 20));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		setLocationRelativeTo(null);
		contentPanel.setLayout(new BorderLayout(0, 0));

		lblNewLabel = new JLabel("New Customer");
		lblNewLabel.setPreferredSize(new Dimension(66, 50));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel.setIcon(new ImageIcon(
				AddCustomer.class.getResource("/com/aptech/LoanProcessingSystem/images/customer (2).png")));
		contentPanel.add(lblNewLabel, BorderLayout.NORTH);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(105, 105, 105));
		contentPanel.add(panel_1);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));

		JPanel panel = new JPanel();
		panel_1.add(panel);
		panel.setBackground(SystemColor.activeCaptionBorder);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

		Component rigidArea_1 = Box.createRigidArea(new Dimension(20, 20));
		rigidArea_1.setPreferredSize(new Dimension(50, 50));
		panel.add(rigidArea_1);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(SystemColor.activeCaptionBorder);
		panel.add(panel_2);
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.PAGE_AXIS));

		Component glue_3 = Box.createGlue();
		panel_2.add(glue_3);

		JLabel lblNewLabel_1 = new JLabel("Name *");
		lblNewLabel_1.setMinimumSize(new Dimension(50, 30));
		lblNewLabel_1.setMaximumSize(new Dimension(100, 30));
		lblNewLabel_1.setPreferredSize(new Dimension(100, 30));
		panel_2.add(lblNewLabel_1);

		Component verticalStrut_7 = Box.createVerticalStrut(20);
		panel_2.add(verticalStrut_7);

		JLabel lblNewLabel_1_1 = new JLabel("Address *");
		lblNewLabel_1_1.setMinimumSize(new Dimension(50, 30));
		lblNewLabel_1_1.setMaximumSize(new Dimension(100, 30));
		lblNewLabel_1_1.setPreferredSize(new Dimension(100, 30));
		panel_2.add(lblNewLabel_1_1);

		Component verticalStrut_6 = Box.createVerticalStrut(20);
		panel_2.add(verticalStrut_6);

		JLabel lblNewLabel_1_2 = new JLabel("Email *");
		lblNewLabel_1_2.setMinimumSize(new Dimension(50, 30));
		lblNewLabel_1_2.setMaximumSize(new Dimension(100, 30));
		lblNewLabel_1_2.setPreferredSize(new Dimension(100, 30));
		panel_2.add(lblNewLabel_1_2);

		Component verticalStrut_5 = Box.createVerticalStrut(20);
		panel_2.add(verticalStrut_5);

		JLabel lblNewLabel_1_3 = new JLabel("Phone *");
		lblNewLabel_1_3.setMinimumSize(new Dimension(50, 30));
		lblNewLabel_1_3.setMaximumSize(new Dimension(100, 30));
		lblNewLabel_1_3.setPreferredSize(new Dimension(100, 30));
		panel_2.add(lblNewLabel_1_3);

		Component verticalStrut_4 = Box.createVerticalStrut(20);
		panel_2.add(verticalStrut_4);

		JLabel lblNewLabel_1_4 = new JLabel("Gender *");
		lblNewLabel_1_4.setMinimumSize(new Dimension(50, 30));
		lblNewLabel_1_4.setMaximumSize(new Dimension(100, 30));
		lblNewLabel_1_4.setPreferredSize(new Dimension(100, 30));
		panel_2.add(lblNewLabel_1_4);

		Component glue_4 = Box.createGlue();
		panel_2.add(glue_4);

		Component horizontalStrut = Box.createHorizontalStrut(20);
		panel.add(horizontalStrut);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(SystemColor.activeCaptionBorder);
		panel.add(panel_3);
		panel_3.setLayout(new BoxLayout(panel_3, BoxLayout.PAGE_AXIS));

		Component glue_1 = Box.createGlue();
		panel_3.add(glue_1);

		txtName = new JTextField();
		txtName.setPreferredSize(new Dimension(7, 30));
		txtName.setMinimumSize(new Dimension(7, 30));
		txtName.setMaximumSize(new Dimension(2147483647, 30));
		panel_3.add(txtName);
		txtName.setColumns(10);

		Component verticalStrut_2 = Box.createVerticalStrut(20);
		panel_3.add(verticalStrut_2);

		txtAddress = new JTextField();
		txtAddress.setPreferredSize(new Dimension(7, 30));
		txtAddress.setMinimumSize(new Dimension(7, 30));
		txtAddress.setMaximumSize(new Dimension(2147483647, 30));
		panel_3.add(txtAddress);
		txtAddress.setColumns(10);

		Component verticalStrut_1 = Box.createVerticalStrut(20);
		panel_3.add(verticalStrut_1);

		txtEmail = new JTextField();
		txtEmail.setPreferredSize(new Dimension(7, 30));
		txtEmail.setMinimumSize(new Dimension(7, 30));
		txtEmail.setMaximumSize(new Dimension(2147483647, 30));
		panel_3.add(txtEmail);
		txtEmail.setColumns(10);

		Component verticalStrut = Box.createVerticalStrut(20);
		panel_3.add(verticalStrut);

		txtPhone = new JTextField();
		txtPhone.setPreferredSize(new Dimension(7, 30));
		txtPhone.setMinimumSize(new Dimension(7, 30));
		txtPhone.setMaximumSize(new Dimension(2147483647, 30));
		panel_3.add(txtPhone);
		txtPhone.setColumns(10);

		Component verticalStrut_3 = Box.createVerticalStrut(20);
		panel_3.add(verticalStrut_3);

		JPanel panel_4 = new JPanel();
		panel_4.setForeground(new Color(0, 0, 0));
		panel_4.setBackground(SystemColor.activeCaptionBorder);
		FlowLayout flowLayout_1 = (FlowLayout) panel_4.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		flowLayout_1.setHgap(0);
		panel_4.setPreferredSize(new Dimension(10, 30));
		panel_4.setMinimumSize(new Dimension(10, 25));
		panel_4.setMaximumSize(new Dimension(32767, 25));
		panel_3.add(panel_4);

		rdbMale = new JRadioButton("Male");
		rdbMale.setBackground(SystemColor.activeCaptionBorder);
		rdbMale.setForeground(new Color(0, 0, 0));
		rdbMale.setPreferredSize(new Dimension(120, 25));
		rdbMale.setMinimumSize(new Dimension(120, 0));
		rdbMale.setMargin(new Insets(0, 0, 0, 0));
		rdbMale.setMaximumSize(new Dimension(200, 30));
		panel_4.add(rdbMale);
		rdbMale.setHorizontalAlignment(SwingConstants.LEFT);
		bg.add(rdbMale);
		rdbMale.setSelected(true);
		bg.add(rdbMale);
		rdbMale.setSelected(true);

		rdbFemale = new JRadioButton("Female");
		rdbFemale.setBackground(SystemColor.activeCaptionBorder);
		rdbFemale.setForeground(new Color(0, 0, 0));
		rdbFemale.setPreferredSize(new Dimension(120, 25));
		rdbFemale.setMinimumSize(new Dimension(120, 0));
		rdbFemale.setMargin(new Insets(0, 0, 0, 0));
		rdbFemale.setMaximumSize(new Dimension(200, 30));
		panel_4.add(rdbFemale);
		rdbFemale.setHorizontalAlignment(SwingConstants.LEFT);
		bg.add(rdbFemale);

		Component glue = Box.createGlue();
		panel_3.add(glue);

		Component rigidArea_2 = Box.createRigidArea(new Dimension(20, 20));
		rigidArea_2.setPreferredSize(new Dimension(50, 50));
		panel.add(rigidArea_2);

		Component glue_2 = Box.createGlue();
		panel.add(glue_2);

		Component rigidArea = Box.createRigidArea(new Dimension(20, 20));
		rigidArea.setPreferredSize(new Dimension(50, 20));
		panel_1.add(rigidArea);

		JPanel panel_1_1 = new JPanel();
		panel_1.add(panel_1_1);
		panel_1_1.setBackground(SystemColor.activeCaptionBorder);
		panel_1_1.setLayout(new BoxLayout(panel_1_1, BoxLayout.X_AXIS));

		Component rigidArea_1_1 = Box.createRigidArea(new Dimension(20, 20));
		rigidArea_1_1.setPreferredSize(new Dimension(50, 50));
		panel_1_1.add(rigidArea_1_1);

		JPanel panel_7 = new JPanel();
		panel_7.setBackground(SystemColor.activeCaptionBorder);
		panel_1_1.add(panel_7);
		panel_7.setLayout(new BoxLayout(panel_7, BoxLayout.PAGE_AXIS));

		Component glue_7 = Box.createGlue();
		panel_7.add(glue_7);

		JLabel lblNewLabel_2 = new JLabel("Salary *");
		lblNewLabel_2.setPreferredSize(new Dimension(100, 30));
		lblNewLabel_2.setMinimumSize(new Dimension(50, 30));
		lblNewLabel_2.setMaximumSize(new Dimension(100, 30));
		panel_7.add(lblNewLabel_2);

		Component verticalStrut_10_3 = Box.createVerticalStrut(20);
		panel_7.add(verticalStrut_10_3);

		JLabel lblNewLabel_3 = new JLabel("Job *");
		lblNewLabel_3.setPreferredSize(new Dimension(100, 30));
		lblNewLabel_3.setMinimumSize(new Dimension(50, 30));
		lblNewLabel_3.setMaximumSize(new Dimension(100, 30));
		panel_7.add(lblNewLabel_3);

		Component verticalStrut_10_2 = Box.createVerticalStrut(20);
		panel_7.add(verticalStrut_10_2);

		JLabel lblNewLabel_4 = new JLabel("Company *");
		lblNewLabel_4.setPreferredSize(new Dimension(100, 30));
		lblNewLabel_4.setMinimumSize(new Dimension(50, 30));
		lblNewLabel_4.setMaximumSize(new Dimension(100, 30));
		panel_7.add(lblNewLabel_4);

		Component verticalStrut_10_1 = Box.createVerticalStrut(20);
		panel_7.add(verticalStrut_10_1);

		JLabel lblNewLabel_5 = new JLabel("Identity Card *");
		lblNewLabel_5.setPreferredSize(new Dimension(100, 30));
		lblNewLabel_5.setMinimumSize(new Dimension(50, 30));
		lblNewLabel_5.setMaximumSize(new Dimension(100, 30));
		panel_7.add(lblNewLabel_5);

		Component verticalStrut_10 = Box.createVerticalStrut(20);
		panel_7.add(verticalStrut_10);

		JLabel lblNewLabel_7 = new JLabel("Dob *");
		lblNewLabel_7.setPreferredSize(new Dimension(100, 30));
		lblNewLabel_7.setMinimumSize(new Dimension(50, 30));
		lblNewLabel_7.setMaximumSize(new Dimension(100, 30));
		panel_7.add(lblNewLabel_7);

		Component glue_8 = Box.createGlue();
		panel_7.add(glue_8);

		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		panel_1_1.add(horizontalStrut_1);

		JPanel panel_5 = new JPanel();
		panel_5.setBackground(SystemColor.activeCaptionBorder);
		panel_1_1.add(panel_5);
		panel_5.setLayout(new BoxLayout(panel_5, BoxLayout.PAGE_AXIS));

		Component glue_5 = Box.createGlue();
		panel_5.add(glue_5);

		txtSalary = new JTextField();
		txtSalary.setMaximumSize(new Dimension(2147483647, 30));
		txtSalary.setPreferredSize(new Dimension(7, 30));
		panel_5.add(txtSalary);
		txtSalary.setColumns(10);

		Component verticalStrut_9_2 = Box.createVerticalStrut(20);
		panel_5.add(verticalStrut_9_2);

		txtJob = new JTextField();
		txtJob.setMaximumSize(new Dimension(2147483647, 30));
		txtJob.setPreferredSize(new Dimension(7, 30));
		panel_5.add(txtJob);
		txtJob.setColumns(10);

		Component verticalStrut_9_1 = Box.createVerticalStrut(20);
		panel_5.add(verticalStrut_9_1);

		txtCompany = new JTextField();
		txtCompany.setMaximumSize(new Dimension(2147483647, 30));
		txtCompany.setPreferredSize(new Dimension(7, 30));
		panel_5.add(txtCompany);
		txtCompany.setColumns(10);

		Component verticalStrut_9 = Box.createVerticalStrut(20);
		panel_5.add(verticalStrut_9);

		txtIdentity = new JTextField();
		txtIdentity.setMaximumSize(new Dimension(2147483647, 30));
		txtIdentity.setPreferredSize(new Dimension(7, 30));
		panel_5.add(txtIdentity);
		txtIdentity.setColumns(10);

		Component verticalStrut_8 = Box.createVerticalStrut(20);
		panel_5.add(verticalStrut_8);

		JPanel panel_6 = new JPanel();
		panel_6.setPreferredSize(new Dimension(10, 30));
		panel_6.setMinimumSize(new Dimension(10, 30));
		panel_6.setMaximumSize(new Dimension(32767, 30));
		panel_5.add(panel_6);
		panel_6.setLayout(new BoxLayout(panel_6, BoxLayout.X_AXIS));

		txtDob = new JDateChooser();
		txtDob.getCalendarButton().setAlignmentX(Component.CENTER_ALIGNMENT);
		panel_6.add(txtDob);
		txtDob.getCalendarButton().setOpaque(false);
		txtDob.getCalendarButton().setSize(new Dimension(0, 30));
		txtDob.getCalendarButton().setMinimumSize(new Dimension(100, 30));
		txtDob.getCalendarButton().setPreferredSize(new Dimension(21, 30));
		txtDob.getCalendarButton().setMaximumSize(new Dimension(21, 30));

		Component glue_6 = Box.createGlue();
		panel_5.add(glue_6);

		Component horizontalStrut_2 = Box.createHorizontalStrut(20);
		panel_1_1.add(horizontalStrut_2);

		Component glue_10 = Box.createGlue();
		panel_1_1.add(glue_10);

		JPanel buttonPane = new JPanel();
		buttonPane.setBackground(Color.LIGHT_GRAY);
		getContentPane().add(buttonPane, BorderLayout.SOUTH);
		buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 20));

		JButton btnSave = new JButton("Save");
		btnSave.setPreferredSize(new Dimension(120, 30));
		buttonPane.add(btnSave);
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 10));

		JTextFieldDateEditor endDateEditor = (JTextFieldDateEditor) txtDob.getDateEditor();
		endDateEditor.setEditable(false);

		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(setValue()) {
					if(isUpdate) {
						updateCustomerAction();
					}else {
						addCustomerAction();
					}
				}
			}
		});
		btnSave.setIcon(new ImageIcon(
				AddCustomer.class.getResource("/com/aptech/LoanProcessingSystem/images/floppy-disk.png")));

		JButton btnClear = new JButton("Clear");
		btnClear.setPreferredSize(new Dimension(120, 30));
		buttonPane.add(btnClear);
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				initForm();
			}
		});
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnClear.setIcon(new ImageIcon(
				AddCustomer.class.getResource("/com/aptech/LoanProcessingSystem/images/ic_refresh_16.png")));

		JButton btnNewButton = new JButton("Cancel");
		btnNewButton.setPreferredSize(new Dimension(120, 30));
		buttonPane.add(btnNewButton);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancelAction();
			}
		});
		btnNewButton.setIcon(
				new ImageIcon(AddCustomer.class.getResource("/com/aptech/LoanProcessingSystem/images/close (2).png")));

		txtSalary.addKeyListener(new KeyAdapter() {

			@Override
			public void keyReleased(KeyEvent e) {
				try {
					double salary = Double.parseDouble(txtSalary.getText().replace(",", "").trim());
					txtSalary.setText(Common.formatInt(salary));
				} catch (Exception e1) {
					String salary = txtSalary.getText();
					salary = salary.replaceAll("[^0-9\\,]", "");
					txtSalary.setText(salary);
				}
			}

		});

		initForm();
		setTextHint(txtName, hintName);
		setTextHint(txtEmail, hintEmail);
		setTextHint(txtAddress, hintAddress);
		setTextHint(txtCompany, hintCompany);
		setTextHint(txtIdentity, hintIdentity);
		setTextHint(txtPhone, hintPhone);
		setTextHint(txtSalary, hintSalary);
		setTextHint(txtJob, hintJob);
	}

	private boolean setValue() {
		boolean result = false;
		name = txtName.getText().trim();
		email = txtEmail.getText().trim();
		address = txtAddress.getText().trim();
		phone = txtPhone.getText().trim();
		company = txtCompany.getText().trim();
		job = txtJob.getText().trim();
		salary = Double.parseDouble(txtSalary.getText().replace(",", "").trim());
		identity_card = txtIdentity.getText().trim();
		dob = txtDob.getDate();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.set(Calendar.YEAR, calendar.get(Calendar.YEAR) - 16);
		Date dateCheck = calendar.getTime();
		boolean isPhoneValid = Pattern.matches("^[0-9]{9,12}$", txtPhone.getText().trim());
		boolean isIdentityValid = Pattern.matches("^[a-zA-Z0-9]{9,12}$", txtIdentity.getText().trim());
		boolean isEmailValid = Pattern.matches("^[a-zA-Z0-9]+(.+)+[@]{1}+(.+)+[.]{1}+[a-zA-Z0-9]+$",
				txtEmail.getText().trim());
		// Apply the validation logic checking all controls are empty or not
		if (!isPhoneValid) {

			JOptionPane.showMessageDialog(null, "Phone invalid!");

		} else if (!isIdentityValid) {

			JOptionPane.showMessageDialog(null, "Identity card invalid!");

		} else if (!isEmailValid) {

			JOptionPane.showMessageDialog(null, "Email invalid!");

		} else if (dob.after(dateCheck)) {

			JOptionPane.showMessageDialog(null, "Birthday invalid!");
			txtDob.grabFocus();

		} else if (name.trim().equals(hintName) || job.trim().equals(hintJob) || address.trim().equals(hintAddress)
				|| company.trim().equals(hintCompany)) {

			JOptionPane.showMessageDialog(null, "Please enter full information !!!");

		} else {
			customer.setName(name);
			customer.setEmail(email);
			customer.setJob(job);
			customer.setSalary(salary);
			customer.setCompany(company);
			customer.setPhone(phone);
			customer.setAddress(address);
			customer.setGender(rdbMale.isSelected());
			customer.setDob(dob);
			customer.setIdentityCard(identity_card);
			result = true;
		}
		return result;
	}

	private void updateCustomerAction() {

		try {
			CustomerModel customerModel = new CustomerModel();
			if (customerModel.update(customer)) {
				JOptionPane.showMessageDialog(null, "Successful!");
				this.dispose();
			} else {
				JOptionPane.showMessageDialog(null, "Please try again!");
			}

		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}

	private void addCustomerAction() {
		try {
			CustomerModel customerModel = new CustomerModel();
			if (customerModel.create(customer)) {
				JOptionPane.showMessageDialog(null, "Successful!");
				this.dispose();
			} else {
				JOptionPane.showMessageDialog(null, "Please try again!");
			}
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}

	private void initForm() {
		if (!isUpdate) {
			txtName.setText(hintName);
			txtName.setFont(new Font("Tahoma", Font.ITALIC, 10));
			txtName.setForeground(Color.GRAY);
			txtEmail.setText(hintEmail);
			txtEmail.setFont(new Font("Tahoma", Font.ITALIC, 10));
			txtEmail.setForeground(Color.GRAY);
			txtAddress.setText(hintAddress);
			txtAddress.setFont(new Font("Tahoma", Font.ITALIC, 10));
			txtAddress.setForeground(Color.GRAY);
			txtCompany.setText(hintCompany);
			txtCompany.setFont(new Font("Tahoma", Font.ITALIC, 10));
			txtCompany.setForeground(Color.GRAY);
			txtIdentity.setText(hintIdentity);
			txtIdentity.setFont(new Font("Tahoma", Font.ITALIC, 10));
			txtIdentity.setForeground(Color.GRAY);
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(new Date());
			calendar.set(Calendar.YEAR, calendar.get(Calendar.YEAR) - 16);
			txtDob.setDate(calendar.getTime());
			txtPhone.setText(hintPhone);
			txtPhone.setFont(new Font("Tahoma", Font.ITALIC, 10));
			txtPhone.setForeground(Color.GRAY);
			txtSalary.setText(hintSalary);
			txtSalary.setFont(new Font("Tahoma", Font.ITALIC, 10));
			txtSalary.setForeground(Color.GRAY);
			txtJob.setText(hintJob);
			txtJob.setFont(new Font("Tahoma", Font.ITALIC, 10));
			txtJob.setForeground(Color.GRAY);
			rdbMale.setSelected(true);
		} else {
			lblNewLabel.setText("Update Customer Information");
			txtName.setText(customer.getName());
			txtEmail.setText(customer.getEmail());
			txtAddress.setText(customer.getAddress());
			txtCompany.setText(customer.getCompany());
			txtIdentity.setText(customer.getIdentityCard());
			txtDob.setDate(customer.getDob());
			txtPhone.setText(customer.getPhone());
			txtSalary.setText(Common.formatInt(customer.getSalary()));
			txtJob.setText(customer.getJob());
			if (customer.isGender()) {
				rdbMale.setSelected(true);
			} else {
				rdbFemale.setSelected(true);
			}
			txtName.setFont(new Font("Tahoma", Font.PLAIN, 12));
			txtName.setForeground(Color.BLACK);
			txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 12));
			txtEmail.setForeground(Color.BLACK);
			txtAddress.setFont(new Font("Tahoma", Font.PLAIN, 12));
			txtAddress.setForeground(Color.BLACK);
			txtCompany.setFont(new Font("Tahoma", Font.PLAIN, 12));
			txtCompany.setForeground(Color.BLACK);
			txtIdentity.setFont(new Font("Tahoma", Font.PLAIN, 12));
			txtIdentity.setForeground(Color.BLACK);
			txtPhone.setFont(new Font("Tahoma", Font.PLAIN, 12));
			txtPhone.setForeground(Color.BLACK);
			txtSalary.setFont(new Font("Tahoma", Font.PLAIN, 12));
			txtSalary.setForeground(Color.BLACK);
			txtJob.setFont(new Font("Tahoma", Font.PLAIN, 12));
			txtJob.setForeground(Color.BLACK);
		}
	}

	private void setTextHint(JTextField textField, String hint) {
		textField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (textField.getText().equals(hint)) {
					textField.setText("");
					textField.setFont(new Font("Tahoma", Font.PLAIN, 12));
					if (textField instanceof JPasswordField) {
						((JPasswordField) textField).setEchoChar('*');
					}
					textField.setForeground(Color.BLACK);
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
