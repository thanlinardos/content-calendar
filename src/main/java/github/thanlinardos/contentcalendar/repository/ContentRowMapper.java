package github.thanlinardos.contentcalendar.repository;

import org.springframework.jdbc.core.RowMapper;

import github.thanlinardos.contentcalendar.model.Content;
import github.thanlinardos.contentcalendar.model.Status;
import github.thanlinardos.contentcalendar.model.Type;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class ContentRowMapper implements RowMapper<Content> {

    @Override
    public Content mapRow(ResultSet rs, int rowNum) throws SQLException {

    	return new Content(rs.getInt("id"),
                rs.getString("title"),
                rs.getString("content_desc"),
                Status.valueOf(rs.getString("status")),
                Type.valueOf(rs.getString("content_type")),
                rs.getObject("date_created", LocalDateTime.class),
                rs.getObject("date_updated",LocalDateTime.class),
                rs.getString("url"));

    }
}