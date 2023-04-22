package com.aptech.LoanProcessingSystem.view.admin;

import javax.swing.JPanel;
import javax.swing.AbstractCellEditor;
import javax.swing.BoxLayout;
import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;

import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.GridBagLayout;

import javax.swing.ImageIcon;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

import com.aptech.LoanProcessingSystem.entities.Customer;
import com.aptech.LoanProcessingSystem.entities.LoanType;
import com.aptech.LoanProcessingSystem.model.CustomerModel;
import com.aptech.LoanProcessingSystem.model.LoanTypeModel;
import com.aptech.LoanProcessingSystem.service.Common;
import com.aptech.LoanProcessingSystem.view.AddCustomer;
import com.aptech.LoanProcessingSystem.view.admin.jpanelCustomerProfile.LoanInfosPane;

import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.EventObject;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;

public class jpanelCustomerProfile extends JPanel {
	private JTable jtableCustomer;
	private JTextField txtSearch;
	private JComboBox<String> cbFilter;
	private JButton btnSearch;
	private JTextField txtEmployeeID;
	private JPanel panelEmployeeID;
	private JButton btnFind;

	/**
	 * Create the panel.
	 */
	public jpanelCustomerProfile() {
		setBackground(new Color(34, 40, 44));
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		JPanel jpanelHomeTop = new JPanel();
		jpanelHomeTop.setBackground(new Color(21, 25, 28));
		add(jpanelHomeTop);
		FlowLayout fl_jpanelHomeTop = new FlowLayout(FlowLayout.LEFT, 5, 5);
		jpanelHomeTop.setLayout(fl_jpanelHomeTop);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(jpanelCustomerProfile.class
				.getResource("/com/aptech/LoanProcessingSystem/images/icons8_profile_20px.png")));
		jpanelHomeTop.add(lblNewLabel_1);

		JLabel lblNewLabel = new JLabel("Customer Profile Management");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblNewLabel.setForeground(SystemColor.text);
		jpanelHomeTop.add(lblNewLabel);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(34, 40, 44));
		add(panel_1);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));

		JPanel panel_3 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_3.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		panel_3.setBackground(new Color(34, 40, 44));
		panel_1.add(panel_3);

		JLabel lblNewLabel_2 = new JLabel("Search");
		lblNewLabel_2.setForeground(Color.WHITE);
		panel_3.add(lblNewLabel_2);

		txtSearch = new JTextField();
		txtSearch.setColumns(10);
		panel_3.add(txtSearch);

		btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnSearch_actionPerformed(e);
			}
		});
		panel_3.add(btnSearch);

		JButton btnReload = new JButton("");
		btnReload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnReload_actionPerformed(e);
			}
		});
		btnReload.setIcon(new ImageIcon(jpanelCustomerProfile.class
				.getResource("/com/aptech/LoanProcessingSystem/images/icons8_refresh_20px.png")));
		btnReload.setFocusPainted(false);
		btnReload.setContentAreaFilled(false);
		btnReload.setBorderPainted(false);
		panel_3.add(btnReload);

		JPanel panel_4 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_4.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		panel_4.setBackground(new Color(30, 40, 44));
		panel_1.add(panel_4);

		JLabel lblNewLabel_3 = new JLabel("Filter");
		lblNewLabel_3.setForeground(SystemColor.text);
		panel_4.add(lblNewLabel_3);

		cbFilter = new JComboBox();
		cbFilter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cbFilter_actionPerformed(e);
			}
		});
