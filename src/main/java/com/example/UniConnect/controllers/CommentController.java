package com.example.UniConnect.controllers;

import com.example.UniConnect.models.Comment;
import com.example.UniConnect.services.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;

@RequiredArgsConstructor
@Controller
public class CommentController {
    final private CommentService commentService;

    @PostMapping("/post/comment-create")
    public String commentCreate(Comment comment) {
        comment.setDate(LocalDate.now());
        commentService.saveComment(comment);
        return "redirect:/post/" + comment.getPost().getId();
    }

    @GetMapping("/post/comment/delete/{id}")
    public String commentDelete(@PathVariable Long id) {
        Long postId = commentService.getPostByCommentId(id).getId();
        commentService.deleteComment(id);
        return "redirect:/post/" + postId;
    }

}
