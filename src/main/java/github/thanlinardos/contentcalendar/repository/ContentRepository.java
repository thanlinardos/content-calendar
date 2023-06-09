package github.thanlinardos.contentcalendar.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

import github.thanlinardos.contentcalendar.model.Content;
import github.thanlinardos.contentcalendar.model.Status;

public interface ContentRepository extends ListCrudRepository<Content, Integer>{
	
	List<Content> findAllByTitleContains(String keyword);
	
	@Query("""
	    SELECT * FROM Content
	    WHERE status = :status
	""")
	List<Content> listByStatus(@Param("status") Status status);
}
