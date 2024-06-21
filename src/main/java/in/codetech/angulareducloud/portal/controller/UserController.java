package in.codetech.angulareducloud.portal.controller;

import in.codetech.angulareducloud.portal.model.User;
import in.codetech.angulareducloud.portal.model.UserRole;
import in.codetech.angulareducloud.portal.service.Impl.UserServiceImpl;
import in.codetech.angulareducloud.portal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserServiceImpl userService;

    @PostMapping("/save")
    public ResponseEntity<User> createUser(@RequestBody  User user) throws  Exception{
        Set<UserRole> userRoles = user.getUserRoles();
       User users =  userService.createUser(user,userRoles);
        return ResponseEntity.status(HttpStatus.CREATED).body(users);
    }

    @GetMapping("/username")
    public ResponseEntity<User> getUser(@PathVariable String username){
        User user = userService.getUser(username);
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long userId){
        userService.deleteUser(userId);
        return ResponseEntity.noContent().build();
    }
}
