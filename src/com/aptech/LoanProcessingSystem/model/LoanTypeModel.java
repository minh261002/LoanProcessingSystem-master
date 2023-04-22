package com.aptech.LoanProcessingSystem.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.aptech.LoanProcessingSystem.database.ConnectDB;
import com.aptech.LoanProcessingSystem.entities.LoanType;

public class LoanTypeModel {
	public boolean create(LoanType loanType) {
		boolean result = true;
		try {
			PreparedStatement preparedStatement = ConnectDB.connection().prepareStatement(
					"insert into loantype(Interest, Name, Description, Status) values(?,?,?,?)");
			preparedStatement.setDouble(1, loanType.getInterest());
			preparedStatement.setString(2, loanType.getName());
			preparedStatement.setString(3, loanType.getDescription());
			preparedStatement.setBoolean(4, loanType.isStatus());
			result = preparedStatement.executeUpdate() > 0;

		} catch (Exception e) {
			e.printStackTrace();
			result = false;
		} finally {
			ConnectDB.disconnect();
		}
		return result;
	}
	
	public List<LoanType> find(String name) {
		List<LoanType> loanTypeList = new ArrayList<LoanType>();
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
					.prepareStatement("select * from loantype where Name like ?");
			preparedStatement.setString(1, "%" + name + "%");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				LoanType loanType = new LoanType();
				loanType.setId(resultSet.getInt("Id"));
				loanType.setName(resultSet.getString("Name"));
				loanType.setInterest(resultSet.getFloat("Interest"));
				loanType.setDescription(resultSet.getString("Description"));
				loanType.setStatus(resultSet.getBoolean("Status"));	
				loanTypeList.add(loanType);
			}
		} catch (Exception e) {
			loanTypeList = null;
		} finally {
			ConnectDB.disconnect();
		}
		return loanTypeList;
	}
	
	public boolean delete(int id) {
		boolean result = true;
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
				.prepareStatement("delete from loantype where id = ?");
			preparedStatement.setInt(1, id);
			result = preparedStatement.executeUpdate() > 0;
		} catch (Exception e) {
			result = false;
		} finally {
			ConnectDB.disconnect();
		}
		return result;
	}
	
	public List<LoanType> loadAllLoanType () {
		List<LoanType> loanTypeList = new ArrayList<LoanType>();
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
					.prepareStatement("SELECT * FROM loantype where status = true");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				LoanType loanType = new LoanType();
				loanType.setId(resultSet.getInt("Id"));
				loanType.setName(resultSet.getString("Name"));
				loanType.setInterest(resultSet.getFloat("Interest"));
				loanType.setDescription(resultSet.getString("Description"));
				loanType.setStatus(resultSet.getBoolean("Status"));
				loanTypeList.add(loanType);
			}
		} catch (Exception e) {
			loanTypeList = null;
		} finally {
			ConnectDB.disconnect();
		}
		return loanTypeList;
	}
	
	public LoanType loadLoanType (String name) {
		LoanType loanType = null;
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
					.prepareStatement("SELECT * FROM loantype WHERE name like ?");
			preparedStatement.setString(1, "%" + name + "%");
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				loanType = new LoanType();
				loanType.setId(resultSet.getInt("Id"));
				loanType.setName(resultSet.getString("Name"));
				loanType.setInterest(resultSet.getFloat("Interest"));
				loanType.setDescription(resultSet.getString("Description"));
				loanType.setStatus(resultSet.getBoolean("Status"));
			}
		} catch (Exception e) {
			loanType = null;
		} finally {
			ConnectDB.disconnect();
		}
		return loanType;
	}
	
	public LoanType loadLoanType (int id) {
		LoanType loanType = null;
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
					.prepareStatement("SELECT * FROM loantype WHERE id = ?");
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				loanType = new LoanType();
				loanType.setId(resultSet.getInt("Id"));
				loanType.setName(resultSet.getString("Name"));
				loanType.setInterest(resultSet.getFloat("Interest"));
				loanType.setDescription(resultSet.getString("Description"));
				loanType.setStatus(resultSet.getBoolean("Status"));
			}
		} catch (Exception e) {
			loanType = null;
		} finally {
			ConnectDB.disconnect();
		}
		return loanType;
	}
	
	public boolean update (LoanType loanType) {
		boolean result = false;
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
					.prepareStatement("UPDATE loantype SET "
							+ "Name = ?, Interest = ?, Description = ?, Status = ? WHERE Id  = ?");
			preparedStatement.setString(1, loanType.getName());
			preparedStatement.setDouble(2, loanType.getInterest());
			preparedStatement.setString(3, loanType.getDescription());
			preparedStatement.setBoolean(4, loanType.isStatus());
			preparedStatement.setInt(5, loanType.getId());
			result = preparedStatement.executeUpdate() > 0;
		} catch (Exception e) {
			result = false; 
		} finally {
			ConnectDB.disconnect();
		}
		return result;
	}
	
	
	public List<LoanType> sortInterestHighToLow () {
		List<LoanType> loanList = new ArrayList<LoanType>();
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
					.prepareStatement("SELECT * FROM loantype "
							+ "ORDER BY Interest DESC");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				LoanType loanType = new LoanType();
				loanType.setId(resultSet.getInt("Id"));
				loanType.setName(resultSet.getString("Name"));
				loanType.setInterest(resultSet.getFloat("Interest"));
				loanType.setDescription(resultSet.getString("Description"));
				loanType.setStatus(resultSet.getBoolean("Status"));
				loanList.add(loanType);
			}
		} catch (Exception e) {
			loanList = null;
		} finally {
			ConnectDB.disconnect();
		}
		return loanList;
	}
	
	public List<LoanType> sortInterestLowToHigh () {
		List<LoanType> loanList = new ArrayList<LoanType>();
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
					.prepareStatement("SELECT * FROM loantype "
							+ "ORDER BY Interest ASC");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				LoanType loanType = new LoanType();
				loanType.setId(resultSet.getInt("Id"));
				loanType.setName(resultSet.getString("Name"));
				loanType.setInterest(resultSet.getFloat("Interest"));
				loanType.setDescription(resultSet.getString("Description"));
				loanType.setStatus(resultSet.getBoolean("Status"));
				loanList.add(loanType);
			}
		} catch (Exception e) {
			loanList = null;
		} finally {
			ConnectDB.disconnect();
		}
		return loanList;
	}
	
	public String loadLoanTypeNameById(int id) {
		String str = null;
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
					.prepareStatement("SELECT Name FROM loantype WHERE Id = ?");
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				str = resultSet.getString("Name");
			}
		} catch (Exception e) {
			// TODO: handle exception
			str = null;
		} finally {
			ConnectDB.disconnect();
		}
		return str;
	}
}






















