package com.aptech.LoanProcessingSystem.view.admin;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import com.aptech.LoanProcessingSystem.entities.Customer;
import com.aptech.LoanProcessingSystem.entities.Loan;
import com.aptech.LoanProcessingSystem.entities.LoanAndFineHistory;
import com.aptech.LoanProcessingSystem.entities.LoanType;
import com.aptech.LoanProcessingSystem.entities.PaymentType;
import com.aptech.LoanProcessingSystem.model.AccountModel;
import com.aptech.LoanProcessingSystem.model.CustomerModel;
import com.aptech.LoanProcessingSystem.model.LoanAndFineHistoryModel;
import com.aptech.LoanProcessingSystem.model.LoanModel;
import com.aptech.LoanProcessingSystem.model.LoanTypeModel;
import com.aptech.LoanProcessingSystem.model.PaymentTypeModel;
import com.aptech.LoanProcessingSystem.service.Common;
import com.aptech.LoanProcessingSystem.view.CreateLoan;
import com.aptech.LoanProcessingSystem.view.PaymentLoan;
import com.toedter.calendar.JDateChooser;

public class jpanelShowLoanDetail extends JPanel {
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
	private Loan loan = new Loan();
	private JTable tableLoanHistory;
	private JTextField txtCustomerID;
	private JComboBox cbPaymentType;
	private JTextField txtAmount;
	private JTextField txtDuration;
	private JComboBox cbLoanType;
	private JTextField txtPeriod;
	private JDateChooser jdatechooserEndDate;
	private JDateChooser jdatechooserDisbursementDate;
	private JTextArea textArea;
	private JCheckBox chkStatus;

