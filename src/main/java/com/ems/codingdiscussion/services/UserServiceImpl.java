package com.ems.codingdiscussion.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.ems.codingdiscussion.dtos.SignupDTO;
import com.ems.codingdiscussion.dtos.UserDTO;

import com.ems.codingdiscussion.entities.User;
import com.ems.codingdiscussion.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;

	@Autowired
	SequenceGeneratorService seqGeneratorService;
	
//	@Autowired
//	private OtpEmailRepository otpEmailRepository;
		
    private static final long OTP_VALID_DURATION = 5 * 60 * 1000;

	
	private enum EmailDomain {
		
		OF_CONTRACTOR("@external.thalesgroup.com"),
		OF_PERMANENT("@thalesgroup.com");
		
		public final String value;

	    private EmailDomain(String value) {
	        this.value = value;
	    }
	}

	@Override
	public UserDTO createUser(SignupDTO signupDTO) {
		User user = new User();
		user.setEmail(signupDTO.getEmail());
		user.setName(signupDTO.getName());
		user.setPassword(signupDTO.getPassword());
		user.setId(seqGeneratorService.generateSequence(User.SEQUENCE_NAME));
		User createdUser = userRepository.save(user);
		UserDTO userDTO = new UserDTO();
		userDTO.setId(createdUser.getId());
		userDTO.setEmail(createdUser.getEmail());
		userDTO.setName(createdUser.getName());
		userDTO.setAdmin(createdUser.isAdmin());
		userDTO.setLocked(createdUser.isLocked());
		return userDTO;
	}

	@Override
	public boolean hasUserWithEmail(String email) {
		return userRepository.findFirstByEmail(email).isPresent();
	}

	@Override
	public boolean isValidEmail(String email) {
		
		if(email.contains("@")) {
			String subStringOfEmail = email.substring(email.indexOf("@"));
			
			if(subStringOfEmail.equalsIgnoreCase(EmailDomain.OF_CONTRACTOR.value)  || subStringOfEmail.equalsIgnoreCase(EmailDomain.OF_PERMANENT.value)) {
				return true;
			}
		}
		return false;
	}

//	@Override
//	public boolean isValidOTP(ValidateOtpDTO validateOtpDTO) {
//
//		String email = validateOtpDTO.getEmail();
//		String otp = validateOtpDTO.getOtp();
//
//		Optional<OtpEmail> otpEmail = otpEmailRepository.findLatestByEmail(email);
//
//		if(otpEmail.isPresent()) {
//			long currentTimeInMillis = System.currentTimeMillis();
//	        long otpRequestedTimeInMillis = otpEmail.get().getOtpRequestedTime();
//
//	        if (otpRequestedTimeInMillis + OTP_VALID_DURATION >= currentTimeInMillis) {
//	            if(otp.equals(otpEmail.get().getOneTimePassword())) {
//	            	return true;
//	            }
//	        }
//		}
//		return false;
//	}

//	@Override
//	public UserDTO resetPassword(ResetPassword resetPassword) throws UsernameNotFoundException {
//
//		User user = new User();
//		userRepository.findFirstByEmail(resetPassword.getEmail()).ifPresentOrElse(userOptional -> {
//			user.setName(userOptional.getName());
//			user.setId(userOptional.getId());
//		}, () -> {
//			throw new UsernameNotFoundException("User not found");
//		});
//
//		user.setEmail(resetPassword.getEmail());
//		user.setPassword(new BCryptPasswordEncoder().encode(resetPassword.getPassword()));
//		User newUser = userRepository.save(user);
//		UserDTO userDTO = new UserDTO();
//		userDTO.setId(newUser.getId());
//		userDTO.setEmail(newUser.getEmail());
//		userDTO.setName(newUser.getName());
//		userDTO.setAdmin(newUser.isAdmin());
//		userDTO.setLocked(user.isLocked());
//		return userDTO;
//	}

	@Override
	public List<UserDTO> getAllUsers() {
		List<User> users = userRepository.findAll();
		List<UserDTO> userDTOs = new ArrayList<>();
		
		for(User user: users) {
			UserDTO userDTO = new UserDTO();
			userDTO.setId(user.getId());
			userDTO.setEmail(user.getEmail());
			userDTO.setName(user.getName());
			userDTO.setAdmin(user.isAdmin());
			userDTO.setLocked(user.isLocked());
			userDTOs.add(userDTO);
		}
		
		return userDTOs;
	}

	@Override
	public UserDTO makeAdmin(Long userId) throws Exception {
		User user = new User();
		userRepository.findById(userId).ifPresentOrElse(userOptional -> {
			user.setName(userOptional.getName());
			user.setId(userOptional.getId());
			user.setEmail(userOptional.getEmail());
		}, () -> {
//			throw new UsernameNotFoundException("User not found");
		});
		try {
			userRepository.makeAdmin(userId);
		}catch(Exception e) {
			throw new Exception("Something went wrong");
		}
		
		UserDTO userDTO = new UserDTO();
		userDTO.setId(user.getId());
		userDTO.setEmail(user.getEmail());
		userDTO.setName(user.getName());
		userDTO.setAdmin(true);
		userDTO.setLocked(false);
		return userDTO;
	}

	@Override
	public UserDTO toggleUserAccess(Long userId) throws Exception {
		User user = new User();
		userRepository.findById(userId).ifPresentOrElse(userOptional -> {
			user.setName(userOptional.getName());
			user.setId(userOptional.getId());
			user.setEmail(userOptional.getEmail());
			user.setAdmin(userOptional.isAdmin());
			user.setLocked(userOptional.isLocked());
		}, () -> {
//			throw new UsernameNotFoundException("User not found");
		});
		try {
			userRepository.toggleUserAccess(userId,!user.isLocked());
		}catch(Exception e) {
			throw new Exception("Something went wrong");
		}
		
		UserDTO userDTO = new UserDTO();
		userDTO.setId(user.getId());
		userDTO.setEmail(user.getEmail());
		userDTO.setName(user.getName());
		userDTO.setAdmin(user.isAdmin());
		userDTO.setLocked(!user.isLocked());
		return userDTO;
		
	}

	


}
