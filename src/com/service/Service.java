package com.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.database.DBManager;

public class Service {

	public boolean Login(String username, String password) {
		String loginsql = "select * from user_info where Uusername = '" + username + "' and Upassword = '" + password
				+ "'";
		// 获取DBManager对象，连接数据库
		DBManager sql = DBManager.createInstance();
		sql.connectDB();

		ResultSet resultSet = sql.executeQuery(loginsql);
		try {
			if (resultSet.next()) {
				sql.closeDB();
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		sql.closeDB();
		return false;
	}

	public boolean Register(String username, String password) {
		String regsql = "insert into user_info(Uusername, Upassword) values('" + username + "','" + password + "') ";
		// 获取DBManager对象，连接数据库
		DBManager sql = DBManager.createInstance();
		sql.connectDB();

		int ret = sql.executeUpdate(regsql);
		if (ret != 0) {
			sql.closeDB();
			return true;
		}
		sql.closeDB();
		return false;
	}
}