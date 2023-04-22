package com.aptech.LoanProcessingSystem.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

import javax.swing.Box;
import javax.swing.BoxLayout;
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
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.aptech.LoanProcessingSystem.entities.Fine;
import com.aptech.LoanProcessingSystem.entities.LoanAndFineHistory;
import com.aptech.LoanProcessingSystem.entities.PaymentMethod;
import com.aptech.LoanProcessingSystem.model.FineModel;
import com.aptech.LoanProcessingSystem.model.LoanAndFineHistoryModel;
import com.aptech.LoanProcessingSystem.model.PaymentMethodModel;
import com.aptech.LoanProcessingSystem.service.Common;
import com.aptech.LoanProcessingSystem.service.ShareData;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;

@SuppressWarnings("serial")
public class PaymentLoan extends JDialog {
	private final JPanel contentPanel = new JPanel();
	private JTextField txtCustomerName;
	private JTextField txtLoanType;
	private JTextField txtPaymentType;
	private JTextField txtPeriod;
	private JTextField txtLoanAmount;
	private JTextField txtInterest;
	private JTextField txtFineInterest;
	private JTextField txtFineOverdays;
	private JTextField txtDuration;
	private JTextField txtPaymentAmount;
	private JTextField txtFineAmount;
	private JTextField txtAmountLeft;
	private JTextField txtTotalPayment;
	private JComboBox<PaymentMethod> cbbxPaymentMethod;
	private Fine fine;
	private LoanAndFineHistory loanAndFineHistory;
	private JDateChooser txtDueDate;
	private String hintPaymentAmount = "Please enter payment amount!";
	private String hintFineAmount = "Please enter fine amount!";
	private int fineOverDays = 0;
	private double fineAmount = 0;
	private JTextArea txtDescription;
	private JButton btnSave;
	private JButton btnClear;
	private JButton btnCancel;
	private JTextField txtPaymentMethod;
	private JTextField txtStatus;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		try {
			if (ShareData.accountLogin == null) {
				Login login = new Login();
				login.setVisible(true);
			} else {
				PaymentLoan dialog = new PaymentLoan();
				dialog.setVisible(true);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public PaymentLoan(int loanHisId) {
		this();
		this.loanAndFineHistory = new LoanAndFineHistoryModel().searchHistoryBasedOnId(loanHisId);
		if (loanAndFineHistory == null) {
			JOptionPane.showMessageDialog(null, "Something went wrong!");
			this.dispose();
		}

		this.fine = new FineModel().findFineInterest(loanAndFineHistory.getPaymentAmount());
		initValue();
	}

	/**
	 * Create the dialog.
	 */
	public PaymentLoan() {
		setMinimumSize(new Dimension(1200, 580));
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent windowEvent) {
				cancelAction();
			}
		});
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(PaymentLoan.class.getResource("/com/aptech/LoanProcessingSystem/images/bank (4).png")));
		setFont(new Font("Dialog", Font.BOLD, 14));
		setTitle("New Customer");
		setBounds(100, 100, 1235, 745);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(105, 105, 105));
		contentPanel.setBorder(new EmptyBorder(50, 20, 30, 20));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		setLocationRelativeTo(null);
		contentPanel.setLayout(new BorderLayout(0, 0));

		JLabel lblNewLabel = new JLabel("Payment");
		lblNewLabel.setPreferredSize(new Dimension(66, 60));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 24));
		lblNewLabel.setIcon(new ImageIcon(
				PaymentLoan.class.getResource("/com/aptech/LoanProcessingSystem/images/customer (2).png")));
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

		JLabel lblNewLabel_1 = new JLabel("Customer");
		lblNewLabel_1.setMinimumSize(new Dimension(50, 30));
		lblNewLabel_1.setMaximumSize(new Dimension(100, 30));
		lblNewLabel_1.setPreferredSize(new Dimension(100, 30));
		panel_2.add(lblNewLabel_1);

		Component verticalStrut_7 = Box.createVerticalStrut(20);
		panel_2.add(verticalStrut_7);

		JLabel lblNewLabel_1_1 = new JLabel("Loan type");
		lblNewLabel_1_1.setMinimumSize(new Dimension(50, 30));
		lblNewLabel_1_1.setMaximumSize(new Dimension(100, 30));
		lblNewLabel_1_1.setPreferredSize(new Dimension(100, 30));
		panel_2.add(lblNewLabel_1_1);

		Component verticalStrut_6 = Box.createVerticalStrut(20);
		panel_2.add(verticalStrut_6);

		JLabel lblNewLabel_1_2 = new JLabel("Payment type");
		lblNewLabel_1_2.setMinimumSize(new Dimension(50, 30));
		lblNewLabel_1_2.setMaximumSize(new Dimension(100, 30));
		lblNewLabel_1_2.setPreferredSize(new Dimension(100, 30));
		panel_2.add(lblNewLabel_1_2);

		Component verticalStrut_5 = Box.createVerticalStrut(20);
		panel_2.add(verticalStrut_5);

		JLabel lblNewLabel_1_3 = new JLabel("Period");
		lblNewLabel_1_3.setMinimumSize(new Dimension(50, 30));
		lblNewLabel_1_3.setMaximumSize(new Dimension(100, 30));
		lblNewLabel_1_3.setPreferredSize(new Dimension(100, 30));
		panel_2.add(lblNewLabel_1_3);

		Component verticalStrut_4 = Box.createVerticalStrut(20);
		panel_2.add(verticalStrut_4);

		JLabel lblNewLabel_1_4 = new JLabel("Duration");
		lblNewLabel_1_4.setMinimumSize(new Dimension(50, 30));
		lblNewLabel_1_4.setMaximumSize(new Dimension(100, 30));
		lblNewLabel_1_4.setPreferredSize(new Dimension(100, 30));
		panel_2.add(lblNewLabel_1_4);

		Component verticalStrut_10_3 = Box.createVerticalStrut(20);
		panel_2.add(verticalStrut_10_3);

		JLabel lblNewLabel_2 = new JLabel("Loan amount");
		panel_2.add(lblNewLabel_2);
		lblNewLabel_2.setPreferredSize(new Dimension(100, 30));
		lblNewLabel_2.setMinimumSize(new Dimension(50, 30));
		lblNewLabel_2.setMaximumSize(new Dimension(100, 30));

		Component verticalStrut_10_2 = Box.createVerticalStrut(20);
		panel_2.add(verticalStrut_10_2);

		JLabel lblNewLabel_3 = new JLabel("Interest");
		panel_2.add(lblNewLabel_3);
		lblNewLabel_3.setPreferredSize(new Dimension(100, 30));
		lblNewLabel_3.setMinimumSize(new Dimension(50, 30));
		lblNewLabel_3.setMaximumSize(new Dimension(100, 30));

		Component verticalStrut_9_1_3 = Box.createVerticalStrut(20);
		panel_2.add(verticalStrut_9_1_3);

		JLabel lblNewLabel_7_1_1_1_1 = new JLabel("Payment method");
		panel_2.add(lblNewLabel_7_1_1_1_1);
		lblNewLabel_7_1_1_1_1.setPreferredSize(new Dimension(100, 30));
		lblNewLabel_7_1_1_1_1.setMinimumSize(new Dimension(50, 30));
		lblNewLabel_7_1_1_1_1.setMaximumSize(new Dimension(100, 30));

		Component verticalStrut_11 = Box.createVerticalStrut(20);
		panel_2.add(verticalStrut_11);

		JLabel lblNewLabel_7_1_1_1_1_1 = new JLabel("Status");
		lblNewLabel_7_1_1_1_1_1.setPreferredSize(new Dimension(100, 30));
		lblNewLabel_7_1_1_1_1_1.setMinimumSize(new Dimension(50, 30));
		lblNewLabel_7_1_1_1_1_1.setMaximumSize(new Dimension(100, 30));
		panel_2.add(lblNewLabel_7_1_1_1_1_1);

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

		txtCustomerName = new JTextField();
		txtCustomerName.setFont(new Font("Dialog", Font.PLAIN, 13));
		txtCustomerName.setEditable(false);
		txtCustomerName.setPreferredSize(new Dimension(7, 30));
		txtCustomerName.setMinimumSize(new Dimension(7, 30));
		txtCustomerName.setMaximumSize(new Dimension(2147483647, 30));
		panel_3.add(txtCustomerName);
		txtCustomerName.setColumns(10);

		Component verticalStrut_2 = Box.createVerticalStrut(20);
		panel_3.add(verticalStrut_2);

		txtLoanType = new JTextField();
		txtLoanType.setFont(new Font("Dialog", Font.PLAIN, 13));
		txtLoanType.setEditable(false);
		txtLoanType.setPreferredSize(new Dimension(7, 30));
		txtLoanType.setMinimumSize(new Dimension(7, 30));
		txtLoanType.setMaximumSize(new Dimension(2147483647, 30));
		panel_3.add(txtLoanType);
		txtLoanType.setColumns(10);

		Component verticalStrut_1 = Box.createVerticalStrut(20);
		panel_3.add(verticalStrut_1);

		txtPaymentType = new JTextField();
		txtPaymentType.setFont(new Font("Dialog", Font.PLAIN, 13));
		txtPaymentType.setEditable(false);
		txtPaymentType.setPreferredSize(new Dimension(7, 30));
		txtPaymentType.setMinimumSize(new Dimension(7, 30));
		txtPaymentType.setMaximumSize(new Dimension(2147483647, 30));
		panel_3.add(txtPaymentType);
		txtPaymentType.setColumns(10);

		Component verticalStrut = Box.createVerticalStrut(20);
		panel_3.add(verticalStrut);

		txtPeriod = new JTextField();
		txtPeriod.setFont(new Font("Dialog", Font.PLAIN, 13));
		txtPeriod.setEditable(false);
		txtPeriod.setPreferredSize(new Dimension(7, 30));
		txtPeriod.setMinimumSize(new Dimension(7, 30));
		txtPeriod.setMaximumSize(new Dimension(2147483647, 30));
		panel_3.add(txtPeriod);
		txtPeriod.setColumns(10);

		Component verticalStrut_3 = Box.createVerticalStrut(20);
		panel_3.add(verticalStrut_3);

		txtDuration = new JTextField();
		txtDuration.setEditable(false);
		txtDuration.setPreferredSize(new Dimension(7, 30));
		txtDuration.setMinimumSize(new Dimension(7, 30));
		txtDuration.setMaximumSize(new Dimension(2147483647, 30));
		txtDuration.setForeground(Color.BLACK);
		txtDuration.setFont(new Font("Dialog", Font.PLAIN, 13));
		txtDuration.setColumns(10);
		panel_3.add(txtDuration);

		Component verticalStrut_9_2 = Box.createVerticalStrut(20);
		panel_3.add(verticalStrut_9_2);

		txtLoanAmount = new JTextField();
		txtLoanAmount.setFont(new Font("Dialog", Font.PLAIN, 13));
		panel_3.add(txtLoanAmount);
		txtLoanAmount.setEditable(false);
		txtLoanAmount.setMaximumSize(new Dimension(2147483647, 30));
		txtLoanAmount.setPreferredSize(new Dimension(7, 30));
		txtLoanAmount.setColumns(10);

		Component verticalStrut_9_1 = Box.createVerticalStrut(20);
		panel_3.add(verticalStrut_9_1);

		txtInterest = new JTextField();
		txtInterest.setFont(new Font("Dialog", Font.PLAIN, 13));
		panel_3.add(txtInterest);
		txtInterest.setEditable(false);
		txtInterest.setMaximumSize(new Dimension(2147483647, 30));
		txtInterest.setPreferredSize(new Dimension(7, 30));
		txtInterest.setColumns(10);

		Component verticalStrut_9_1_1 = Box.createVerticalStrut(20);
		panel_3.add(verticalStrut_9_1_1);

		JPanel panel_6 = new JPanel();
		panel_3.add(panel_6);
		panel_6.setMinimumSize(new Dimension(10, 30));
		panel_6.setMaximumSize(new Dimension(32767, 30));
		panel_6.setLayout(new BoxLayout(panel_6, BoxLayout.X_AXIS));

		cbbxPaymentMethod = new JComboBox<PaymentMethod>();
		cbbxPaymentMethod.setPreferredSize(new Dimension(29, 30));
		cbbxPaymentMethod.setMinimumSize(new Dimension(29, 30));
		panel_6.add(cbbxPaymentMethod);

		txtPaymentMethod = new JTextField();
		txtPaymentMethod.setFont(new Font("Dialog", Font.PLAIN, 13));
		txtPaymentMethod.setVisible(false);
		txtPaymentMethod.setPreferredSize(new Dimension(7, 30));
		txtPaymentMethod.setMaximumSize(new Dimension(2147483647, 30));
		txtPaymentMethod.setEditable(false);
		txtPaymentMethod.setColumns(10);
		panel_3.add(txtPaymentMethod);

		Component verticalStrut_11_1 = Box.createVerticalStrut(20);
		panel_3.add(verticalStrut_11_1);

		txtStatus = new JTextField();
		txtStatus.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtStatus.setForeground(Color.RED);
		txtStatus.setPreferredSize(new Dimension(7, 30));
		txtStatus.setMaximumSize(new Dimension(2147483647, 30));
		txtStatus.setEditable(false);
		txtStatus.setColumns(10);
		panel_3.add(txtStatus);

		Component glue = Box.createGlue();
		panel_3.add(glue);

		Component rigidArea_2 = Box.createRigidArea(new Dimension(20, 20));
		rigidArea_2.setPreferredSize(new Dimension(50, 50));
		panel.add(rigidArea_2);

		Component glue_2 = Box.createGlue();
		panel.add(glue_2);

		Component rigidArea = Box.createRigidArea(new Dimension(20, 20));
		rigidArea.setPreferredSize(new Dimension(30, 20));
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

		JLabel lblNewLabel_4_1 = new JLabel("Payment amount");
		lblNewLabel_4_1.setPreferredSize(new Dimension(100, 30));
		lblNewLabel_4_1.setMinimumSize(new Dimension(50, 30));
		lblNewLabel_4_1.setMaximumSize(new Dimension(100, 30));
		panel_7.add(lblNewLabel_4_1);

		Component verticalStrut_10_2_1 = Box.createVerticalStrut(20);
		panel_7.add(verticalStrut_10_2_1);

		JLabel lblNewLabel_4 = new JLabel("Due date");
		lblNewLabel_4.setPreferredSize(new Dimension(100, 30));
		lblNewLabel_4.setMinimumSize(new Dimension(50, 30));
		lblNewLabel_4.setMaximumSize(new Dimension(100, 30));
		panel_7.add(lblNewLabel_4);

		Component verticalStrut_10_1 = Box.createVerticalStrut(20);
		panel_7.add(verticalStrut_10_1);

		JLabel lblNewLabel_5 = new JLabel("Fine over days");
		lblNewLabel_5.setPreferredSize(new Dimension(100, 30));
		lblNewLabel_5.setMinimumSize(new Dimension(50, 30));
		lblNewLabel_5.setMaximumSize(new Dimension(100, 30));
		panel_7.add(lblNewLabel_5);

		Component verticalStrut_10_1_1 = Box.createVerticalStrut(20);
		panel_7.add(verticalStrut_10_1_1);

		JLabel lblNewLabel_7 = new JLabel("Fine interest");
		lblNewLabel_7.setPreferredSize(new Dimension(100, 30));
		lblNewLabel_7.setMinimumSize(new Dimension(50, 30));
		lblNewLabel_7.setMaximumSize(new Dimension(100, 30));
		panel_7.add(lblNewLabel_7);

		Component verticalStrut_10 = Box.createVerticalStrut(20);
		panel_7.add(verticalStrut_10);

		JLabel lblNewLabel_7_1 = new JLabel("Fine amount");
		lblNewLabel_7_1.setPreferredSize(new Dimension(100, 30));
		lblNewLabel_7_1.setMinimumSize(new Dimension(50, 30));
		lblNewLabel_7_1.setMaximumSize(new Dimension(100, 30));
		panel_7.add(lblNewLabel_7_1);

		Component verticalStrut_10_4 = Box.createVerticalStrut(20);
		panel_7.add(verticalStrut_10_4);

		JLabel lblNewLabel_7_1_1 = new JLabel("Amount left");
		lblNewLabel_7_1_1.setPreferredSize(new Dimension(100, 30));
		lblNewLabel_7_1_1.setMinimumSize(new Dimension(50, 30));
		lblNewLabel_7_1_1.setMaximumSize(new Dimension(100, 30));
		panel_7.add(lblNewLabel_7_1_1);

		Component verticalStrut_10_4_1 = Box.createVerticalStrut(20);
		panel_7.add(verticalStrut_10_4_1);

		JLabel lblNewLabel_7_1_1_1 = new JLabel("Total payment");
		lblNewLabel_7_1_1_1.setPreferredSize(new Dimension(100, 30));
		lblNewLabel_7_1_1_1.setMinimumSize(new Dimension(50, 30));
		lblNewLabel_7_1_1_1.setMaximumSize(new Dimension(100, 30));
		panel_7.add(lblNewLabel_7_1_1_1);

		Component verticalStrut_10_4_1_1 = Box.createVerticalStrut(20);
		panel_7.add(verticalStrut_10_4_1_1);

		JLabel lblNewLabel_7_1_1_1_2 = new JLabel("Description");
		lblNewLabel_7_1_1_1_2.setPreferredSize(new Dimension(100, 30));
		lblNewLabel_7_1_1_1_2.setMinimumSize(new Dimension(50, 30));
		lblNewLabel_7_1_1_1_2.setMaximumSize(new Dimension(100, 30));
		panel_7.add(lblNewLabel_7_1_1_1_2);

		Component verticalStrut_10_4_2_1_1 = Box.createVerticalStrut(20);
		verticalStrut_10_4_2_1_1.setPreferredSize(new Dimension(0, 60));
		panel_7.add(verticalStrut_10_4_2_1_1);

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

		txtPaymentAmount = new JTextField();
		txtPaymentAmount.setEditable(false);
		txtPaymentAmount.setPreferredSize(new Dimension(7, 30));
		txtPaymentAmount.setMaximumSize(new Dimension(2147483647, 30));
		txtPaymentAmount.setForeground(Color.BLACK);
		txtPaymentAmount.setFont(new Font("Dialog", Font.PLAIN, 13));
		txtPaymentAmount.setColumns(10);
		setTextHint(txtPaymentAmount, hintPaymentAmount);
		panel_5.add(txtPaymentAmount);

		Component verticalStrut_9_4 = Box.createVerticalStrut(20);
		panel_5.add(verticalStrut_9_4);

		JPanel panel_4 = new JPanel();
		panel_4.setMinimumSize(new Dimension(10, 30));
		panel_4.setMaximumSize(new Dimension(32767, 30));
		panel_5.add(panel_4);
		panel_4.setLayout(new BoxLayout(panel_4, BoxLayout.X_AXIS));

		txtDueDate = new JDateChooser();
		txtDueDate.getCalendarButton().setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtDueDate.getCalendarButton().setSize(new Dimension(0, 30));
		txtDueDate.getCalendarButton().setPreferredSize(new Dimension(21, 30));
		txtDueDate.getCalendarButton().setOpaque(false);
		txtDueDate.getCalendarButton().setMinimumSize(new Dimension(100, 30));
		txtDueDate.getCalendarButton().setMaximumSize(new Dimension(21, 30));
		txtDueDate.getCalendarButton().setEnabled(false);
		txtDueDate.getCalendarButton().setAlignmentX(0.5f);
		panel_4.add(txtDueDate);

		Component verticalStrut_9 = Box.createVerticalStrut(20);
		panel_5.add(verticalStrut_9);

		txtFineOverdays = new JTextField();
		txtFineOverdays.setFont(new Font("Dialog", Font.PLAIN, 13));
		txtFineOverdays.setEditable(false);
		txtFineOverdays.setMaximumSize(new Dimension(2147483647, 30));
		txtFineOverdays.setPreferredSize(new Dimension(7, 30));
		panel_5.add(txtFineOverdays);
		txtFineOverdays.setColumns(10);
		Component verticalStrut_9_3 = Box.createVerticalStrut(20);
		panel_5.add(verticalStrut_9_3);

		txtFineInterest = new JTextField();
		txtFineInterest.setFont(new Font("Dialog", Font.PLAIN, 13));
		txtFineInterest.setEditable(false);
		txtFineInterest.setMaximumSize(new Dimension(2147483647, 30));
		txtFineInterest.setPreferredSize(new Dimension(7, 30));
		panel_5.add(txtFineInterest);
		txtFineInterest.setColumns(10);

		Component verticalStrut_8 = Box.createVerticalStrut(20);
		panel_5.add(verticalStrut_8);

		txtFineAmount = new JTextField();
		txtFineAmount.setEditable(false);
		txtFineAmount.setPreferredSize(new Dimension(7, 30));
		txtFineAmount.setMaximumSize(new Dimension(2147483647, 30));
		txtFineAmount.setForeground(Color.BLACK);
		txtFineAmount.setFont(new Font("Dialog", Font.PLAIN, 13));
		txtFineAmount.setColumns(10);
		setTextHint(txtFineAmount, hintFineAmount);
		panel_5.add(txtFineAmount);

		Component verticalStrut_10_5 = Box.createVerticalStrut(20);
		panel_5.add(verticalStrut_10_5);

		txtAmountLeft = new JTextField();
		txtAmountLeft.setPreferredSize(new Dimension(7, 30));
		txtAmountLeft.setMaximumSize(new Dimension(2147483647, 30));
		txtAmountLeft.setForeground(Color.BLACK);
		txtAmountLeft.setFont(new Font("Dialog", Font.PLAIN, 13));
		txtAmountLeft.setEditable(false);
		txtAmountLeft.setColumns(10);
		panel_5.add(txtAmountLeft);

		Component verticalStrut_10_4_2 = Box.createVerticalStrut(20);
		panel_5.add(verticalStrut_10_4_2);

		txtTotalPayment = new JTextField();
		txtTotalPayment.setEditable(false);
		txtTotalPayment.setPreferredSize(new Dimension(7, 30));
		txtTotalPayment.setMaximumSize(new Dimension(2147483647, 30));
		txtTotalPayment.setForeground(Color.BLACK);
		txtTotalPayment.setFont(new Font("Dialog", Font.PLAIN, 13));
		txtTotalPayment.setColumns(10);
		setTextHint(txtTotalPayment, hintFineAmount);
		panel_5.add(txtTotalPayment);

		Component verticalStrut_10_4_2_1 = Box.createVerticalStrut(20);
		panel_5.add(verticalStrut_10_4_2_1);

		txtDescription = new JTextArea();
		txtDescription.setFont(new Font("Monospaced", Font.PLAIN, 13));
		txtDescription.setPreferredSize(new Dimension(5, 90));
		txtDescription.setMinimumSize(new Dimension(5, 90));
		txtDescription.setMaximumSize(new Dimension(2147483647, 90));
		panel_5.add(txtDescription);

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

		btnSave = new JButton("Save");
		btnSave.setPreferredSize(new Dimension(120, 30));
		buttonPane.add(btnSave);
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 10));

		btnSave.setIcon(new ImageIcon(
				PaymentLoan.class.getResource("/com/aptech/LoanProcessingSystem/images/floppy-disk.png")));

		btnClear = new JButton("Clear");
		btnClear.setPreferredSize(new Dimension(120, 30));
		buttonPane.add(btnClear);

		btnClear.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnClear.setIcon(new ImageIcon(
				PaymentLoan.class.getResource("/com/aptech/LoanProcessingSystem/images/ic_refresh_16.png")));

		btnCancel = new JButton("Cancel");
		btnCancel.setPreferredSize(new Dimension(120, 30));
		buttonPane.add(btnCancel);

		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 10));
		JTextFieldDateEditor endDateEditor = (JTextFieldDateEditor) txtDueDate.getDateEditor();
		endDateEditor.setEditable(false);

		btnCancel.setIcon(
				new ImageIcon(PaymentLoan.class.getResource("/com/aptech/LoanProcessingSystem/images/close (2).png")));

		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				paymentAction();
			}
		});

		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				initValue();
			}
		});
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancelAction();
			}
		});
	}

	protected void paymentAction() {

		try {
			int paymemtMethodId = ((PaymentMethod) cbbxPaymentMethod.getSelectedItem()).getId();
			if(fineOverDays>0) {
				loanAndFineHistory.setFineId(fine.getId());
				loanAndFineHistory.setFineInterest(fine.getFineInterest());
			}
			loanAndFineHistory.setFineOverDays(fineOverDays);
			loanAndFineHistory.setFineAmount(fineAmount);
			loanAndFineHistory.setPaymentDate(new Date());
			loanAndFineHistory.setPaymentMethodId(paymemtMethodId);
			loanAndFineHistory.setStatus(true);
			loanAndFineHistory.setDescription(txtDescription.getText());
			LoanAndFineHistoryModel model = new LoanAndFineHistoryModel();
			if (model.updatePayment(loanAndFineHistory)) {
				JOptionPane.showMessageDialog(null, "Successful!");
				PaymentLoan.this.dispose();
			} else {
				JOptionPane.showMessageDialog(null, "Please try again!");
			}

		} catch (Exception e2) {
			e2.printStackTrace();
		}

	}

	@SuppressWarnings("deprecation")
	private void initValue() {
		txtCustomerName.setText(loanAndFineHistory.getCustomer());
		txtLoanType.setText(loanAndFineHistory.getLoanType());
		txtPaymentType.setText(loanAndFineHistory.getPaymentType());
		txtPeriod.setText(String.valueOf(loanAndFineHistory.getPeriod()));
		txtDuration.setText(String.valueOf(loanAndFineHistory.getDuration()));
		txtLoanAmount.setText(Common.formatNumber(loanAndFineHistory.getAmount()));
		txtInterest.setText(Common.formatNumber(loanAndFineHistory.getLoanInterest() * 100) + " %");
		txtPaymentAmount.setText(Common.formatNumber(loanAndFineHistory.getPaymentAmount()));
		txtDueDate.setDate(loanAndFineHistory.getDueDate());
		txtStatus.setText(loanAndFineHistory.isStatus() ? "Paid" : "Unpaid");
		txtAmountLeft.setText(Common.formatNumber(loanAndFineHistory.getAmountLeft()));
		if (loanAndFineHistory.isStatus()) {
			btnSave.setVisible(false);
			btnClear.setVisible(false);
			txtDescription.setEditable(false);
			txtPaymentMethod.setVisible(true);
			cbbxPaymentMethod.setVisible(false);
			txtFineOverdays.setText(String.valueOf(loanAndFineHistory.getFineOverDays()));
			txtFineInterest.setText(Common.formatNumber(fine.getFineInterest() * 100) + " %");
			txtFineAmount.setText(Common.formatNumber(loanAndFineHistory.getFineAmount()));
			txtTotalPayment.setText(
					Common.formatNumber(loanAndFineHistory.getFineAmount() + loanAndFineHistory.getPaymentAmount()));
			txtPaymentMethod.setText(loanAndFineHistory.getPaymentMenthodName());
			txtDescription.setText(loanAndFineHistory.getDescription());
			btnCancel.setText("Close");

		} else {

			Calendar nowCalendar = Calendar.getInstance();
			nowCalendar.setTime(new Date());
			nowCalendar.set(Calendar.HOUR_OF_DAY, 0);
			nowCalendar.set(Calendar.MINUTE, 0);
			nowCalendar.set(Calendar.SECOND, 0);
			Calendar dueCalendar = Calendar.getInstance();
			dueCalendar.setTime(loanAndFineHistory.getDueDate());
			dueCalendar.set(Calendar.HOUR_OF_DAY, 0);
			dueCalendar.set(Calendar.MINUTE, 0);
			dueCalendar.set(Calendar.SECOND, 0);
			fineOverDays = (int) ChronoUnit.DAYS.between(dueCalendar.toInstant(), nowCalendar.toInstant());
			fineOverDays = fineOverDays < 1 ? 0 : fineOverDays;
			txtFineOverdays.setText(String.valueOf(fineOverDays));
			if (fineOverDays > 0) {
				txtFineInterest.setText(Common.formatNumber(fine.getFineInterest() * 100) + " %");
			} else {
				txtFineInterest.setText("-");
			}
			fineAmount = loanAndFineHistory.getPaymentAmount() * fineOverDays * fine.getFineInterest();
			txtFineAmount.setText(Common.formatNumber(fineAmount));
			txtTotalPayment.setText(Common.formatNumber(fineAmount + loanAndFineHistory.getPaymentAmount()));
			txtDescription.setText("");
			initPaymentMethodValue();
		}
	}

	private void initPaymentMethodValue() {
		PaymentMethodModel paymentMethodModel = new PaymentMethodModel();
		DefaultComboBoxModel<PaymentMethod> model = new DefaultComboBoxModel<>();
		for (PaymentMethod paymentMethod : paymentMethodModel.getAllPaymentMethods()) {
			model.addElement(paymentMethod);
		}
		cbbxPaymentMethod.setModel(model);
		cbbxPaymentMethod.setRenderer(new PaymentListCellRenderer());

	}

	private class PaymentListCellRenderer extends DefaultListCellRenderer {

		@Override
		public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
				boolean cellHasFocus) {
			PaymentMethod item = (PaymentMethod) value;
			return super.getListCellRendererComponent(list, item.getName(), index, isSelected, cellHasFocus);
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
					txtLoanAmount.setForeground(Color.BLACK);
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
		if (loanAndFineHistory.isStatus()) {
			this.dispose();
		} else {
			if (JOptionPane.showConfirmDialog(null, "Are you sure you want to cancel?", "Confirm",
					JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
				this.dispose();
			}
		}

	}
}
