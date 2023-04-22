package com.aptech.LoanProcessingSystem.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.mindrot.jbcrypt.BCrypt;

import com.aptech.LoanProcessingSystem.database.ConnectDB;
import com.aptech.LoanProcessingSystem.entities.Account;

public class AccountModel {

	public boolean create(Account account) {
		boolean result = true;
		try {
			String generatedColumns[] = { "Id" };
			PreparedStatement preparedStatement = ConnectDB.connection().prepareStatement(
					"insert into account(AuthId, Name, Email, Password,  Phone, Address,Gender, DOB, IdentityCard, Status) values(?,?,?,?,?,?,?,?,?,?)",
					generatedColumns);
			preparedStatement.setInt(1, account.getAuthId());
			preparedStatement.setString(2, account.getName());
			preparedStatement.setString(3, account.getEmail());
			preparedStatement.setString(4, account.getPassword());
			preparedStatement.setString(5, account.getPhone());
			preparedStatement.setString(6, account.getAddress());
			preparedStatement.setBoolean(7, account.isGender());
			preparedStatement.setDate(8, new java.sql.Date(account.getDob().getTime()));
			preparedStatement.setString(9, account.getIdentityCard());
			preparedStatement.setBoolean(10, true);
			result = preparedStatement.executeUpdate() > 0;
			ResultSet rs = preparedStatement.getGeneratedKeys();
			if (rs.next()) {
			    long id = rs.getLong(1);
			    System.out.println("Inserted ID -" + id);
			}
		} catch (Exception e) {
			e.printStackTrace();
			result = false;
		} finally {
			ConnectDB.disconnect();
		}
		return result;
	}

	public Account login(String email, String password) {
		Account account = null;
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
					.prepareStatement("select * from account where Email = ?");
			preparedStatement.setString(1, email);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				String hashPass = resultSet.getString("Password");
				if (BCrypt.checkpw(password, hashPass)) {
					account = new Account();
					account.setId(resultSet.getInt("Id"));
					account.setAuthId(resultSet.getInt("AuthId"));
					account.setDob(resultSet.getDate("DOB"));
					account.setEmail(resultSet.getString("Email"));
					account.setName(resultSet.getString("Name"));
					account.setPassword(hashPass);
					account.setStatus(resultSet.getBoolean("Status"));
					account.setAddress(resultSet.getString("Address"));
					account.setPhone(resultSet.getString("Phone"));
					account.setIdentityCard(resultSet.getString("IdentityCard"));
					account.setGender(resultSet.getBoolean("Gender"));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			account = null;
		} finally {
			ConnectDB.disconnect();
		}
		return account;
	}
	
