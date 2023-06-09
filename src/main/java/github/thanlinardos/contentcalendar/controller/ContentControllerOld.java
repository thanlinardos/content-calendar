//package github.thanlinardos.contentcalendar.controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseStatus;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.server.ResponseStatusException;
//
//import github.thanlinardos.contentcalendar.model.Content;
//import github.thanlinardos.contentcalendar.repository.ContentCollectionRepository;
//import github.thanlinardos.contentcalendar.repository.ContentJdbcTemplateRepository;
//import jakarta.validation.Valid;
//
//@RestController
//@RequestMapping("/api/content")
//@CrossOrigin
//public class ContentController {
//	private final ContentCollectionRepository repository;
////	private final ContentJdbcTemplateRepository repository;
//	
//	@Autowired
//	public ContentController(ContentCollectionRepository contentCollectionRepository) {
//		this.repository = contentCollectionRepository;
//	}
//	
//	//request for all content
//	@GetMapping("")
//	public List<Content> findAll(){
//		return repository.findAll();
//	}
//	
//	@GetMapping("/{id}")
//	public Content findById(@PathVariable Integer id){
//		return repository.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,HttpStatus.NOT_FOUND.getReasonPhrase()));
//	}
//	
//	@ResponseStatus(HttpStatus.CREATED)
//	@PostMapping("")
//	public Content create(@Valid @RequestBody Content content) {
//		return repository.createContent(content).orElseThrow(()->new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase()));
//	}
//	
//	@ResponseStatus(HttpStatus.NO_CONTENT)
//	@PutMapping("/{id}")
//	public Content update(@RequestBody Content content,@PathVariable Integer id) {
//		return repository.updateContent(content,id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,HttpStatus.NOT_FOUND.getReasonPhrase()));
//	}
//	
//	@ResponseStatus(HttpStatus.NO_CONTENT)
//	@DeleteMapping("/{id}")
//	public Integer delete(@PathVariable Integer id) {
//		return repository.delete(id).orElseThrow(()->new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase()));
//	}
//	
//}
