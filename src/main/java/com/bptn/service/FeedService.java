package com.bptn.service;




import java.util.LinkedList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bptn.exceptions.InvalidPostException;
import com.bptn.exceptions.InvalidUserNameException;
import com.bptn.models.Post;
import com.bptn.repository.FeedRepository;
import com.bptn.service.UserService;

@Service
public class FeedService {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private FeedRepository feedRepository;
	
	@Autowired
	private UserService userService;
	
	public List<Post> getPostsByUsername(String username) throws InvalidUserNameException{
	
		logger.info("retrieving Posts from Database by Username");
	
		userService.validateUserID(username);
		List<Post> posts = feedRepository.findByUsername(username);
		posts = removeEmptyPosts(posts);
	
		logger.debug("Feeds = {}", posts);
		return posts;
	}
	
	
	public Post getPostsByPostId(String postID) throws InvalidPostException{
		
		logger.info("retrieving Posts from Database by postId");
		
		Post post = feedRepository.findByPostID(postID);
		
		if (post == null){
			throw new InvalidPostException("PostID does not exist");
		}
		
		logger.debug("Feed ={}", post);
		
		return post;
	}

	public List<Post> getPostsByPostType(String postType){
		
		logger.info("retrieving Posts from database by postType");
		
		List<Post> posts = feedRepository.findByPostType(postType);
		posts = removeEmptyPosts(posts);
				
		logger.debug("Feed={}", posts);
		
		return posts;
	}
	
	
	
	
	
	
	
	
	
	private List <Post> removeEmptyPosts (List <Post> posts){
		List<Post> resultPosts = new LinkedList<>();
		
		for (Post post : posts) {
			if (post.getPost()!=null && !post.getPost().isEmpty()){
				resultPosts.add(post);
			}
		}
		return resultPosts;
	}
}


