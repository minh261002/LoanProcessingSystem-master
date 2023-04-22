package com.aptech.LoanProcessingSystem.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Insets;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import com.aptech.LoanProcessingSystem.entities.Customer;
import com.aptech.LoanProcessingSystem.model.CustomerModel;
import com.aptech.LoanProcessingSystem.service.Common;
import com.aptech.LoanProcessingSystem.service.MessageDialog;

@SuppressWarnings("serial")
public class CustomerInfo extends JPanel {

	private Home mainForm;
	private DefaultTableModel tblModel = new DefaultTableModel();
	private JTable table;
	private JTextField txtSearch;
	List<Customer> list = new ArrayList<>();
	private JLabel txtHeader;
	private JTextField textField;
	private int currentPageIndex = 1;
	private final int itemsPerPage = 20;
	private int maxPageIndex;
	private final TableRowSorter<TableModel> sorter1 = new TableRowSorter<TableModel>(tblModel);
	private JButton btnBackLong;
	private JButton btnBackShort;
	private JButton btnNextShort;
	private JButton btnNextLong;
	private JButton btnNewCustomer;

	public CustomerInfo() {
		initComponents();
		initTable();
		CustomerModel customerModel = new CustomerModel();
		loadDataToTable(customerModel.findAll());
	}

	private void initTable() {
		tblModel.setColumnIdentifiers(new String[] { "Id", "Name", "Email", "Phone", "Gender", "Dob", "Salary", "Job",
				"Company", "Identity", "Address", "Status" });
		table.setModel(tblModel);
		table.setRowSorter(sorter1);
	}

	private void loadDataToTable(List<Customer> list) {
		try {
			tblModel.setRowCount(0);
			for (Customer customer : list) {
				tblModel.addRow(new Object[] { customer.getId(), customer.getName(), customer.getEmail(),
						customer.getPhone(), customer.isGender() ? "Male" : "Female", customer.getDob(),
						Common.formatNumber(customer.getSalary()), customer.getJob(), customer.getCompany(), customer.getIdentityCard(),
						customer.getAddress(), customer.isStatus() ? "Active" : "Inactive"

				});

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

	/**
	 * Create the panel.
	 * 
	 * @return
	 */
	public void initComponents() {

		setBackground(new Color(112, 128, 144));
		setLayout(new BorderLayout(0, 0));

		JPanel panel_2 = new JPanel();
		add(panel_2, BorderLayout.SOUTH);
		panel_2.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		panel_2.add(panel);
		panel.setBackground(Color.DARK_GRAY);
		panel.setAlignmentY(10.0f);
		panel.setAlignmentX(10.0f);
		panel.setLayout(new BoxLayout(panel, BoxLayout.LINE_AXIS));

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.DARK_GRAY);
		panel.add(panel_3);
		panel_3.setLayout(new FlowLayout(FlowLayout.LEADING, 20, 20));

		txtSearch = new JTextField();
		panel_3.add(txtSearch);
		txtSearch.setMinimumSize(new Dimension(200, 19));
		txtSearch.setMargin(new Insets(2, 20, 2, 20));
		txtSearch.setPreferredSize(new Dimension(350, 31));
		txtSearch.setForeground(Color.RED);
		txtSearch.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 10));
		txtSearch.setColumns(30);

		JButton btnSearch = new JButton("");
		panel_3.add(btnSearch);
		btnSearch.setPreferredSize(new Dimension(30, 30));
		btnSearch.setMargin(new Insets(2, 20, 2, 20));
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnSearch.setIcon(
				new ImageIcon(CustomerInfo.class.getResource("/com/aptech/LoanProcessingSystem/images/search.png")));

		JButton btnRefresh = new JButton("");
		btnRefresh.setPreferredSize(new Dimension(30, 30));
		btnRefresh.setIcon(new ImageIcon(
				CustomerInfo.class.getResource("/com/aptech/LoanProcessingSystem/images/ic_refresh_16.png")));
		panel_3.add(btnRefresh);

		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.DARK_GRAY);
		panel.add(panel_4);
		panel_4.setLayout(new FlowLayout(FlowLayout.TRAILING, 20, 20));
		
