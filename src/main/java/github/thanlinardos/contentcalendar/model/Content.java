package github.thanlinardos.contentcalendar.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;

import jakarta.validation.constraints.NotBlank;

//@Table(value="content")
public record Content(
		@Id
		Integer id,
		@NotBlank
		String title,
		String content_desc,
		Status status,
		Type content_type,
		LocalDateTime dateCreated,
		LocalDateTime dateUpdated,
		String url
) {
	
}
