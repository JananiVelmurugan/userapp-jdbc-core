package test.com.userapp.model;

import com.userapp.model.User;

public class TestUser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		User user = new User();

		user.setId(1);
		user.setName("Janani");
		user.setEmailId("janani@gmail.com");
		user.setPassword("pass123");

		System.out.println(user);

	}

}
