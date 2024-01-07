package com.Beelab.DAO;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.Beelab.Entity.Comment;

public interface CommentDAO extends JpaRepository<Comment, Integer> {
    @Query("SELECT c FROM comment c WHERE c.product_id = :productId AND c.status = :status")
    List<Comment> getListComment(@Param("productId") int productId, @Param("status") int status);
;
	
	
	 @Query("SELECT c FROM comment c WHERE c.id = :commentId")
	 List<Comment> getDetailComment(@Param("commentId") int commentId);


	}

