package com.appsdeveloperblog.app.ws.ui.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appsdeveloperblog.app.ws.ui.service.UserServiceImpl;
import com.appsdeveloperblog.app.ws.ui.transport.UserDataTransferObject;
import com.appsdeveloperblog.app.ws.ui.transport.UserDetailsRequestModel;
import com.appsdeveloperblog.app.ws.ui.transport.UserRest;

@RestController // willl be able to receive http request
@RequestMapping("users") // url tht is responsible for creating the path

//http://localhost:8080/users
public class UserController {
	@Autowired
	UserServiceImpl userService;

	@GetMapping(path = "/{id}")
	public UserRest getUser(@PathVariable String id) {
		UserRest returnValue = new UserRest(); // response
		
		UserDataTransferObject userDto = new UserDataTransferObject();
		
		BeanUtils.copyProperties(id, userDto);
		
		UserDataTransferObject createdUser = userService.getUserById(id);
		
		BeanUtils.copyProperties(createdUser, returnValue);

		return returnValue;
	}

	@PostMapping
	public UserRest createUser(@RequestBody UserDetailsRequestModel userDetail) { // userdetails request input from the
																					// user
		UserRest returnValue = new UserRest(); // response
		UserDataTransferObject userDto = new UserDataTransferObject(); // userdatatransfer object is class that can be
																		// shared across all the layers
		BeanUtils.copyProperties(userDetail, userDto); // copying userdetails (user input to userdata object)
		UserDataTransferObject createdUser = userService.createUser(userDto); // with the help of service class doing
																				// some validation to user data object
		BeanUtils.copyProperties(createdUser, returnValue);

		return returnValue;
	}

	
	
	@PutMapping
	public String updateUser() {
		return "update user was called";
	}

	@DeleteMapping
	public String deleteUser() {
		return "delete user was called";

	}
}
