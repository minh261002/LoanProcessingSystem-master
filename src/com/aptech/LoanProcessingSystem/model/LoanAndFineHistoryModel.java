package com.aptech.LoanProcessingSystem.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.aptech.LoanProcessingSystem.database.ConnectDB;
import com.aptech.LoanProcessingSystem.entities.LoanAndFineHistory;

public class LoanAndFineHistoryModel {

	public List<LoanAndFineHistory> getAllLoanAndFineHistorys() {
		List<LoanAndFineHistory> loanAndFineHistorys = null;
		try {
			loanAndFineHistorys = new ArrayList<>();

			PreparedStatement statement = ConnectDB.connection()
					.prepareStatement("Select a.*, c.Name as 'CName', d.Name as 'PMName' from LoanAndFineHistory a\r\n"
							+ "left JOIN loan b on a.LoanId = b.Id\r\n"
							+ "left join customer c on c.id = b.CustomerId\r\n"
							+ "left join paymentmethod d on d.id = a.PaymentMethodId");

			ResultSet resultset = statement.executeQuery();
			while (resultset.next()) {
				LoanAndFineHistory loanAndFineHistory = new LoanAndFineHistory();
				loanAndFineHistory.setId(resultset.getInt("Id"));
				loanAndFineHistory.setCustomer(resultset.getString("CName"));
				loanAndFineHistory.setAmount(resultset.getDouble("Amount"));
				loanAndFineHistory.setPaymentMenthodName(resultset.getString("PMName"));
				loanAndFineHistory.setPaymentAmount(resultset.getDouble("PaymentAmount"));
				loanAndFineHistory.setAmountLeft(resultset.getDouble("AmountLeft"));
				loanAndFineHistory.setDueDate(resultset.getDate("DueDate"));
				loanAndFineHistory.setFineInterest(resultset.getFloat("FineInterest"));
				loanAndFineHistory.setFineOverDays(resultset.getInt("FineOverDays"));
				loanAndFineHistory.setFineAmount(resultset.getDouble("FineAmount"));
				loanAndFineHistory.setPaymentDate(resultset.getDate("PaymentDate"));
				loanAndFineHistory.setDescription(resultset.getString("Description"));
				loanAndFineHistory.setStatus(resultset.getBoolean("Status"));
				loanAndFineHistorys.add(loanAndFineHistory);
			}
		} catch (Exception e) {
			e.printStackTrace();
			loanAndFineHistorys = null;
		} finally {
			ConnectDB.disconnect();
		}
		return loanAndFineHistorys;
	}
	
	public List<LoanAndFineHistory> getAllLoanAndFineHistorys(int loanID) {
		List<LoanAndFineHistory> loanAndFineHistorys = null;
		try {
			loanAndFineHistorys = new ArrayList<>();
			PreparedStatement statement = ConnectDB.connection().prepareStatement("Select a.*, c.Name as 'CName', d.Name as "
					+ "'PMName' from LoanAndFineHistory a\r\n"
					+ "left JOIN loan b on a.LoanId = b.Id\r\n"
					+ "left join customer c on c.id = b.CustomerId\r\n"
					+ "left join paymentmethod d on d.id = a.PaymentMethodId Where a.LoanId = ?");
			statement.setInt(1, loanID);
			ResultSet resultset = statement.executeQuery();
			while (resultset.next()) {
				LoanAndFineHistory loanAndFineHistory = new LoanAndFineHistory();
				loanAndFineHistory.setId(resultset.getInt("Id"));
				loanAndFineHistory.setCustomer(resultset.getString("CName"));
				loanAndFineHistory.setAmount(resultset.getDouble("Amount"));
				loanAndFineHistory.setPaymentMenthodName(resultset.getString("PMName"));
				loanAndFineHistory.setPaymentAmount(resultset.getDouble("PaymentAmount"));
				loanAndFineHistory.setAmountLeft(resultset.getDouble("AmountLeft"));
				loanAndFineHistory.setDueDate(resultset.getDate("DueDate"));
				loanAndFineHistory.setFineInterest(resultset.getFloat("FineInterest"));
				loanAndFineHistory.setFineOverDays(resultset.getInt("FineOverDays"));
				loanAndFineHistory.setFineAmount(resultset.getDouble("FineAmount"));
				loanAndFineHistory.setPaymentDate(resultset.getDate("PaymentDate"));
				loanAndFineHistory.setDescription(resultset.getString("Description"));
				loanAndFineHistory.setStatus(resultset.getBoolean("Status"));
				loanAndFineHistorys.add(loanAndFineHistory);
			}
		} catch (Exception e) {
			e.printStackTrace();
			loanAndFineHistorys = null;
		} finally {
			ConnectDB.disconnect();
		}
		return loanAndFineHistorys;
	}

