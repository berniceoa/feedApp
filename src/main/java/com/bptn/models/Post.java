package com.bptn.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="\"Post\"")
public class Post {
	@Id
	@Column(name="\"postID\"")
	private String postID;
	@Column(name="\"postType\"")
	private String postType;
	@Column(name="\"usernameKey\"")
	private String usernameKey;
	
	
	public Post() {
		super();
	}
	public Post(String postID, String postType, String usernameKey) {
		super();
		this.postID = postID;
		this.postType = postType;
		this.usernameKey = usernameKey;
	}
	public String getPostID() {
		return postID;
	}
	public void setPostID(String postID) {
		this.postID = postID;
	}
	public String getPostType() {
		return postType;
	}
	public void setPostType(String postType) {
		this.postType = postType;
	}
	public String getUsernameKey() {
		return usernameKey;
	}
	public void setUsernameKey(String usernameKey) {
		this.usernameKey = usernameKey;
	}
	
	
	
	
	

}
