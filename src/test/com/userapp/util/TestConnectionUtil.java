package test.com.userapp.util;

import java.sql.Connection;

import com.userapp.util.ConnectionUtil;

public class TestConnectionUtil {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Connection connection = ConnectionUtil.getConnection();
		System.out.println(connection);

	}

}
