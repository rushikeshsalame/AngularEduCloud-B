package in.codetech.angulareducloud.portal.service;

import in.codetech.angulareducloud.portal.model.User;
import in.codetech.angulareducloud.portal.model.UserRole;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public interface UserService {
    //creating user
    public User createUser(User user, Set<UserRole> userRoles) throws Exception;

    // get user by username
    public  User getUser(String username);
    //delete user by id
    public void deleteUser(Long userId);
}
