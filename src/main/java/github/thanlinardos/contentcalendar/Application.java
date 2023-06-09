package github.thanlinardos.contentcalendar;

import java.time.LocalDateTime;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import github.thanlinardos.contentcalendar.config.ContentCalendarProperties;
import github.thanlinardos.contentcalendar.model.Content;
import github.thanlinardos.contentcalendar.model.Status;
import github.thanlinardos.contentcalendar.model.Type;
import github.thanlinardos.contentcalendar.repository.ContentRepository;

@EnableConfigurationProperties(ContentCalendarProperties.class)
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
//	@ConditionalOnProperty(name="cc.init")
//	@Bean
//	CommandLineRunner commandLineRunner(ContentRepository repository) {
//		return args -> {
//			Content content = new Content(null,
//					"All about Chat gpt",
//					"My first blog post",
//					Status.IDEA,
//					Type.ARTICLE,
//					LocalDateTime.now(),
//					null,
//					""
//					);
//			repository.save(content);
//		};
//	}

}
