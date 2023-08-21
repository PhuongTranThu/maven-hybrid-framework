package com.nopcommerce.data;

import java.io.File;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.json.UTF8DataInputJsonParser;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nopcommerce.data.UserData.Login;

import commons.GlobalConstants;

public class UserDataMapper {

	@JsonProperty("firstName")
	private String firstName;
	
	@JsonProperty("lastName")
	private String lastName;
	
	@JsonProperty("emailAddress")
	private String emailAddress;
	
	@JsonProperty("validPassword")
	private String validPassword;
	
	@JsonProperty("date")
	private String date;
	
	@JsonProperty("month")
	private String month;
	
	@JsonProperty("year")
	private String year;
	
	@JsonProperty("Login")
	private Login login;
	
	static class Login {
		@JsonProperty("userName")
		static String userName;
		
		@JsonProperty("password")
		static String password;
	}
	
	public String getLoginUserCode() {
		return login.userName;	
	}
	
	public String getLoginPassword() {
		return login.password;
	}
	
	public static UserDataMapper getUserData() {
		try {
			ObjectMapper mapper =  new ObjectMapper();
			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			return mapper.readValue(new File(GlobalConstants.PROJECT_PATH + "/src/test/resources/UserData.json"), UserDataMapper.class);
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public String getValidPassword() {
		return validPassword;
	}
	public String getDate() {
		return date;
	}
	public String getMonth() {
		return month;
	}
	public String getYear() {
		return year;
	}

}
