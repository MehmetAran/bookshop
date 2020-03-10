package bookshop.controller;

import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bookshop.model.Author;
import bookshop.model.Role;
import bookshop.model.User;
import bookshop.payload.ApiResponse;
import bookshop.payload.InsertAuthorRequest;
import bookshop.security.CurrentUser;
import bookshop.security.UserPrincipal;
import bookshop.service.AuthorService;
import bookshop.service.UserService;

@RestController
@RequestMapping("/api/author")
public class AuthorController {
	
	@Autowired
	AuthorService authorServiceImp;

	@Autowired
	UserService userServiceImp;
	
	@PostMapping("/insert")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<?> insertAuthor(@Valid @RequestBody InsertAuthorRequest newAuthor) {
		if(userServiceImp.findById(newAuthor.getUserID()) == null)
			return  ResponseEntity.badRequest().body(new ApiResponse(false, "Not Found User by userID"));
		Author author = new Author();
		author.setAbout(newAuthor.getAbout());
		author.setAuthorLastname(newAuthor.getAuthorLastname());
		author.setAuthorName(author.getAuthorName());
		author.setUserID(author.getUserID());
		authorServiceImp.insert(author);
		return ResponseEntity.ok().body(new ApiResponse(true, "The user is now a author."));
	}
	@GetMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER') ")
	public ResponseEntity<?> getAuthorByID(@PathVariable Long id,@CurrentUser UserPrincipal currentUser){
		User user = userServiceImp.findById(currentUser.getId());
		for (Role role : user.getRoles()) {
			if(role.getName().equals("ROLE_ADMIN")) {
				Author author = authorServiceImp.findByID(id);
				return ResponseEntity.ok(author);
			}
		}
		Author author = authorServiceImp.findByID(id);
		if(author.getUserID().getId() != user.getId())
			return ResponseEntity.badRequest().body(new ApiResponse(false, "Sorry you are not authorized."));
		
		return ResponseEntity.ok().body(author);
	}
	
	@DeleteMapping("/delete/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER') ")
	public ResponseEntity<?> deleteAuthor(@PathVariable Long id,@CurrentUser UserPrincipal currentUser){
		User user = userServiceImp.findById(currentUser.getId());
		for (Role role : user.getRoles()) {
			if(role.getName().equals("ROLE_ADMIN")) {
				authorServiceImp.delete(id);
				return ResponseEntity.ok(new ApiResponse(true, "Author is deleted"));
			}
		}
		Author author = authorServiceImp.findByID(id);
		if(author.getUserID().getId() != user.getId())
			return ResponseEntity.badRequest().body(new ApiResponse(false, "Sorry you are not authorized."));
		
		authorServiceImp.delete(id);
		return ResponseEntity.ok().body(new ApiResponse(true, "Author is deleted"));
	}
	
	@DeleteMapping("/list")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<?> allAuthor(){
		return ResponseEntity.ok().body(authorServiceImp.findAll());
	}
	
	
}

