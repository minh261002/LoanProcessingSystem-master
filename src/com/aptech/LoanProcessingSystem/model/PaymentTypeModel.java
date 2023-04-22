package com.aptech.LoanProcessingSystem.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.aptech.LoanProcessingSystem.database.ConnectDB;
import com.aptech.LoanProcessingSystem.entities.PaymentType;

public class PaymentTypeModel {

	public List<PaymentType> getAllPaymentTypes() {
		List<PaymentType> paymentTypes = null;
		try {
			paymentTypes = new ArrayList<>();
			PreparedStatement statement = ConnectDB.connection().prepareStatement("Select * from PaymentType");
			ResultSet resultset = statement.executeQuery();
			while (resultset.next()) {
				PaymentType paymentType = new PaymentType();
				paymentType.setId(resultset.getInt("Id"));
				paymentType.setName(resultset.getString("Name"));
				paymentTypes.add(paymentType);
			}
		} catch (Exception e) {
			e.printStackTrace();
			paymentTypes = null;
		} finally {
			ConnectDB.disconnect();
		}
		return paymentTypes;
	}

	public Boolean createPaymentType(PaymentType paymentType) {
		Boolean result = false;
		try {
			PreparedStatement preparedStatement = ConnectDB.connection().prepareStatement(
					"insert into PaymentType(Name) values(?)");
			preparedStatement.setString(1, paymentType.getName());
			result = preparedStatement.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectDB.disconnect();
		}
		return result;
	}

	public Boolean updatePaymentType(PaymentType paymentType) {
		Boolean result = false;
		try {
			PreparedStatement preparedStatement = ConnectDB.connection().prepareStatement(
					"update PaymentType SET Name = ?");
			preparedStatement.setString(1, paymentType.getName());
			result = preparedStatement.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectDB.disconnect();
		}
		return result;
	}
	
	public String loadPaymentTypeNameById(int id) {
		String str = null;
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
					.prepareStatement("SELECT Name FROM paymenttype WHERE Id = ?");
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