	/**
	 * Create the panel.
	 */
	public jpanelShowLoanDetail() {
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
				panel_1.setBackground(new Color(34, 40, 44));
				panel.add(panel_1);
				panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.Y_AXIS));
				{
					JPanel panel_2 = new JPanel();
					panel_2.setBackground(new Color(34, 40, 44));
					panel_1.add(panel_2);
					{
						JLabel lblNewLabel_1 = new JLabel("ID:");
						lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
						lblNewLabel_1.setForeground(SystemColor.text);
						panel_2.add(lblNewLabel_1);
					}
					{
						lblId = new JLabel("New label");
						lblId.setFont(new Font("Tahoma", Font.PLAIN, 17));
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
						lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
						lblNewLabel_1.setForeground(SystemColor.text);
						panel_2.add(lblNewLabel_1);
					}
					{
						lblName = new JLabel("New label");
						lblName.setFont(new Font("Tahoma", Font.PLAIN, 17));
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
						lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
						lblNewLabel_1.setForeground(SystemColor.text);
						panel_2.add(lblNewLabel_1);
					}
					{
						lblAddress = new JLabel("New label");
						lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 17));
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
					{
						JButton btnViewAllLoans = new JButton("View All Loans");
						btnViewAllLoans.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								btnViewAllLoans_actionPerformed(e);
							}
						});
						panel_2.add(btnViewAllLoans);
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
						lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
						lblNewLabel_1.setForeground(SystemColor.text);
						panel_2.add(lblNewLabel_1);
					}
					{
						lblPhone = new JLabel("New label");
						lblPhone.setFont(new Font("Tahoma", Font.PLAIN, 17));
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
						lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
						lblNewLabel_1.setForeground(SystemColor.text);
						panel_2.add(lblNewLabel_1);
					}
					{
						lblEmail = new JLabel("New label");
						lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 17));
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
						lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
						lblNewLabel_1.setForeground(SystemColor.text);
						panel_2.add(lblNewLabel_1);
					}
					{
						lblGender = new JLabel("New label");
						lblGender.setFont(new Font("Tahoma", Font.PLAIN, 17));
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
						lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
						lblNewLabel_1.setForeground(SystemColor.text);
						panel_2.add(lblNewLabel_1);
					}
					{
						lblDOB = new JLabel("New label");
						lblDOB.setFont(new Font("Tahoma", Font.PLAIN, 17));
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
						lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
						lblNewLabel_1.setForeground(SystemColor.text);
						panel_2.add(lblNewLabel_1);
					}
					{
						lblSalary = new JLabel("New label");
						lblSalary.setFont(new Font("Tahoma", Font.PLAIN, 17));
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
						lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
						lblNewLabel_1.setForeground(SystemColor.text);
						panel_2.add(lblNewLabel_1);
					}
					{
						lblJob = new JLabel("New label");
						lblJob.setFont(new Font("Tahoma", Font.PLAIN, 17));
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
						lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
						lblNewLabel_1.setForeground(SystemColor.text);
						panel_2.add(lblNewLabel_1);
					}
					{
						lblCompany = new JLabel("New label");
						lblCompany.setFont(new Font("Tahoma", Font.PLAIN, 17));
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
						lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
						lblNewLabel_1.setForeground(SystemColor.text);
						panel_2.add(lblNewLabel_1);
					}
					{
						lblIDCard = new JLabel("New label");
						lblIDCard.setFont(new Font("Tahoma", Font.PLAIN, 17));
						lblIDCard.setForeground(SystemColor.text);
						panel_2.add(lblIDCard);
					}
				}
			}
		}
		{
			JPanel panel = new JPanel();
			panel.setMinimumSize(new Dimension(100, 100));
			panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Loan Detail",
					TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 255, 255)));
			panel.setBackground(new Color(34, 40, 44));
			add(panel);
			panel.setLayout(new BorderLayout(0, 0));
			{
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBackground(SystemColor.controlText);
				panel.add(scrollPane);
				{
					tblLoanDetail = new JTable();
					tblLoanDetail.setFont(new Font("Tahoma", Font.PLAIN, 15));
					tblLoanDetail.setRowHeight(30);
					tblLoanDetail.setBackground(new Color(34, 40, 44));
					tblLoanDetail.setForeground(SystemColor.text);
					scrollPane.setViewportView(tblLoanDetail);
				}
			}
		}
		{
			JPanel panel = new JPanel();
			panel.setBackground(new Color(34, 40, 44));
			panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Loan Action",
					TitledBorder.LEADING, TitledBorder.TOP, null, SystemColor.text));
			add(panel);
			panel.setLayout(new BorderLayout(0, 0));
			{
				JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
				tabbedPane.setBackground(new Color(34, 40, 44));
				panel.add(tabbedPane, BorderLayout.CENTER);
				{
					JPanel panel_1 = new JPanel();
					panel_1.setBackground(new Color(34, 40, 44));
					tabbedPane.addTab("Repayment", null, panel_1, null);
					tabbedPane.setBackgroundAt(0, Color.BLUE);
					panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.Y_AXIS));
					{
						JPanel panel_2 = new JPanel();
						panel_2.setBackground(new Color(34, 40, 44));
						panel_1.add(panel_2);
						panel_2.setLayout(new BorderLayout(0, 0));
						{
							JScrollPane scrollPane = new JScrollPane();
							panel_2.add(scrollPane, BorderLayout.CENTER);
							{
								tableLoanHistory = new JTable();
								tableLoanHistory.setRowHeight(30);
								tableLoanHistory.setFont(new Font("Tahoma", Font.PLAIN, 13));
								tableLoanHistory.setForeground(SystemColor.text);
								tableLoanHistory.setBackground(new Color(34, 40, 44));
								scrollPane.setViewportView(tableLoanHistory);
							}
						}
					}
				}
				{
					JPanel panel_1 = new JPanel();
					panel_1.setBackground(new Color(34, 40, 44));
					tabbedPane.addTab("Loan terms", null, panel_1, null);
					panel_1.setLayout(new BorderLayout(0, 0));
					{
						JPanel panel_LoanTerms = new JPanel();
						panel_LoanTerms.setBackground(new Color(34, 40, 44));
						panel_1.add(panel_LoanTerms, BorderLayout.CENTER);
						panel_LoanTerms.setLayout(new BoxLayout(panel_LoanTerms, BoxLayout.X_AXIS));
						{
							JPanel panel_2 = new JPanel();
							panel_2.setBackground(new Color(34, 40, 44));
							panel_LoanTerms.add(panel_2);
							panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.Y_AXIS));
							{
								JPanel panel_3 = new JPanel();
								panel_3.setBackground(new Color(34, 40, 44));
								panel_2.add(panel_3);
								panel_3.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 35));
								{
									JLabel lblNewLabel_2 = new JLabel("Customer ID");
									lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
									lblNewLabel_2.setBorder(new EmptyBorder(0, 120, 0, 0));
									lblNewLabel_2.setForeground(Color.WHITE);
									panel_3.add(lblNewLabel_2);
								}
							}
							{
								JPanel panel_3 = new JPanel();
								FlowLayout flowLayout = (FlowLayout) panel_3.getLayout();
								flowLayout.setAlignment(FlowLayout.LEFT);
								flowLayout.setVgap(35);
								panel_3.setBackground(new Color(34, 40, 44));
								panel_2.add(panel_3);
								{
									JLabel lblNewLabel_2_1 = new JLabel("Payment Type");
									lblNewLabel_2_1.setBorder(new EmptyBorder(0, 120, 0, 0));
									lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
									lblNewLabel_2_1.setForeground(Color.WHITE);
									panel_3.add(lblNewLabel_2_1);
								}
							}
							{
								JPanel panel_3 = new JPanel();
								FlowLayout flowLayout = (FlowLayout) panel_3.getLayout();
								flowLayout.setAlignment(FlowLayout.LEFT);
								flowLayout.setVgap(35);
								panel_3.setBackground(new Color(34, 40, 44));
								panel_2.add(panel_3);
								{
									JLabel lblNewLabel_2_1 = new JLabel("Amount");
									lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
									lblNewLabel_2_1.setBorder(new EmptyBorder(0, 120, 0, 0));
									lblNewLabel_2_1.setForeground(Color.WHITE);
									panel_3.add(lblNewLabel_2_1);
								}
							}
							{
								JPanel panel_3 = new JPanel();
								FlowLayout flowLayout = (FlowLayout) panel_3.getLayout();
								flowLayout.setAlignment(FlowLayout.LEFT);
								flowLayout.setVgap(35);
								panel_3.setBackground(new Color(34, 40, 44));
								panel_2.add(panel_3);
								{
									JLabel lblNewLabel_2_1 = new JLabel("Duration");
									lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
									lblNewLabel_2_1.setBorder(new EmptyBorder(0, 120, 0, 0));
									lblNewLabel_2_1.setForeground(Color.WHITE);
									panel_3.add(lblNewLabel_2_1);
								}
							}
							{
								JPanel panel_3 = new JPanel();
								FlowLayout flowLayout = (FlowLayout) panel_3.getLayout();
								flowLayout.setAlignment(FlowLayout.LEFT);
								flowLayout.setVgap(35);
								panel_3.setBackground(new Color(34, 40, 44));
								panel_2.add(panel_3);
								{
									JLabel lblNewLabel_2_1 = new JLabel("Loan Type");
									lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
									lblNewLabel_2_1.setBorder(new EmptyBorder(0, 120, 0, 0));
									lblNewLabel_2_1.setForeground(Color.WHITE);
									panel_3.add(lblNewLabel_2_1);
								}
							}
						}
						{
							JPanel panel_2 = new JPanel();
							panel_2.setBackground(new Color(34, 40, 44));
							panel_LoanTerms.add(panel_2);
							panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.Y_AXIS));
							{
								JPanel panel_3 = new JPanel();
								panel_3.setBackground(new Color(34, 40, 44));
								FlowLayout flowLayout = (FlowLayout) panel_3.getLayout();
								flowLayout.setAlignment(FlowLayout.LEFT);
								flowLayout.setVgap(35);
								panel_2.add(panel_3);
								{
									txtCustomerID = new JTextField();
									panel_3.add(txtCustomerID);
									txtCustomerID.setFont(new Font("Tahoma", Font.PLAIN, 15));
									txtCustomerID.setColumns(15);
								}
							}
							{
								JPanel panel_3 = new JPanel();
								panel_3.setBackground(new Color(34, 40, 44));
								FlowLayout flowLayout = (FlowLayout) panel_3.getLayout();
								flowLayout.setAlignment(FlowLayout.LEFT);
								flowLayout.setVgap(35);
								panel_2.add(panel_3);
								{
									cbPaymentType = new JComboBox();
									panel_3.add(cbPaymentType);
									cbPaymentType.setFont(new Font("Tahoma", Font.PLAIN, 15));
								}
							}
							{
								JPanel panel_3 = new JPanel();
								panel_3.setBackground(new Color(34, 40, 44));
								FlowLayout flowLayout = (FlowLayout) panel_3.getLayout();
								flowLayout.setAlignment(FlowLayout.LEFT);
								flowLayout.setVgap(35);
								panel_2.add(panel_3);
								{
									txtAmount = new JTextField();
									panel_3.add(txtAmount);
									txtAmount.setFont(new Font("Tahoma", Font.PLAIN, 15));
									txtAmount.setColumns(15);
								}
							}
							{
								JPanel panel_3 = new JPanel();
								panel_3.setBackground(new Color(34, 40, 44));
								FlowLayout flowLayout = (FlowLayout) panel_3.getLayout();
								flowLayout.setAlignment(FlowLayout.LEFT);
								flowLayout.setVgap(35);
								panel_2.add(panel_3);
								{
									txtDuration = new JTextField();
									panel_3.add(txtDuration);
									txtDuration.addFocusListener(new FocusAdapter() {

										@Override
										public void focusLost(FocusEvent e) {
//											txtDuration_focusLost(e);
										}
									});
									txtDuration.setFont(new Font("Tahoma", Font.PLAIN, 15));
									txtDuration.setColumns(15);
								}
							}
							{

								JPanel panel_3 = new JPanel();
								panel_3.setBackground(new Color(34, 40, 44));
								FlowLayout flowLayout = (FlowLayout) panel_3.getLayout();
								flowLayout.setAlignment(FlowLayout.LEFT);
								flowLayout.setVgap(35);
								panel_2.add(panel_3);
								{
									cbLoanType = new JComboBox();
									panel_3.add(cbLoanType);
									cbLoanType.setFont(new Font("Tahoma", Font.PLAIN, 15));
								}
							}
						}
						{
							JPanel panel_2 = new JPanel();
							panel_2.setBackground(new Color(34, 40, 44));
							panel_LoanTerms.add(panel_2);
							panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.Y_AXIS));
							{
								JPanel panel_3 = new JPanel();
								FlowLayout flowLayout = (FlowLayout) panel_3.getLayout();
								flowLayout.setAlignment(FlowLayout.LEFT);
								flowLayout.setVgap(35);
								panel_3.setBackground(new Color(34, 40, 44));
								panel_2.add(panel_3);
								{
									JLabel lblNewLabel_2_1 = new JLabel("Period");
									lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
									lblNewLabel_2_1.setBorder(new EmptyBorder(0, 120, 0, 0));
									lblNewLabel_2_1.setForeground(Color.WHITE);
									panel_3.add(lblNewLabel_2_1);
								}
							}
							{
								JPanel panel_3 = new JPanel();
								FlowLayout flowLayout = (FlowLayout) panel_3.getLayout();
								flowLayout.setAlignment(FlowLayout.LEFT);
								flowLayout.setVgap(35);
								panel_3.setBackground(new Color(34, 40, 44));
								panel_2.add(panel_3);
								{
									JLabel lblNewLabel_2_1 = new JLabel("End Date");
									lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
									lblNewLabel_2_1.setBorder(new EmptyBorder(0, 120, 0, 0));
									lblNewLabel_2_1.setForeground(Color.WHITE);
									panel_3.add(lblNewLabel_2_1);
								}
							}
							{
								JPanel panel_3 = new JPanel();
								FlowLayout flowLayout = (FlowLayout) panel_3.getLayout();
								flowLayout.setAlignment(FlowLayout.LEFT);
								flowLayout.setVgap(35);
								panel_3.setBackground(new Color(34, 40, 44));
								panel_2.add(panel_3);
								{
									JLabel lblNewLabel_2_1 = new JLabel("Disbursement Date");
									lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
									lblNewLabel_2_1.setBorder(new EmptyBorder(0, 120, 0, 0));
									lblNewLabel_2_1.setForeground(Color.WHITE);
									panel_3.add(lblNewLabel_2_1);
								}
							}
							{
								JPanel panel_3 = new JPanel();
								FlowLayout flowLayout = (FlowLayout) panel_3.getLayout();
								flowLayout.setAlignment(FlowLayout.LEFT);
								flowLayout.setVgap(35);
								panel_3.setBackground(new Color(34, 40, 44));
								panel_2.add(panel_3);
								{
									JLabel lblNewLabel_2_1 = new JLabel("Description");
									lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
									lblNewLabel_2_1.setBorder(new EmptyBorder(0, 120, 0, 0));
									lblNewLabel_2_1.setForeground(Color.WHITE);
									panel_3.add(lblNewLabel_2_1);
								}
							}
							{
								JPanel panel_3 = new JPanel();
								FlowLayout flowLayout = (FlowLayout) panel_3.getLayout();
								flowLayout.setAlignment(FlowLayout.LEFT);
								flowLayout.setVgap(35);
								panel_3.setBackground(new Color(34, 40, 44));
								panel_2.add(panel_3);
								{
									JLabel lblNewLabel_2_1 = new JLabel("Status");
									lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
									lblNewLabel_2_1.setBorder(new EmptyBorder(0, 120, 0, 0));
									lblNewLabel_2_1.setForeground(Color.WHITE);
									panel_3.add(lblNewLabel_2_1);
								}
							}
						}
						{
							JPanel panel_2 = new JPanel();
							panel_2.setBackground(new Color(34, 40, 44));
							panel_LoanTerms.add(panel_2);
							panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.Y_AXIS));
							{
								JPanel panel_3 = new JPanel();
								panel_3.setBackground(new Color(34, 40, 44));
								FlowLayout flowLayout = (FlowLayout) panel_3.getLayout();
								flowLayout.setAlignment(FlowLayout.LEFT);
								flowLayout.setVgap(30);
								panel_2.add(panel_3);
								{
									txtPeriod = new JTextField();
									panel_3.add(txtPeriod);
									txtPeriod.setFont(new Font("Tahoma", Font.PLAIN, 15));
									txtPeriod.setColumns(15);
								}
							}
							{
								JPanel panel_3 = new JPanel();
								panel_3.setBackground(new Color(34, 40, 44));
								FlowLayout flowLayout = (FlowLayout) panel_3.getLayout();
								flowLayout.setAlignment(FlowLayout.LEFT);
								panel_2.add(panel_3);
								{
									jdatechooserEndDate = new JDateChooser();
									jdatechooserEndDate.setPreferredSize(new Dimension(264, 35));
									panel_3.add(jdatechooserEndDate);
									jdatechooserEndDate.setBackground(new Color(34, 40, 44));
								}
							}
							{
								JPanel panel_3 = new JPanel();
								panel_3.setBackground(new Color(34, 40, 44));
								FlowLayout flowLayout = (FlowLayout) panel_3.getLayout();
								flowLayout.setAlignment(FlowLayout.LEFT);
								flowLayout.setVgap(20);
								panel_2.add(panel_3);
								{
									jdatechooserDisbursementDate = new JDateChooser();
									jdatechooserDisbursementDate.setPreferredSize(new Dimension(264, 35));
									panel_3.add(jdatechooserDisbursementDate);
								}
							}
							{
								JPanel panel_3 = new JPanel();
								panel_3.setBackground(new Color(34, 40, 44));
								FlowLayout flowLayout = (FlowLayout) panel_3.getLayout();
								flowLayout.setVgap(0);
								flowLayout.setAlignment(FlowLayout.LEFT);
								panel_2.add(panel_3);
								{
									JScrollPane scrollPane = new JScrollPane();
									panel_3.add(scrollPane);
									{
										textArea = new JTextArea();
										textArea.setPreferredSize(new Dimension(300, 70));
										scrollPane.setViewportView(textArea);
									}
								}
							}
							{
								JPanel panel_3 = new JPanel();
								panel_3.setBackground(new Color(34, 40, 44));
								FlowLayout flowLayout = (FlowLayout) panel_3.getLayout();
								flowLayout.setAlignment(FlowLayout.LEFT);
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
					{
						JPanel panel_2 = new JPanel();
						panel_2.setBackground(new Color(34, 40, 44));
						panel_1.add(panel_2, BorderLayout.SOUTH);
						{
							JButton btnDelete = new JButton("Delete");
							btnDelete.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent e) {
									btnDelete_actionPerformed(e);
								}
							});
							btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 16));
							panel_2.add(btnDelete);
						}
					}
				}
			}
		}
	}

	public void btnViewAllLoans_actionPerformed(ActionEvent e) {
		JPanel jpanelMain = (JPanel) this.getParent();
		jpanelMain.removeAll();
		jpanelMain.revalidate();
		jpnaelShowCustomerLoan customerLoan = new jpnaelShowCustomerLoan(this.customer);
		jpanelMain.add(customerLoan);
		customerLoan.setVisible(true);
	}

	public void btnDelete_actionPerformed(ActionEvent e) {
		if (this.loan.getStatus() == 2) {
			JOptionPane.showMessageDialog(this, "You can not stop fully paid loan");
		} else {
			int i = JOptionPane.showConfirmDialog(this, "Do you want to close this loan?", "Close Loan",
					JOptionPane.YES_NO_CANCEL_OPTION);
			if (i == JOptionPane.YES_OPTION) {
				LoanModel loanModel = new LoanModel();
				if (loanModel.closeLoan(this.loan.getId())) {
					JOptionPane.showMessageDialog(this, "Done");
					this.loan = loanModel.loadLoanByID(this.loan.getId());
					FillDataToJTable(this.loan, tblLoanDetail);
				}
			}
		}
	}

	private void repayment(int i) {
		LoanModel loanModel = new LoanModel();
		int statusFalse = loanModel.countStatusFalseInLoan(this.loan.getId());
		if (statusFalse > 1) {
			if (this.loan.getStatus() == 1) {
				PaymentLoan paymentLoan = new PaymentLoan(i);
				paymentLoan.setVisible(true);
				paymentLoan.addWindowListener(new WindowAdapter() {

					@Override
					public void windowClosed(WindowEvent e) {
						LoanAndFineHistoryModel loanAndFineHistoryModel = new LoanAndFineHistoryModel();
						FillDataToJTableLoanHistory(loanAndFineHistoryModel.getAllLoanAndFineHistorys(loan.getId()),
								tableLoanHistory);
						super.windowClosed(e);
					}

				});
			} else if (this.loan.getStatus() == 3) {
				JOptionPane.showMessageDialog(this, "You cannot repayment this loan because it was stopped!!!");
			}
		} else if (statusFalse == 0) {
			if (this.loan.getStatus() == 2) {
				JOptionPane.showMessageDialog(this, "This loan has been fully paid");
			} else {
				if (loanModel.fullyPaidLoan(this.loan.getId())) {
					JOptionPane.showMessageDialog(this, "Fully paid");
				}
			}
		} else if (statusFalse == 1) {
			if (this.loan.getStatus() == 1) {
				PaymentLoan paymentLoan = new PaymentLoan(i);
				paymentLoan.setVisible(true);
				paymentLoan.addWindowListener(new WindowAdapter() {

					@Override
					public void windowClosed(WindowEvent e) {
						LoanAndFineHistoryModel loanAndFineHistoryModel = new LoanAndFineHistoryModel();
						FillDataToJTableLoanHistory(loanAndFineHistoryModel.getAllLoanAndFineHistorys(loan.getId()),
								tableLoanHistory);
						if (loanModel.fullyPaidLoan(loan.getId())) {
							JOptionPane.showMessageDialog(null, "Fully paid");
							loan.setStatus(2);
							FillDataToJTable(loan, tblLoanDetail);
						}
					}

				});

			} else if (this.loan.getStatus() == 3) {
				JOptionPane.showMessageDialog(this, "You cannot repayment this loan because it was stopped!!!");
			}
		}
	}

	public jpanelShowLoanDetail(Customer customer, Loan loan) {
		this();
		this.customer = customer;
		this.loan = loan;
		loadData();
		FillDataToJTable(loan, tblLoanDetail);
		LoanAndFineHistoryModel loanAndFineHistoryModel = new LoanAndFineHistoryModel();
		FillDataToJTableLoanHistory(loanAndFineHistoryModel.getAllLoanAndFineHistorys(loan.getId()), tableLoanHistory);
	}

	public void btnAddLoan_actionPerformed(ActionEvent e) {
		CreateLoan createLoan = new CreateLoan(this.customer.getId());
		createLoan.setVisible(true);
	}

	private void loadData() {
		// load customer information
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

		// load loan information.
		txtCustomerID.setText(String.valueOf(this.loan.getCustomerId()));
		txtAmount.setText(String.valueOf(this.loan.getAmount()));
		txtDuration.setText(String.valueOf(this.loan.getDuration()));
		txtPeriod.setText(String.valueOf(this.loan.getPeriod()));
		textArea.setText(this.loan.getDescription());
		chkStatus.setSelected(this.loan.getStatus() == 1);
		jdatechooserEndDate.setDate(this.loan.getEndDate());
		jdatechooserDisbursementDate.setDate(this.loan.getDisbursementDate());
		cbLoanType_FillToJComboBox();
		cbPaymentTypt_FillToJComboBox();
		for (int i = 0; i < cbLoanType.getItemCount(); i++) {
			if (((LoanType) cbLoanType.getItemAt(i)).getId() == this.loan.getLoanTypeId()) {
				cbLoanType.setSelectedIndex(i);
			}
		}
		for (int i = 0; i < cbPaymentType.getItemCount(); i++) {
			if (((PaymentType) cbPaymentType.getItemAt(i)).getId() == this.loan.getPaymentTypeId()) {
				cbPaymentType.setSelectedIndex(i);
			}
		}
	}

	public void FillDataToJTable(Loan loan, JTable tableLoan) {
		String statusMask = "";
		DefaultTableModel defaultTableModel = new DefaultTableModel() {

			@Override
			public boolean isCellEditable(int row, int column) {
				return super.isCellEditable(row, column);
			}

		};
		defaultTableModel.addColumn("Id");
		defaultTableModel.addColumn("Loan Type");
		defaultTableModel.addColumn("Interest");
		defaultTableModel.addColumn("Employee ID");
		defaultTableModel.addColumn("Customer ID");
		defaultTableModel.addColumn("Payment Type");
		defaultTableModel.addColumn("Amount");
		defaultTableModel.addColumn("Period");
		defaultTableModel.addColumn("Duration");
		defaultTableModel.addColumn("Date Created");
		defaultTableModel.addColumn("Date Disbursement");
		defaultTableModel.addColumn("Date End");
		defaultTableModel.addColumn("Description");
		defaultTableModel.addColumn("Status");
		if (loan.getStatus() == 0) {
			statusMask = "New";
		} else if (loan.getStatus() == 1) {
			statusMask = "Open";
		} else if (loan.getStatus() == 2) {
			statusMask = "Fully Paid";
		} else if (loan.getStatus() == 3) {
			statusMask = "Stop";
		}
		defaultTableModel.addRow(new Object[] { loan.getId(), loadLoanTypeName(loan.getLoanTypeId()),
				Common.formatInt(loan.getInterest()*100)+ " %", loadEmployeeName(loan.getAccountId()), loadCustomerName(loan.getCustomerId()),
				loadPaymentTypeName(loan.getPaymentTypeId()), Common.formatNumber(loan.getAmount()), loan.getPeriod() + " Month",
				loan.getDuration() + " Month", loan.getCreateDate(), loan.getDisbursementDate(), loan.getEndDate(),
				loan.getDescription(), statusMask });

		tableLoan.setModel(defaultTableModel);
		tableLoan.getColumnModel().getColumn(13).setCellRenderer(new LoanTableStatusButtonRenderer());
		tableLoan.getColumnModel().getColumn(13).setCellEditor(new ClientsTableRenderer(new JCheckBox()));
		tableLoan.getTableHeader().setReorderingAllowed(false);
		tableLoan.setShowHorizontalLines(true);
		tableLoan.setShowVerticalLines(false);
		defaultTableModel.fireTableDataChanged();
	}

	public void FillDataToJTableLoanHistory(List<LoanAndFineHistory> list, JTable tableLoanHistory) {
		String statusMask = "";
		DefaultTableModel defaultTableModel = new DefaultTableModel() {

			@Override
			public boolean isCellEditable(int row, int column) {
				return super.isCellEditable(row, column);
			}

		};
		defaultTableModel.addColumn("Id");
		defaultTableModel.addColumn("Customer");
		defaultTableModel.addColumn("Amount");
		defaultTableModel.addColumn("Payment Method");
		defaultTableModel.addColumn("Payment Amount");
		defaultTableModel.addColumn("Amount Left");
		defaultTableModel.addColumn("Due Date");
		defaultTableModel.addColumn("Fine Interest");
		defaultTableModel.addColumn("Fine Over Days");
		defaultTableModel.addColumn("Fine Amount");
		defaultTableModel.addColumn("Payment Date");
		defaultTableModel.addColumn("Description");
		defaultTableModel.addColumn("Action");
		for (LoanAndFineHistory history : list) {
			statusMask = history.isStatus() ? "Repayment" : "Not Repayment";
			defaultTableModel.addRow(new Object[] { history.getId(), history.getCustomer(),
					Common.formatNumber(history.getAmount()), history.getPaymentMenthodName(),
					Common.formatNumber(history.getPaymentAmount()),
					Common.formatNumber(history.getAmountLeft()), history.getDueDate(),
					Common.formatInt(history.getFineInterest()*100)+ " %", history.getFineOverDays()+ " day",
					Common.formatNumber(history.getFineAmount()), history.getPaymentDate(),
					history.getDescription(), statusMask });
		}
		tableLoanHistory.setModel(defaultTableModel);
		tableLoanHistory.getColumnModel().getColumn(12)
				.setCellRenderer(new LoanAndFineHistoryTableStatusButtonRenderer());
		tableLoanHistory.getColumnModel().getColumn(12).setCellEditor(new HistoryClientsTableRenderer(new JCheckBox()));
		tableLoanHistory.getTableHeader().setReorderingAllowed(false);
		tableLoanHistory.setShowHorizontalLines(true);
		tableLoanHistory.setShowVerticalLines(false);
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
				this.loan.setStatus(1);
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

	class LoanTableStatusButtonRenderer extends JButton implements TableCellRenderer {
		public LoanTableStatusButtonRenderer() {
			setOpaque(true);
		}

		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {
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
							FillDataToJTable(loan, table);
						} else if (button.getText().equals("Stop")) {
							updateStatusNewToOpen(id);
							LoanModel loanModel = new LoanModel();
							FillDataToJTable(loan, table);
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

	class LoanAndFineHistoryTableStatusButtonRenderer extends JButton implements TableCellRenderer {
		public LoanAndFineHistoryTableStatusButtonRenderer() {
			setOpaque(true);
		}

		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {
			setText((value == null) ? "" : value.toString());
			loadColorOfButton(value.toString(), "Not Repayment", "Repayment", "", "", this);
			return this;
		}
	}

	public class HistoryClientsTableRenderer extends DefaultCellEditor {
		private JButton button;
		private String label;
		private boolean clicked;
		private int row, col;
		private JTable table;

		public HistoryClientsTableRenderer(JCheckBox checkBox) {
			super(checkBox);
			button = new JButton();
			button.setOpaque(true);
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (button.getText().equals("Not Repayment")) {
						int Id = (int) table.getValueAt(row, 0);
						repayment(Id);
					} else if (button.getText().equals("Repayment")) {
						JOptionPane.showMessageDialog(null, "Already repayment this period!");
					}
				}
			});
		}

		public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row,
				int column) {
			this.table = table;
			this.row = row;
			this.col = column;
			loadColorOfButton(value.toString(), "Not Repayment", "Repayment", "", "", button);
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
