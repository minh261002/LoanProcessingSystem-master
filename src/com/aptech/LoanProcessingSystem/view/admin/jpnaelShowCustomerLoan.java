package com.aptech.LoanProcessingSystem.view.admin;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import com.aptech.LoanProcessingSystem.entities.Customer;
import com.aptech.LoanProcessingSystem.entities.Loan;
import com.aptech.LoanProcessingSystem.entities.LoanAndFineHistory;
import com.aptech.LoanProcessingSystem.model.AccountModel;
import com.aptech.LoanProcessingSystem.model.CustomerModel;
import com.aptech.LoanProcessingSystem.model.LoanAndFineHistoryModel;
import com.aptech.LoanProcessingSystem.model.LoanModel;
import com.aptech.LoanProcessingSystem.model.LoanTypeModel;
import com.aptech.LoanProcessingSystem.model.PaymentTypeModel;
import com.aptech.LoanProcessingSystem.view.CreateLoan;

public class jpnaelShowCustomerLoan extends JPanel {
	private JTable tblLoanDetail;
	private JLabel lblId;
	private JLabel lblName;
	private JLabel lblAddress;
	private JLabel lblPhone;
	private JLabel lblCompany;
	private JLabel lblIDCard;
	private JLabel lblJob;
	private JLabel lblSalary;
	private JLabel lblDOB;
	private JLabel lblGender;
	private JLabel lblEmail;
	private Customer customer = new Customer();

