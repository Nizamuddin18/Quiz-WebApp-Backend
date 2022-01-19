package com.exam.Controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.model.Role;
import com.exam.model.User;
import com.exam.model.UserRole;
import com.exam.services.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {
	@Autowired
	private UserService userService;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	// For creating User
	@PostMapping("/")
	public User createUser(@RequestBody User user) {
		try {
			Set<UserRole> roles = new HashSet<>();
			// Setting New Role
			Role role = new Role();
			role.setRoleID(20L);
			role.setRoleName("NORMAL");

			// Setting UserRole to User
			UserRole userRole = new UserRole();
			userRole.setUser(user);
			userRole.setRole(role);
			
			user.setProfile("default.png");
			user.setPassword(this.bCryptPasswordEncoder.encode(user.getPassword()));
			roles.add(userRole);
			return this.userService.createUser(user, roles);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}
	
	// For Fetching UserDetails
	@GetMapping("/{userName}")
	public User getUser(@PathVariable("userName") String userName) {
		return this.userService.getUser(userName);
	}
	
	// For Deleting UserDetails
	@DeleteMapping("/{userId}")
	public void deleteUser(@PathVariable("userId") Long userId) {
		this.userService.deleteUser(userId);;
	} 
	
}
