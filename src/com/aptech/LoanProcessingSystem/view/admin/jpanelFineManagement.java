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
import com.aptech.LoanProcessingSystem.entities.Fine;
import com.aptech.LoanProcessingSystem.entities.Loan;
import com.aptech.LoanProcessingSystem.entities.LoanType;
import com.aptech.LoanProcessingSystem.entities.PaymentType;
import com.aptech.LoanProcessingSystem.model.CustomerModel;
import com.aptech.LoanProcessingSystem.model.FineModel;
import com.aptech.LoanProcessingSystem.model.LoanModel;
import com.aptech.LoanProcessingSystem.model.LoanTypeModel;
import com.aptech.LoanProcessingSystem.model.PaymentTypeModel;
import com.toedter.calendar.JDateChooser;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
import java.awt.Insets;
import javax.swing.JScrollBar;
import javax.swing.SwingConstants;

public class jpanelFineManagement extends JPanel {
	private Account account = new Account();
	private JButton btnUpdate;
	private JTextField txtMin1;
	private JTextField txtMax1;
	private JTextField txtInterest1;
	private JTextField txtMin2;
	private JTextField txtMax2;
	private JTextField txtInterest2;
	private JTextField txtMin3;
	private JTextField txtMax3;
	private JTextField txtInterest3;
	private JTextArea jtextareaDes1;
	private JTextArea jtextareaDis2;
	private JTextArea jtextareaDis3;
	private Fine fine1 = new Fine();
	private Fine fine2 = new Fine();
	private Fine fine3 = new Fine();

