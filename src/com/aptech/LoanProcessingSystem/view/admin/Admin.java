package com.aptech.LoanProcessingSystem.view.admin;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicButtonUI;

import com.aptech.LoanProcessingSystem.entities.Account;
import com.aptech.LoanProcessingSystem.view.Login;
import com.aptech.LoanProcessingSystem.entities.Account;

import java.awt.SystemColor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;
import java.util.Map;

import java.awt.event.ActionEvent;
import javax.swing.BoxLayout;
import java.awt.CardLayout;
import javax.swing.JScrollPane;

public class Admin extends JFrame {

	private JPanel contentPane;
	private JPanel jpanelMain;
	private Account account = new Account();
	private Map<String, Object> data = new HashMap<String, Object>();

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
					Admin frame = new Admin();
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
	public Admin() {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 898, 653);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(34, 40, 44));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel jpanelRoot = new JPanel();
		contentPane.add(jpanelRoot, BorderLayout.CENTER);
		jpanelRoot.setLayout(new BorderLayout(0, 0));

		JPanel jpanelSide = new JPanel();
		jpanelSide.setBorder(new EmptyBorder(50, 0, 0, 0));
		jpanelSide.setBackground(new Color(21, 25, 28));
		jpanelSide.setPreferredSize(new Dimension(80, 0));
		jpanelRoot.add(jpanelSide, BorderLayout.WEST);
		FlowLayout fl_jpanelSide = new FlowLayout(FlowLayout.CENTER, 5, 5);
		fl_jpanelSide.setAlignOnBaseline(true);
		jpanelSide.setLayout(fl_jpanelSide);

		JButton btnHome = new JButton("");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnHome_actionPerformed(e);
			}
		});

		JPanel panel = new JPanel();
		panel.setBackground(new Color(21, 25, 28));
		panel.setPreferredSize(new Dimension(60, 150));
		jpanelSide.add(panel);
		btnHome.setBorderPainted(false);
		btnHome.setBackground(new Color(21, 25, 28));
		btnHome.setIcon(new ImageIcon(
				Admin.class.getResource("/com/aptech/LoanProcessingSystem/images/icons8_home_20px_3.png")));
		btnHome.setPreferredSize(new Dimension(40, 40));
		jpanelSide.add(btnHome);

		JButton btnInterest = new JButton("");
		btnInterest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnInterest_actionPerformed(e);
			}
		});
		
		JButton btnFine = new JButton("");
		btnFine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnFine_actionPerformed(e);
			}
		});
		btnFine.setIcon(new ImageIcon(Admin.class.getResource("/com/aptech/LoanProcessingSystem/images/icons8_services_20px.png")));
		btnFine.setPreferredSize(new Dimension(40, 40));
		btnFine.setBorderPainted(false);
		btnFine.setBackground(new Color(21, 25, 28));
		jpanelSide.add(btnFine);
		btnInterest.setIcon(new ImageIcon(
				Admin.class.getResource("/com/aptech/LoanProcessingSystem/images/icons8_currency_exchange_20px.png")));
		btnInterest.setPreferredSize(new Dimension(40, 40));
		btnInterest.setBorderPainted(false);
		btnInterest.setBackground(new Color(21, 25, 28));
		jpanelSide.add(btnInterest);

		JButton btnLoanData = new JButton("");
		btnLoanData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnLoanData_actionPerformed(e);
			}
		});
		btnLoanData.setIcon(new ImageIcon(
				Admin.class.getResource("/com/aptech/LoanProcessingSystem/images/icons8_layers_20px.png")));
		btnLoanData.setPreferredSize(new Dimension(40, 40));
		btnLoanData.setBorderPainted(false);
		btnLoanData.setBackground(new Color(21, 25, 28));
		jpanelSide.add(btnLoanData);

		JButton btnUserProfile = new JButton("");
		btnUserProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnUserProfile_actionPerformed(e);
			}
		});
		btnUserProfile.setIcon(new ImageIcon(
				Admin.class.getResource("/com/aptech/LoanProcessingSystem/images/icons8_profile_20px.png")));
		btnUserProfile.setPreferredSize(new Dimension(40, 40));
		btnUserProfile.setBorderPainted(false);
		btnUserProfile.setBackground(new Color(21, 25, 28));
		jpanelSide.add(btnUserProfile);

		JButton btnEmployeeProfile = new JButton("");
		btnEmployeeProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnEmployeeProfile_actionPerformed(e);
			}
		});
		btnEmployeeProfile.setIcon(new ImageIcon(
				Admin.class.getResource("/com/aptech/LoanProcessingSystem/images/icons8_management_20px.png")));
		btnEmployeeProfile.setPreferredSize(new Dimension(40, 40));
		btnEmployeeProfile.setBorderPainted(false);
		btnEmployeeProfile.setBackground(new Color(21, 25, 28));
		jpanelSide.add(btnEmployeeProfile);

		JButton btnExit = new JButton("");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnExit_actionPerformed(e);
			}
		});
		btnExit.setIcon(
				new ImageIcon(Admin.class.getResource("/com/aptech/LoanProcessingSystem/images/icons8_exit_20px.png")));
		btnExit.setPreferredSize(new Dimension(40, 40));
		btnExit.setBorderPainted(false);
		btnExit.setBackground(new Color(21, 25, 28));
		jpanelSide.add(btnExit);

		jpanelMain = new JPanel();
		jpanelMain.setBackground(new Color(34,40,44));
		jpanelRoot.add(jpanelMain, BorderLayout.CENTER);
		jpanelMain.setLayout(new CardLayout(0, 0));

		JButton[] btns = { btnHome, btnExit, btnEmployeeProfile, btnInterest, btnUserProfile, btnLoanData, btnFine };
		for (JButton jButton : btns) {
			jButton.setBackground(new Color(21, 25, 28));
			jButton.setUI(new BasicButtonUI());
			jButton.addMouseListener(new MouseListener() {

				@Override
				public void mouseReleased(MouseEvent e) {

				}

				@Override
				public void mousePressed(MouseEvent e) {

				}

				@Override
				public void mouseExited(MouseEvent e) {
					jButton.setBackground(new Color(21, 25, 28));
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					jButton.setBackground(new Color(54, 81, 207));
				}

				@Override
				public void mouseClicked(MouseEvent e) {

				}
			});
		}
	}

	public Admin(Map<String, Object> data) {
		this();
		this.data = data;
		loadData();
	}

	public void loadData() {
		this.account = (Account) this.data.get("users");
	}
	public Admin(Account account) {
		this();
		this.account = account;
	}
	
	public void btnFine_actionPerformed(ActionEvent e) {
		clearScreen();
		jpanelFineManagement fineManagement = new jpanelFineManagement();
		jpanelMain.add(fineManagement);
		fineManagement.setVisible(true);
	}
	
	public void btnExit_actionPerformed(ActionEvent e) {
		int a = JOptionPane.showConfirmDialog(null, "Do you want to logout?", "Log out", JOptionPane.YES_NO_CANCEL_OPTION);
		if (a == JOptionPane.YES_OPTION) {
			Login login = new Login();
			login.setVisible(true);
			this.dispose();
		}
	}
	
	public void btnUserProfile_actionPerformed(ActionEvent e) {
		clearScreen();
		jpanelCustomerProfile customerProfile = new jpanelCustomerProfile();
		jpanelMain.add(customerProfile);
		customerProfile.setVisible(true);
	}

	public void btnHome_actionPerformed(ActionEvent e) {
		clearScreen();
		jpanelHomePage data = new jpanelHomePage(this.account);
		jpanelMain.add(data);
		data.setVisible(true);
	}

	public void btnLoanData_actionPerformed(ActionEvent e) {
		clearScreen();
		jpanelLoadData jpanelLoanData = new jpanelLoadData();
		jpanelMain.add(jpanelLoanData);
		jpanelLoanData.setVisible(true);
	}

	public void btnInterest_actionPerformed(ActionEvent e) {
		clearScreen();
		jpanelLoanType jpanelLoanType = new jpanelLoanType();
		jpanelMain.add(jpanelLoanType);
		jpanelLoanType.setVisible(true);
	}
	
	public void btnEmployeeProfile_actionPerformed(ActionEvent e) {
		clearScreen();
		jpanelEmployeeManagement employeeManagement = new jpanelEmployeeManagement();
		jpanelMain.add(employeeManagement);
		employeeManagement.setVisible(true);
	}

	private void clearScreen() {
		jpanelMain.removeAll();
		jpanelMain.revalidate();
	}
}