	public Boolean createLoanAndFineHistory(LoanAndFineHistory loanAndFineHistory) {
		Boolean result = false;
		try {
			PreparedStatement preparedStatement = ConnectDB.connection().prepareStatement(
					"insert into LoanAndFineHistory(PaymentAmount, AmountLeft, DueDate, FineInterest, FineOverDays, FineAmount, Description, Status, LoanId, Amount) values(?,?,?,?,?,?,?,?,?,?)");

			preparedStatement.setDouble(1, loanAndFineHistory.getPaymentAmount());
			preparedStatement.setDouble(2, loanAndFineHistory.getAmountLeft());
			preparedStatement.setDate(3, new java.sql.Date(loanAndFineHistory.getDueDate().getTime()));
			preparedStatement.setDouble(4, loanAndFineHistory.getFineInterest());
			preparedStatement.setInt(5, loanAndFineHistory.getFineOverDays());
			preparedStatement.setDouble(6, loanAndFineHistory.getFineAmount());
			preparedStatement.setString(7, loanAndFineHistory.getDescription());
			preparedStatement.setBoolean(8, loanAndFineHistory.isStatus());
			preparedStatement.setInt(9, loanAndFineHistory.getLoanId());
			preparedStatement.setDouble(10, loanAndFineHistory.getAmount());
			result = preparedStatement.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectDB.disconnect();
		}
		return result;
	}

	public Boolean updateLoanAndFineHistory(LoanAndFineHistory loanAndFineHistory) {
		Boolean result = false;
		try {
			PreparedStatement preparedStatement = ConnectDB.connection().prepareStatement(
					"update LoanAndFineHistory SET LoanId = ?, FineId = ?, PaymentMethodId = ?, PaymentAmount = ?, AmountLeft = ?, DueDate = ?, FineInterest = ?, FineOverDays = ?, FineAmount = ?, PaymentDate = ?, Description = ?, Status = ?)");
			preparedStatement.setInt(1, loanAndFineHistory.getLoanId());
			preparedStatement.setInt(2, loanAndFineHistory.getFineId());
			preparedStatement.setInt(3, loanAndFineHistory.getPaymentMethodId());
			preparedStatement.setDouble(4, loanAndFineHistory.getPaymentAmount());
			preparedStatement.setDouble(5, loanAndFineHistory.getAmountLeft());
			preparedStatement.setDate(6, new java.sql.Date(loanAndFineHistory.getDueDate().getTime()));
			preparedStatement.setDouble(7, loanAndFineHistory.getFineInterest());
			preparedStatement.setInt(8, loanAndFineHistory.getFineOverDays());
			preparedStatement.setDouble(9, loanAndFineHistory.getFineAmount());
			preparedStatement.setDate(10, new java.sql.Date(loanAndFineHistory.getPaymentDate().getTime()));
			preparedStatement.setString(11, loanAndFineHistory.getDescription());
			preparedStatement.setBoolean(12, loanAndFineHistory.isStatus());
			result = preparedStatement.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectDB.disconnect();
		}
		return result;
	}

