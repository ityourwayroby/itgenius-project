package products;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import products.entities.User;
import products.repository.UserRepository;
import products.dto.RegistrationForm;

import java.util.Optional;

@SpringBootApplication
public class ItGenuineApplication {
	public static void main(String[] args) {
		SpringApplication.run(ItGenuineApplication.class, args);
	}
	@Bean
	public CommandLineRunner dataLoader(UserRepository userRepo) {
		return new CommandLineRunner() {
			@Override
				public void run(String... args) {
				PasswordEncoder encoder = new BCryptPasswordEncoder();
				Optional<User> user = userRepo.findByUsername("user");
				if (!user.isPresent()){
					RegistrationForm form = new RegistrationForm("user",
							"pass", "Juan Esteban Sanchez");
					userRepo.save(form.toUser(encoder));
				}
			}
		};
	}

}
