package com.crimewatcher.users.service;
import com.crimewatcher.users.model.*;import com.crimewatcher.users.repository.UserRepository;
import org.springframework.stereotype.Service;import java.util.List;
@Service
public class UserService{
 private final UserRepository repo; public UserService(UserRepository r){this.repo=r;}
 public User create(UserDTO d){return repo.save(new User(null,d.getName(),d.getEmail(),d.getRole()));}
 public List<User> all(){return repo.findAll();}
}
