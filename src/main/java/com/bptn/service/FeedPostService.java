package com.bptn.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.bptn.models.Post;
import com.bptn.repository.FeedPostRepository;
import com.bptn.request.FeedPostRequest;

@Service
public class FeedPostService {
	
	//adding a logging functionality to this class 
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
	@Value("{$api.key}")
	private String apiKey;
	
	@Value("{$api.base.url}")
	private String apiBaseUrl;
	
	@Autowired
	private FeedPostRepository feedPostRepository;
	
	
	
	
	//store feed method is to create the feed object(postType, Post Username, PostId)
	
	private Post storeFeed(String feedResult, FeedPostRequest feedPostRequest) {
		
		Post feed = new Post();
		feed.setPost(feedResult);
		feed.setPostType(feedPostRequest.getQuerykeyword());
		feed.setUsername(feedPostRequest.getUserName());
		feed.setPostID(generatePostId(feedPostRequest));
		
		LOGGER.debug("Feed to be stored : {}",feed);
		return feedPostRepository.save(feed);
	}




	private String generatePostId(FeedPostRequest feedPostRequest) {
		// TODO Auto-generated method stub
		return null;
	}

}