		btnNewCustomer = new JButton("New Customer");
		btnNewCustomer.setIcon(new ImageIcon(CustomerInfo.class.getResource("/com/aptech/LoanProcessingSystem/images/ic_new_customer_20.png")));
		btnNewCustomer.setPreferredSize(new Dimension(150, 30));
		btnNewCustomer.setMargin(new Insets(2, 20, 2, 20));
		btnNewCustomer.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnNewCustomer.setAlignmentY(10.0f);
		btnNewCustomer.setAlignmentX(20.0f);
		panel_4.add(btnNewCustomer);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setIcon(new ImageIcon(CustomerInfo.class.getResource("/com/aptech/LoanProcessingSystem/images/ic_update_16.png")));
		btnUpdate.setPreferredSize(new Dimension(150, 30));
		btnUpdate.setMargin(new Insets(2, 20, 2, 20));
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnUpdate.setAlignmentY(10.0f);
		btnUpdate.setAlignmentX(20.0f);
		panel_4.add(btnUpdate);

		JButton btnCreateLoan = new JButton("New Loan");
		btnCreateLoan.setAlignmentY(10.0f);
		btnCreateLoan.setAlignmentX(20.0f);
		panel_4.add(btnCreateLoan);
		btnCreateLoan.setPreferredSize(new Dimension(150, 30));
		btnCreateLoan.setMargin(new Insets(2, 20, 2, 20));

		btnCreateLoan.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnCreateLoan.setIcon(
				new ImageIcon(CustomerInfo.class.getResource("/com/aptech/LoanProcessingSystem/images/add.png")));

		JButton btnDelete = new JButton("Delete");
		btnDelete.setVisible(false);
		btnDelete.setAlignmentY(10.0f);
		btnDelete.setAlignmentX(20.0f);
		panel_4.add(btnDelete);
		btnDelete.setPreferredSize(new Dimension(150, 30));
		btnDelete.setMargin(new Insets(2, 20, 2, 20));
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnDelete.setIcon(
				new ImageIcon(CustomerInfo.class.getResource("/com/aptech/LoanProcessingSystem/images/close (2).png")));

		JButton btnPrint = new JButton("Print");
		btnPrint.setAlignmentY(10.0f);
		btnPrint.setAlignmentX(20.0f);
		panel_4.add(btnPrint);
		btnPrint.setPreferredSize(new Dimension(120, 30));
		btnPrint.setMargin(new Insets(2, 20, 2, 20));
		btnPrint.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnPrint.setIcon(
				new ImageIcon(CustomerInfo.class.getResource("/com/aptech/LoanProcessingSystem/images/print.png")));

		JPanel panel_5 = new JPanel();
		panel_2.add(panel_5, BorderLayout.NORTH);

