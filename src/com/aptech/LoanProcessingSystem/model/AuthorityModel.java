package com.aptech.LoanProcessingSystem.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.text.html.HTMLDocument.HTMLReader.PreAction;
import com.aptech.LoanProcessingSystem.database.ConnectDB;
import com.aptech.LoanProcessingSystem.entities.Authority;

public class AuthorityModel {
	public List<Authority> getAll() {
		List<Authority> authoritys = null;
		try {
			authoritys = new ArrayList<>();
			PreparedStatement statement = ConnectDB.connection().prepareStatement("Select * from Authorities");
			ResultSet resultset = statement.executeQuery();
			while (resultset.next()) {
				Authority authority = new Authority();
				authority.setId(resultset.getInt("Id"));
				authority.setName(resultset.getString("Name"));
				authoritys.add(authority);
			}
		} catch (Exception e) {
			e.printStackTrace();
			authoritys = null;
		} finally {
			ConnectDB.disconnect();
		}
		return authoritys;
	}

	public Boolean createAuthority(Authority authority) {
		Boolean result = false;
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
					.prepareStatement("insert into Authorities(Name) values(?)");
			preparedStatement.setString(1, authority.getName());
			result = preparedStatement.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectDB.disconnect();
		}
		return result;
	}

	public Boolean updaAuthoritype(Authority authority) {
		Boolean result = false;
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
					.prepareStatement("update Authorities SET Name = ?");
			preparedStatement.setString(1, authority.getName());
			result = preparedStatement.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectDB.disconnect();
		}
		return result;
	}
}
