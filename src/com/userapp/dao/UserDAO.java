package com.userapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.userapp.model.User;
import com.userapp.util.ConnectionUtil;

public class UserDAO {

	public List<User> findAll() throws SQLException {
		Connection connection = ConnectionUtil.getConnection();
		String sql = "select id,name,email_id,password,active from users";
		PreparedStatement pst = connection.prepareStatement(sql);
		ResultSet rs = pst.executeQuery();
		List<User> users = new ArrayList<>();
		while (rs.next()) {
			User user = new User();
			user.setId(rs.getInt("id"));
			user.setName(rs.getString("name"));
			user.setEmailId(rs.getString("email_id"));
			user.setPassword(rs.getString("password"));
			user.setActive(rs.getBoolean("active"));
			users.add(user);
		}
		return users;
	}

	public User findByEmailAndPassword(User user) throws SQLException {
		Connection connection = ConnectionUtil.getConnection();
		String sql = "select id,name,email_id,password,active from users where email_id=? and password=?";
		PreparedStatement pst = connection.prepareStatement(sql);
		pst.setString(1, user.getEmailId());
		pst.setString(2, user.getPassword());
		ResultSet rs = pst.executeQuery();
		User userObj = null;
		if (rs.next()) {
			userObj = new User();
			user.setId(rs.getInt("id"));
			user.setName(rs.getString("name"));
			user.setEmailId(rs.getString("email_id"));
			user.setPassword(rs.getString("password"));
			user.setActive(rs.getBoolean("active"));
		}
		return userObj;
	}

	public User findOne(Integer id) throws SQLException {
		Connection connection = ConnectionUtil.getConnection();
		String sql = "select id,name,email_id,password,active from users where id=?";
		PreparedStatement pst = connection.prepareStatement(sql);
		pst.setInt(1, id);
		ResultSet rs = pst.executeQuery();
		User user = null;
		if (rs.next()) {
			user = new User();
			user.setId(rs.getInt("id"));
			user.setName(rs.getString("name"));
			user.setEmailId(rs.getString("email_id"));
			user.setPassword(rs.getString("password"));
			user.setActive(rs.getBoolean("active"));
		}
		return user;
	}

	public void save(User user) throws SQLException {
		Connection connection = ConnectionUtil.getConnection();
		String sql = "insert into users(name,email_id,password) values(?,?,?)";
		PreparedStatement pst = connection.prepareStatement(sql);
		pst.setString(1, user.getName());
		pst.setString(2, user.getEmailId());
		pst.setString(3, user.getPassword());
		pst.executeUpdate();
	}

	public void update(User user) throws SQLException {
		Connection connection = ConnectionUtil.getConnection();
		String sql = "update users  set name= ?, email_id = ? , password = ?  ,active = ?  where id = ?";
		PreparedStatement pst = connection.prepareStatement(sql);
		pst.setString(1, user.getName());
		pst.setString(2, user.getEmailId());
		pst.setString(3, user.getPassword());
		pst.setBoolean(4, user.getActive());
		pst.setInt(5, user.getId());
		pst.executeUpdate();
	}

	public void delete(Integer id) throws SQLException {
		Connection connection = ConnectionUtil.getConnection();
		String sql = "delete from users where id = ?";
		PreparedStatement pst = connection.prepareStatement(sql);
		pst.setInt(1, id);
		pst.executeUpdate();
	}

	public void activateAccount(Integer id) throws SQLException {
		Connection connection = ConnectionUtil.getConnection();
		String sql = "update users set active = 1 where id = ?";
		PreparedStatement pst = connection.prepareStatement(sql);
		pst.setInt(1, id);
		pst.executeUpdate();
	}

	public void deActivateAccount(Integer id) throws SQLException {
		Connection connection = ConnectionUtil.getConnection();
		String sql = "update users set active = 0 where id = ?";
		PreparedStatement pst = connection.prepareStatement(sql);
		pst.setInt(1, id);
		pst.executeUpdate();
	}
}
