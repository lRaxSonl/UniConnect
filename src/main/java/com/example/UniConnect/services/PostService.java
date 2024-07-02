package com.example.UniConnect.services;

import com.example.UniConnect.interfaces.CommentRepository;
import com.example.UniConnect.interfaces.FavoriteRepository;
import com.example.UniConnect.models.Comment;
import com.example.UniConnect.models.Favorite;
import com.example.UniConnect.models.Post;
import com.example.UniConnect.models.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import com.example.UniConnect.interfaces.PostRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Slf4j
@Service
public class PostService {
    private final PostRepository postRepository;
    private final CommentRepository commentRepository;
    private final FavoriteRepository favoriteRepository;
    private final UserService userService;


    //Список всех постов с учётом поиска по названию
    public List<Post> getPostsList(String title) {
        if (title != null) {
            return postRepository.findByTitle(title);
        }
        else {
            return postRepository.findAll();
        }
    }

    //Сохранение поста
    public void savePost(Post post) {
        log.info("Saving new post: {}", post);
        postRepository.save(post);
    }

    //Удаление поста
    public void deletePost(Long id, User user) {
        try {
            if (getPostById(id).getUser().equals(user) || userService.isAdmin(user)) {

                List<Comment> commentList = getCommentsByPostId(id);
                commentRepository.deleteAll(commentList);

                List<Favorite> favoriteEntityList = getFavoriteByPostId(id);
                if (!favoriteEntityList.equals(null)) {
                    favoriteRepository.deleteAll(favoriteEntityList);
                }

                log.info("Post {} has been deleted", getPostById(id));
                postRepository.deleteById(id);
            } else {
                log.info("Access is denied");
            }
        } catch (NullPointerException e) {
            log.info("User {} has not found", user.getUsername());
        }
    }

    //Найти пост по id
    public Post getPostById(Long id) {
        return postRepository.findById(id).orElse(null);
    }

    //Найти все комментарии привязанные к посту
    private List<Comment> getCommentsByPostId(Long id) {
        Optional<Post> optionalPost = postRepository.findById(id);
        if(optionalPost.isPresent()) {
            Post post = optionalPost.get();
            return commentRepository.findByPost(post);
        }
        return null;
    }

    private List<Favorite> getFavoriteByPostId(Long id) {
        Optional<Post> optionalPost = postRepository.findById(id);
        if (optionalPost.isPresent()) {
            Post post = optionalPost.get();
            return favoriteRepository.findByPost(post);
        }
        return null;
    }

}
