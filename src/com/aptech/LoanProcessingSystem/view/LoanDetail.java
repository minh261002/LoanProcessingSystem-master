package com.aptech.LoanProcessingSystem.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.MessageFormat;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import com.aptech.LoanProcessingSystem.entities.Loan;
import com.aptech.LoanProcessingSystem.entities.LoanAndFineHistory;
import com.aptech.LoanProcessingSystem.model.LoanAndFineHistoryModel;
import com.aptech.LoanProcessingSystem.model.LoanModel;
import com.aptech.LoanProcessingSystem.service.Common;
import com.aptech.LoanProcessingSystem.service.MessageDialog;

@SuppressWarnings("serial")
public class LoanDetail extends JPanel {

	private Home mainForm;
	private DefaultTableModel tblModel = new DefaultTableModel();
	private JTable table;
	private JTextField txtSearch;
	private String loanPage = "LOAN_PAGE";
	private String historyPage = "HISTORY_PAGE";
	private String pageState = loanPage;
	private JButton btnBack;
	private JButton btnDetail;
	private String hintSearch = "Please enter customer name!";
	private int loanSelectedId;
	private JLabel txtHeader;
	private JButton btnSearch;
	private JButton btnRefesh;
	private JButton btnPayment;
	private JPanel panel_4;
	private JPanel panel_5;
	private JButton btnNextLong;
	private JButton btnNextShort;
	private JButton btnBackShort;
	private JButton btnBackLong;
	private JTextField textField_1;
	private int currentPageIndex = 1;
	private final int itemsPerPage = 20;
	private int maxPageIndex;
	private final TableRowSorter<TableModel> sorter1 = new TableRowSorter<TableModel>(tblModel);
	private JButton btnDelete;

	public LoanDetail() {
		initComponents();
		loadLoanToTable(new LoanModel().findAllActive());
	}

