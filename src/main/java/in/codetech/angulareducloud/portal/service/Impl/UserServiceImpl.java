package in.codetech.angulareducloud.portal.service.Impl;

import in.codetech.angulareducloud.portal.model.User;
import in.codetech.angulareducloud.portal.model.UserRole;
import in.codetech.angulareducloud.portal.repository.RoleRepository;
import in.codetech.angulareducloud.portal.repository.UserRepository;
import in.codetech.angulareducloud.portal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public User createUser(User user, Set<UserRole> userRoles) throws Exception {
       //check duplicate
        User local = this.userRepository.findByUsername(user.getUsername());
        if(local!=null){
            throw new Exception("User is already there !!");

        }
        else {
            //user create
            for(UserRole ur : userRoles) {
                roleRepository.save(ur.getRole());
            }
            user.getUserRoles().addAll(userRoles);
            local = this.userRepository.save(user);
        }
        return local;
    }

    @Override
    public User getUser(String username) {
        return this.userRepository.findByUsername(username);
    }

    @Override
    public void deleteUser(Long userId) {
       this.userRepository.deleteById(userId);
    }
}
