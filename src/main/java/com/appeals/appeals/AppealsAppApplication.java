package com.appeals.appeals;

import com.appeals.appeals.domain.User;
import com.appeals.appeals.domain.UserRole;
import com.appeals.appeals.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableJpaRepositories
@EnableTransactionManagement
@SpringBootApplication
public class AppealsAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppealsAppApplication.class, args);
	}

	CommandLineRunner commandLineRunner(UserRepository userRepository) {
		return args -> {
			final User user = new User(
					"jone",
					"Bush",
					"12345",
					"taraspih@gmail.com",
					"09356456",
					UserRole.ADMIN);
			userRepository.save(user);
		};
	}
}
