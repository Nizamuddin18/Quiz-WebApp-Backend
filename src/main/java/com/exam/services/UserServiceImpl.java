package com.exam.services;

import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.model.User;
import com.exam.model.UserRole;
import com.exam.repo.RoleRepository;
import com.exam.repo.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Override
	public User createUser(User user, Set<UserRole> userRoles) throws Exception {
		User newUser = null;
		try {
			newUser = this.userRepository.findByUserName(user.getUserName());
			if (newUser != null) {
				System.out.println("Already User Exist!");
				throw new Exception("Already User Exist!");
			} else {
				// create New User

				// save all Roles
				for (UserRole userRole : userRoles) {
					roleRepository.save(userRole.getRole());
				}
				user.getUserRoles().addAll(userRoles);
				newUser = this.userRepository.save(user);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return newUser;
	}

	@Override
	public User getUser(String userName) {
		// Getting User By UserName
		return this.userRepository.findByUserName(userName);
	}

	@Override
	public void deleteUser(Long userId) {
		this.userRepository.deleteById(userId);
	}

}
