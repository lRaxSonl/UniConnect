package com.example.UniConnect.services;

import com.example.UniConnect.interfaces.FavoriteRepository;
import com.example.UniConnect.interfaces.PostRepository;
import com.example.UniConnect.models.Favorite;
import com.example.UniConnect.models.Post;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Slf4j
@Service
public class FavoriteService {
    private final PostRepository postRepository;
    private final FavoriteRepository favoriteRepository;

    public void saveFavorite(Favorite favorite) {
        log.info("Saving new favorite: {}", favorite);
        favoriteRepository.save(favorite);
    }
    public void deleteFavorite(Long id) {
        favoriteRepository.deleteById(id);
    }

    public Post getPostByFavoriteId(Long id) {
        Optional<Favorite> optionalFavorite = favoriteRepository.findById(id);
        if (optionalFavorite.isPresent()) {
            Favorite favorite = optionalFavorite.get();
            return favorite.getPost();
        }
        return null;
    }
    public List<Favorite> getFavoritesList() {
        return favoriteRepository.findAll();
    }


    public Favorite getFavoriteByUserIdAndPostId(Long userId, Long postId) {
        return favoriteRepository.findByUser_IdAndPost_Id(userId, postId);
    }
}