	/**
	 * Create the panel.
	 */
	public jpanelFineManagement() {
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
				lblNewLabel.setIcon(new ImageIcon(jpanelFineManagement.class
						.getResource("/com/aptech/LoanProcessingSystem/images/icons8_add_tab_20px_1.png")));
				panel.add(lblNewLabel);
			}
			{
				JLabel lblNewLabel_1 = new JLabel("Fine Management");
				lblNewLabel_1.setForeground(Color.WHITE);
				lblNewLabel_1.setFont(new Font("Dialog", Font.PLAIN, 30));
				panel.add(lblNewLabel_1);
			}
		}
		{
			JPanel panel = new JPanel();
			panel.setBackground(new Color(34, 40, 44));
			add(panel);
			panel.setLayout(new BorderLayout(0, 0));
			{
				JPanel panel_1 = new JPanel();
				panel_1.setBackground(new Color(34, 40, 44));
				panel.add(panel_1, BorderLayout.CENTER);
				panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.Y_AXIS));
				{
					JPanel panel_2 = new JPanel();
					panel_2.setBackground(new Color(34, 40, 44));
					panel_1.add(panel_2);
					panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.X_AXIS));
					{
						JPanel panel_3 = new JPanel();
						FlowLayout flowLayout = (FlowLayout) panel_3.getLayout();
						flowLayout.setVgap(70);
						panel_3.setBackground(new Color(34, 40, 44));
						panel_2.add(panel_3);
						{
							JLabel lblNewLabel_2 = new JLabel("Min Installment");
							panel_3.add(lblNewLabel_2);
							lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
							lblNewLabel_2.setForeground(SystemColor.text);
						}
					}
					{
						JPanel panel_3 = new JPanel();
						FlowLayout flowLayout = (FlowLayout) panel_3.getLayout();
						flowLayout.setVgap(70);
						panel_3.setBackground(new Color(34, 40, 44));
						panel_2.add(panel_3);
						{
							txtMin1 = new JTextField();
							txtMin1.setHorizontalAlignment(SwingConstants.CENTER);
							txtMin1.setFont(new Font("Tahoma", Font.PLAIN, 20));
							panel_3.add(txtMin1);
							txtMin1.setColumns(15);
						}
					}
					{
						JPanel panel_3 = new JPanel();
						FlowLayout flowLayout = (FlowLayout) panel_3.getLayout();
						flowLayout.setVgap(70);
						panel_3.setBackground(new Color(34, 40, 44));
						panel_2.add(panel_3);
						{
							JLabel lblNewLabel_3 = new JLabel("Max Installment");
							panel_3.add(lblNewLabel_3);
							lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
							lblNewLabel_3.setForeground(SystemColor.text);
						}
					}
					{
						JPanel panel_3 = new JPanel();
						FlowLayout flowLayout = (FlowLayout) panel_3.getLayout();
						flowLayout.setVgap(70);
						panel_3.setBackground(new Color(34, 40, 44));
						panel_2.add(panel_3);
						{
							txtMax1 = new JTextField();
							txtMax1.setHorizontalAlignment(SwingConstants.CENTER);
							txtMax1.setFont(new Font("Tahoma", Font.PLAIN, 20));
							panel_3.add(txtMax1);
							txtMax1.setColumns(15);
						}
					}
					{
						JPanel panel_3 = new JPanel();
						FlowLayout flowLayout = (FlowLayout) panel_3.getLayout();
						flowLayout.setVgap(70);
						panel_3.setBackground(new Color(34, 40, 44));
						panel_2.add(panel_3);
						{
							JLabel lblNewLabel_4 = new JLabel("Fine Interest");
							panel_3.add(lblNewLabel_4);
							lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
							lblNewLabel_4.setForeground(SystemColor.text);
						}
					}
					{
						JPanel panel_3 = new JPanel();
						FlowLayout flowLayout = (FlowLayout) panel_3.getLayout();
						flowLayout.setVgap(70);
						panel_3.setBackground(new Color(34, 40, 44));
						panel_2.add(panel_3);
						{
							txtInterest1 = new JTextField();
							txtInterest1.setHorizontalAlignment(SwingConstants.CENTER);
							txtInterest1.setFont(new Font("Tahoma", Font.PLAIN, 20));
							panel_3.add(txtInterest1);
							txtInterest1.setColumns(15);
						}
					}
					{
						JPanel panel_3 = new JPanel();
						FlowLayout flowLayout = (FlowLayout) panel_3.getLayout();
						flowLayout.setVgap(70);
						panel_3.setBackground(new Color(34, 40, 44));
						panel_2.add(panel_3);
						{
							JLabel lblNewLabel_5 = new JLabel("Description");
							panel_3.add(lblNewLabel_5);
							lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
							lblNewLabel_5.setForeground(SystemColor.text);
						}
					}
					{
						JPanel panel_3 = new JPanel();
						FlowLayout flowLayout = (FlowLayout) panel_3.getLayout();
						flowLayout.setVgap(70);
						panel_3.setBackground(new Color(34, 40, 44));
						panel_2.add(panel_3);
						{
							JScrollPane scrollPane = new JScrollPane();
							panel_3.add(scrollPane);
							{
								jtextareaDes1 = new JTextArea();
								jtextareaDes1.setPreferredSize(new Dimension(300, 100));
								scrollPane.setViewportView(jtextareaDes1);
							}
						}
					}
				}
				{
					JPanel panel_2 = new JPanel();
					panel_2.setBackground(new Color(34, 40, 44));
					panel_1.add(panel_2);
					panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.X_AXIS));
					{
						JPanel panel_3 = new JPanel();
						FlowLayout flowLayout = (FlowLayout) panel_3.getLayout();
						flowLayout.setVgap(70);
						panel_3.setBackground(new Color(34, 40, 44));
						panel_2.add(panel_3);
						{
							JLabel lblNewLabel_2 = new JLabel("Min Installment");
							panel_3.add(lblNewLabel_2);
							lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
							lblNewLabel_2.setForeground(SystemColor.text);
						}
					}
					{
						JPanel panel_3 = new JPanel();
						FlowLayout flowLayout = (FlowLayout) panel_3.getLayout();
						flowLayout.setVgap(70);
						panel_3.setBackground(new Color(34, 40, 44));
						panel_2.add(panel_3);
						{
							txtMin2 = new JTextField();
							txtMin2.setHorizontalAlignment(SwingConstants.CENTER);
							txtMin2.setFont(new Font("Tahoma", Font.PLAIN, 20));
							panel_3.add(txtMin2);
							txtMin2.setColumns(15);
						}
					}
					{
						JPanel panel_3 = new JPanel();
						FlowLayout flowLayout = (FlowLayout) panel_3.getLayout();
						flowLayout.setVgap(70);
						panel_3.setBackground(new Color(34, 40, 44));
						panel_2.add(panel_3);
						{
							JLabel lblNewLabel_3 = new JLabel("Max Installment");
							panel_3.add(lblNewLabel_3);
							lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
							lblNewLabel_3.setForeground(SystemColor.text);
						}
					}
					{
						JPanel panel_3 = new JPanel();
						FlowLayout flowLayout = (FlowLayout) panel_3.getLayout();
						flowLayout.setVgap(70);
						panel_3.setBackground(new Color(34, 40, 44));
						panel_2.add(panel_3);
						{
							txtMax2 = new JTextField();
							txtMax2.setHorizontalAlignment(SwingConstants.CENTER);
							txtMax2.setFont(new Font("Tahoma", Font.PLAIN, 20));
							panel_3.add(txtMax2);
							txtMax2.setColumns(15);
						}
					}
					{
						JPanel panel_3 = new JPanel();
						FlowLayout flowLayout = (FlowLayout) panel_3.getLayout();
						flowLayout.setVgap(70);
						panel_3.setBackground(new Color(34, 40, 44));
						panel_2.add(panel_3);
						{
							JLabel lblNewLabel_4 = new JLabel("Fine Interest");
							panel_3.add(lblNewLabel_4);
							lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
							lblNewLabel_4.setForeground(SystemColor.text);
						}
					}
					{
						JPanel panel_3 = new JPanel();
						FlowLayout flowLayout = (FlowLayout) panel_3.getLayout();
						flowLayout.setVgap(70);
						panel_3.setBackground(new Color(34, 40, 44));
						panel_2.add(panel_3);
						{
							txtInterest2 = new JTextField();
							txtInterest2.setHorizontalAlignment(SwingConstants.CENTER);
							txtInterest2.setFont(new Font("Tahoma", Font.PLAIN, 20));
							panel_3.add(txtInterest2);
							txtInterest2.setColumns(15);
						}
					}
					{
						JPanel panel_3 = new JPanel();
						FlowLayout flowLayout = (FlowLayout) panel_3.getLayout();
						flowLayout.setVgap(70);
						panel_3.setBackground(new Color(34, 40, 44));
						panel_2.add(panel_3);
						{
							JLabel lblNewLabel_5 = new JLabel("Description");
							panel_3.add(lblNewLabel_5);
							lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
							lblNewLabel_5.setForeground(SystemColor.text);
						}
					}
					{
						JPanel panel_3 = new JPanel();
						FlowLayout flowLayout = (FlowLayout) panel_3.getLayout();
						flowLayout.setVgap(70);
						panel_3.setBackground(new Color(34, 40, 44));
						panel_2.add(panel_3);
						{
							JScrollPane scrollPane = new JScrollPane();
							panel_3.add(scrollPane);
							{
								jtextareaDis2 = new JTextArea();
								jtextareaDis2.setPreferredSize(new Dimension(300, 100));
								scrollPane.setViewportView(jtextareaDis2);
							}
						}
					}
				}
				{
					JPanel panel_2 = new JPanel();
					panel_2.setBackground(new Color(34, 40, 44));
					panel_1.add(panel_2);
					panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.X_AXIS));
					{
						JPanel panel_3 = new JPanel();
						FlowLayout flowLayout = (FlowLayout) panel_3.getLayout();
						flowLayout.setVgap(70);
						panel_3.setBackground(new Color(34, 40, 44));
						panel_2.add(panel_3);
						{
							JLabel lblNewLabel_2 = new JLabel("Min Installment");
							panel_3.add(lblNewLabel_2);
							lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
							lblNewLabel_2.setForeground(SystemColor.text);
						}
					}
					{
						JPanel panel_3 = new JPanel();
						FlowLayout flowLayout = (FlowLayout) panel_3.getLayout();
						flowLayout.setVgap(70);
						panel_3.setBackground(new Color(34, 40, 44));
						panel_2.add(panel_3);
						{
							txtMin3 = new JTextField();
							txtMin3.setHorizontalAlignment(SwingConstants.CENTER);
							txtMin3.setFont(new Font("Tahoma", Font.PLAIN, 20));
							panel_3.add(txtMin3);
							txtMin3.setColumns(15);
						}
					}
					{
						JPanel panel_3 = new JPanel();
						FlowLayout flowLayout = (FlowLayout) panel_3.getLayout();
						flowLayout.setVgap(70);
						panel_3.setBackground(new Color(34, 40, 44));
						panel_2.add(panel_3);
						{
							JLabel lblNewLabel_3 = new JLabel("Max Installment");
							panel_3.add(lblNewLabel_3);
							lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
							lblNewLabel_3.setForeground(SystemColor.text);
						}
					}
					{
						JPanel panel_3 = new JPanel();
						FlowLayout flowLayout = (FlowLayout) panel_3.getLayout();
						flowLayout.setVgap(70);
						panel_3.setBackground(new Color(34, 40, 44));
						panel_2.add(panel_3);
						{
							txtMax3 = new JTextField();
							txtMax3.setHorizontalAlignment(SwingConstants.CENTER);
							txtMax3.setFont(new Font("Tahoma", Font.PLAIN, 20));
							panel_3.add(txtMax3);
							txtMax3.setColumns(15);
						}
					}
					{
						JPanel panel_3 = new JPanel();
						FlowLayout flowLayout = (FlowLayout) panel_3.getLayout();
						flowLayout.setVgap(70);
						panel_3.setBackground(new Color(34, 40, 44));
						panel_2.add(panel_3);
						{
							JLabel lblNewLabel_4 = new JLabel("Fine Interest");
							panel_3.add(lblNewLabel_4);
							lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
							lblNewLabel_4.setForeground(SystemColor.text);
						}
					}
					{
						JPanel panel_3 = new JPanel();
						FlowLayout flowLayout = (FlowLayout) panel_3.getLayout();
						flowLayout.setVgap(70);
						panel_3.setBackground(new Color(34, 40, 44));
						panel_2.add(panel_3);
						{
							txtInterest3 = new JTextField();
							txtInterest3.setHorizontalAlignment(SwingConstants.CENTER);
							txtInterest3.setFont(new Font("Tahoma", Font.PLAIN, 20));
							panel_3.add(txtInterest3);
							txtInterest3.setColumns(15);
						}
					}
					{
						JPanel panel_3 = new JPanel();
						FlowLayout flowLayout = (FlowLayout) panel_3.getLayout();
						flowLayout.setVgap(70);
						panel_3.setBackground(new Color(34, 40, 44));
						panel_2.add(panel_3);
						{
							JLabel lblNewLabel_5 = new JLabel("Description");
							panel_3.add(lblNewLabel_5);
							lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
							lblNewLabel_5.setForeground(SystemColor.text);
						}
					}
					{
						JPanel panel_3 = new JPanel();
						FlowLayout flowLayout = (FlowLayout) panel_3.getLayout();
						flowLayout.setVgap(70);
						panel_3.setBackground(new Color(34, 40, 44));
						panel_2.add(panel_3);
						{
							JScrollPane scrollPane = new JScrollPane();
							panel_3.add(scrollPane);
							{
								jtextareaDis3 = new JTextArea();
								jtextareaDis3.setPreferredSize(new Dimension(300, 100));
								scrollPane.setViewportView(jtextareaDis3);
							}
						}
					}
				}
			}
		}
		{
			JPanel panel = new JPanel();
			FlowLayout flowLayout = (FlowLayout) panel.getLayout();
			flowLayout.setVgap(30);
			panel.setBackground(new Color(34, 40, 44));
			add(panel);
			{
				btnUpdate = new JButton("Update");
				btnUpdate.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						btnUpdate_actionPerformed(e);
					}
				});
				btnUpdate.setPreferredSize(new Dimension(120, 40));
				panel.add(btnUpdate);
			}
		}
		loadData();
	}

	public void btnUpdate_actionPerformed(ActionEvent e) {
		FineModel fineModel = new FineModel();
		boolean check = false;
		this.fine1.setFineInterest(Float.parseFloat(txtInterest1.getText().trim()));
		this.fine1.setMin(Double.parseDouble(txtMin1.getText().trim()));
		this.fine1.setMax(Double.parseDouble(txtMax1.getText().trim()));
		this.fine1.setDescription(jtextareaDes1.getText().trim());
		if (fineModel.updateFine(this.fine1)) {
			check = true;
		} else {
			check = false;
		}

		this.fine2.setFineInterest(Float.parseFloat(txtInterest2.getText().trim()));
		this.fine2.setMin(Double.parseDouble(txtMin2.getText().trim()));
		this.fine2.setMax(Double.parseDouble(txtMax2.getText().trim()));
		this.fine2.setDescription(jtextareaDis2.getText().trim());
		if (fineModel.updateFine(this.fine2)) {
			check = true;
		} else {
			check = false;
		}

		this.fine3.setFineInterest(Float.parseFloat(txtInterest3.getText().trim()));
		this.fine3.setMin(Double.parseDouble(txtMin3.getText().trim()));
		this.fine3.setMax(Double.parseDouble(txtMax3.getText().trim()));
		this.fine3.setDescription(jtextareaDis3.getText().trim());
		if (fineModel.updateFine(this.fine3)) {
			check = true;
		} else {
			check = false;
		}
		
		if (check) {
			JOptionPane.showMessageDialog(null, "Done");
		} else {
			JOptionPane.showMessageDialog(null, "Failed");
		}
	}

	private void loadData() {
		FineModel fineModel = new FineModel();
		this.fine1 = fineModel.findFineInterest(1);
		txtInterest1.setText(String.valueOf(fine1.getFineInterest()));
		txtMin1.setText(String.valueOf(fine1.getMin()));
		txtMax1.setText(String.valueOf(fine1.getMax()));
		jtextareaDes1.setText(fine1.getDescription());
		this.fine2 = fineModel.findFineInterest(2);
		txtInterest2.setText(String.valueOf(fine2.getFineInterest()));
		txtMin2.setText(String.valueOf(fine2.getMin()));
		txtMax2.setText(String.valueOf(fine2.getMax()));
		jtextareaDis2.setText(fine2.getDescription());
		this.fine3 = fineModel.findFineInterest(3);
		txtInterest3.setText(String.valueOf(fine3.getFineInterest()));
		txtMin3.setText(String.valueOf(fine3.getMin()));
		txtMax3.setText(String.valueOf(fine3.getMax()));
		jtextareaDis3.setText(fine3.getDescription());
	}
}