	public boolean delete(int id) {
		boolean result = false;
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
					.prepareStatement("delete from LoanAndFineHistory where id = ?");
			preparedStatement.setInt(1, id);
			result = preparedStatement.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectDB.disconnect();
		}
		return result;
	}


	public LoanAndFineHistory searchHistoryBasedOnId(int keyword) {
		LoanAndFineHistory result = null;
		try {
			PreparedStatement preparedStatement = ConnectDB.connection().prepareStatement(
					"SELECT c.Name as Customer, pm.Name as PaymemtMethod, lt.Name as LoanType, pt.Name as PaymentType, l.Period, l.Duration, l.EndDate, l.Interest, hs.* FROM `loanandfinehistory` as hs LEFT JOIN `loan` as l on hs.LoanId = l.Id LEFT JOIN `loantype` as lt on l.LoanTypeId = lt.Id JOIN `customer` as c ON l.CustomerId = c.Id LEFT JOIN `paymenttype` as pt ON l.PaymentTypeId = pt.Id LEFT JOIN `paymentmethod` as pm ON pm.Id = hs.PaymentMethodId where hs.id = ?");
			preparedStatement.setInt(1, keyword);
			ResultSet rs = preparedStatement.executeQuery();
			if (rs.next()) {
				result = new LoanAndFineHistory();
				result.setCustomer(rs.getString("Customer"));
				result.setLoanType(rs.getString("LoanType"));
				result.setPaymentType(rs.getString("PaymentType"));
				result.setPeriod(rs.getInt("Period"));
				result.setDuration(rs.getInt("Duration"));
				result.setEndDate(rs.getDate("EndDate"));
				result.setLoanInterest(rs.getFloat("Interest"));
				result.setId(rs.getInt("Id"));
				result.setLoanId(rs.getInt("LoanId"));
				result.setFineId(rs.getInt("FineId"));
				result.setPaymentMethodId(rs.getInt("PaymentMethodId"));
				result.setPaymentMenthodName(rs.getString("PaymemtMethod"));
				result.setPaymentAmount(rs.getDouble("PaymentAmount"));
				result.setAmount(rs.getDouble("Amount"));
				result.setAmountLeft(rs.getDouble("AmountLeft"));
				result.setDueDate(rs.getDate("DueDate"));
				result.setFineInterest(rs.getFloat("FineInterest"));
				result.setFineOverDays(rs.getInt("FineOverDays"));
				result.setFineAmount(rs.getDouble("FineAmount"));
				result.setPaymentDate(rs.getDate("PaymentDate"));
				result.setDescription(rs.getString("Description"));
				result.setStatus(rs.getBoolean("Status"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			result = null;
		} finally {
			ConnectDB.disconnect();
		}

		return result;
	}

	public Boolean updatePayment(LoanAndFineHistory loanAndFineHistory) {
		Boolean result = false;
		try {
			PreparedStatement preparedStatement = ConnectDB.connection().prepareStatement(
					"update LoanAndFineHistory SET PaymentAmount = ?, AmountLeft = ?, FineOverDays = ?, FineAmount = ?,"
					+ " PaymentDate = ?, Description = ?, FineInterest = ?, PaymentMethodId = ?, Status = true WHERE Id = ?");
			preparedStatement.setDouble(1, loanAndFineHistory.getPaymentAmount());
			preparedStatement.setDouble(2, loanAndFineHistory.getAmountLeft());
			preparedStatement.setInt(3, loanAndFineHistory.getFineOverDays());
			preparedStatement.setDouble(4, loanAndFineHistory.getFineAmount());
			preparedStatement.setDate(5, new java.sql.Date(loanAndFineHistory.getPaymentDate().getTime()));
			preparedStatement.setString(6, loanAndFineHistory.getDescription());
			preparedStatement.setDouble(7, loanAndFineHistory.getFineInterest());
			preparedStatement.setInt(8, loanAndFineHistory.getPaymentMethodId());
			preparedStatement.setInt(9, loanAndFineHistory.getId());
			result = preparedStatement.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectDB.disconnect();
		}
		return result;
	}

	public List<LoanAndFineHistory> search(String keyword) {
		List<LoanAndFineHistory> loanAndFineHistorys = null;
		try {
			loanAndFineHistorys = new ArrayList<>();
			PreparedStatement statement = ConnectDB.connection()
					.prepareStatement("Select a.*, c.Name as 'CName', d.Name as 'PMName' from LoanAndFineHistory a\r\n"
							+ "left JOIN loan b on a.LoanId = b.Id\r\n"
							+ "left join customer c on c.id = b.CustomerId\r\n"
							+ "left join paymentmethod d on d.id = a.PaymentMethodId\r\n " + "where c.Name like ?");
			statement.setString(1, "%" + keyword + "%");
			ResultSet resultset = statement.executeQuery();
			while (resultset.next()) {
				LoanAndFineHistory loanAndFineHistory = new LoanAndFineHistory();
				loanAndFineHistory.setId(resultset.getInt("Id"));
				loanAndFineHistory.setCustomer(resultset.getString("CName"));
				loanAndFineHistory.setAmount(resultset.getDouble("Amount"));
				loanAndFineHistory.setPaymentMenthodName(resultset.getString("PMName"));
				loanAndFineHistory.setPaymentAmount(resultset.getDouble("PaymentAmount"));
				loanAndFineHistory.setAmountLeft(resultset.getDouble("AmountLeft"));
				loanAndFineHistory.setDueDate(resultset.getDate("DueDate"));
				loanAndFineHistory.setFineInterest(resultset.getFloat("FineInterest"));
				loanAndFineHistory.setFineOverDays(resultset.getInt("FineOverDays"));
				loanAndFineHistory.setFineAmount(resultset.getDouble("FineAmount"));
				loanAndFineHistory.setPaymentDate(resultset.getDate("PaymentDate"));
				loanAndFineHistory.setDescription(resultset.getString("Description"));
				loanAndFineHistory.setStatus(resultset.getBoolean("Status"));
				loanAndFineHistorys.add(loanAndFineHistory);
			}
		} catch (Exception e) {
			e.printStackTrace();
			loanAndFineHistorys = null;
		} finally {
			ConnectDB.disconnect();
		}
		return loanAndFineHistorys;
	}

	public List<LoanAndFineHistory> searchByLoanId(int loanId) {

		List<LoanAndFineHistory> loanAndFineHistorys = null;
		try {
			loanAndFineHistorys = new ArrayList<>();
			PreparedStatement statement = ConnectDB.connection()
					.prepareStatement("Select a.*, c.Name as 'CName', d.Name as 'PMName' from LoanAndFineHistory a\r\n"
							+ "left JOIN loan b on a.LoanId = b.Id\r\n"
							+ "left join customer c on c.id = b.CustomerId\r\n"
							+ "left join paymentmethod d on d.id = a.PaymentMethodId\r\n " + "where a.LoanId = ?");
			statement.setInt(1, loanId);
			ResultSet resultset = statement.executeQuery();
			while (resultset.next()) {
				LoanAndFineHistory loanAndFineHistory = new LoanAndFineHistory();
				loanAndFineHistory.setId(resultset.getInt("Id"));
				loanAndFineHistory.setCustomer(resultset.getString("CName"));
				loanAndFineHistory.setAmount(resultset.getDouble("Amount"));
				loanAndFineHistory.setPaymentMenthodName(resultset.getString("PMName"));
				loanAndFineHistory.setPaymentAmount(resultset.getDouble("PaymentAmount"));
				loanAndFineHistory.setAmountLeft(resultset.getDouble("AmountLeft"));
				loanAndFineHistory.setDueDate(resultset.getDate("DueDate"));
				loanAndFineHistory.setFineInterest(resultset.getFloat("FineInterest"));
				loanAndFineHistory.setFineOverDays(resultset.getInt("FineOverDays"));
				loanAndFineHistory.setFineAmount(resultset.getDouble("FineAmount"));
				loanAndFineHistory.setPaymentDate(resultset.getDate("PaymentDate"));
				loanAndFineHistory.setDescription(resultset.getString("Description"));
				loanAndFineHistory.setStatus(resultset.getBoolean("Status"));
				loanAndFineHistorys.add(loanAndFineHistory);
			}
		} catch (Exception e) {
			e.printStackTrace();
			loanAndFineHistorys = null;
		} finally {
			ConnectDB.disconnect();
		}
		return loanAndFineHistorys;
	}
}