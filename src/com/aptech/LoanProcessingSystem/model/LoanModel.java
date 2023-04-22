package com.aptech.LoanProcessingSystem.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.aptech.LoanProcessingSystem.database.ConnectDB;
import com.aptech.LoanProcessingSystem.entities.Loan;
import com.aptech.LoanProcessingSystem.entities.LoanType;
import com.aptech.LoanProcessingSystem.service.ShareData;

public class LoanModel {

	public List<Loan> findAll() {
		List<Loan> loans = new ArrayList<Loan>();
		try {
			PreparedStatement preparedStatement = ConnectDB.connection().prepareStatement(
					"SELECT c.Name as CustomerName, lt.name as LoanType, pt.name as PaymentType, l.* FROM `loan` as l join `customer` as c on l.CustomerId = c.Id join `loantype` as lt on l.LoanTypeId = lt.Id JOIN `paymenttype` as pt on l.PaymentTypeId = pt.id  order by l.id desc");
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Loan loan = new Loan();
				loan.setId(rs.getInt("Id"));
				loan.setCustomerName(rs.getString("CustomerName"));
				loan.setLoanTypeName(rs.getString("LoanType"));
				loan.setPaymentTypeName(rs.getString("PaymentType"));
				loan.setLoanTypeId(rs.getInt("LoanTypeId"));
				loan.setAccountId(rs.getInt("AccountId"));
				loan.setCustomerId(rs.getInt("CustomerId"));
				loan.setPaymentTypeId(rs.getInt("PaymentTypeId"));
				loan.setAmount(rs.getDouble("Amount"));
				loan.setPeriod(rs.getInt("Period"));
				loan.setCreateDate(rs.getDate("CreateDate"));
				loan.setDisbursementDate(rs.getDate("DisbursementDate"));
				loan.setEndDate(rs.getDate("EndDate"));
				loan.setDuration(rs.getInt("Duration"));
				loan.setStatus(rs.getInt("Status"));
				loans.add(loan);
			}
		} catch (Exception e) {
			e.printStackTrace();
			loans = null;
		} finally {
			ConnectDB.disconnect();
		}
		return loans;
	}

	public List<Loan> findAllActive() {
		List<Loan> loans = new ArrayList<Loan>();
		try {
			PreparedStatement preparedStatement = ConnectDB.connection().prepareStatement(
					"SELECT c.Name as CustomerName, lt.name as LoanType, pt.name as PaymentType, l.* FROM `loan` as l join `customer` as c on l.CustomerId = c.Id join `loantype` as lt on l.LoanTypeId = lt.Id JOIN `paymenttype` as pt on l.PaymentTypeId = pt.id where l.status < 3  order by l.id desc");
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Loan loan = new Loan();
				loan.setId(rs.getInt("Id"));
				loan.setCustomerName(rs.getString("CustomerName"));
				loan.setLoanTypeName(rs.getString("LoanType"));
				loan.setPaymentTypeName(rs.getString("PaymentType"));
				loan.setLoanTypeId(rs.getInt("LoanTypeId"));
				loan.setAccountId(rs.getInt("AccountId"));
				loan.setCustomerId(rs.getInt("CustomerId"));
				loan.setPaymentTypeId(rs.getInt("PaymentTypeId"));
				loan.setAmount(rs.getDouble("Amount"));
				loan.setPeriod(rs.getInt("Period"));
				loan.setInterest(rs.getDouble("Interest"));
				loan.setCreateDate(rs.getDate("CreateDate"));
				loan.setDisbursementDate(rs.getDate("DisbursementDate"));
				loan.setEndDate(rs.getDate("EndDate"));
				loan.setDuration(rs.getInt("Duration"));
				loan.setStatus(rs.getInt("Status"));
				loans.add(loan);
			}
		} catch (Exception e) {
			e.printStackTrace();
			loans = null;
		} finally {
			ConnectDB.disconnect();
		}
		return loans;
	}

	public List<Loan> getAllLoansByCustomerID(int id) {
		List<Loan> loans = null;
		try {
			loans = new ArrayList<Loan>();
			PreparedStatement statement = ConnectDB.connection()
					.prepareStatement("Select * from loan where CustomerId = ? order by id desc");
			statement.setInt(1, id);
			ResultSet resultset = statement.executeQuery();
			while (resultset.next()) {
				Loan loan = new Loan();
				loan.setId(resultset.getInt("Id"));
				loan.setLoanTypeId(resultset.getInt("LoanTypeId"));
				loan.setAccountId(resultset.getInt("AccountId"));
				loan.setCustomerId(resultset.getInt("CustomerId"));
				loan.setPaymentTypeId(resultset.getInt("PaymentTypeId"));
				loan.setAmount(resultset.getDouble("Amount"));
				loan.setPeriod(resultset.getInt("Period"));
				loan.setCreateDate(resultset.getDate("CreateDate"));
				loan.setDisbursementDate(resultset.getDate("DisbursementDate"));
				loan.setDuration(resultset.getInt("Duration"));
				loan.setEndDate(resultset.getDate("EndDate"));
				loan.setInterest(resultset.getDouble("Interest"));
				loan.setDescription(resultset.getString("Description"));
				loan.setStatus(resultset.getInt("Status"));
				loans.add(loan);
			}
		} catch (Exception e) {
			loans = null;
		} finally {
			ConnectDB.disconnect();
		}
		return loans;
	}

	public List<Loan> getAllLoanHome(LoanType loanType) {
		List<Loan> loans = new ArrayList<Loan>();
		try {
			PreparedStatement statement = ConnectDB.connection()
					.prepareStatement("Select * from Loan where LoanTypeId = ? order by id desc");
			statement.setInt(1, loanType.getId());
			ResultSet resultset = statement.executeQuery();
			while (resultset.next()) {
				Loan loan = new Loan();
				loan.setId(resultset.getInt("Id"));
				loan.setLoanTypeId(resultset.getInt("LoanTypeId"));
				loan.setAccountId(resultset.getInt("AccountId"));
				loan.setCustomerId(resultset.getInt("CustomerId"));
				loan.setPaymentTypeId(resultset.getInt("PaymentTypeId"));
				loan.setAmount(resultset.getDouble("Amount"));
				loan.setPeriod(resultset.getInt("Period"));
				loan.setCreateDate(resultset.getDate("CreateDate"));
				loan.setDisbursementDate(resultset.getDate("DisbursementDate"));
				loan.setDuration(resultset.getInt("Duration"));
				loan.setEndDate(resultset.getDate("EndDate"));
				loan.setInterest(resultset.getFloat("Interest"));
				loan.setDescription(resultset.getString("Description"));
				loan.setStatus(resultset.getInt("Status"));
				loans.add(loan);
			}
		} catch (Exception e) {
			e.printStackTrace();
			loans = null;
		} finally {
			ConnectDB.disconnect();
		}
		return loans;
	}

	public List<Loan> getLoanByStatus(LoanType loanType, int status) {
		List<Loan> loans = null;
		try {
			loans = new ArrayList<Loan>();
			PreparedStatement statement = ConnectDB.connection()
					.prepareStatement("Select * from Loan where LoanTypeId = ? AND Status = ? order by id desc");
			statement.setInt(1, loanType.getId());
			statement.setInt(2, status);
			ResultSet resultset = statement.executeQuery();
			while (resultset.next()) {
				Loan loan = new Loan();
				loan.setId(resultset.getInt("Id"));
				loan.setLoanTypeId(resultset.getInt("LoanTypeId"));
				loan.setAccountId(resultset.getInt("AccountId"));
				loan.setCustomerId(resultset.getInt("CustomerId"));
				loan.setPaymentTypeId(resultset.getInt("PaymentTypeId"));
				loan.setAmount(resultset.getDouble("Amount"));
				loan.setPeriod(resultset.getInt("Period"));
				loan.setCreateDate(resultset.getDate("CreateDate"));
				loan.setDisbursementDate(resultset.getDate("DisbursementDate"));
				loan.setDuration(resultset.getInt("Duration"));
				loan.setEndDate(resultset.getDate("EndDate"));
				loan.setInterest(resultset.getFloat("Interest"));
				loan.setDescription(resultset.getString("Description"));
				loan.setStatus(resultset.getInt("Status"));
				loans.add(loan);
			}
		} catch (Exception e) {
			e.printStackTrace();
			loans = null;
		} finally {
			ConnectDB.disconnect();
		}
		return loans;
	}

	public List<Loan> findLoanByLoanType(LoanType loanType, int id) {
		List<Loan> loans = null;
		try {
			loans = new ArrayList<Loan>();
			PreparedStatement statement = ConnectDB.connection()
					.prepareStatement("" + "Select * from Loan where CustomerId = ? AND LoanTypeId = ? order by id desc");
			statement.setInt(1, id);
			statement.setInt(2, loanType.getId());
			ResultSet resultset = statement.executeQuery();
			while (resultset.next()) {
				Loan loan = new Loan();
				loan.setId(resultset.getInt("Id"));
				loan.setLoanTypeId(resultset.getInt("LoanTypeId"));
				loan.setAccountId(resultset.getInt("AccountId"));
				loan.setCustomerId(resultset.getInt("CustomerId"));
				loan.setPaymentTypeId(resultset.getInt("PaymentTypeId"));
				loan.setAmount(resultset.getDouble("Amount"));
				loan.setPeriod(resultset.getInt("Period"));
				loan.setCreateDate(resultset.getDate("CreateDate"));
				loan.setDisbursementDate(resultset.getDate("DisbursementDate"));
				loan.setDuration(resultset.getInt("Duration"));
				loan.setEndDate(resultset.getDate("EndDate"));
				loan.setInterest(resultset.getFloat("Interest"));
				loan.setDescription(resultset.getString("Description"));
				loan.setStatus(resultset.getInt("Status"));
				loans.add(loan);
			}
		} catch (Exception e) {
			e.printStackTrace();
			loans = null;
		} finally {
			ConnectDB.disconnect();
		}
		return loans;
	}

	public boolean create(Loan loan) {
		boolean rs = false;
		try {
			PreparedStatement ps = ConnectDB.connection().prepareStatement(
					"insert into loan(Amount, Period, CreateDate, DisbursementDate, Duration, EndDate, Interest, Description, CustomerId, PaymentTypeId, LoanTypeId, AccountId, Status) values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
			ps.setDouble(1, loan.getAmount());
			ps.setInt(2, loan.getPeriod());
			ps.setDate(3, new java.sql.Date(loan.getCreateDate().getTime()));
			ps.setDate(4, new java.sql.Date(loan.getDisbursementDate().getTime()));
			ps.setInt(5, loan.getDuration());
			ps.setDate(6, new java.sql.Date(loan.getEndDate().getTime()));
			ps.setDouble(7, loan.getInterest());
			ps.setString(8, loan.getDescription());
			ps.setInt(9, loan.getCustomerId());
			ps.setInt(10, loan.getPaymentTypeId());
			ps.setInt(11, loan.getLoanTypeId());
			ps.setInt(12, ShareData.accountLogin.getId());
			ps.setInt(13, loan.getStatus());
			rs = ps.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectDB.disconnect();
		}
		return rs;
	}

	public boolean updateLoan(Loan loan) {
		boolean result = false;
		try {
			PreparedStatement preparedStatement = ConnectDB.connection().prepareStatement(
					"update Loan SET LoanTypeId = ?, AccountId = ?, PaymentTypeId = ?, CustomerId = ?, Amount = ?, Period = ?, CreateDate = ?, DisbursementDate = ?, EndDate = ?, Duration = ?, Interest = ?, Status = ?, Description = ?");
			preparedStatement.setInt(1, loan.getLoanTypeId());
			preparedStatement.setInt(2, loan.getAccountId());
			preparedStatement.setInt(3, loan.getPaymentTypeId());
			preparedStatement.setInt(4, loan.getCustomerId());
			preparedStatement.setDouble(5, loan.getAmount());
			preparedStatement.setInt(6, loan.getPeriod());
			preparedStatement.setDate(7, new java.sql.Date(loan.getCreateDate().getTime()));
			preparedStatement.setDate(8, new java.sql.Date(loan.getDisbursementDate().getTime()));
			preparedStatement.setDate(9, new java.sql.Date(loan.getEndDate().getTime()));
			preparedStatement.setInt(10, loan.getDuration());
			preparedStatement.setDouble(11, loan.getInterest());
			preparedStatement.setInt(12, loan.getStatus());
			preparedStatement.setString(13, loan.getDescription());
			result = preparedStatement.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectDB.disconnect();
		}
		return result;
	}

	public boolean closeLoan(int id) {
		boolean result = true;
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
					.prepareStatement("update loan set status = 3 where id = ?");
			preparedStatement.setInt(1, id);
			result = preparedStatement.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectDB.disconnect();
		}
		return result;
	}

	public boolean fullyPaidLoan(int id) {
		boolean result = true;
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
					.prepareStatement("UPDATE loan SET Status = 2 WHERE Id = ?");
			preparedStatement.setInt(1, id);
			result = preparedStatement.executeUpdate() > 0;
		} catch (Exception e) {
			result = false;
		} finally {
			ConnectDB.disconnect();
		}
		return result;
	}

	public int countStatusFalseInLoan(int id) {
		int count = -1;
		try {
			PreparedStatement preparedStatement = ConnectDB.connection().prepareStatement(
					"SELECT COUNT(Id) as Count FROM loanandfinehistory WHERE LoanId = ? AND Status = false");
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			count = resultSet.getInt("Count");
		} catch (Exception e) {
			e.printStackTrace();
			count = -1;
		}
		return count;
	}

	public List<Loan> search(String keyword) {
		java.util.List<Loan> loans = new ArrayList<Loan>();
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
					.prepareStatement("select * from loan where id like ? order by id desc");
			preparedStatement.setString(1, "%" + keyword + "%");
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Loan loan = new Loan();
				loan.setId(rs.getInt("Id"));
				loan.setLoanTypeId(rs.getInt("LoanTypeId"));
				loan.setAccountId(rs.getInt("AccountId"));
				loan.setCustomerId(rs.getInt("CustomerId"));
				loan.setPaymentTypeId(rs.getInt("PaymentTypeId"));
				loan.setAmount(rs.getDouble("Amount"));
				loan.setPeriod(rs.getInt("Period"));
				loan.setCreateDate(rs.getDate("CreateDate"));
				loan.setDisbursementDate(rs.getDate("DisbursementDate"));
				loan.setEndDate(rs.getDate("EndDate"));
				loan.setDuration(rs.getInt("Duration"));
				loan.setStatus(rs.getInt("Status"));
				loans.add(loan);
			}
		} catch (Exception e) {
			loans = null;
		} finally {
			ConnectDB.disconnect();
		}
		return loans;
	}

	public List<Loan> searchByCustomerName(String keyword) {
		java.util.List<Loan> loans = new ArrayList<Loan>();
		try {
			PreparedStatement preparedStatement = ConnectDB.connection().prepareStatement(
					"SELECT c.Name as CustomerName, lt.name as LoanType, pt.name as PaymentType, l.* FROM `loan` as l join `customer` as c on l.CustomerId = c.Id join `loantype` as lt on l.LoanTypeId = lt.Id JOIN `paymenttype` as pt on l.PaymentTypeId = pt.id WHERE c.Name LIKE ? and l.status < 3 order by l.id desc");
			preparedStatement.setString(1, "%" + keyword + "%");
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Loan loan = new Loan();
				loan.setId(rs.getInt("Id"));
				loan.setCustomerName(rs.getString("CustomerName"));
				loan.setLoanTypeName(rs.getString("LoanType"));
				loan.setPaymentTypeName(rs.getString("PaymentType"));
				loan.setLoanTypeId(rs.getInt("LoanTypeId"));
				loan.setAccountId(rs.getInt("AccountId"));
				loan.setCustomerId(rs.getInt("CustomerId"));
				loan.setPaymentTypeId(rs.getInt("PaymentTypeId"));
				loan.setAmount(rs.getDouble("Amount"));
				loan.setPeriod(rs.getInt("Period"));
				loan.setCreateDate(rs.getDate("CreateDate"));
				loan.setDisbursementDate(rs.getDate("DisbursementDate"));
				loan.setEndDate(rs.getDate("EndDate"));
				loan.setDuration(rs.getInt("Duration"));
				loan.setStatus(rs.getInt("Status"));
				loans.add(loan);
			}
		} catch (Exception e) {
			loans = null;
		} finally {
			ConnectDB.disconnect();
		}
		return loans;
	}

	public boolean findLoanByID(int id) {
		Boolean result = false;
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
					.prepareStatement("SELECT Id FROM loan WHERE Id = ?");
			preparedStatement.setInt(1, id);
			result = preparedStatement.executeUpdate() > 0;
		} catch (Exception e) {
			result = false;
		} finally {
			ConnectDB.disconnect();
		}
		return result;
	}

	public boolean accpetLoan(int id) {
		boolean result = false;
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
					.prepareStatement("UPDATE loan SET Status = 1 WHERE Id = ?");
			preparedStatement.setInt(1, id);
			result = preparedStatement.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectDB.disconnect();
		}
		return result;
	}

	public Loan loadLoanByID(int id) {
		Loan loan = new Loan();
		try {
			PreparedStatement statement = ConnectDB.connection().prepareStatement("Select * from Loan where id = ?");
			statement.setInt(1, id);
			ResultSet resultset = statement.executeQuery();
			if (resultset.next()) {
				loan.setId(resultset.getInt("Id"));
				loan.setLoanTypeId(resultset.getInt("LoanTypeId"));
				loan.setAccountId(resultset.getInt("AccountId"));
				loan.setCustomerId(resultset.getInt("CustomerId"));
				loan.setPaymentTypeId(resultset.getInt("PaymentTypeId"));
				loan.setAmount(resultset.getDouble("Amount"));
				loan.setPeriod(resultset.getInt("Period"));
				loan.setCreateDate(resultset.getDate("CreateDate"));
				loan.setDisbursementDate(resultset.getDate("DisbursementDate"));
				loan.setDuration(resultset.getInt("Duration"));
				loan.setEndDate(resultset.getDate("EndDate"));
				loan.setInterest(resultset.getDouble("Interest"));
				loan.setDescription(resultset.getString("Description"));
				loan.setStatus(resultset.getInt("Status"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			loan = null;
		} finally {
			ConnectDB.disconnect();
		}
		return loan;
	}
	
	public int createResultId(Loan loan) {
		int rs = -1;
		try {
			String generatedColums[] = { "Id" };
			PreparedStatement ps = ConnectDB.connection().prepareStatement(
					"insert into loan(Amount, Period, CreateDate, DisbursementDate, Duration, EndDate, Interest, Description, CustomerId, PaymentTypeId, LoanTypeId, AccountId, Status) values(?,?,?,?,?,?,?,?,?,?,?,?,?)",
					generatedColums);
			ps.setDouble(1, loan.getAmount());
			ps.setInt(2, loan.getPeriod());
			ps.setDate(3, new java.sql.Date(loan.getCreateDate().getTime()));
			ps.setDate(4, new java.sql.Date(loan.getDisbursementDate().getTime()));
			ps.setInt(5, loan.getDuration());
			ps.setDate(6, new java.sql.Date(loan.getEndDate().getTime()));
			ps.setDouble(7, loan.getInterest());
			ps.setString(8, loan.getDescription());
			ps.setInt(9, loan.getCustomerId());
			ps.setInt(10, loan.getPaymentTypeId());
			ps.setInt(11, loan.getLoanTypeId());
			ps.setInt(12, ShareData.accountLogin.getId());
			ps.setInt(13, loan.getStatus());
			boolean response = ps.executeUpdate() > 0;
			if (response) {
				ResultSet resultSet = ps.getGeneratedKeys();
				if (resultSet.next()) {
					int id = resultSet.getInt(1);
					rs = id;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectDB.disconnect();
		}
		return rs;
	}

	public LoanType loadLoanTypeByLoanID(int id) {
		LoanType loanType = new LoanType();
		try {
			PreparedStatement statement = ConnectDB.connection()
					.prepareStatement("Select LoanTypeId from Loan where id = ?");
			statement.setInt(1, id);
			ResultSet resultset = statement.executeQuery();
			if (resultset.next()) {
				int loanTypeId = resultset.getInt("LoanTypeId");
				LoanTypeModel loanTypeModel = new LoanTypeModel();
				loanType = loanTypeModel.loadLoanType(loanTypeId);
			}
		} catch (Exception e) {
			e.printStackTrace();
			loanType = null;
		} finally {
			ConnectDB.disconnect();
		}
		return loanType;
	}
}