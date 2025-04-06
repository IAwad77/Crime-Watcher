package com.crimewatcher.users.controller;
import com.crimewatcher.users.model.*;import com.crimewatcher.users.service.UserService;
import jakarta.validation.Valid;import org.springframework.http.ResponseEntity;import org.springframework.web.bind.annotation.*;import java.util.List;

@RestController @RequestMapping("/api/users")
public class UserController{
 private final UserService svc; public UserController(UserService s){this.svc=s;}

 @PostMapping public ResponseEntity<User> create(@Valid @RequestBody UserDTO d){return ResponseEntity.ok(svc.create(d));}
 
 @GetMapping public List<User> all(){return svc.all();}
}
