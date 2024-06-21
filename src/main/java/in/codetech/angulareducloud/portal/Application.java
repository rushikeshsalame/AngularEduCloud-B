package in.codetech.angulareducloud.portal;

import in.codetech.angulareducloud.portal.model.Role;
import in.codetech.angulareducloud.portal.model.User;
import in.codetech.angulareducloud.portal.model.UserRole;
import in.codetech.angulareducloud.portal.repository.QuizRepository;
import in.codetech.angulareducloud.portal.service.Impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class Application implements CommandLineRunner {
	@Autowired
	private UserServiceImpl userService;

	@Autowired
	private QuizRepository quizRepository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		try {


			System.out.println("starting code");

			User user = new User();

			user.setFirstName("Admin");
			user.setLastName("User");
			user.setUsername("admin12345");
			user.setPassword("abcde");
			user.setEmail("user@gmail.com");
			user.setProfile("default.png");

			Role role1 = new Role();
			role1.setRoleId(101L);
			role1.setRoleName("ADMIN");

			Set<UserRole> userRoleSet = new HashSet<>();
			UserRole userRole = new UserRole();

			userRole.setRole(role1);

			userRole.setUser(user);

			userRoleSet.add(userRole);

			User user1 = this.userService.createUser(user, userRoleSet);
			System.out.println(user1.getUsername());


		} catch (Exception e) {
			e.printStackTrace();

		}
	}
}
