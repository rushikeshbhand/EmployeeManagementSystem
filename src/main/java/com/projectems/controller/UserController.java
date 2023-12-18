package com.projectems.controller; //(for user-related operations like login and access control)

import java.sql.Date;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projectems.entities.User;
import com.projectems.service.UserService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
@RestController
@RequestMapping("/user")
public class UserController {

    	@Autowired
    	private UserService userService;
    	
    	@PostMapping("/login")
    	public String validate(@RequestBody User user) throws ServletException
    	{
    		String jwtToken="";
    		
    		if(user.getUserName()==null || user.getPassword()==null)
    		{
    			throw new ServletException("Please Fill in Username and Password");
    		}
    		
    		String userName=user.getUserName();
    		String password=user.getPassword();
    		//will check in database whether the login and password is present or not
    		user=userService.login(userName, password);
    		
    		if(user==null)
    		{
    			throw new ServletException("User not found");
    		}
    		
    		jwtToken=Jwts.builder().setSubject(userName).claim("userName", user.getUserName()).
    			setIssuedAt(new Date(0)).signWith(SignatureAlgorithm.HS256, "secretkey").compact();
    		
    		return jwtToken;
    		
    		
    	}
    }
//    private UserService userService;
//
//    @GetMapping("/{id}")
//    public ResponseEntity<UserDTO> getUserById(@PathVariable Long id) {
//        UserDTO userDTO = userService.getUserById(id);
//        return ResponseEntity.ok(userDTO);
//    }
//
//    @PostMapping("/createUser")
//    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO) {
//        UserDTO createdUser = userService.createUser(userDTO);
//        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<UserDTO> updateUser(@PathVariable Long id, @RequestBody UserDTO userDTO) {
//        UserDTO updatedUser = userService.updateUser(id, userDTO);
//        return ResponseEntity.ok(updatedUser);
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
//        userService.deleteUser(id);
//        return ResponseEntity.noContent().build();
//    } 
//   
//}
