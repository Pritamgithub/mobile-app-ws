package com.appsdeveloperblog.app.ws.ui.service;

import com.appsdeveloperblog.app.ws.ui.transport.UserDataTransferObject;

public interface UserService {

	UserDataTransferObject createUser(UserDataTransferObject user);
	UserDataTransferObject getUserById(String userId );
	
}
