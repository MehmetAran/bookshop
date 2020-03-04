package bookshop.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import bookshop.model.Role;
import bookshop.model.User;
import bookshop.payload.ChangeUserRoleRequest;
import bookshop.payload.ChangeUserRoleResponse;
import bookshop.security.CurrentUser;
import bookshop.security.JwtTokenProvider;
import bookshop.security.UserPrincipal;
import bookshop.service.RoleService;
import bookshop.service.UserService;


@RestController
@RequestMapping("/api/user")
public class UserController {
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	JwtTokenProvider tokenProvider;
	@Autowired
	UserService userServiceImp;
	@Autowired
	RoleService roleServiceImp;
	
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
	@GetMapping("/roles")
	ResponseEntity<?> getRoles(@CurrentUser UserPrincipal currentUser ){
		return ResponseEntity.ok(currentUser.getAuthorities());
	}
    
    @PreAuthorize("hasRole('ROLE_ADMIN')")
  	@PostMapping("/addRole")
  	ResponseEntity<?> addRoleToUser(@Valid @RequestBody ChangeUserRoleRequest changeUserRoleRequest){
    	User user = userServiceImp.findById(changeUserRoleRequest.getUserID());
    	if(user == null)
    		return ResponseEntity.badRequest().body(new ChangeUserRoleResponse("The user was not found while looking at the ID."));
    	
    	Set<Role> roles = user.getRoles();
    	for (Role role : roles) {
			if(role.getName().equals(changeUserRoleRequest.getRole()))
	    		return ResponseEntity.badRequest().body(new ChangeUserRoleResponse(user.getId(),"This user already has this role."));
		}
    	
    	Role role = roleServiceImp.findByRoleName(changeUserRoleRequest.getRole());
    	if(role == null )
    		ResponseEntity.badRequest().body(new ChangeUserRoleResponse(user.getId(),"No such role."));
    	roles.add(role);
    	user.setRoles(roles);
    	
    	return  ResponseEntity.ok().body(new ChangeUserRoleResponse(user.getId(),"Successfully added to the role"));
    }
    @PreAuthorize("hasRole('ROLE_ADMIN')")
  	@PostMapping("/addRole")
  	ResponseEntity<?> deleteRoleToUser(@Valid @RequestBody ChangeUserRoleRequest changeUserRoleRequest){
    	User user = userServiceImp.findById(changeUserRoleRequest.getUserID());
    	if(user == null)
    		return ResponseEntity.badRequest().body(new ChangeUserRoleResponse("The user was not found while looking at the ID."));
    	
    	Set<Role> roles = user.getRoles();
    	boolean hasRole = true;
    	for (Role role : roles) {
			if(!role.getName().equals(changeUserRoleRequest.getRole()))
				hasRole = false;
		}
    	if(hasRole == false)
    		return ResponseEntity.badRequest().body(new ChangeUserRoleResponse(user.getId(),"This user already hasn't this role."));

    	Role role = roleServiceImp.findByRoleName(changeUserRoleRequest.getRole());
    	if(role == null )
    		ResponseEntity.badRequest().body(new ChangeUserRoleResponse(user.getId(),"No such role."));
    	roles.add(role);
    	user.setRoles(roles);
    	
    	return  ResponseEntity.ok().body(new ChangeUserRoleResponse(user.getId(),"Successfully added to the role"));
    }
      
  
	
    

}
