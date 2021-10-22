package com.junseong.book.springboot.web;

import com.junseong.book.springboot.config.auth.LoginUser;
import com.junseong.book.springboot.config.auth.dto.SessionUser;
import com.junseong.book.springboot.domain.user.User;
import com.junseong.book.springboot.domain.user.UserRepository;
import com.junseong.book.springboot.service.PostsService;
import com.junseong.book.springboot.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;

    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user) {
        model.addAttribute("posts", postsService.findAllDesc());
        if (user != null) {
            model.addAttribute("name", user.getName());
        }
        return "index";
    }


}
