package github.thanlinardos.contentcalendar.config;

import java.io.InputStream;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import github.thanlinardos.contentcalendar.model.Content;
import github.thanlinardos.contentcalendar.repository.ContentRepository;

//@Profile("!dev")
@ConditionalOnProperty(name="cc.init")
@Component
public class DataLoader implements CommandLineRunner{
	
	private final ContentRepository repository;
	private final ObjectMapper objectMapper;
	
	public DataLoader(ContentRepository repository,ObjectMapper objectMapper) {
		this.repository = repository;
		this.objectMapper = objectMapper;
	}
	
	@Override
	public void run(String... args) throws Exception {
		if(repository.count()==0) {
		try(InputStream inputStream = TypeReference.class.getResourceAsStream("/data/content.json")){
			repository.saveAll(objectMapper.readValue(inputStream, new TypeReference<List<Content>>() {}));
		}
		}
		
	}

}
