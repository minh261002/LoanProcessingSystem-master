package com.aptech.LoanProcessingSystem.view.admin;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.aptech.LoanProcessingSystem.entities.Account;
import com.aptech.LoanProcessingSystem.entities.Customer;
import com.aptech.LoanProcessingSystem.entities.Loan;
import com.aptech.LoanProcessingSystem.entities.LoanType;
import com.aptech.LoanProcessingSystem.entities.PaymentType;
import com.aptech.LoanProcessingSystem.model.CustomerModel;
import com.aptech.LoanProcessingSystem.model.LoanModel;
import com.aptech.LoanProcessingSystem.model.LoanTypeModel;
import com.aptech.LoanProcessingSystem.model.PaymentTypeModel;
import com.aptech.LoanProcessingSystem.service.ShareData;
import com.toedter.calendar.JDateChooser;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
import java.awt.Insets;

public class jpanelAddNewLoan extends JPanel {
	private JTextField txtCustomerID;
	private JTextField txtAmount;
	private JTextField txtDuration;
	private JTextField txtPeriod;
	private JComboBox cbPaymentType;
	private JComboBox cbLoanType;
	private JDateChooser jdatechooserEndDate;
	private JDateChooser jdatechooserDisbursementDate;
	private JScrollPane scrollPane;
	private JCheckBox chkStatus;
	private JButton btnAdd;
	private JTextArea textArea;