		btnBackLong = new JButton("");
		btnBackLong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				first_actionPerformed(e);
			}
		});
		btnBackLong.setIcon(new ImageIcon(
				CustomerInfo.class.getResource("/com/aptech/LoanProcessingSystem/images/ic_back_long_20.png")));
		btnBackLong.setFocusPainted(false);
		btnBackLong.setContentAreaFilled(false);
		btnBackLong.setBorderPainted(false);
		panel_5.add(btnBackLong);

		btnBackShort = new JButton("");
		btnBackShort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				prev_actionPerformed(e);
			}
		});
		btnBackShort.setIcon(new ImageIcon(
				CustomerInfo.class.getResource("/com/aptech/LoanProcessingSystem/images/ic_back_short_20.png")));
		btnBackShort.setFocusPainted(false);
		btnBackShort.setContentAreaFilled(false);
		btnBackShort.setBorderPainted(false);
		panel_5.add(btnBackShort);

		textField = new JTextField();
		textField.setMaximumSize(new Dimension(30, 30));
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setPreferredSize(new Dimension(30, 30));
		textField.setMinimumSize(new Dimension(30, 30));
		textField.setColumns(10);
		panel_5.add(textField);

		btnNextShort = new JButton("");
		btnNextShort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				next_actionPerformed(e);
			}
		});
		btnNextShort.setIcon(new ImageIcon(
				CustomerInfo.class.getResource("/com/aptech/LoanProcessingSystem/images/ic_next_short_20.png")));
		btnNextShort.setFocusPainted(false);
		btnNextShort.setContentAreaFilled(false);
		btnNextShort.setBorderPainted(false);
		panel_5.add(btnNextShort);

		btnNextLong = new JButton("");
		btnNextLong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				last_actionPerformed(e);
			}
		});
		btnNextLong.setIcon(new ImageIcon(
				CustomerInfo.class.getResource("/com/aptech/LoanProcessingSystem/images/ic_next_long_20.png")));
		btnNextLong.setFocusPainted(false);
		btnNextLong.setContentAreaFilled(false);
		btnNextLong.setBorderPainted(false);
		panel_5.add(btnNextLong);

		btnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MessageFormat header = new MessageFormat("List Customer");
				MessageFormat footer = new MessageFormat("Page{0, number, integer}");

				try {
					table.print(JTable.PrintMode.NORMAL, header, footer);

				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2);
				}
			}
		});

		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = table.getSelectedRow();
				if (selectedRow != -1) {
					int result = JOptionPane.showConfirmDialog(null, "Are you sure?", "Confirm",
							JOptionPane.YES_NO_OPTION);
					if (result == JOptionPane.YES_OPTION) {
						int id = Integer.parseInt(table.getValueAt(selectedRow, 0).toString());
						CustomerModel customerModel = new CustomerModel();
						if (customerModel.delete(id)) {
							JOptionPane.showMessageDialog(null, "Successful Delete");
							loadDataToTable(customerModel.findAll());
						} else {
							JOptionPane.showMessageDialog(null, "Failed");
						}
					}
				} else {
					JOptionPane.showMessageDialog(null, "Please choose a value!");
				}
			}
		});

		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String keyword = txtSearch.getText().trim();
				loadDataToTable(new CustomerModel().search(keyword));
			}
		});

		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtSearch.setText("");
				loadDataToTable(new CustomerModel().findAll());
			}
		});
		btnCreateLoan.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int selectedRow = table.getSelectedRow();
				if (selectedRow != -1) {
					int id = Integer.parseInt(table.getValueAt(selectedRow, 0).toString());
					CreateLoan createLoan = new CreateLoan(id);
					createLoan.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null, "Please choose a value!");
				}

			}
		});

		btnUpdate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int selectedRow = table.getSelectedRow();
				if (selectedRow != -1) {
					int id = Integer.parseInt(table.getValueAt(selectedRow, 0).toString());
					AddCustomer addCustomer = new AddCustomer(id);
					addCustomer.setVisible(true);
					addCustomer.addWindowListener(new WindowAdapter() {

						@Override
						public void windowClosed(WindowEvent e) {
							super.windowClosed(e);
							CustomerModel customerModel = new CustomerModel();
							loadDataToTable(customerModel.findAll());
						}
					});
				} else {
					JOptionPane.showMessageDialog(null, "Please choose a value!");
				}

			}
		});

		btnNewCustomer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
					AddCustomer addCustomer = new AddCustomer();
					addCustomer.setVisible(true);
					addCustomer.addWindowListener(new WindowAdapter() {
						@Override
						public void windowClosed(WindowEvent e) {
							super.windowClosed(e);
							CustomerModel customerModel = new CustomerModel();
							loadDataToTable(customerModel.findAll());
						}
					});
			}
		});
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(UIManager.getColor("Button.shadow"));
		add(panel_1, BorderLayout.NORTH);

		txtHeader = new JLabel("CUSTOMER LIST");
		txtHeader.setHorizontalTextPosition(SwingConstants.CENTER);
		txtHeader.setHorizontalAlignment(SwingConstants.CENTER);
		txtHeader.setPreferredSize(new Dimension(1000, 40));
		txtHeader.setMinimumSize(new Dimension(1000, 100));
		txtHeader.setMaximumSize(new Dimension(5000, 500));
		txtHeader.setBackground(UIManager.getColor("Button.shadow"));
		txtHeader.setForeground(SystemColor.infoText);
		txtHeader.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 24));
		panel_1.add(txtHeader);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(new Color(112, 128, 144));
		add(scrollPane);

		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
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
			int v = Integer.parseInt(textField.getText());
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
		textField.setText(Integer.toString(currentPageIndex));
	}

}
