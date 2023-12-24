package com.Beelab.Imp;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.Beelab.DAO.CommentDAO;
import com.Beelab.Entity.Cart;
import com.Beelab.Entity.Comment;
import com.Beelab.Service.CommentService;

public class CommentServiceImpl implements CommentService{
@Autowired
CommentDAO cmdao;
	@Override
	public Comment createComment(Long userId, Comment createCommentDTO) {
		// TODO Auto-generated method stub
		return cmdao .save(createComment(userId, createCommentDTO)) ;
	}

	@Override
	public List<Comment> getListComment(int productId, int status) {
		// TODO Auto-generated method stub
		return cmdao.getListComment(productId, status);
	}

	@Override
	public Comment getDetailComment(int commentId) {
		// TODO Auto-generated method stub
		return (Comment) cmdao.getDetailComment(commentId);
	}

	

	@Override
	public Comment findOneById(int id) {
		
		return cmdao .findById(id).get();
	}

	@Override
	public void update(Comment Comment) {
		// TODO Auto-generated method stub/// chưa viết được        	
	}

}
