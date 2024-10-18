package org.dev.library.msvc.users.dev.Controllers;

import org.dev.library.msvc.users.dev.Models.UsersModel;
import org.dev.library.msvc.users.dev.Services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/users")
public class UsersController {

    private final UsersService usersService;

    @Autowired
    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping()
    public ResponseEntity<Object> GetAllUsers() {
        return ResponseEntity.ok().body(usersService.GetAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> GetByIdUser(@PathVariable Long id) {
        Optional<UsersModel> usersModel = usersService.GetByIdUser(id);
        if (usersModel.isPresent()) {
            return ResponseEntity.ok().body(usersModel);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User  not found with id " + id);
    }

    @PostMapping()
    public ResponseEntity<Object> SaveUser(@RequestBody UsersModel usersModel) {
        if (usersService.SaveUser(usersModel)) {
            return ResponseEntity.status(HttpStatus.CREATED).body("User created successfully.");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("The user created with id: " + usersModel.getCreatedBy().getId() + " does not exist.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> UpdateUser(@PathVariable Long id, @RequestBody UsersModel usersModel) {
        if (usersService.UpdateUser(id, usersModel)) {
            return ResponseEntity.ok().body("User updated successfully.");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found with id: " + id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> DeleteUser(@PathVariable Long id) {
        if (usersService.DeleteByUser(id)) {
            return ResponseEntity.ok().body("User delete successfully.");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found with id: " + id);
    }
}
