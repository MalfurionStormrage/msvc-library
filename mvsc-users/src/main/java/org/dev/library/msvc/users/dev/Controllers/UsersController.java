package org.dev.library.msvc.users.dev.Controllers;

import org.dev.library.msvc.users.dev.Models.UsersModel;
import org.dev.library.msvc.users.dev.Services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    public ResponseEntity<Object> GetByIdUser(@PathVariable Long id) {
        return ResponseEntity.ok().body(usersService.GetByIdUser(id));
    }

    @PostMapping()
    public ResponseEntity<Object> SaveUser(UsersModel usersModel) {
        return ResponseEntity.ok().body(usersService.SaveUser(usersModel));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> UpdateUser(@PathVariable Long id, @RequestBody UsersModel usersModel) {
        return ResponseEntity.ok().body(usersService.UpdateUser(id , usersModel));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> DeleteUser(@PathVariable Long id) {
        return ResponseEntity.ok().body(usersService.DeleteByUser(id));
    }
}
