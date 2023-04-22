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
import java.awt.event.ActionEvent;

public class JFrameAddNewLoanType extends JFrame {

	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtInterest;
	private JTextField txtDescription;
	private JCheckBox chkStatus;

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
					JFrameAddNewLoanType frame = new JFrameAddNewLoanType();
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
	public JFrameAddNewLoanType() {
		setTitle("Add New ");
		setBounds(100, 100, 362, 342);
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
		lblNewLabel.setIcon(new ImageIcon(JFrameAddNewLoanType.class
				.getResource("/com/aptech/LoanProcessingSystem/images/icons8_add_tab_20px_1.png")));
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Add New Loan Type");
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
		lblNewLabel_2_1.setBounds(57, 36, 55, 16);
		panel_2.add(lblNewLabel_2_1);

		txtName = new JTextField();
		txtName.setColumns(10);
		txtName.setBounds(167, 30, 122, 28);
		panel_2.add(txtName);

		JLabel lblNewLabel_2_2 = new JLabel("Interest");
		lblNewLabel_2_2.setForeground(SystemColor.text);
		lblNewLabel_2_2.setBounds(57, 76, 55, 16);
		panel_2.add(lblNewLabel_2_2);

		txtInterest = new JTextField();
		txtInterest.setColumns(10);
		txtInterest.setBounds(167, 70, 122, 28);
		panel_2.add(txtInterest);

		JLabel lblNewLabel_2_3 = new JLabel("Description");
		lblNewLabel_2_3.setForeground(SystemColor.text);
		lblNewLabel_2_3.setBounds(57, 116, 73, 16);
		panel_2.add(lblNewLabel_2_3);

		txtDescription = new JTextField();
		txtDescription.setColumns(10);
		txtDescription.setBounds(167, 110, 122, 28);
		panel_2.add(txtDescription);

		JLabel lblNewLabel_2_4 = new JLabel("Status");
		lblNewLabel_2_4.setForeground(SystemColor.text);
		lblNewLabel_2_4.setBounds(57, 156, 55, 16);
		panel_2.add(lblNewLabel_2_4);

		JButton btnAddNewLoanType = new JButton("Add");
		btnAddNewLoanType.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnAddNewLoanType_actionPerformed(e);
			}
		});
		btnAddNewLoanType.setBounds(167, 197, 90, 28);
		panel_2.add(btnAddNewLoanType);

		chkStatus = new JCheckBox("Public");
		chkStatus.setForeground(SystemColor.text);
		chkStatus.setBounds(167, 155, 104, 18);
		panel_2.add(chkStatus);
	}

	public void btnAddNewLoanType_actionPerformed(ActionEvent e) {
		LoanType loanType = new LoanType();
		loanType.setName(txtName.getText().trim());
		loanType.setInterest(Double.parseDouble(txtInterest.getText().trim()));
		loanType.setDescription(txtDescription.getText().trim());
		loanType.setStatus(chkStatus.isSelected());
		LoanTypeModel loanTypeModel = new LoanTypeModel();
		if (loanTypeModel.create(loanType)) {
			JOptionPane.showMessageDialog(null, "Done");
			this.setVisible(false);
		} else {
			JOptionPane.showMessageDialog(null, "Failed");
		}
	}
}
