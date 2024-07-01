package com.example.UniConnect.interfaces;

import com.example.UniConnect.models.Comment;
import com.example.UniConnect.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByPost(Post post);
}
