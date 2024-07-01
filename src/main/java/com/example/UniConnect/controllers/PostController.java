package com.example.UniConnect.controllers;

import com.example.UniConnect.config.SecurityConfig;
import com.example.UniConnect.interfaces.UserRepository;
import com.example.UniConnect.models.Post;
import com.example.UniConnect.models.User;
import com.example.UniConnect.services.CommentService;
import com.example.UniConnect.services.PostService;
import com.example.UniConnect.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.util.UUID;

@RequiredArgsConstructor
@Controller
public class PostController {
    private final PostService postService;
    private final CommentService commentService;
    private final UserRepository userRepository;
    private final UserService userService;

    @Autowired
    private ResourceLoader resourceLoader;

    @GetMapping("/")
    public String viewPosts(@RequestParam(name = "title", required = false) String title, Model model) {
        model.addAttribute("posts", postService.getPostsList(title));
        return "index";
    }

    @GetMapping("/post/create")
    public String createPost() {
        return "create-post";
    }

    @GetMapping("/post/{id}")
    public String viewPostInfo(@PathVariable Long id, Model model) {
        model.addAttribute("post", postService.getPostById(id));
        model.addAttribute("comments", commentService.getComments());
        return "post";
    }

    @PostMapping("post/create-now")
    public String createPostNow(Post post, @RequestParam("file") MultipartFile file) throws IOException {

        String imagePath = resourceLoader.getResource("classpath:static/assets/img/user_uploads").getFile().getAbsolutePath();

        String newFilename = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
        String fullFilePath = imagePath + File.separator + newFilename;
        String localFilePath = "assets/img/user_uploads/" + newFilename;


        try (InputStream inputStream = file.getInputStream();
             FileOutputStream outputStream = new FileOutputStream(new File(fullFilePath))) {
            FileCopyUtils.copy(inputStream, outputStream);
            post.setFilename(localFilePath);
        }

        post.setDate(LocalDate.now());
        post.setUser(userService.getCurrentUser());
        postService.savePost(post);

        return "redirect:/";
    }

    @GetMapping("/post/delete/{id}")
    public String deletePost(@PathVariable Long id) {
        SecurityConfig securityConfig = new SecurityConfig();
        User user = userService.getCurrentUser();
        postService.deletePost(id, user);
        return "redirect:/";
    }
}
