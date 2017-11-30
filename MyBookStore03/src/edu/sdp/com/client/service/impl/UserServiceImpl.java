package edu.sdp.com.client.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.sdp.com.client.mapper.UserMapper;
import edu.sdp.com.client.service.UserService;
import edu.sdp.com.entities.User;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper userMapper;

	@Override
	public User login(User user) {
		return userMapper.getUser(user);
	}

}
