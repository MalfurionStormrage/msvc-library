package org.dev.library.msvc.users.dev.Controllers;

import org.dev.library.msvc.users.dev.Services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/users")
public class UsersController {

    private final UsersService usersService;

    @Autowired
    public UsersController(UsersService usersService){
        this.usersService = usersService;
    }

    @GetMapping()
    public ResponseEntity<Object> GetAllUsers() {
        return ResponseEntity.ok().body(usersService.GetAllUsers());
    }
}
