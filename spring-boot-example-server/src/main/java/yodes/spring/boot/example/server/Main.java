package yodes.spring.boot.example.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mangofactory.swagger.plugin.EnableSwagger;

/**
 * This is the Main class that loads your application and configures how your
 * application is ran
 */
@SpringBootApplication
@EnableSwagger
public class Main {

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}
}
