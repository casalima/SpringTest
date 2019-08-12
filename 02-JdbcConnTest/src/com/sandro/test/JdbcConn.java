package com.sandro.test;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Value;

public class JdbcConn {

	private String url;
	private String user;
	private String passw;
	private String driver;
	private String serverTimezone;
	

	@Value("${database.url}")
	public void setUrl(String url) {
		this.url = url;
	}
	
	@Value("${database.user}")
	public void setUser(String user) {
		this.user = user;
	}
	
	@Value("${database.passw}")
	public void setPassw(String passw) {
		this.passw = passw;
	}
	
	@Value("${database.driver}")
	public void setDriver(String driver) {
		this.driver = driver;
	}
	
	@Value("${database.serverTimezone}")
	public void setServerTimezone(String serverTimezone) {
		this.serverTimezone = serverTimezone;
	}

	public String getUrl() {
		return url;
	}

	public String getUser() {
		return user;
	}

	public String getPassw() {
		return passw;
	}

	public String getDriver() {
		return driver;
	}

	public void showInfo() {
		System.out.println("url:            " + url);
		System.out.println("user:           " + user);
		System.out.println("password:       " + passw);
		System.out.println("driver:         " + driver);
		System.out.println("serverTimezone: " + serverTimezone);		
	}	
	
	public Properties getProperties() {
		Properties props = new Properties();
		props.put("user", user);
		props.put("password", passw);
		props.put("driver", driver);
		props.put("serverTimezone", serverTimezone);
		
		return props;
	}
	
}
