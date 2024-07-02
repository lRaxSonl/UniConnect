package com.example.UniConnect.services;

import com.example.UniConnect.interfaces.CommentRepository;
import com.example.UniConnect.models.Comment;
import com.example.UniConnect.models.Post;
import com.example.UniConnect.models.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Slf4j
@Service
public class CommentService {
    private final CommentRepository commentRepository;
    private final UserService userService;

    public List<Comment> getComments() {
        return commentRepository.findAll();
    }

    public void saveComment(Comment comment) {
        log.info("Saving new comment: {}", comment);
        comment.setUser(userService.getCurrentUser());
        commentRepository.save(comment);
    }

    public void deleteComment(Long id) {
        Comment comment = commentRepository.findById(id).get();
        User user = userService.getCurrentUser();
        if(comment.getUser().equals(user) || userService.isAdmin(user)) {
            commentRepository.deleteById(id);
        }else {
            log.info("Access is denied");
        }
    }

    public Post getPostByCommentId(Long id) {
        Optional<Comment> optionalComment = commentRepository.findById(id);
        if (optionalComment.isPresent()) {
            Comment comment = optionalComment.get();
            return comment.getPost();
        }
        return null;
    }
}
