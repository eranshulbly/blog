package com.personal.blog.repositories;

import com.personal.blog.entities.CommentEntity;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface CommentsRepository extends JpaRepository<CommentEntity, Integer> {

    CommentEntity findCommentByArticleId(int articleId);

//    void deleteId(int commentId);

}
