//package github.thanlinardos.contentcalendar.repository;
//
//import java.time.LocalDateTime;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.stereotype.Repository;
//
//import github.thanlinardos.contentcalendar.model.Content;
//import github.thanlinardos.contentcalendar.model.Status;
//import github.thanlinardos.contentcalendar.model.Type;
//import jakarta.annotation.PostConstruct;
//
//@Repository
//public class ContentCollectionRepository {
//	private final List<Content> contentList = new ArrayList<>();
//	
//	public ContentCollectionRepository() {
//		
//	}
//	
//	public List<Content> findAll(){
//		return contentList;
//	}
//	
//	public Optional<Content> findById(Integer id){
//		return contentList.stream().filter(c->c.id().equals(id)).findFirst();
//	}
//	
//	public Optional<Content> createContent(Content content) {
//		try {
//			contentList.add(content);
//		}
//		catch(Exception e) {
//			e.printStackTrace();
//			content = null;
//		}
//		return Optional.ofNullable(content);
//	}
//	
//	public Optional<Content> updateContent(Content content,Integer id) {
//		try {
//			boolean found = false;
//			for(int i=0;i<contentList.size();i++) {
//				if (id == contentList.get(i).id()) {
//					contentList.remove(i);
//					contentList.add(i, content);
//					found = true;
//					break;
//				}
//			}
//			if(!found) {
//				content = null;
//			}
//		}
//		catch(Exception e) {
//			e.printStackTrace();
//			content = null;
//		}
//		return Optional.ofNullable(content);
//	}
//	
//	public Optional<Integer> delete(Integer id) {
//		Optional<Integer> res=Optional.empty();
//		try {
//			for(int i=0;i<contentList.size();i++) {
//				if(id==contentList.get(i).id()) {
//					contentList.remove(i);
//					res = Optional.ofNullable(1);
//					break;
//				}
//			}
//		}
//		catch(Exception e) {
//			e.printStackTrace();
//			res = Optional.empty();
//		}
//		return res;
//	}
//	
//	public boolean existsById(Integer id) {
//		return contentList.stream().filter(c->c.id().equals(id)).count()==1;
//	}
//	
//	@PostConstruct
//	private void Init() {
//		Content content = new Content(1,
//				"my first blog post",
//				"My first blog post",
//				Status.IDEA,
//				Type.ARTICLE,
//				LocalDateTime.now(),
//				null,
//				""
//				);
//		contentList.add(content);
//	}
//
//	
//	
//}
