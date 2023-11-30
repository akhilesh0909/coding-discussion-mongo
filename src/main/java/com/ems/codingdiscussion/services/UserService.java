package com.ems.codingdiscussion.services;

import java.util.List;


import com.ems.codingdiscussion.dtos.SignupDTO;
import com.ems.codingdiscussion.dtos.UserDTO;


public interface UserService {

	UserDTO createUser(SignupDTO signupDTO);

	boolean hasUserWithEmail(String email);
	
	boolean isValidEmail(String email);
	
//	boolean isValidOTP(ValidateOtpDTO validateOtpDTO);
//
//	UserDTO resetPassword(ResetPassword resetPassword) throws UsernameNotFoundException;

	List<UserDTO> getAllUsers();

	UserDTO makeAdmin(Long userId) throws  Exception;

	UserDTO toggleUserAccess(Long userId) throws  Exception;

}
