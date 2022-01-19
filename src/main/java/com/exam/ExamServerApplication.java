package com.exam;

import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.exam.model.Role;
import com.exam.model.User;
import com.exam.model.UserRole;
import com.exam.services.UserService;

@SpringBootApplication
public class ExamServerApplication implements CommandLineRunner{
	@Autowired
	private UserService userService;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public static void main(String[] args) {
		SpringApplication.run(ExamServerApplication.class, args);
	}
	

	@Override
	public void run(String... args) throws Exception {
//		System.out.println("Creating Admin...");
//		User user = new User();
//		user.setUserName("ahmednizam2");
//		user.setEmail("ahmednizam2@gmail.com");
//		user.setFirstName("Nizamuddin");
//		user.setLastName("Ahmed");
//		user.setPassword(this.bCryptPasswordEncoder.encode("1234@Nizam"));
//		user.setPhone("9163679977");
//		user.setProfile("default.png");
//		
//		Role role = new Role();
//		role.setRoleID(10L);
//		role.setRoleName("ADMIN");
//		
//		
//		
//		// Setting UserRole to User
//		UserRole userRole = new UserRole();
//		userRole.setUser(user);
//		userRole.setRole(role);
//		
//		Set<UserRole> roles = new HashSet<>();
//		roles.add(userRole);
//		
//		User adminUser = this.userService.createUser(user, roles);
//		System.out.println("Admin Created : " + adminUser.getUsername());
	}

}