	/**
	 * Create the panel.
	 */
	public jpanelAddNewLoan() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		{
			JPanel panel = new JPanel();
			FlowLayout flowLayout = (FlowLayout) panel.getLayout();
			flowLayout.setVgap(30);
			panel.setBackground(new Color(21, 25, 28));
			add(panel);
			{
				JLabel lblNewLabel = new JLabel("");
				lblNewLabel.setFont(new Font("Dialog", Font.PLAIN, 30));
				lblNewLabel.setIcon(new ImageIcon(jpanelAddNewLoan.class
						.getResource("/com/aptech/LoanProcessingSystem/images/icons8_add_tab_20px_1.png")));
				panel.add(lblNewLabel);
			}
			{
				JLabel lblNewLabel_1 = new JLabel("Add New Loan");
				lblNewLabel_1.setForeground(Color.WHITE);
				lblNewLabel_1.setFont(new Font("Dialog", Font.PLAIN, 30));
				panel.add(lblNewLabel_1);
			}
		}
		{
			JPanel panel = new JPanel();
			panel.setBackground(new Color(34,40,44));
			add(panel);
			panel.setLayout(new BorderLayout(0, 0));
			{
				JPanel panel_1 = new JPanel();
				panel_1.setBackground(new Color(34, 40, 44));
				panel.add(panel_1, BorderLayout.CENTER);
				panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));
				{
					JPanel panel_2 = new JPanel();
					panel_2.setBackground(new Color(34,40,44));
					panel_1.add(panel_2);
					panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.Y_AXIS));
					{
						JPanel panel_3 = new JPanel();
						panel_3.setBackground(new Color(34,40,44));
						panel_2.add(panel_3);
						panel_3.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 50));
						{
							JLabel lblNewLabel_2 = new JLabel("Customer ID");
							lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
							lblNewLabel_2.setBorder(new EmptyBorder(0, 200, 0, 0));
							lblNewLabel_2.setForeground(Color.WHITE);
							panel_3.add(lblNewLabel_2);
						}
					}
					{
						JPanel panel_3 = new JPanel();
						FlowLayout flowLayout = (FlowLayout) panel_3.getLayout();
						flowLayout.setAlignment(FlowLayout.LEFT);
						flowLayout.setVgap(50);
						panel_3.setBackground(new Color(34,40,44));
						panel_2.add(panel_3);
						{
							JLabel lblNewLabel_2_1 = new JLabel("Payment Type");
							lblNewLabel_2_1.setBorder(new EmptyBorder(0, 200, 0, 0));
							lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
							lblNewLabel_2_1.setForeground(Color.WHITE);
							panel_3.add(lblNewLabel_2_1);
						}
					}
					{
						JPanel panel_3 = new JPanel();
						FlowLayout flowLayout = (FlowLayout) panel_3.getLayout();
						flowLayout.setAlignment(FlowLayout.LEFT);
						flowLayout.setVgap(50);
						panel_3.setBackground(new Color(34,40,44));
						panel_2.add(panel_3);
						{
							JLabel lblNewLabel_2_1 = new JLabel("Amount");
							lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
							lblNewLabel_2_1.setBorder(new EmptyBorder(0, 200, 0, 0));
							lblNewLabel_2_1.setForeground(Color.WHITE);
							panel_3.add(lblNewLabel_2_1);
						}
					}
					{
						JPanel panel_3 = new JPanel();
						FlowLayout flowLayout = (FlowLayout) panel_3.getLayout();
						flowLayout.setAlignment(FlowLayout.LEFT);
						flowLayout.setVgap(50);
						panel_3.setBackground(new Color(34,40,44));
						panel_2.add(panel_3);
						{
							JLabel lblNewLabel_2_1 = new JLabel("Duration");
							lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
							lblNewLabel_2_1.setBorder(new EmptyBorder(0, 200, 0, 0));
							lblNewLabel_2_1.setForeground(Color.WHITE);
							panel_3.add(lblNewLabel_2_1);
						}
					}
					{
						JPanel panel_3 = new JPanel();
						FlowLayout flowLayout = (FlowLayout) panel_3.getLayout();
						flowLayout.setAlignment(FlowLayout.LEFT);
						flowLayout.setVgap(50);
						panel_3.setBackground(new Color(34,40,44));
						panel_2.add(panel_3);
						{
							JLabel lblNewLabel_2_1 = new JLabel("Loan Type");
							lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
							lblNewLabel_2_1.setBorder(new EmptyBorder(0, 200, 0, 0));
							lblNewLabel_2_1.setForeground(Color.WHITE);
							panel_3.add(lblNewLabel_2_1);
						}
					}
				}
				{
					JPanel panel_2 = new JPanel();
					panel_2.setBackground(new Color(34,40,44));
					panel_1.add(panel_2);
					panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.Y_AXIS));
					{
						JPanel panel_3 = new JPanel();
						panel_3.setBackground(new Color(34,40,44));
						FlowLayout flowLayout = (FlowLayout) panel_3.getLayout();
						flowLayout.setAlignment(FlowLayout.LEFT);
						flowLayout.setVgap(50);
						panel_2.add(panel_3);
						{
							txtCustomerID = new JTextField();
							panel_3.add(txtCustomerID);
							txtCustomerID.setFont(new Font("Tahoma", Font.PLAIN, 20));
							txtCustomerID.setColumns(15);
						}
					}
					{
						JPanel panel_3 = new JPanel();
						panel_3.setBackground(new Color(34,40,44));
						FlowLayout flowLayout = (FlowLayout) panel_3.getLayout();
						flowLayout.setAlignment(FlowLayout.LEFT);
						flowLayout.setVgap(50);
						panel_2.add(panel_3);
						{
							cbPaymentType = new JComboBox();
							panel_3.add(cbPaymentType);
							cbPaymentType.setFont(new Font("Tahoma", Font.PLAIN, 20));
						}
					}
					{
						JPanel panel_3 = new JPanel();
						panel_3.setBackground(new Color(34,40,44));
						FlowLayout flowLayout = (FlowLayout) panel_3.getLayout();
						flowLayout.setAlignment(FlowLayout.LEFT);
						flowLayout.setVgap(50);
						panel_2.add(panel_3);
						{
							txtAmount = new JTextField();
							panel_3.add(txtAmount);
							txtAmount.setFont(new Font("Tahoma", Font.PLAIN, 20));
							txtAmount.setColumns(15);
						}
					}
					{
						JPanel panel_3 = new JPanel();
						panel_3.setBackground(new Color(34,40,44));
						FlowLayout flowLayout = (FlowLayout) panel_3.getLayout();
						flowLayout.setAlignment(FlowLayout.LEFT);
						flowLayout.setVgap(50);
						panel_2.add(panel_3);
						{
							txtDuration = new JTextField();
							panel_3.add(txtDuration);
							txtDuration.addFocusListener(new FocusAdapter() {
								@Override
								public void focusLost(FocusEvent e) {
									txtDuration_focusLost(e);
								}
							});
							txtDuration.setFont(new Font("Tahoma", Font.PLAIN, 20));
							txtDuration.setColumns(15);
						}
					}
					{
						JPanel panel_3 = new JPanel();
						panel_3.setBackground(new Color(34,40,44));
						FlowLayout flowLayout = (FlowLayout) panel_3.getLayout();
						flowLayout.setAlignment(FlowLayout.LEFT);
						flowLayout.setVgap(50);
						panel_2.add(panel_3);
						{
							cbLoanType = new JComboBox();
							panel_3.add(cbLoanType);
							cbLoanType.setFont(new Font("Tahoma", Font.PLAIN, 20));
						}
					}
				}
				{
					JPanel panel_2 = new JPanel();
					panel_2.setBackground(new Color(34,40,44));
					panel_1.add(panel_2);
					panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.Y_AXIS));
					{
						JPanel panel_3 = new JPanel();
						FlowLayout flowLayout = (FlowLayout) panel_3.getLayout();
						flowLayout.setAlignment(FlowLayout.LEFT);
						flowLayout.setVgap(50);
						panel_3.setBackground(new Color(34,40,44));
						panel_2.add(panel_3);
						{
							JLabel lblNewLabel_2_1 = new JLabel("Period");
							lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
							lblNewLabel_2_1.setBorder(new EmptyBorder(0, 200, 0, 0));
							lblNewLabel_2_1.setForeground(Color.WHITE);
							panel_3.add(lblNewLabel_2_1);
						}
					}
					{
						JPanel panel_3 = new JPanel();
						FlowLayout flowLayout = (FlowLayout) panel_3.getLayout();
						flowLayout.setAlignment(FlowLayout.LEFT);
						flowLayout.setVgap(50);
						panel_3.setBackground(new Color(34,40,44));
						panel_2.add(panel_3);
						{
							JLabel lblNewLabel_2_1 = new JLabel("End Date");
							lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
							lblNewLabel_2_1.setBorder(new EmptyBorder(0, 200, 0, 0));
							lblNewLabel_2_1.setForeground(Color.WHITE);
							panel_3.add(lblNewLabel_2_1);
						}
					}
					{
						JPanel panel_3 = new JPanel();
						FlowLayout flowLayout = (FlowLayout) panel_3.getLayout();
						flowLayout.setAlignment(FlowLayout.LEFT);
						flowLayout.setVgap(50);
						panel_3.setBackground(new Color(34,40,44));
						panel_2.add(panel_3);
						{
							JLabel lblNewLabel_2_1 = new JLabel("Disbursement Date");
							lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
							lblNewLabel_2_1.setBorder(new EmptyBorder(0, 200, 0, 0));
							lblNewLabel_2_1.setForeground(Color.WHITE);
							panel_3.add(lblNewLabel_2_1);
						}
					}
					{
						JPanel panel_3 = new JPanel();
						FlowLayout flowLayout = (FlowLayout) panel_3.getLayout();
						flowLayout.setAlignment(FlowLayout.LEFT);
						flowLayout.setVgap(50);
						panel_3.setBackground(new Color(34,40,44));
						panel_2.add(panel_3);
						{
							JLabel lblNewLabel_2_1 = new JLabel("Description");
							lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
							lblNewLabel_2_1.setBorder(new EmptyBorder(0, 200, 0, 0));
							lblNewLabel_2_1.setForeground(Color.WHITE);
							panel_3.add(lblNewLabel_2_1);
						}
					}
					{
						JPanel panel_3 = new JPanel();
						FlowLayout flowLayout = (FlowLayout) panel_3.getLayout();
						flowLayout.setAlignment(FlowLayout.LEFT);
						flowLayout.setVgap(50);
						panel_3.setBackground(new Color(34,40,44));
						panel_2.add(panel_3);
						{
							JLabel lblNewLabel_2_1 = new JLabel("Status");
							lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
							lblNewLabel_2_1.setBorder(new EmptyBorder(0, 200, 0, 0));
							lblNewLabel_2_1.setForeground(Color.WHITE);
							panel_3.add(lblNewLabel_2_1);
						}
					}
				}
				{
					JPanel panel_2 = new JPanel();
					panel_2.setBackground(new Color(34,40,44));
					panel_1.add(panel_2);
					panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.Y_AXIS));
					{
						JPanel panel_3 = new JPanel();
						panel_3.setBackground(new Color(34,40,44));
						FlowLayout flowLayout = (FlowLayout) panel_3.getLayout();
						flowLayout.setAlignment(FlowLayout.LEFT);
						flowLayout.setVgap(50);
						panel_2.add(panel_3);
						{
							txtPeriod = new JTextField();
							panel_3.add(txtPeriod);
							txtPeriod.setFont(new Font("Tahoma", Font.PLAIN, 20));
							txtPeriod.setColumns(15);
						}
					}
					{
						JPanel panel_3 = new JPanel();
						panel_3.setBackground(new Color(34,40,44));
						FlowLayout flowLayout = (FlowLayout) panel_3.getLayout();
						flowLayout.setAlignment(FlowLayout.LEFT);
						flowLayout.setVgap(50);
						panel_2.add(panel_3);
						{
							jdatechooserEndDate = new JDateChooser();
							jdatechooserEndDate.setPreferredSize(new Dimension(264, 35));
							panel_3.add(jdatechooserEndDate);
							jdatechooserEndDate.setBackground(new Color(34,40,44));
						}
					}
					{
						JPanel panel_3 = new JPanel();
						panel_3.setBackground(new Color(34,40,44));
						FlowLayout flowLayout = (FlowLayout) panel_3.getLayout();
						flowLayout.setAlignment(FlowLayout.LEFT);
						flowLayout.setVgap(50);
						panel_2.add(panel_3);
						{
							jdatechooserDisbursementDate = new JDateChooser();
							jdatechooserDisbursementDate.setPreferredSize(new Dimension(264, 35));
							panel_3.add(jdatechooserDisbursementDate);
						}
					}
					{
						JPanel panel_3 = new JPanel();
						panel_3.setBackground(new Color(34,40,44));
						FlowLayout flowLayout = (FlowLayout) panel_3.getLayout();
						flowLayout.setAlignment(FlowLayout.LEFT);
						flowLayout.setVgap(15);
						panel_2.add(panel_3);
						{
							scrollPane = new JScrollPane();
							panel_3.add(scrollPane);
							{
								textArea = new JTextArea();
								textArea.setPreferredSize(new Dimension(300, 100));
								scrollPane.setViewportView(textArea);
							}
						}
					}
					{
						JPanel panel_3 = new JPanel();
						panel_3.setBackground(new Color(34,40,44));
						FlowLayout flowLayout = (FlowLayout) panel_3.getLayout();
						flowLayout.setAlignment(FlowLayout.LEFT);
						flowLayout.setVgap(45);
						panel_2.add(panel_3);
						{
							chkStatus = new JCheckBox("Public");
							chkStatus.setBackground(new Color(34, 40, 44));
							panel_3.add(chkStatus);
							chkStatus.setFont(new Font("Tahoma", Font.PLAIN, 20));
							chkStatus.setForeground(Color.WHITE);
						}
					}
				}
			}
		}
		{
			JPanel panel = new JPanel();
			FlowLayout flowLayout = (FlowLayout) panel.getLayout();
			flowLayout.setVgap(30);
			panel.setBackground(new Color(34,40,44));
			add(panel);
			{
				btnAdd = new JButton("Add");
				btnAdd.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						btnAdd_actionPerformed(e);
					}
				});
				btnAdd.setPreferredSize(new Dimension(120, 40));
				panel.add(btnAdd);
			}
		}
		cbLoanType_FillToJComboBox();
		cbPaymentTypt_FillToJComboBox();
	}
	
	public void btnAdd_actionPerformed(ActionEvent e) {
		if (validation().isEmpty()) {
			LoanType loanType = (LoanType) cbLoanType.getSelectedItem();
			PaymentType paymentType = (PaymentType) cbPaymentType.getSelectedItem();
			Loan loan = new Loan();
			loan.setLoanTypeId(loanType.getId());
			loan.setAccountId(ShareData.accountLogin.getId());
			loan.setCustomerId(Integer.parseInt(txtCustomerID.getText().trim()));
			loan.setPaymentTypeId(paymentType.getId());
			loan.setAmount(Double.parseDouble(txtAmount.getText().trim()));
			loan.setPeriod(Integer.parseInt(txtPeriod.getText().trim()));
			loan.setCreateDate(new java.util.Date());
			loan.setDisbursementDate(jdatechooserDisbursementDate.getDate());
			loan.setDuration(Integer.parseInt(txtDuration.getText().trim()));
			loan.setEndDate(jdatechooserEndDate.getDate());
			loan.setInterest(loanType.getInterest());
			loan.setDescription(textArea.getText().trim());
			loan.setStatus(chkStatus.isSelected() ? 1 : 0);
			LoanModel loanModel = new LoanModel();
			if (loanModel.create(loan)) {
				JOptionPane.showMessageDialog(null, "Done");
				JPanel jpanelMain = (JPanel) this.getParent();
				jpanelMain.removeAll();
				jpanelMain.revalidate();
				jpanelLoadData data = new jpanelLoadData();
				jpanelMain.add(data);
				data.setVisible(true);
			} else {
				JOptionPane.showMessageDialog(null, "Failed");
			}
		} else {
			JOptionPane.showMessageDialog(null, validation());
		}
	}
	
	public jpanelAddNewLoan(int customerID) {
		this();
		txtCustomerID.setText(String.valueOf(customerID));
		txtCustomerID.setEditable(false);
	}

	public String validation() {
		String errorMsg = "";
		if (!checkCustomerIDExisted()) {
//			if (!errorMsg.isEmpty()) {
//				errorMsg += "\n";
//			}
			errorMsg += "This customer ID does not existed!!";
		}

		if (!checkDisbursementDate()) {
			if (!errorMsg.isEmpty()) {
				errorMsg += "\n";
			}
			errorMsg += "The disbursment date must larger than today!!";
		}

		if (!checkPeriod()) {
			if (!errorMsg.isEmpty()) {
				errorMsg += "\n";
			}
			errorMsg += "Period can not larger than duration!!";
		}

		if (!checkAmount()) {
			if (!errorMsg.isEmpty()) {
				errorMsg += "\n";
			}
			errorMsg += "The amount must be larger than 1000000!!";
		}

		if (txtCustomerID.getText().trim().isEmpty() || txtAmount.getText().trim().isEmpty()
				|| txtDuration.getText().trim().isEmpty() || txtPeriod.getText().trim().isEmpty()
				|| jdatechooserDisbursementDate.getDate() == null) {
			if (!errorMsg.isEmpty()) {
				errorMsg += "\n";
			}
			errorMsg += "Please finish all information!!";
		}
		return errorMsg;
	}
	
	public void txtDuration_focusLost(FocusEvent e) {
		countEndDate();
	}

	public void countEndDate() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/YYYY");
		Calendar now = Calendar.getInstance();
		int i = Integer.parseInt(txtDuration.getText().trim());
		now.add(Calendar.MONTH, i);
		jdatechooserEndDate.setDate(now.getTime());
	}

	public boolean checkDisbursementDate() {
		Calendar calendar = Calendar.getInstance();
		return jdatechooserDisbursementDate.getDate().after(calendar.getTime());
	}

	public boolean checkAmount() {
		return Double.parseDouble(txtAmount.getText().trim()) > 1000000;
	}

	public boolean checkPeriod() {
		return Integer.parseInt(txtPeriod.getText().trim()) < Integer.parseInt(txtDuration.getText().trim());
	}

	public boolean checkCustomerIDExisted() {
		CustomerModel customer = new CustomerModel();
		return customer.findById(Integer.parseInt(txtCustomerID.getText().trim())) != null;
	}

	public void cbLoanType_FillToJComboBox() {
		DefaultComboBoxModel<LoanType> boxModel = new DefaultComboBoxModel<LoanType>();
		LoanTypeModel loanTypeModel = new LoanTypeModel();
		for (LoanType loanType : loanTypeModel.loadAllLoanType()) {
			boxModel.addElement(loanType);
		}
		cbLoanType.setModel(boxModel);
		cbLoanType.setRenderer(new cbLoanTypeCellRender());
	}

	public class cbLoanTypeCellRender extends DefaultListCellRenderer {

		@Override
		public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
				boolean cellHasFocus) {
			LoanType loanType = (LoanType) value;
			return super.getListCellRendererComponent(list, loanType.getName(), index, isSelected, cellHasFocus);
		}
	}

	public void cbPaymentTypt_FillToJComboBox() {
		DefaultComboBoxModel<PaymentType> boxModel = new DefaultComboBoxModel<PaymentType>();
		PaymentTypeModel paymentTypeModel = new PaymentTypeModel();
		for (PaymentType paymentType : paymentTypeModel.getAllPaymentTypes()) {
			boxModel.addElement(paymentType);
		}
		cbPaymentType.setModel(boxModel);
		cbPaymentType.setRenderer(new cbPaymentTypt_CellRender());
	}

	public class cbPaymentTypt_CellRender extends DefaultListCellRenderer {
		@Override
		public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
				boolean cellHasFocus) {
			PaymentType paymentType = (PaymentType) value;
			return super.getListCellRendererComponent(list, paymentType.getName(), index, isSelected, cellHasFocus);
		}

	}

}
