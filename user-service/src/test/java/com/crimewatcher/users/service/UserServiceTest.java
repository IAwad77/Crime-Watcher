package com.crimewatcher.users.service;
import com.crimewatcher.users.model.*;import com.crimewatcher.users.repository.UserRepository;
import org.junit.jupiter.api.Test;import java.util.List;import static org.junit.jupiter.api.Assertions.*;import static org.mockito.Mockito.*;
class UserServiceTest{
 private final UserRepository repo=mock(UserRepository.class);
 private final UserService svc=new UserService(repo);
 @Test void create(){UserDTO d=new UserDTO("Ali","a@x.com","CITIZEN");when(repo.save(any())).thenAnswer(i->i.getArgument(0));assertEquals("Ali",svc.create(d).getName());}
 @Test void all(){when(repo.findAll()).thenReturn(List.of());assertTrue(svc.all().isEmpty());}
}