	/**
	 * Create the panel.
	 */
	public jpnaelShowCustomerLoan() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		{
			JPanel panel = new JPanel();
			panel.setBackground(new Color(21, 25, 28));
			FlowLayout flowLayout = (FlowLayout) panel.getLayout();
			flowLayout.setAlignment(FlowLayout.LEFT);
			add(panel);
			{
				JLabel lblNewLabel = new JLabel("View Customer");
				lblNewLabel.setForeground(SystemColor.text);
				lblNewLabel.setBorder(new EmptyBorder(0, 10, 0, 0));
				lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
				panel.add(lblNewLabel);
			}
		}
		{
			JPanel panel = new JPanel();
			panel.setBackground(new Color(34, 40, 44));
			add(panel);
			panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
			{
				JPanel panel_1 = new JPanel();
				panel.add(panel_1);
				panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.Y_AXIS));
				{
					JPanel panel_2 = new JPanel();
					panel_2.setBackground(new Color(34, 40, 44));
					panel_1.add(panel_2);
					{
						JLabel lblNewLabel_1 = new JLabel("ID:");
						lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
						lblNewLabel_1.setForeground(SystemColor.text);
						panel_2.add(lblNewLabel_1);
					}
					{
						lblId = new JLabel("New label");
						lblId.setFont(new Font("Tahoma", Font.PLAIN, 16));
						lblId.setForeground(SystemColor.text);
						panel_2.add(lblId);
					}
				}
				{
					JPanel panel_2 = new JPanel();
					panel_2.setBackground(new Color(34, 40, 44));
					panel_1.add(panel_2);
					{
						JLabel lblNewLabel_1 = new JLabel("Name:");
						lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
						lblNewLabel_1.setForeground(SystemColor.text);
						panel_2.add(lblNewLabel_1);
					}
					{
						lblName = new JLabel("New label");
						lblName.setFont(new Font("Tahoma", Font.PLAIN, 16));
						lblName.setForeground(SystemColor.text);
						panel_2.add(lblName);
					}
				}
				{
					JPanel panel_2 = new JPanel();
					panel_2.setBackground(new Color(34, 40, 44));
					panel_1.add(panel_2);
					{
						JLabel lblNewLabel_1 = new JLabel("Address:");
						lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
						lblNewLabel_1.setForeground(SystemColor.text);
						panel_2.add(lblNewLabel_1);
					}
					{
						lblAddress = new JLabel("New label");
						lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 16));
						lblAddress.setForeground(SystemColor.text);
						panel_2.add(lblAddress);
					}
				}
				{
					JPanel panel_2 = new JPanel();
					panel_2.setBackground(new Color(34, 40, 44));
					panel_1.add(panel_2);
					{
						JButton btnAddLoan = new JButton("Add Loan");
						btnAddLoan.addActionListener(new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent e) {
								btnAddLoan_actionPerformed(e);

							}
						});
						panel_2.add(btnAddLoan);
					}
				}
			}
			{
				JPanel panel_1 = new JPanel();
				panel_1.setBackground(new Color(34, 40, 44));
				panel.add(panel_1);
				panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.Y_AXIS));
				{
					JPanel panel_2 = new JPanel();
					panel_2.setBackground(new Color(34, 40, 44));
					panel_1.add(panel_2);
					{
						JLabel lblNewLabel_1 = new JLabel("Phone:");
						lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
						lblNewLabel_1.setForeground(SystemColor.text);
						panel_2.add(lblNewLabel_1);
					}
					{
						lblPhone = new JLabel("New label");
						lblPhone.setFont(new Font("Tahoma", Font.PLAIN, 16));
						lblPhone.setForeground(SystemColor.text);
						panel_2.add(lblPhone);
					}
				}
				{
					JPanel panel_2 = new JPanel();
					panel_2.setBackground(new Color(34, 40, 44));
					panel_1.add(panel_2);
					{
						JLabel lblNewLabel_1 = new JLabel("Email:");
						lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
						lblNewLabel_1.setForeground(SystemColor.text);
						panel_2.add(lblNewLabel_1);
					}
					{
						lblEmail = new JLabel("New label");
						lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
						lblEmail.setForeground(SystemColor.text);
						panel_2.add(lblEmail);
					}
				}
				{
					JPanel panel_2 = new JPanel();
					panel_2.setBackground(new Color(34, 40, 44));
					panel_1.add(panel_2);
					{
						JLabel lblNewLabel_1 = new JLabel("Gender:");
						lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
						lblNewLabel_1.setForeground(SystemColor.text);
						panel_2.add(lblNewLabel_1);
					}
					{
						lblGender = new JLabel("New label");
						lblGender.setFont(new Font("Tahoma", Font.PLAIN, 16));
						lblGender.setForeground(SystemColor.text);
						panel_2.add(lblGender);
					}
				}
				{
					JPanel panel_2 = new JPanel();
					panel_2.setBackground(new Color(34, 40, 44));
					panel_1.add(panel_2);
					{
						JLabel lblNewLabel_1 = new JLabel("DOB:");
						lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
						lblNewLabel_1.setForeground(SystemColor.text);
						panel_2.add(lblNewLabel_1);
					}
					{
						lblDOB = new JLabel("New label");
						lblDOB.setFont(new Font("Tahoma", Font.PLAIN, 16));
						lblDOB.setForeground(SystemColor.text);
						panel_2.add(lblDOB);
					}
				}
			}
			{
				JPanel panel_1 = new JPanel();
				panel_1.setBackground(new Color(34, 40, 44));
				panel.add(panel_1);
				panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.Y_AXIS));
				{
					JPanel panel_2 = new JPanel();
					panel_2.setBackground(new Color(34, 40, 44));
					panel_1.add(panel_2);
					{
						JLabel lblNewLabel_1 = new JLabel("Salary:");
						lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
						lblNewLabel_1.setForeground(SystemColor.text);
						panel_2.add(lblNewLabel_1);
					}
					{
						lblSalary = new JLabel("New label");
						lblSalary.setFont(new Font("Tahoma", Font.PLAIN, 16));
						lblSalary.setForeground(SystemColor.text);
						panel_2.add(lblSalary);
					}
				}
				{
					JPanel panel_2 = new JPanel();
					panel_2.setBackground(new Color(34, 40, 44));
					panel_1.add(panel_2);
					{
						JLabel lblNewLabel_1 = new JLabel("Job:");
						lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
						lblNewLabel_1.setForeground(SystemColor.text);
						panel_2.add(lblNewLabel_1);
					}
					{
						lblJob = new JLabel("New label");
						lblJob.setFont(new Font("Tahoma", Font.PLAIN, 16));
						lblJob.setForeground(SystemColor.text);
						panel_2.add(lblJob);
					}
				}
				{
					JPanel panel_2 = new JPanel();
					panel_2.setBackground(new Color(34, 40, 44));
					panel_1.add(panel_2);
					{
						JLabel lblNewLabel_1 = new JLabel("Company:");
						lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
						lblNewLabel_1.setForeground(SystemColor.text);
						panel_2.add(lblNewLabel_1);
					}
					{
						lblCompany = new JLabel("New label");
						lblCompany.setFont(new Font("Tahoma", Font.PLAIN, 16));
						lblCompany.setForeground(SystemColor.text);
						panel_2.add(lblCompany);
					}
				}
				{
					JPanel panel_2 = new JPanel();
					panel_2.setBackground(new Color(34, 40, 44));
					panel_1.add(panel_2);
					{
						JLabel lblNewLabel_1 = new JLabel("ID Card:");
						lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
						lblNewLabel_1.setForeground(SystemColor.text);
						panel_2.add(lblNewLabel_1);
					}
					{
						lblIDCard = new JLabel("New label");
						lblIDCard.setFont(new Font("Tahoma", Font.PLAIN, 16));
						lblIDCard.setForeground(SystemColor.text);
						panel_2.add(lblIDCard);
					}
				}
			}
		}
		{
			JPanel panel = new JPanel();
			panel.setBackground(SystemColor.controlDkShadow);
			add(panel);
			panel.setLayout(new BorderLayout(0, 0));
			{
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBackground(SystemColor.controlText);
				panel.add(scrollPane, BorderLayout.CENTER);
				{
					tblLoanDetail = new JTable();
					tblLoanDetail.setFont(new Font("Tahoma", Font.PLAIN, 14));
					tblLoanDetail.setRowHeight(30);
					tblLoanDetail.setBackground(new Color(34, 40, 44));
					tblLoanDetail.setForeground(SystemColor.text);
					scrollPane.setViewportView(tblLoanDetail);
				}
			}
		}
		LoanModel loanModel = new LoanModel();
		FillDataToJTable(loanModel.getAllLoansByCustomerID(this.customer.getId()), tblLoanDetail);
	}

	public jpnaelShowCustomerLoan(Customer customer) {
		this();
		this.customer = customer;
		loadData();
		LoanModel loanModel = new LoanModel();
		FillDataToJTable(loanModel.getAllLoansByCustomerID(this.customer.getId()), tblLoanDetail);
	}

	public void btnAddLoan_actionPerformed(ActionEvent e) {
		CreateLoan createLoan = new CreateLoan(this.customer.getId());
		createLoan.setVisible(true);
	}

	private void loadData() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/YYYY");
		lblId.setText(String.valueOf(this.customer.getId()));
		lblName.setText(this.customer.getName());
		lblAddress.setText(this.customer.getAddress());
		lblCompany.setText(this.customer.getCompany());
		lblEmail.setText(this.customer.getEmail());
		lblIDCard.setText(this.customer.getIdentityCard());
		lblJob.setText(this.customer.getJob());
		lblGender.setText(this.customer.isGender() ? "Male" : "Female");
		lblDOB.setText(dateFormat.format(this.customer.getDob()));
		lblPhone.setText(this.customer.getPhone());
		lblSalary.setText(String.valueOf(this.customer.getSalary()));
	}

	public void FillDataToJTable(List<Loan> loanList, JTable tableLoan) {
		String statusMask = "";
		DefaultTableModel defaultTableModel = new DefaultTableModel() {

			@Override
			public boolean isCellEditable(int row, int column) {
				return super.isCellEditable(row, column);
			}

		};
		defaultTableModel.addColumn("Customer ID");
		defaultTableModel.addColumn("Id");
		defaultTableModel.addColumn("Loan Type");
		defaultTableModel.addColumn("Interest");
		defaultTableModel.addColumn("Employee ID");
		defaultTableModel.addColumn("Customer");
		defaultTableModel.addColumn("Payment Type");
		defaultTableModel.addColumn("Amount");
		defaultTableModel.addColumn("Period");
		defaultTableModel.addColumn("Duration");
		defaultTableModel.addColumn("Date Created");
		defaultTableModel.addColumn("Date Disbursement");
		defaultTableModel.addColumn("Date End");
		defaultTableModel.addColumn("Description");
		defaultTableModel.addColumn("Status");
		defaultTableModel.addColumn("View/Modify");
		for (Loan loan : loanList) {
			if (loan.getStatus() == 0) {
				statusMask = "New";
			} else if (loan.getStatus() == 1) {
				statusMask = "Open";
			} else if (loan.getStatus() == 2) {
				statusMask = "Fully Paid";
			} else if (loan.getStatus() == 3) {
				statusMask = "Stop";
			}
			defaultTableModel.addRow(new Object[] { loan.getCustomerId(), loan.getId(),
					loadLoanTypeName(loan.getLoanTypeId()), loan.getInterest(), loadEmployeeName(loan.getAccountId()),
					loadCustomerName(loan.getCustomerId()), loadPaymentTypeName(loan.getPaymentTypeId()),
					loan.getAmount(), loan.getPeriod(), loan.getDuration(), loan.getCreateDate(),
					loan.getDisbursementDate(), loan.getEndDate(), loan.getDescription(), statusMask, "View" });
		}
		tableLoan.setModel(defaultTableModel);
		tableLoan.removeColumn(tableLoan.getColumnModel().getColumn(0));
		tableLoan.getColumnModel().getColumn(13).setCellRenderer(new LoanTableStatusButtonRenderer());
		tableLoan.getColumnModel().getColumn(13).setCellEditor(new ClientsTableRenderer(new JCheckBox()));
		tableLoan.getColumnModel().getColumn(14).setCellRenderer(new LoanTableViewButtonRenderer());
		tableLoan.getColumnModel().getColumn(14).setCellEditor(new ViewClientsTableRenderer(new JCheckBox()));
		tableLoan.getTableHeader().setReorderingAllowed(false);
		tableLoan.setShowHorizontalLines(true);
		tableLoan.setShowVerticalLines(false);
		defaultTableModel.fireTableDataChanged();
	}

	private String loadLoanTypeName(int id) {
		LoanTypeModel loanTypeModel = new LoanTypeModel();
		return loanTypeModel.loadLoanTypeNameById(id);
	}

	private String loadPaymentTypeName(int id) {
		PaymentTypeModel model = new PaymentTypeModel();
		return model.loadPaymentTypeNameById(id);
	}

	private String loadEmployeeName(int id) {
		String str = "";
		AccountModel accountModel = new AccountModel();
		str = accountModel.loadEmployeeNameByID(id);
		return str;
	}

	private String loadCustomerName(int id) {
		String str = "";
		CustomerModel customerModel = new CustomerModel();
		str = customerModel.findCustomerNameById(id);
		return str;
	}

	private void loadColorOfButton(String returnStatus, String statusNew, String statusOpen, String statusFully,
			String statusStop, JButton status) {
		status.setForeground(SystemColor.WHITE);
		if (returnStatus.equals(statusNew)) {
			status.setBackground(SystemColor.RED);
		} else if (returnStatus.equals(statusOpen)) {
			status.setBackground(SystemColor.GREEN);
		} else if (returnStatus.equals(statusStop)) {
			status.setForeground(SystemColor.BLACK);
			status.setBackground(SystemColor.YELLOW);
		} else if (returnStatus.equals(statusFully)) {
			status.setBackground(SystemColor.BLUE);
		}
	}
	
	private void updateStatusNewToOpen(int id) {
		int a = JOptionPane.showConfirmDialog(null, "Do you want to inspect this loan", "Warning",
				JOptionPane.YES_NO_CANCEL_OPTION);
		if (a == JOptionPane.YES_OPTION) {
			LoanModel loanModel = new LoanModel();
			if (loanModel.accpetLoan(id)) {
				JOptionPane.showMessageDialog(null, "Done");
			} else {
				JOptionPane.showMessageDialog(null, "Fail");
			}
		}
	}
	
	private void createLoanAndFineHistory(int loanId) {
		Loan loan = new LoanModel().loadLoanByID(loanId);
		Double amountDouble = loan.getAmount();
		LoanAndFineHistory loanAndFineHistory = new LoanAndFineHistory();
		loanAndFineHistory.setLoanId(loanId);
		loanAndFineHistory.setPaymentMethodId(1);
		loanAndFineHistory.setPaymentAmount(0);
		loanAndFineHistory.setStatus(false);
		loanAndFineHistory.setFineAmount(0);
		loanAndFineHistory.setFineOverDays(0);
		loanAndFineHistory.setAmount(amountDouble);

		Calendar dueDateCalendar = Calendar.getInstance();
		dueDateCalendar.setTime(loan.getDisbursementDate());

		Calendar disbursementCalendar = Calendar.getInstance();
		disbursementCalendar.setTime(loan.getDisbursementDate());

		double amountInAmount = amountDouble / loan.getDuration();
		double amountLeft = amountDouble;
		int period = loan.getPeriod();
		dueDateCalendar.set(Calendar.MONTH, disbursementCalendar.get(Calendar.MONTH));
		LoanAndFineHistoryModel loanAndFineHistoryModel = new LoanAndFineHistoryModel();
		try {
			for (int i = period; i <= loan.getDuration(); i += period) {
				Date dueDate = dueDateCalendar.getTime();
				double paymentAmount = (amountInAmount + (amountDouble * loan.getInterest()) / 12) * period;
				amountLeft = amountLeft - (amountInAmount * period);
				loanAndFineHistory.setPaymentAmount(paymentAmount);
				loanAndFineHistory.setAmountLeft(Math.abs(amountLeft));
				loanAndFineHistory.setDueDate(dueDate);
				dueDateCalendar.set(Calendar.MONTH, dueDateCalendar.get(Calendar.MONTH) + 1);
				loanAndFineHistoryModel.createLoanAndFineHistory(loanAndFineHistory);
			}
			JOptionPane.showMessageDialog(null, "Successful!");
		} catch (Exception a) {
			JOptionPane.showMessageDialog(null, "Please try again!");
			a.printStackTrace();
		}
	}

	private void callParentPanel(int customerId, int loanId) {
		LoanModel loanModel = new LoanModel();
		Loan loan = loanModel.loadLoanByID(loanId);
		JPanel jpanelMain = (JPanel) this.getParent();
		jpanelMain.removeAll();
		jpanelMain.revalidate();
		CustomerModel customerModel = new CustomerModel();
		jpanelShowLoanDetail detail = new jpanelShowLoanDetail(customerModel.findById(customerId), loan);
		jpanelMain.add(detail);
		detail.setVisible(true);
	}

	class LoanTableStatusButtonRenderer extends JButton implements TableCellRenderer {
		public LoanTableStatusButtonRenderer() {
			setOpaque(true);
		}

		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {
			setForeground(Color.black);
			setBackground(UIManager.getColor("Button.background"));
			setText((value == null) ? "" : value.toString());
			loadColorOfButton(value.toString(), "New", "Open", "Fully Paid", "Stop", this);
			return this;
		}
	}

	public class ClientsTableRenderer extends DefaultCellEditor {
		private JButton button;
		private String label;
		private boolean clicked;
		private int row, col;
		private JTable table;

		public ClientsTableRenderer(JCheckBox checkBox) {
			super(checkBox);
			button = new JButton();
			button.setOpaque(true);
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					fireEditingStopped();
					if (button.getText().equals("New") || button.getText().equals("Stop")) {
						int id = (int) table.getValueAt(row, 0);
						if (button.getText().equals("New")) {
							updateStatusNewToOpen(id);
							createLoanAndFineHistory(id);
							LoanModel loanModel = new LoanModel();
							FillDataToJTable(loanModel.getAllLoansByCustomerID(customer.getId()), table);
						}
						else if (button.getText().equals("Stop")) {
							updateStatusNewToOpen(id);
							LoanModel loanModel = new LoanModel();
							FillDataToJTable(loanModel.getAllLoansByCustomerID(customer.getId()), table);
						}
					}
				}
			});
		}

		public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row,
				int column) {
			this.table = table;
			this.row = row;
			this.col = column;

			button.setForeground(Color.black);
			button.setBackground(UIManager.getColor("Button.background"));
			label = (value == null) ? "" : value.toString();
			button.setText(label);
			clicked = true;
			return button;
		}

		public Object getCellEditorValue() {
			if (clicked) {

			}
			clicked = false;
			return new String(label);
		}

		public boolean stopCellEditing() {
			clicked = false;
			return super.stopCellEditing();
		}

		protected void fireEditingStopped() {
			super.fireEditingStopped();
		}
	}

	class LoanTableViewButtonRenderer extends JButton implements TableCellRenderer {
		public LoanTableViewButtonRenderer() {
			setOpaque(true);
		}

		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {
			setForeground(Color.black);
			setBackground(UIManager.getColor("Button.background"));
			setText((value == null) ? "" : value.toString());
//			loadColorOfButton(value.toString(), "New", "Open", this);
			return this;
		}
	}

	public class ViewClientsTableRenderer extends DefaultCellEditor {
		private JButton button;
		private String label;
		private boolean clicked;
		private int row, col;
		private JTable table;

		public ViewClientsTableRenderer(JCheckBox checkBox) {
			super(checkBox);
			button = new JButton();
			button.setOpaque(true);
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					fireEditingStopped();
					int loanId = (int) table.getValueAt(row, 0);
					int customerId = (int) table.getModel().getValueAt(row, 0);
					callParentPanel(customerId, loanId);
					// adding reload table function
				}
			});
		}

		public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row,
				int column) {
			this.table = table;
			this.row = row;
			this.col = column;

			button.setForeground(Color.black);
			button.setBackground(UIManager.getColor("Button.background"));
			label = (value == null) ? "" : value.toString();
			button.setText(label);
			clicked = true;
			return button;
		}

		public Object getCellEditorValue() {
			if (clicked) {

			}
			clicked = false;
			return new String(label);
		}

		public boolean stopCellEditing() {
			clicked = false;
			return super.stopCellEditing();
		}

		protected void fireEditingStopped() {
			super.fireEditingStopped();
		}
	}
}
