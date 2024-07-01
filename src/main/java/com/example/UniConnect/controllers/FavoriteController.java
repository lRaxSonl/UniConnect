package com.example.UniConnect.controllers;

import com.example.UniConnect.models.Favorite;
import com.example.UniConnect.services.FavoriteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@RequiredArgsConstructor
@Controller
public class FavoriteController {
    final private FavoriteService favoriteService;

    @GetMapping("/post/favorites")
    public String viewFavoritePage(Model model) {
        model.addAttribute("favorites", favoriteService.getFavoritesList());
        return "favorite-post";
    }

    @PostMapping("/post/favorite-create")
    public String favoriteCreate(Favorite favorite, @RequestHeader(value = "referer", required = false) String referer) {
        // Проверка наличия объекта favorite с тем же id пользователя и поста
        Favorite existingFavorite = favoriteService.getFavoriteByUserIdAndPostId(favorite.getUserId(), favorite.getPostId());

        if (existingFavorite != null) {
            // Если объект уже существует, то он удаляется
            favoriteService.deleteFavorite(existingFavorite.getId());
        } else {
            // Иначе создается новый объект favorite
            favoriteService.saveFavorite(favorite);
        }

        // Возвращаем перенаправление на ту же страницу
        if (referer != null && !referer.isEmpty()) {
            return "redirect:" + referer;
        } else {
            // Если Referer не указан, вернемся на главную страницу или на другую страницу по вашему выбору
            return "redirect:/";
        }
    }
}