	/**
	 * Create the panel.
	 * 
	 * @return
	 */
	public void initComponents() {

		setBackground(new Color(112, 128, 144));
		setLayout(new BorderLayout(0, 0));

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(UIManager.getColor("Button.shadow"));
		add(panel_3, BorderLayout.NORTH);

		txtHeader = new JLabel("Loan List");
		txtHeader.setBackground(UIManager.getColor("Button.shadow"));
		txtHeader.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 24));
		txtHeader.setHorizontalTextPosition(SwingConstants.CENTER);
		txtHeader.setHorizontalAlignment(SwingConstants.CENTER);
		txtHeader.setPreferredSize(new Dimension(1000, 40));
		txtHeader.setMaximumSize(new Dimension(2000, 100));
		panel_3.add(txtHeader);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(new Color(112, 128, 144));
		add(scrollPane);

		table = new JTable();
		table.setIntercellSpacing(new Dimension(10, 1));
		table.setRequestFocusEnabled(false);
		table.setRowHeight(30);
		table.setForeground(Color.BLACK);
		table.setBackground(new Color(112, 128, 144));
		table.getTableHeader().setOpaque(false);
		table.getTableHeader().setBackground(Color.darkGray);
		table.getTableHeader().setForeground(Color.lightGray);
		Font bigFont = new Font("sansserif", Font.BOLD, 17);
		table.getTableHeader().setFont(bigFont);
		scrollPane.setViewportView(table);

		panel_4 = new JPanel();
		add(panel_4, BorderLayout.SOUTH);
		panel_4.setLayout(new BorderLayout(0, 0));

		panel_5 = new JPanel();
		panel_4.add(panel_5, BorderLayout.NORTH);

		btnBackLong = new JButton("");
		btnBackLong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				first_actionPerformed(e);
			}
		});
		btnBackLong.setFocusPainted(false);
		btnBackLong.setContentAreaFilled(false);
		btnBackLong.setBorderPainted(false);
		btnBackLong.setIcon(new ImageIcon(
				LoanDetail.class.getResource("/com/aptech/LoanProcessingSystem/images/ic_back_long_20.png")));
		panel_5.add(btnBackLong);

		btnBackShort = new JButton("");
		btnBackShort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				prev_actionPerformed(e);
			}
		});
		btnBackShort.setFocusPainted(false);
		btnBackShort.setContentAreaFilled(false);
		btnBackShort.setBorderPainted(false);
		btnBackShort.setIcon(new ImageIcon(
				LoanDetail.class.getResource("/com/aptech/LoanProcessingSystem/images/ic_back_short_20.png")));
		panel_5.add(btnBackShort);

		textField_1 = new JTextField();
		textField_1.setMaximumSize(new Dimension(30, 30));
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_1_actionPerformed(e);
			}
		});
		textField_1.setPreferredSize(new Dimension(30, 30));
		textField_1.setMinimumSize(new Dimension(30, 30));
		panel_5.add(textField_1);
		textField_1.setColumns(10);

		btnNextShort = new JButton("");
		btnNextShort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				next_actionPerformed(e);
			}
		});
		btnNextShort.setFocusPainted(false);
		btnNextShort.setContentAreaFilled(false);
		btnNextShort.setBorderPainted(false);
		btnNextShort.setIcon(new ImageIcon(
				LoanDetail.class.getResource("/com/aptech/LoanProcessingSystem/images/ic_next_short_20.png")));
		panel_5.add(btnNextShort);

		btnNextLong = new JButton("");
		btnNextLong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				last_actionPerformed(e);
			}
		});
		btnNextLong.setFocusPainted(false);
		btnNextLong.setContentAreaFilled(false);
		btnNextLong.setBorderPainted(false);
		btnNextLong.setIcon(new ImageIcon(
				LoanDetail.class.getResource("/com/aptech/LoanProcessingSystem/images/ic_next_long_20.png")));
		panel_5.add(btnNextLong);

		JPanel panel = new JPanel();
		panel_4.add(panel);
		panel.setBackground(Color.DARK_GRAY);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.DARK_GRAY);
		panel.add(panel_1);
		panel_1.setLayout(new FlowLayout(FlowLayout.LEADING, 20, 20));

		txtSearch = new JTextField();
		txtSearch.setMargin(new Insets(2, 20, 2, 20));
		txtSearch.setPreferredSize(new Dimension(300, 30));
		panel_1.add(txtSearch);
		txtSearch.setForeground(Color.RED);
		txtSearch.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 10));
		txtSearch.setColumns(30);

		btnSearch = new JButton("");
		btnSearch.setFocusPainted(false);
		btnSearch.setPreferredSize(new Dimension(30, 30));
		btnSearch.setMargin(new Insets(2, 20, 2, 20));
		panel_1.add(btnSearch);
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnSearch.setIcon(
				new ImageIcon(LoanDetail.class.getResource("/com/aptech/LoanProcessingSystem/images/search.png")));

		btnRefesh = new JButton("");
		btnRefesh.setFocusPainted(false);
		btnRefesh.setPreferredSize(new Dimension(30, 30));
		btnRefesh.setIcon(new ImageIcon(
				LoanDetail.class.getResource("/com/aptech/LoanProcessingSystem/images/ic_refresh_16.png")));
		panel_1.add(btnRefesh);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.DARK_GRAY);
		panel.add(panel_2);
		FlowLayout fl_panel_2 = new FlowLayout(FlowLayout.TRAILING, 20, 20);
		panel_2.setLayout(fl_panel_2);

		btnBack = new JButton("Back");

		btnBack.setIcon(
				new ImageIcon(LoanDetail.class.getResource("/com/aptech/LoanProcessingSystem/images/back.png")));
		btnBack.setPreferredSize(new Dimension(150, 30));
		btnBack.setMargin(new Insets(2, 20, 2, 20));
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 10));
		panel_2.add(btnBack);

		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pageState = loanPage;
				initPage();
			}
		});

		btnPayment = new JButton("Payment");
		btnPayment.setIcon(new ImageIcon(
				LoanDetail.class.getResource("/com/aptech/LoanProcessingSystem/images/ic_payment_24.png")));
		btnPayment.setPreferredSize(new Dimension(150, 30));
		btnPayment.setMargin(new Insets(2, 20, 2, 20));
		btnPayment.setFont(new Font("Tahoma", Font.BOLD, 10));
		panel_2.add(btnPayment);

		btnDetail = new JButton("Detail");

		btnDetail.setPreferredSize(new Dimension(150, 30));
		btnDetail.setMargin(new Insets(2, 20, 2, 20));
		panel_2.add(btnDetail);

		btnDetail.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnDetail.setIcon(new ImageIcon(
				LoanDetail.class.getResource("/com/aptech/LoanProcessingSystem/images/ic_detail_16.png")));

		btnDelete = new JButton("Delete");
		btnDelete.setPreferredSize(new Dimension(150, 30));
		btnDelete.setMargin(new Insets(2, 20, 2, 20));
		panel_2.add(btnDelete);

		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnDelete.setIcon(
				new ImageIcon(LoanDetail.class.getResource("/com/aptech/LoanProcessingSystem/images/close (2).png")));

		JButton btnPrint = new JButton("Print");
		btnPrint.setPreferredSize(new Dimension(150, 30));
		btnPrint.setMargin(new Insets(2, 20, 2, 20));
		panel_2.add(btnPrint);
		btnPrint.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnPrint.setIcon(
				new ImageIcon(LoanDetail.class.getResource("/com/aptech/LoanProcessingSystem/images/print.png")));
		btnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MessageFormat header = new MessageFormat("Loan Detail");
				MessageFormat footer = new MessageFormat("Page{0, number, integer}");
				try {
					table.print(JTable.PrintMode.NORMAL, header, footer);

				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2);
				}
			}
		});

		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchAction();
			}
		});

		btnRefesh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				refreshAction();
			}
		});

		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteAction();
			}
		});

		btnDetail.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int selectedRow = table.getSelectedRow();
				if (selectedRow != -1) {
					loanSelectedId = Integer.parseInt(table.getValueAt(selectedRow, 0).toString());
					String status = table.getValueAt(selectedRow, 11).toString();
					if (status == "Active") {
						pageState = historyPage;
						initPage();
					} else {
						JOptionPane.showMessageDialog(null, "Loan waiting for approval!");
					}
				} else {
					JOptionPane.showMessageDialog(null, "Please choose a value!");
				}
			}
		});

		btnPayment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateAction();
			}
		});
		initForm();
	}

	private void updateAction() {
		int selectedRow = table.getSelectedRow();
		if (selectedRow != -1) {
			int id = Integer.parseInt(table.getValueAt(selectedRow, 0).toString());
			PaymentLoan paymentLoan = new PaymentLoan(id);
			paymentLoan.setVisible(true);
			paymentLoan.addWindowListener(new WindowAdapter() {

				@Override
				public void windowClosed(WindowEvent e) {
					super.windowClosed(e);
					loadHistoryToTable(new LoanAndFineHistoryModel().searchByLoanId(loanSelectedId));
				}

			});
		} else {
			JOptionPane.showMessageDialog(null, "Please choose a value!");
		}
	}

	private void initPage() {
		currentPageIndex = 1;
		if (pageState.equals(loanPage)) {
			btnDetail.setVisible(true);
			txtSearch.setVisible(true);
			btnSearch.setVisible(true);
			btnDelete.setVisible(true);
			btnPayment.setVisible(false);
			btnBack.setVisible(false);
			txtHeader.setText("LOAN LIST");
			loadLoanToTable(new LoanModel().findAllActive());
		} else {
			btnDetail.setVisible(false);
			txtSearch.setVisible(false);
			btnSearch.setVisible(false);
			btnDelete.setVisible(false);
			btnPayment.setVisible(true);
			btnBack.setVisible(true);
			txtHeader.setText("LOAN DETAIL LIST");
			loadHistoryToTable(new LoanAndFineHistoryModel().searchByLoanId(loanSelectedId));
		}
	}

	protected void deleteAction() {
		int selectedRow = table.getSelectedRow();
		if (selectedRow != -1) {

			int id = Integer.parseInt(table.getValueAt(selectedRow, 0).toString());

			if (JOptionPane.showConfirmDialog(null, "Are you sure you want to delete?", "Confirm",

					JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {

				if (pageState.equals(loanPage)) {

					if (new LoanModel().closeLoan(id)) {

						JOptionPane.showMessageDialog(null, "Successful Delete");
						loadLoanToTable(new LoanModel().findAllActive());

					} else {

						JOptionPane.showMessageDialog(null, "Delete failed, please try again!");
					}
				}
			}
		} else {

			JOptionPane.showMessageDialog(null, "Please choose a value!");
		}
	}

	private void refreshAction() {
		txtSearch.setText("");
		if (pageState.equals(loanPage)) {
			loadLoanToTable(new LoanModel().findAllActive());
		} else {
			loadHistoryToTable(new LoanAndFineHistoryModel().searchByLoanId(loanSelectedId));
		}
	}

	private void searchAction() {
		String keyword = txtSearch.getText().trim();
		if (pageState.equals(loanPage)) {
			loadLoanToTable(new LoanModel().searchByCustomerName(keyword));
		} else {
			loadHistoryToTable(new LoanAndFineHistoryModel().search(keyword));
		}
	}

	private void loadLoanToTable(List<Loan> list) {

		tblModel.setColumnIdentifiers(new String[] { "Id", "Customer", "Loan type", "Payment type", "Period", "Amount",
				"Disbursement", "Duration", "End date", "Interest", "Description", "Status" });

		table.setModel(tblModel);
		table.setRowSorter(sorter1);
		try {
			tblModel.setRowCount(0);
			for (Loan loans : list) {
				tblModel.addRow(new Object[] { loans.getId(), loans.getCustomerName(), loans.getLoanTypeName(),
						loans.getPaymentTypeName(), loans.getPeriod() + " Month",
						Common.formatNumber(loans.getAmount()), loans.getDisbursementDate(),
						loans.getDuration() + " Month", loans.getEndDate(),
						Common.formatInt(loans.getInterest() * 100) + " %", loans.getDescription(),
						loans.getStatus() == 0 ? "New" : (loans.getStatus() == 1 ? "Active" : "Update") });
			}
			int rowCount = tblModel.getRowCount();
			int v = rowCount % itemsPerPage == 0 ? 0 : 1;
			maxPageIndex = rowCount / itemsPerPage + v;
			initFilterAndButton();
			tblModel.fireTableDataChanged();

		} catch (Exception e) {
			e.printStackTrace();
			MessageDialog.showErrorMessage(mainForm, e.getMessage(), "Error");
		}
	}

	private void loadHistoryToTable(List<LoanAndFineHistory> list) {
		currentPageIndex = 1;
		textField_1.setText(Integer.toString(currentPageIndex));
		tblModel.setColumnIdentifiers(
				new String[] { "Id", "Customer", "Payment Amount", "Loan Amount", "Amount Left", "Due Date", "Fine Interest",
						"Fine Over Days", "Fine Amount", "Payment Date", "Payment method", "Description", "Status" });
		table.setModel(tblModel);
		try {

			tblModel.setRowCount(0);
			for (LoanAndFineHistory hisItem : list) {
				tblModel.addRow(new Object[] { hisItem.getId(), hisItem.getCustomer(),
						Common.formatNumber(hisItem.getPaymentAmount()), Common.formatNumber(hisItem.getAmount()),
						Common.formatNumber(hisItem.getAmountLeft()), hisItem.getDueDate(),
						hisItem.getFineInterest() == 0 ? "-" : hisItem.getFineInterest() * 100 + " %",
						hisItem.getFineOverDays() == 0 ? "-" : hisItem.getFineOverDays() + " day",
						hisItem.getFineAmount() == 0 ? "-" : Common.formatNumber(hisItem.getFineAmount()),
						hisItem.getPaymentDate(), hisItem.isStatus() ? hisItem.getPaymentMenthodName() : "-",
						hisItem.getDescription(), hisItem.isStatus() ? "Paid" : "Unpaid" });
			}
			tblModel.fireTableDataChanged();

		} catch (Exception e) {
			e.printStackTrace();
			MessageDialog.showErrorMessage(mainForm, e.getMessage(), "Error");
		}
	}

	private void initForm() {
		txtSearch.setText(hintSearch);
		txtSearch.setFont(new Font("Tahoma", Font.ITALIC, 10));
		txtSearch.setForeground(Color.GRAY);
		setTextHint(txtSearch, hintSearch);
		initPage();
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

	public void next_actionPerformed(ActionEvent e) {
		currentPageIndex += 1;
		initFilterAndButton();
	}

	public void last_actionPerformed(ActionEvent e) {
		currentPageIndex = maxPageIndex;
		initFilterAndButton();
	}

	public void prev_actionPerformed(ActionEvent e) {
		currentPageIndex -= 1;
		initFilterAndButton();
	}

	public void first_actionPerformed(ActionEvent e) {
		currentPageIndex = 1;
		initFilterAndButton();
	}

	public void textField_1_actionPerformed(ActionEvent arg0) {
		try {
			int v = Integer.parseInt(textField_1.getText());
			if (v > 0 && v <= maxPageIndex) {
				currentPageIndex = v;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		initFilterAndButton();
	}

	private void initFilterAndButton() {
		sorter1.setRowFilter(new RowFilter<TableModel, Integer>() {
			@Override
			public boolean include(Entry<? extends TableModel, ? extends Integer> entry) {
				int ti = currentPageIndex - 1;
				int ei = entry.getIdentifier();
				return ti * itemsPerPage <= ei && ei < ti * itemsPerPage + itemsPerPage;
			}
		});
		btnBackLong.setEnabled(currentPageIndex > 1);
		btnBackShort.setEnabled(currentPageIndex > 1);
		btnNextShort.setEnabled(currentPageIndex < maxPageIndex);
		textField_1.setText(Integer.toString(currentPageIndex));
	}

}
