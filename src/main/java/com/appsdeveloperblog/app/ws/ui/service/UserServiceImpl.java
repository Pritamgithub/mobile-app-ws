package com.appsdeveloperblog.app.ws.ui.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appsdeveloperblog.app.ws.UserRepository;
import com.appsdeveloperblog.app.ws.io.entity.UserEntity;
import com.appsdeveloperblog.app.ws.ui.transport.UserDataTransferObject;
import com.appsdeveloperblog.app.ws.ui.transport.Utils;

import javassist.NotFoundException;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	Utils utils;

	@Override
	public UserDataTransferObject createUser(UserDataTransferObject user) {

		if (userRepository.findByEmail(user.getEmail()) != null)
			throw new RuntimeException("Record already exits");

		UserEntity userEntity = new UserEntity();
		BeanUtils.copyProperties(user, userEntity);

		String publicUserId = utils.generateUserId(30);
		userEntity.setUserId(publicUserId);
		userEntity.setEncryptedPassword("test");

		UserEntity storedUserDetails = userRepository.save(userEntity);

		UserDataTransferObject returnValue = new UserDataTransferObject();
		BeanUtils.copyProperties(storedUserDetails, returnValue);

		return returnValue;
	}

	@Override
	public UserDataTransferObject getUserById(String userId) {
		UserDataTransferObject returnValue = new UserDataTransferObject();
		UserEntity userEntity = userRepository.findUserById(userId);
		/*
		 * if (userEntity == null) throw new Exception(userId);
		 */
		BeanUtils.copyProperties(userEntity, returnValue);
		return returnValue;
	}

}
