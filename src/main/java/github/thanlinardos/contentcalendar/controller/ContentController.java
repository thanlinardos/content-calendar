package github.thanlinardos.contentcalendar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import github.thanlinardos.contentcalendar.model.Content;
import github.thanlinardos.contentcalendar.model.Status;
import github.thanlinardos.contentcalendar.repository.ContentRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/content")
@CrossOrigin
public class ContentController {
	private final ContentRepository repository;
	@Autowired
	public ContentController(ContentRepository repository) {
		this.repository = repository;
	}
	
	//request for all content
	@GetMapping("")
	public List<Content> findAll(){
		return repository.findAll();
	}
	
	@GetMapping("/{id}")
	public Content findById(@PathVariable Integer id){
		return repository.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,HttpStatus.NOT_FOUND.getReasonPhrase()));
	}
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("")
	public Content create(@Valid @RequestBody Content content) {
		return repository.save(content);
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@PutMapping("/{id}")
	public Content update(@RequestBody Content content,@PathVariable Integer id) {
		if(!repository.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,HttpStatus.NOT_FOUND.getReasonPhrase());
		}
		return repository.save(content);
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		repository.deleteById(id);
	}
	
	@GetMapping("/filter/{keyword}")
	public List<Content> findByTitle(@PathVariable String keyword){
		return repository.findAllByTitleContains(keyword);
	}
	
	@GetMapping("/filter/status/{status}")
	public List<Content> findByStatus(@PathVariable Status status){
		return repository.listByStatus(status);
	}
}