	public List<Account> loadAllEmployee() {
		List<Account> employeeList = new ArrayList<Account>();
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
					.prepareStatement("select ac.*, a.name as AuthName from account as ac join authorities as a on ac.authId = a.id");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
					Account account = new Account();
					account.setId(resultSet.getInt("Id"));
					account.setAuthId(resultSet.getInt("AuthId"));
					account.setAuthName(resultSet.getString("AuthName"));
					account.setDob(resultSet.getDate("DOB"));
					account.setEmail(resultSet.getString("Email"));
					account.setName(resultSet.getString("Name"));
					account.setStatus(resultSet.getBoolean("Status"));
					account.setAddress(resultSet.getString("Address"));
					account.setPhone(resultSet.getString("Phone"));
					account.setIdentityCard(resultSet.getString("IdentityCard"));
					account.setGender(resultSet.getBoolean("Gender"));
					employeeList.add(account);
					}
		} catch (Exception e) {
			employeeList = null;
			e.printStackTrace();
		} finally {
			ConnectDB.disconnect();
		}
		return employeeList;
	}
	
	public String loadEmployeeNameByID (int id) {
		String str = "";
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
					.prepareStatement("SELECT name FROM account WHERE id = ?");
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				str = resultSet.getString("name");
			}
		} catch (Exception e) {
			e.printStackTrace();
			str = null;
		} finally {
			ConnectDB.disconnect();
		}
		return str;
	}
	
	public List<Account> loadEmployeeExisted() {
		List<Account> employeeList = new ArrayList<Account>();
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
					.prepareStatement("select ac.*, a.name as AuthName from account as ac join authorities as a on ac.authId = a.id where AuthId = 1 and status = true");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
					Account account = new Account();
					account.setId(resultSet.getInt("Id"));
					account.setAuthId(resultSet.getInt("AuthId"));
					account.setAuthName(resultSet.getString("AuthName"));
					account.setDob(resultSet.getDate("DOB"));
					account.setEmail(resultSet.getString("Email"));
					account.setName(resultSet.getString("Name"));
					account.setStatus(resultSet.getBoolean("Status"));
					account.setAddress(resultSet.getString("Address"));
					account.setPhone(resultSet.getString("Phone"));
					account.setIdentityCard(resultSet.getString("IdentityCard"));
					account.setGender(resultSet.getBoolean("Gender"));
					employeeList.add(account);
					}
		} catch (Exception e) {
			employeeList = null;
			e.printStackTrace();
		} finally {
			ConnectDB.disconnect();
		}
		return employeeList;
	}
	
	public List<Account> loadEmployeeDeleted() {
		List<Account> employeeList = new ArrayList<Account>();
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
					.prepareStatement("select ac.*, a.name as AuthName from account as ac join authorities as a on ac.authId = a.id where AuthId = 1 and status = false");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
					Account account = new Account();
					account.setId(resultSet.getInt("Id"));
					account.setAuthId(resultSet.getInt("AuthId"));
					account.setAuthName(resultSet.getString("AuthName"));
					account.setDob(resultSet.getDate("DOB"));
					account.setEmail(resultSet.getString("Email"));
					account.setName(resultSet.getString("Name"));
					account.setStatus(resultSet.getBoolean("Status"));
					account.setAddress(resultSet.getString("Address"));
					account.setPhone(resultSet.getString("Phone"));
					account.setIdentityCard(resultSet.getString("IdentityCard"));
					account.setGender(resultSet.getBoolean("Gender"));
					employeeList.add(account);
					}
		} catch (Exception e) {
			employeeList = null;
			e.printStackTrace();
		} finally {
			ConnectDB.disconnect();
		}
		return employeeList;
	}
	
	public List<Account> find(String name) {
		List<Account> employeeList = new ArrayList<Account>();
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
					.prepareStatement("select * from account where AuthId = 1 AND Name like ?");
			preparedStatement.setString(1, "%" + name + "%");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
					Account account = new Account();
					account.setId(resultSet.getInt("Id"));
					account.setAuthId(resultSet.getInt("AuthId"));
					account.setDob(resultSet.getDate("DOB"));
					account.setEmail(resultSet.getString("Email"));
					account.setName(resultSet.getString("Name"));
					account.setStatus(resultSet.getBoolean("Status"));
					account.setAddress(resultSet.getString("Address"));
					account.setPhone(resultSet.getString("Phone"));
					account.setIdentityCard(resultSet.getString("IdentityCard"));
					account.setGender(resultSet.getBoolean("Gender"));
					employeeList.add(account);
					}
		} catch (Exception e) {
			employeeList = null;
			e.printStackTrace();
		} finally {
			ConnectDB.disconnect();
		}
		return employeeList;
	}
	
	public boolean delete(int id) {
		boolean result = false;
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
					.prepareStatement("UPDATE account SET status = false "
							+ "WHERE Id = ?");
			preparedStatement.setInt(1, id);
			result  = preparedStatement.executeUpdate() > 0;
		} catch (Exception e) {
			// TODO: handle exception
			result = false;
		} finally {
			ConnectDB.disconnect();
		}
		return result;
	}

	public boolean changePass(Account account) {
		boolean result = false;
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
					.prepareStatement("update account set Password = ? where email = ?");
			preparedStatement.setString(1, account.getPassword());
			preparedStatement.setString(2, account.getEmail());
			result = preparedStatement.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectDB.disconnect();
		}
		return result;
	}

	public boolean checkEmail (String email) {
		boolean result = false;
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
					.prepareStatement("SELECT * FROM account WHERE Email = ?");
			preparedStatement.setString(1, email);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				result = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectDB.disconnect();
		}
		return result;
	}
	
}
