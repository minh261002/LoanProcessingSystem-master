package com.aptech.LoanProcessingSystem.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.aptech.LoanProcessingSystem.database.ConnectDB;
import com.aptech.LoanProcessingSystem.entities.PaymentMethod;

public class PaymentMethodModel {

	public List<PaymentMethod> getAllPaymentMethods() {
		List<PaymentMethod> paymentMethods = null;
		try {
			paymentMethods = new ArrayList<>();
			PreparedStatement statement = ConnectDB.connection().prepareStatement("Select * from PaymentMethod");
			ResultSet resultset = statement.executeQuery();
			while (resultset.next()) {
				PaymentMethod paymentMethod = new PaymentMethod();
				paymentMethod.setId(resultset.getInt("Id"));
				paymentMethod.setName(resultset.getString("Name"));
				paymentMethods.add(paymentMethod);
			}
		} catch (Exception e) {
			e.printStackTrace();
			paymentMethods = null;
		} finally {
			ConnectDB.disconnect();
		}
		return paymentMethods;
	}

	public Boolean createPaymentMethod(PaymentMethod paymentMethod) {
		Boolean result = false;
		try {
			PreparedStatement preparedStatement = ConnectDB.connection().prepareStatement(
					"insert into PaymentMethod(Name) values(?)");
			preparedStatement.setString(1, paymentMethod.getName());
			result = preparedStatement.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectDB.disconnect();
		}
		return result;
	}

	public Boolean updatePaymentMethod(PaymentMethod paymentMethod) {
		Boolean result = false;
		try {
			PreparedStatement preparedStatement = ConnectDB.connection().prepareStatement(
					"update PaymentMethod SET Name = ?");
			preparedStatement.setString(1, paymentMethod.getName());
			result = preparedStatement.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectDB.disconnect();
		}
		return result;
	}

}