//		cbFilter.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				cbFilter_actionPerformed(e);
//			}
//		});
		panel_4.add(cbFilter);

		panelEmployeeID = new JPanel();
		panelEmployeeID.setBackground(new Color(30, 40, 44));
		panelEmployeeID.setVisible(false);
		add(panelEmployeeID);

		JLabel lblNewLabel_4 = new JLabel("Employee ID");
		lblNewLabel_4.setForeground(SystemColor.text);
		panelEmployeeID.add(lblNewLabel_4);

		txtEmployeeID = new JTextField();
		panelEmployeeID.add(txtEmployeeID);
		txtEmployeeID.setColumns(10);

		btnFind = new JButton("Find");
		btnFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnFind_actionPerformed(e);
			}
		});
		panelEmployeeID.add(btnFind);

		JPanel panel = new JPanel();
		add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		panel.setBackground(new Color(34, 40, 44));

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(new Color(34, 40, 44));
		panel.add(scrollPane, BorderLayout.CENTER);

		jtableCustomer = new JTable();
		jtableCustomer.setRowHeight(40);
		jtableCustomer.setGridColor(SystemColor.activeCaption);
		jtableCustomer.setForeground(SystemColor.text);
		jtableCustomer.setBackground(new Color(34, 40, 44));
		scrollPane.setViewportView(jtableCustomer);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(34, 40, 44));
		add(panel_2);

		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnAdd_actionPerformed(e);
			}
		});
		panel_2.add(btnAdd);

		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnUpdate_actionPerformed(e);
			}
		});
		panel_2.add(btnUpdate);

		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnDelete_actionPerformed(e);
			}
		});
		panel_2.add(btnDelete);

		btnReload_actionPerformed(null);
		fillComboBox();
		CustomerModel customerModel = new CustomerModel();
		fillDataToJTable(customerModel.findAll());
	}

	public void btnSearch_actionPerformed(ActionEvent e) {
		String keyValue = txtSearch.getText().trim();
		CustomerModel customerModel = new CustomerModel();
		fillDataToJTable(customerModel.search(keyValue));
	}

	public void btnAdd_actionPerformed(ActionEvent e) {
		AddCustomer addNewCustomer = new AddCustomer();
		addNewCustomer.setVisible(true);
	}

	public void fillDataToJTable(List<Customer> customerList) {
		DefaultTableModel defaultTableModel = new DefaultTableModel() {

			@Override
			public boolean isCellEditable(int row, int column) {
				return column == 11;
			}

		};
		defaultTableModel.addColumn("ID");
		defaultTableModel.addColumn("Name");
		defaultTableModel.addColumn("Address");
		defaultTableModel.addColumn("Phone");
		defaultTableModel.addColumn("Email");
		defaultTableModel.addColumn("Gender");
		defaultTableModel.addColumn("DOB");
		defaultTableModel.addColumn("Salary");
		defaultTableModel.addColumn("Job");
		defaultTableModel.addColumn("Company");
		defaultTableModel.addColumn("Id Card");
		defaultTableModel.addColumn("View");
		defaultTableModel.addColumn("Status");
		for (Customer customer : customerList) {
			defaultTableModel.addRow(new Object[] { customer.getId(), customer.getName(), customer.getAddress(),
					customer.getPhone(), customer.getEmail(), customer.isGender() ? "Male" : "Female",
					customer.getDob(), Common.formatInt(customer.getSalary()), customer.getJob(), customer.getCompany(),
					customer.getIdentityCard(), new Object[] { "Loans", "Info" }, customer.isStatus() });
		}
		jtableCustomer.setModel(defaultTableModel);
		LoanInfosPane infosPane = new LoanInfosPane();
		jtableCustomer.getColumnModel().getColumn(11).setCellRenderer(infosPane);
		jtableCustomer.getColumnModel().getColumn(11).setCellEditor(new ButtonEditor());
		jtableCustomer.getTableHeader().setReorderingAllowed(false);
		jtableCustomer.addNotify();
	}

	public class LoanInfosPane extends JPanel implements TableCellRenderer {

		private JButton loan;
		private String state;

		public LoanInfosPane() {
			setBackground(new Color(34, 40, 44));
			setLayout(new GridBagLayout());
			loan = new JButton("Loans");
			loan.setActionCommand("loans");

			add(loan);

			ActionListener listener = new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					state = e.getActionCommand();
					if (state.equals("loans")) {
						btnLoans();
					}
				}
			};

			loan.addActionListener(listener);
		}

		public void addActionListener(ActionListener listener) {
			loan.addActionListener(listener);
		}

		public String getState() {
			return state;
		}

		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {
			// TODO Auto-generated method stub
			return this;
		}
	}

	class ButtonRenderer extends DefaultTableCellRenderer {

		private LoanInfosPane loanInfosPane;

		public ButtonRenderer() {
			loanInfosPane = new LoanInfosPane();
		}

		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {
			if (isSelected) {
				loanInfosPane.setBackground(table.getSelectionBackground());
			} else {
				loanInfosPane.setBackground(table.getBackground());
			}
			return loanInfosPane;
		}
	}

	class ButtonEditor extends AbstractCellEditor implements TableCellEditor {

		private LoanInfosPane loanInfosPane;

		public ButtonEditor() {
			loanInfosPane = new LoanInfosPane();
			loanInfosPane.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					SwingUtilities.invokeLater(new Runnable() {

						@Override
						public void run() {
							stopCellEditing();

						}
					});

				}
			});
		}

		public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row,
				int column) {
			if (isSelected) {
				loanInfosPane.setBackground(jtableCustomer.getSelectionBackground());
			} else {
				loanInfosPane.setBackground(jtableCustomer.getBackground());
			}
			return loanInfosPane;
		}

		public Object getCellEditorValue() {
			return loanInfosPane.getState();
		}

		@Override
		public boolean isCellEditable(EventObject e) {
			return true;
		}
	}

	public void btnReload_actionPerformed(ActionEvent e) {
		CustomerModel customerModel = new CustomerModel();
		fillDataToJTable(customerModel.findAll());
	}

	public void btnUpdate_actionPerformed(ActionEvent e) {
		int i = jtableCustomer.getSelectedRow();
		if (i > -1) {
			int id = (int) (jtableCustomer.getValueAt(i, 0));
			AddCustomer addNewCustomer = new AddCustomer(id);
			addNewCustomer.setVisible(true);
			addNewCustomer.addWindowListener(new WindowAdapter() {
				@Override
				public void windowClosed(WindowEvent e) {
					CustomerModel customerModel = new CustomerModel();
					fillDataToJTable(customerModel.findAll());
					super.windowClosed(e);
				}
			});
		} else {
			JOptionPane.showMessageDialog(null, "Please choose a value!");
		}
	}

	public void btnLoans() {
		int i = jtableCustomer.getSelectedRow();
		if (i > -1) {
			int id = (int) jtableCustomer.getValueAt(i, 0);
			CustomerModel customerModel = new CustomerModel();
			Customer customer = customerModel.findById(id);
			JPanel jpanelMain = (JPanel) this.getParent();
			jpanelMain.removeAll();
			jpanelMain.revalidate();
			jpnaelShowCustomerLoan jpnaelShowCustomerLoan = new jpnaelShowCustomerLoan(customer);
			jpanelMain.add(jpnaelShowCustomerLoan);
			jpnaelShowCustomerLoan.setVisible(true);
		}
	}

	public void btnDelete_actionPerformed(ActionEvent e) {
		int i = jtableCustomer.getSelectedRow();
		if (i > -1) {
			int id = (int) jtableCustomer.getValueAt(i, 0);
			CustomerModel customerModel = new CustomerModel();
			int a = JOptionPane.showConfirmDialog(null, "Do you want to delete" + " this customer?", "Confirm",
					JOptionPane.YES_NO_CANCEL_OPTION);
			if (a == JOptionPane.YES_OPTION) {
				if (customerModel.delete(id)) {
					JOptionPane.showMessageDialog(null, "Done");
					btnReload_actionPerformed(e);
				} else {
					JOptionPane.showMessageDialog(null, "Failed");
				}
			}
		}
	}

	public void cbFilter_actionPerformed(ActionEvent e) {
		int i = cbFilter.getSelectedIndex();

		if (i == 0) {
			panelEmployeeID.setVisible(true);
//			try {
			btnFind_actionPerformed(null);
//			} catch (Exception ex) {
//				JOptionPane.showMessageDialog(null, "You must enter integer");
//			}
		}
	}

	public void btnFind_actionPerformed(ActionEvent e) {
		CustomerModel customerModel = new CustomerModel();
		try {
			int accountID = Integer.parseInt(txtEmployeeID.getText().trim());
			fillDataToJTable(customerModel.findCustomerByAccountID(accountID));
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(this, "Please input an integer");
		}
	}

	public void fillComboBox() {
		DefaultComboBoxModel<String> boxModel = new DefaultComboBoxModel<String>();
		boxModel.addElement("Load customer by employee");
		cbFilter.setModel(boxModel);
	}
}
