package com.cervantes.spring.security.controller;

import java.security.Principal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cervantes.spring.security.constants.Constants;
import com.cervantes.spring.security.entity.User;
import com.cervantes.spring.security.repository.repository;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private repository repo;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	
	@PostMapping("/AddCustomer")
	public String addUser(@RequestBody User user) {
		user.setRoles(Constants.DEFAULT_ROLE);
		String encodedPass = encoder.encode(user.getPassowrd()); 
		user.setPassowrd(encodedPass);
		repo.save(user);
		return "Hi" + user.getuserName() + "Account added succesfully !";
	}
	
	
//	If logged In user is Admin --> Admin or moderator
	// Principal --> current logged in user
	
	
	@GetMapping("/access/{userId}/{userRole}")
    @Secured("ROLE_ADMIN")
    @PreAuthorize("hasAuthority('ROLE_ADMIN') or hasAuthority('ROLE_MODERATOR')")
	public String giveAccessToUser(@PathVariable int userId, @PathVariable String  userRole,Principal principal) {
		User user = repo.findById(userId).get();
		List<String> activeRoles = getRolesByLoggesInUser(principal);
		String newRole="";
		
		if(activeRoles.contains(userRole)) {
			newRole = user.getRoles() + "," + userRole;
			user.setRoles(newRole);
		}
		
		repo.save(user);
		return "Hi user roles changed";
	}
	
	@GetMapping
    @Secured("ROLE_ADMIN")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public List<User> loadUsers() {
        return repo.findAll();
    }

    @GetMapping("/test")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public String testUserAccess() {
        return "user can only access this !";
    }
	
	private List<String> getRolesByLoggesInUser(Principal principal){
		String roles = getLoggedInUser(principal).getRoles();
		List<String> assignRoles = Arrays.stream(roles.split(","))
				.collect(Collectors.toList());
		if(assignRoles.contains("ROLE_ADMIN")) {
			return Arrays.stream(Constants.ADMIN_ACCESS)
					.collect(Collectors.toList());
		}
		if(assignRoles.contains("ROLE_MANAGER")) {
			return Arrays.stream(Constants.MANAGER_ACCESS)
					.collect(Collectors.toList());
		}
		
		return Collections.emptyList();
	}
	
	
	private User getLoggedInUser(Principal principal) {
		return repo.findByUserName(principal.getName()).get();
	}

	
	
}
