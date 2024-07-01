package com.example.UniConnect.interfaces;

import com.example.UniConnect.models.Favorite;
import com.example.UniConnect.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FavoriteRepository extends JpaRepository<Favorite, Long> {
    List<Favorite> findByPost(Post post);
    Favorite findByUser_IdAndPost_Id(Long userId, Long postId);

}
