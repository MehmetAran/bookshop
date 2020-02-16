package bookshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import bookshop.service.AuthorService;

@RestController("/api/author")
public class AuthorController {
	@Autowired
	AuthorService authorService;
	
	

}
