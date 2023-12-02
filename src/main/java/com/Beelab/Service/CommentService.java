package com.Beelab.Service;

import java.util.List;

import com.Beelab.Entity.Comment;

public interface CommentService {
	  	public Comment createComment(Long userId, Comment createCommentDTO);

	  	public List<Comment> getListComment(int productId, int status);

	  	public Comment getDetailComment(int commentId);

	  	public Comment deleteCommentByAdmin(int commentId);

	  	public Comment findOneById(int id);

	  	public void update(Comment comment);
}
