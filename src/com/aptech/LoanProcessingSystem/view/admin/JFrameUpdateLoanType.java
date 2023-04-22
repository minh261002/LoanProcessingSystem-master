package com.aptech.LoanProcessingSystem.view.admin;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import com.aptech.LoanProcessingSystem.entities.LoanType;
import com.aptech.LoanProcessingSystem.model.LoanTypeModel;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.FlowLayout;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.GridLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.awt.event.ActionEvent;

public class JFrameUpdateLoanType extends JFrame {

	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtInterest;
	private JTextField txtDescription;
	private JCheckBox chkStatus;
	private JTextField txtID;
	private Map<Integer, Object> data = new HashMap<Integer, Object>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameUpdateLoanType frame = new JFrameUpdateLoanType();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JFrameUpdateLoanType() {
		setTitle("Add New ");
		setBounds(100, 100, 362, 391);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panel.setBackground(new Color(21, 25, 28));
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(JFrameUpdateLoanType.class.getResource("/com/aptech/LoanProcessingSystem/images/icons8_update_file_20px.png")));
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Update Loan Type");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setForeground(SystemColor.text);
		panel.add(lblNewLabel_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(34, 40, 44));
		contentPane.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(34, 40, 44));
		panel_1.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_2_1 = new JLabel("Name");
		lblNewLabel_2_1.setForeground(SystemColor.text);
		lblNewLabel_2_1.setBounds(57, 79, 55, 16);
		panel_2.add(lblNewLabel_2_1);
		
		txtName = new JTextField();
		txtName.setColumns(10);
		txtName.setBounds(167, 73, 122, 28);
		panel_2.add(txtName);
		
		JLabel lblNewLabel_2_2 = new JLabel("Interest");
		lblNewLabel_2_2.setForeground(SystemColor.text);
		lblNewLabel_2_2.setBounds(57, 119, 55, 16);
		panel_2.add(lblNewLabel_2_2);
		
		txtInterest = new JTextField();
		txtInterest.setColumns(10);
		txtInterest.setBounds(167, 113, 122, 28);
		panel_2.add(txtInterest);
		
		JLabel lblNewLabel_2_3 = new JLabel("Description");
		lblNewLabel_2_3.setForeground(SystemColor.text);
		lblNewLabel_2_3.setBounds(57, 159, 73, 16);
		panel_2.add(lblNewLabel_2_3);
		
		txtDescription = new JTextField();
		txtDescription.setColumns(10);
		txtDescription.setBounds(167, 153, 122, 28);
		panel_2.add(txtDescription);
		
		JLabel lblNewLabel_2_4 = new JLabel("Status");
		lblNewLabel_2_4.setForeground(SystemColor.text);
		lblNewLabel_2_4.setBounds(57, 199, 55, 16);
		panel_2.add(lblNewLabel_2_4);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnUpdate_actionPerformed(e);
			}
		});
		btnUpdate.setBounds(167, 240, 90, 28);
		panel_2.add(btnUpdate);
		
		chkStatus = new JCheckBox("Public");
		chkStatus.setForeground(SystemColor.text);
		chkStatus.setBounds(167, 198, 104, 18);
		panel_2.add(chkStatus);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("ID");
		lblNewLabel_2_1_1.setForeground(Color.WHITE);
		lblNewLabel_2_1_1.setBounds(57, 38, 55, 16);
		panel_2.add(lblNewLabel_2_1_1);
		
		txtID = new JTextField();
		txtID.setEnabled(false);
		txtID.setEditable(false);
		txtID.setColumns(10);
		txtID.setBounds(167, 32, 122, 28);
		panel_2.add(txtID);
	}
	
	public JFrameUpdateLoanType(Map<Integer, Object> data) {
		this();
		this.data = data;
		loadData();
	}
	
	private void loadData() {
		LoanType loanType = (LoanType) data.get(1);
		txtID.setText(String.valueOf(loanType.getId()));
		txtName.setText(loanType.getName());
		txtDescription.setText(loanType.getDescription());
		txtInterest.setText(String.valueOf(loanType.getInterest()));
		chkStatus.setSelected(loanType.isStatus());
		txtID.setEditable(false);
	}
	
	public void btnUpdate_actionPerformed(ActionEvent e) {
		LoanType loanType = new LoanType();
		loanType.setId(Integer.parseInt(txtID.getText().trim()));
		loanType.setName(txtName.getText().trim());
		loanType.setInterest(Float.parseFloat(txtInterest.getText().trim()));
		loanType.setDescription(txtDescription.getText().trim());
		loanType.setStatus(chkStatus.isSelected());
		LoanTypeModel loanTypeModel = new LoanTypeModel();
		if (loanTypeModel.update(loanType)) {
			JOptionPane.showMessageDialog(null, "Done");
			this.dispose();
		} else {
			JOptionPane.showMessageDialog(null, "Failed");
		}
	}
}
