package com.aptech.LoanProcessingSystem.view.admin;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;

import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.aptech.LoanProcessingSystem.entities.Account;
import com.aptech.LoanProcessingSystem.entities.Customer;
import com.aptech.LoanProcessingSystem.entities.LoanType;
import com.aptech.LoanProcessingSystem.model.AccountModel;
import com.aptech.LoanProcessingSystem.model.CustomerModel;
import com.aptech.LoanProcessingSystem.model.LoanTypeModel;
import com.aptech.LoanProcessingSystem.view.Login;

import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;

public class jpanelEmployeeManagement extends JPanel {
	private JTable jtableEmployee;
	private JTextField txtSearch;
	private JComboBox<String> cbFilter;
	private JButton btnSearch;
	private JButton btnDelete;
	private JButton btnAdd;
	private JButton btnReload;

	/**
	 * Create the panel.
	 */
	public jpanelEmployeeManagement() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JPanel jpanelHomeTop = new JPanel();
		jpanelHomeTop.setBackground(new Color(21, 25, 28));
		add(jpanelHomeTop);
		FlowLayout fl_jpanelHomeTop = new FlowLayout(FlowLayout.LEFT, 5, 5);
		jpanelHomeTop.setLayout(fl_jpanelHomeTop);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(jpanelEmployeeManagement.class.getResource("/com/aptech/LoanProcessingSystem/images/icons8_management_20px.png")));
		jpanelHomeTop.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("Employee Profile Management");
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
		
		btnReload = new JButton("");
		btnReload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnReload_actionPerformed(e);
			}
		});
		btnReload.setIcon(new ImageIcon(jpanelEmployeeManagement.class.getResource("/com/aptech/LoanProcessingSystem/images/icons8_refresh_20px.png")));
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
		panel_4.add(cbFilter);
		
		JPanel panel = new JPanel();
		add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		panel.setBackground(new Color(34, 40, 44));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(new Color(34, 40, 44));
		panel.add(scrollPane, BorderLayout.CENTER);
		
		
		jtableEmployee = new JTable();
		jtableEmployee.setGridColor(SystemColor.activeCaption);
		jtableEmployee.setForeground(SystemColor.text);
		jtableEmployee.setBackground(new Color(34, 40, 44));
		scrollPane.setViewportView(jtableEmployee);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(34, 40, 44));
		add(panel_2);
		
		btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnAdd_actionPerformed(e);
			}
		});
		panel_2.add(btnAdd);
		
		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnDelete_actionPerformed(e);
			}
		});
		panel_2.add(btnDelete);
		
		btnReload_actionPerformed(null);
		fillComboBox();
		AccountModel accountModel = new AccountModel();
		fillDataToJTable(accountModel.loadAllEmployee());
	}
	
	public void btnSearch_actionPerformed(ActionEvent e) {
		String keyValue = txtSearch.getText().trim();
		AccountModel accountModel = new AccountModel();
		fillDataToJTable(accountModel.find(keyValue));
	}
	
	public void btnAdd_actionPerformed(ActionEvent e) {
//		jDialogAddNewCustomer addNewCustomer = new jDialogAddNewCustomer();
//		addNewCustomer.setVisible(true);
		
		SignUp signUp = new SignUp();
		signUp.setVisible(true);
//		Login.this.dispose();
	}
	
	public void fillDataToJTable (List<Account> accountList) {
		AccountModel accountModel = new AccountModel();
		DefaultTableModel defaultTableModel = new DefaultTableModel() {

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
			
		};
		defaultTableModel.addColumn("ID");
		defaultTableModel.addColumn("Authority");
		defaultTableModel.addColumn("Name");
		defaultTableModel.addColumn("Email");
		defaultTableModel.addColumn("Phone");
		defaultTableModel.addColumn("Address");
		defaultTableModel.addColumn("Gender");
		defaultTableModel.addColumn("DOB");
		defaultTableModel.addColumn("Id Card");
		defaultTableModel.addColumn("Status");
		for (Account account : accountList) {
			defaultTableModel.addRow(new Object[] {
					account.getId(), account.getAuthName(), 
					account.getName(), account.getEmail(), account.getPhone(),
					account.getAddress(), account.isGender() ? "Male" : "Female",
					account.getDob(), account.getIdentityCard(), account.isStatus() 
			});
		}
		jtableEmployee.setModel(defaultTableModel);
		jtableEmployee.getTableHeader().setReorderingAllowed(false);
	}
	
	public void btnReload_actionPerformed(ActionEvent e) {
		AccountModel accountModel = new AccountModel();
		fillDataToJTable(accountModel.loadAllEmployee());
	}
	
	public void btnDelete_actionPerformed(ActionEvent e) {
		int i = jtableEmployee.getSelectedRow();
		if ( i  > -1 ) {
			int id = (int) jtableEmployee.getValueAt(i, 0);
			boolean status = (boolean) jtableEmployee.getValueAt(i, 9);
			if (status) {
				AccountModel accountModel = new AccountModel();
				int a = JOptionPane.showConfirmDialog(null, "Do you want to delete"
						+ " this account?", "Confirm", JOptionPane.YES_NO_CANCEL_OPTION);
				if (a == JOptionPane.YES_OPTION) {
					if (accountModel.delete(id)) {
						JOptionPane.showMessageDialog(null, "Done");
						btnReload_actionPerformed(e);
					} else {
						JOptionPane.showMessageDialog(null, "Failed");
					}
				}
			} else {
				JOptionPane.showMessageDialog(null, "This Account has been deleted already!!!");
			}
		}
	}
	
	public void cbFilter_actionPerformed(ActionEvent e) {
		int i = cbFilter.getSelectedIndex();
		AccountModel accountModel = new AccountModel();
		if (i == 0) {
			fillDataToJTable(accountModel.loadAllEmployee());
		} else if (i == 1) {
			fillDataToJTable(accountModel.loadEmployeeExisted());
		} else if (i == 2) {
			fillDataToJTable(accountModel.loadEmployeeDeleted());
		} 
	}
	
	public void fillComboBox() {
		DefaultComboBoxModel<String> boxModel = new DefaultComboBoxModel<String>();
		boxModel.addElement("Show all account");
		boxModel.addElement("Show account existed");
		boxModel.addElement("Show account deleted");
		cbFilter.setModel(boxModel);
	}
}
