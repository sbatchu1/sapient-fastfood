package com.sapient.fastfood.datastore;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import com.sapient.fastfood.beans.User;

public class UserStore {
	private static final AtomicLong userId = new AtomicLong(1);
	private static final Map<Long, User> USER_MAP = new HashMap<>(50);

	static {
		initializeData();
	}

	private static void initializeData() {
		User sairam = new User("Sai Ram Gopal");
		addUser(sairam);

		User mahesh = new User("Mahesh");
		addUser(mahesh);
	}

	public static void addUser(User user) {
		user.setId(userId.getAndIncrement());
		USER_MAP.put(user.getId(), user);
	}

	public static Map<Long, User> fetchUsers() {
		return USER_MAP;
	}

}
