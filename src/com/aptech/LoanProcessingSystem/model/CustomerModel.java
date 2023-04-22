package com.aptech.LoanProcessingSystem.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.aptech.LoanProcessingSystem.database.ConnectDB;
import com.aptech.LoanProcessingSystem.entities.Customer;

public class CustomerModel {

	public boolean create(Customer customer) {
		boolean rs = false;
		try {
			PreparedStatement ps = ConnectDB.connection().prepareStatement(
					"insert into customer(name, address, phone, email, gender, dob, salary, job, company, IdentityCard, status) values(?,?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1, customer.getName());
			ps.setString(2, customer.getAddress());
			ps.setString(3, customer.getPhone());
			ps.setString(4, customer.getEmail());
			ps.setBoolean(5, customer.isGender());
			ps.setDate(6, new java.sql.Date(customer.getDob().getTime()));
			ps.setDouble(7, customer.getSalary());
			ps.setString(8, customer.getJob());
			ps.setString(9, customer.getCompany());
			ps.setString(10, customer.getIdentityCard());
			ps.setBoolean(11, true);
			rs = ps.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectDB.disconnect();
		}
		return rs;
	}

	public boolean update(Customer customer) {
		boolean rs = false;
		try {
			PreparedStatement ps = ConnectDB.connection()
					.prepareStatement("UPDATE customer SET Name = ?, Address = ?, Phone = ?, Email = ?,"
							+ " Gender = ?, DOB = ?, Salary = ?, Job = ?, Company = ?, "
							+ "IdentityCard = ?, Status = ? WHERE Id = ?");
			ps.setString(1, customer.getName());
			ps.setString(2, customer.getAddress());
			ps.setString(3, customer.getPhone());
			ps.setString(4, customer.getEmail());
			ps.setBoolean(5, customer.isGender());
			ps.setDate(6, new java.sql.Date(customer.getDob().getTime()));
			ps.setDouble(7, customer.getSalary());
			ps.setString(8, customer.getJob());
			ps.setString(9, customer.getCompany());
			ps.setString(10, customer.getIdentityCard());
			ps.setBoolean(11, customer.isStatus());
			ps.setInt(12, customer.getId());
			rs = ps.executeUpdate() > 0;
		} catch (Exception e) {
			rs = false;
		} finally {
			ConnectDB.disconnect();
		}
		System.out.println(customer.getId());
		return rs;
	}

	public List<Customer> findAll() {
		List<Customer> customers = new ArrayList<Customer>();

		try {

			PreparedStatement ps = ConnectDB.connection().prepareStatement("select * from customer order by id desc");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Customer customer = new Customer();
				customer.setId(rs.getInt("Id"));
				customer.setName(rs.getString("Name"));
				customer.setAddress(rs.getString("Address"));
				customer.setPhone(rs.getString("Phone"));
				customer.setEmail(rs.getString("Email"));
				customer.setGender(rs.getBoolean("Gender"));
				customer.setDob(rs.getDate("DOB"));
				customer.setSalary(rs.getFloat("Salary"));
				customer.setJob(rs.getString("Job"));
				customer.setCompany(rs.getString("Company"));
				customer.setIdentityCard(rs.getString("IdentityCard"));
				customer.setStatus(rs.getBoolean("Status"));
				customers.add(customer);
			}

		} catch (Exception e) {
			customers = null;
		} finally {
			ConnectDB.disconnect();
		}
		return customers;
	}

	public List<Customer> search(String keyword) {
		java.util.List<Customer> customers = new ArrayList<Customer>();
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
					.prepareStatement("select * from customer where name like ? order by id desc");
			preparedStatement.setString(1, "%" + keyword + "%");
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Customer customer = new Customer();
				customer.setId(rs.getInt("Id"));
				customer.setName(rs.getString("Name"));
				customer.setAddress(rs.getString("Address"));
				customer.setPhone(rs.getString("Phone"));
				customer.setEmail(rs.getString("Email"));
				customer.setGender(rs.getBoolean("Gender"));
				customer.setDob(rs.getDate("DOB"));
				customer.setSalary(rs.getFloat("Salary"));
				customer.setJob(rs.getString("Job"));
				customer.setCompany(rs.getString("Company"));
				customer.setIdentityCard(rs.getString("IdentityCard"));
				customer.setStatus(rs.getBoolean("Status"));
				customers.add(customer);
			}
		} catch (Exception e) {
			customers = null;
		} finally {
			ConnectDB.disconnect();
		}
		return customers;
	}

	public Customer findById(int CustomerId) {
		Customer customer = null;
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
					.prepareStatement("select * from customer where id = ?");
			preparedStatement.setInt(1, CustomerId);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				customer = new Customer();
				customer.setId(rs.getInt("Id"));
				customer.setName(rs.getString("Name"));
				customer.setAddress(rs.getString("Address"));
				customer.setPhone(rs.getString("Phone"));
				customer.setEmail(rs.getString("Email"));
				customer.setGender(rs.getBoolean("Gender"));
				customer.setDob(rs.getDate("DOB"));
				customer.setSalary(rs.getFloat("Salary"));
				customer.setJob(rs.getString("Job"));
				customer.setCompany(rs.getString("Company"));
				customer.setIdentityCard(rs.getString("IdentityCard"));
				customer.setStatus(rs.getBoolean("Status"));
			}
		} catch (Exception e) {
			customer = null;
			e.printStackTrace();
		} finally {
			ConnectDB.disconnect();
		}
		return customer;
	}

	public String findCustomerNameById(int id) {
		String str = null;
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
					.prepareStatement("SELECT Name FROM customer WHERE Id = ?");
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				str = resultSet.getString("name");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectDB.disconnect();
		}
		return str;
	}

	public boolean findCustomerByEmail(String email) {
		boolean result = false;
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
					.prepareStatement("SELECT Id From customer WHERE Email = ?");
			preparedStatement.setString(1, email);
			result = preparedStatement.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectDB.disconnect();
		}
		return result;
	}

	public List<Customer> findCustomerByAccountID(int id) {
		List<Customer> customerList = new ArrayList<Customer>();
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
					.prepareStatement("SELECT DISTINCT loan.CustomerId FROM customer"
							+ " as cus INNER JOIN loan ON cus.Id = loan.CustomerId " + "WHERE loan.AccountId = ?");
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				int customerId = resultSet.getInt("CustomerId");
				customerList.add(findById(customerId));
			}
		} catch (Exception e) {
			e.printStackTrace();
			customerList = null;
		} finally {
			ConnectDB.disconnect();
		}
		return customerList;
	}

	public boolean delete(int id) {
		boolean result = false;
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
					.prepareStatement("delete from customer where id = ?");
			preparedStatement.setInt(1, id);
			result = preparedStatement.executeUpdate() > 0;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			ConnectDB.disconnect();
		}
		return result;
	}

}
