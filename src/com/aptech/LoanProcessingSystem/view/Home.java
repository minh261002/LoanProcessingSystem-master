package com.aptech.LoanProcessingSystem.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;

import com.aptech.LoanProcessingSystem.entities.Account;
import com.aptech.LoanProcessingSystem.service.ClockThread;
import com.aptech.LoanProcessingSystem.service.ShareData;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.border.EmptyBorder;
import java.awt.Insets;
import javax.swing.BoxLayout;
import java.awt.SystemColor;

@SuppressWarnings("serial")
public class Home extends JFrame {
	private JTabbedPane tabbedHome = new JTabbedPane(JTabbedPane.TOP);
	private JLabel lblEmail;
	private JLabel lblClock;
	private JPanel panelHome;
	private JMenu mnLoans;
	private JMenu mnCustomers;
	private JMenu mnChangePass;

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					if (ShareData.accountLogin == null) {
						Login login = new Login();
						login.setVisible(true);
					} else {
						Home frame = new Home();
						frame.setVisible(true);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Home() {
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent windowEvent) {
				exitAction();
			}
		});
		setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);

		setForeground(Color.GRAY);
		setBackground(Color.GRAY);
		setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 15));
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(Home.class.getResource("/com/aptech/LoanProcessingSystem/images/bank (4).png")));
		getContentPane().setBackground(new Color(255, 255, 255));
		getContentPane().setLayout(new BorderLayout(0, 0));

		tabbedHome.setForeground(Color.GRAY);
		tabbedHome.setBackground(Color.GRAY);
		getContentPane().add(tabbedHome, BorderLayout.WEST);

		panelHome = new JPanel();
		getContentPane().add(panelHome, BorderLayout.CENTER);
		panelHome.setLayout(new BorderLayout(0, 0));
		setTitle("Loan Processing System");
		setBounds(100, 100, 1248, 692);
		setLocationRelativeTo(null);

		JMenuBar menuBar_1 = new JMenuBar();
		menuBar_1.setAutoscrolls(true);
		menuBar_1.setBorder(new EmptyBorder(5, 10, 5, 0));
		menuBar_1.setBackground(Color.BLACK);
		setJMenuBar(menuBar_1);

		mnLoans = new JMenu("Loans");
		mnLoans.setAutoscrolls(true);
		mnLoans.setBackground(Color.BLACK);
		mnLoans.setIcon(new ImageIcon(Home.class.getResource("/com/aptech/LoanProcessingSystem/images/loan (3).png")));
		mnLoans.setMargin(new Insets(2, 10, 2, 10));
		mnLoans.setForeground(SystemColor.controlShadow);
		menuBar_1.add(mnLoans);

		mnCustomers = new JMenu("Customers");
		mnCustomers.setAutoscrolls(true);
		mnCustomers.setBackground(Color.BLACK);
		mnCustomers.setIcon(
				new ImageIcon(Home.class.getResource("/com/aptech/LoanProcessingSystem/images/customer (3).png")));
		mnCustomers.setMargin(new Insets(2, 10, 2, 10));
		mnCustomers.setForeground(SystemColor.controlShadow);
		menuBar_1.add(mnCustomers);

		JMenu mnStatistic = new JMenu("Statistic");
		mnStatistic.setAutoscrolls(true);
		mnStatistic.setBackground(Color.BLACK);
		mnStatistic.setMargin(new Insets(2, 10, 2, 10));
		mnStatistic.setIcon(
				new ImageIcon(Home.class.getResource("/com/aptech/LoanProcessingSystem/images/statistics (1).png")));
		mnStatistic.setSelectedIcon(
				new ImageIcon(Home.class.getResource("/com/aptech/LoanProcessingSystem/images/statistics.png")));
		mnStatistic.setForeground(SystemColor.controlShadow);
		menuBar_1.add(mnStatistic);

		mnChangePass = new JMenu("Change password");
		mnChangePass.setAutoscrolls(true);
		mnChangePass.setBackground(Color.BLACK);
		mnChangePass.setIcon(
				new ImageIcon(Home.class.getResource("/com/aptech/LoanProcessingSystem/images/ic_changpass_20.png")));
		mnChangePass.setMargin(new Insets(2, 10, 2, 10));
		mnChangePass.setForeground(SystemColor.controlShadow);
		menuBar_1.add(mnChangePass);

		JMenu mnAbout = new JMenu("About");
		mnAbout.setAutoscrolls(true);
		mnAbout.setBackground(Color.BLACK);
		mnAbout.setMargin(new Insets(2, 10, 2, 10));
		mnAbout.setIcon(new ImageIcon(Home.class.getResource("/com/aptech/LoanProcessingSystem/images/info.png")));
		mnAbout.setSelectedIcon(
				new ImageIcon(Home.class.getResource("/com/aptech/LoanProcessingSystem/images/info.png")));
		mnAbout.setForeground(SystemColor.controlShadow);
		menuBar_1.add(mnAbout);

		JMenu mnHelp = new JMenu("Help");
		mnHelp.setAutoscrolls(true);
		mnHelp.setBackground(Color.BLACK);
		mnHelp.setMargin(new Insets(2, 10, 2, 10));
		mnHelp.setIcon(new ImageIcon(Home.class.getResource("/com/aptech/LoanProcessingSystem/images/help.png")));
		mnHelp.setSelectedIcon(
				new ImageIcon(Home.class.getResource("/com/aptech/LoanProcessingSystem/images/help.png")));
		mnHelp.setForeground(SystemColor.controlShadow);
		menuBar_1.add(mnHelp);

		JMenu mnLogout = new JMenu("Logout");
		mnLogout.setAutoscrolls(true);
		mnLogout.setBackground(Color.BLACK);
		mnLogout.setIcon(
				new ImageIcon(Home.class.getResource("/com/aptech/LoanProcessingSystem/images/ic_logout_20.png")));
		mnLogout.setMargin(new Insets(2, 10, 2, 10));
		mnLogout.setForeground(SystemColor.controlShadow);
		menuBar_1.add(mnLogout);

		JMenu mnExit = new JMenu("Exit");
		mnExit.setAutoscrolls(true);
		mnExit.setBackground(Color.BLACK);
		mnExit.setIcon(new ImageIcon(Home.class.getResource("/com/aptech/LoanProcessingSystem/images/ic_exit_20.png")));
		mnExit.setMargin(new Insets(2, 10, 2, 10));
		mnExit.setForeground(SystemColor.controlShadow);
		menuBar_1.add(mnExit);

		JPanel panel = new JPanel();
		menuBar_1.add(panel);
		panel.setBackground(Color.BLACK);
		panel.setLayout(new FlowLayout(FlowLayout.RIGHT, 20, 5));

		lblEmail = new JLabel("");
		lblEmail.setBorder(new EmptyBorder(0, 10, 0, 0));
		lblEmail.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 9));
		lblEmail.setIcon(new ImageIcon(
				Home.class.getResource("/com/aptech/LoanProcessingSystem/images/unauthorized-person.png")));
		lblEmail.setForeground(Color.WHITE);
		panel.add(lblEmail);
		lblEmail.setText(ShareData.accountLogin.getEmail());

		lblClock = new JLabel("");
		lblClock.setBorder(new EmptyBorder(0, 0, 0, 10));
		lblClock.setHorizontalTextPosition(SwingConstants.LEFT);
		lblClock.setHorizontalAlignment(SwingConstants.LEFT);
		lblClock.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblClock.setIcon(new ImageIcon(Home.class.getResource("/com/aptech/LoanProcessingSystem/images/clock.png")));
		lblClock.setForeground(Color.WHITE);
		panel.add(lblClock);
		loadLoanAction();

		mnCustomers.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				loadCustomerAction();
			}
		});

		mnLoans.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				loadLoanAction();
			}
		});

		mnStatistic.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Statistic statistic = new Statistic();
				statistic.setVisible(true);
			}
		});

		mnAbout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				About about = new About();
				about.setVisible(true);
			}
		});

		mnHelp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Help help = new Help();
				help.setVisible(true);
			}
		});

		mnChangePass.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ChangePass changePass = new ChangePass();
				changePass.setVisible(true);
			}
		});

		mnLogout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				logoutAction();
			}
		});

		mnExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				exitAction();
			}
		});
		initClock();
	}

	protected void loadCustomerAction() {
		panelHome.removeAll();
		panelHome.revalidate();
		CustomerInfo customerInfo = new CustomerInfo();
		panelHome.add(customerInfo);
		customerInfo.setVisible(true);

	}

	protected void loadLoanAction() {
		panelHome.removeAll();
		panelHome.revalidate();
		LoanDetail loanDetail = new LoanDetail();
		panelHome.add(loanDetail);
		loanDetail.setVisible(true);
	}

	protected void exitAction() {
		if (JOptionPane.showConfirmDialog(null, "Are you sure you want to close Application?", "Confirm",
				JOptionPane.YES_NO_OPTION) == 0) {
			System.exit(0);
		}
	}

	protected void logoutAction() {
		if (JOptionPane.showConfirmDialog(null, "Are you sure you want to logout?", "Confirm",
				JOptionPane.YES_NO_OPTION) == 0) {
			ShareData.accountLogin = null;
			Login login = new Login();
			login.setVisible(true);
			this.dispose();
		}
	}

	private void initClock() {
		ClockThread clockThread = new ClockThread(lblClock);
		clockThread.start();
	}
}
