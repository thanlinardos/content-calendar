//package github.thanlinardos.contentcalendar.repository;
//
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.stereotype.Repository;
//
//import github.thanlinardos.contentcalendar.model.Content;
//
//@Repository
//public class ContentJdbcTemplateRepository {
//	private final JdbcTemplate jdbcTemplate;
//	
//	@Autowired
//	public ContentJdbcTemplateRepository(JdbcTemplate jdbcTemplate) {
//		this.jdbcTemplate = jdbcTemplate;
//	}
//
//    public List<Content> findAll() {
//        String sql = "SELECT * FROM Content";
//        List<Content> contents = jdbcTemplate.query(sql, new ContentRowMapper());
//        return contents;
//    }
//
//    public Optional<Content> createContent(Content content) {
//        String sql = "INSERT INTO Content (title, content_desc, status, content_type, date_created, URL) VALUES (?, ?, ?, ?, NOW(), ?)";
//        try {
//        jdbcTemplate.update(sql, content.title(), content.content_desc(), content.status().toString(), content.content_type().toString(), content.url());
//        
//        return Optional.ofNullable(content);
//        }
//        catch(Exception e) {
//        	e.printStackTrace();
//        	return Optional.empty();
//        }
//    }
//
//    public Optional<Content> updateContent(Content content,Integer id) {
//        String sql = "UPDATE Content SET title=?, content_desc=?, status=?, content_type=?, date_updated=NOW(), url=? WHERE id=?";
//        try {
//        jdbcTemplate.update(sql, content.title(), content.content_desc(), content.status().toString(), content.content_type().toString(), content.url(), id);
//        return findById(id);
//        }
//        catch(Exception e) {
//        	e.printStackTrace();
//        	return Optional.empty();
//        }
//    }
//
//    public Optional<Integer> delete(Integer id) {
//        String sql = "DELETE FROM Content WHERE id=?";
//        try {
//        	if(jdbcTemplate.update(sql, id)!=1) {
//        		return Optional.empty();
//        	}
//        	return Optional.ofNullable(1);
//        }
//    	catch(Exception e) {
//			e.printStackTrace();
//			return Optional.empty();
//		}
//        
//    }
//
//    public  Optional<Content> findById(Integer id) {
//        String sql = "SELECT * FROM Content WHERE id=?";
//        Content content = jdbcTemplate.queryForObject(sql, new ContentRowMapper(), id);
//        return Optional.ofNullable(content);
//    }
//    
//    @SuppressWarnings("deprecation")
//	public List<Content> getContentByString(String col_name,String col_value) {
//        String sql = "SELECT * FROM Content WHERE " + col_name + "=?";
//        List<Content> content = jdbcTemplate.query(sql,new Object[] {col_value}, new ContentRowMapper());
//        return content;
//    }
//    
//    @SuppressWarnings("deprecation")
//    public List<String> getContentColumn(Integer id, String col_name){
//    	String sql = "SELECT "+col_name+" FROM Content WHERE id=?";
//    	List<String> result = jdbcTemplate.query(sql, new Object[] {id}, (rs,colNum) -> new String(rs.getString(col_name)));
//    	return result;
//    }
//    @SuppressWarnings("deprecation")
//    public List<String> getContentColumnByString(String query_col_name,String query_col_value, String col_name){
//    	String sql = "SELECT "+col_name+" FROM Content WHERE " + query_col_name+ "=?";
//    	List<String> result = jdbcTemplate.query(sql, new Object[] {query_col_value}, (rs,colNum) -> new String(rs.getString(col_name)));
//    	return result;
//    }
//}
//
