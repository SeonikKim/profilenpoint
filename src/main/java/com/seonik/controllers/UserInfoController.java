package com.seonik.controllers;


import com.seonik.domain.UserInfo;
import com.seonik.service.UserInfoService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/userinfo")
public class UserInfoController {

    private final UserInfoService userInfoService;

    public UserInfoController(UserInfoService userInfoService) {
        this.userInfoService = userInfoService;
    }

    @GetMapping
    public Page<UserInfo> listUserInfo(@RequestParam(defaultValue = "0") int page,
                                       @RequestParam(defaultValue = "10") int size,
                                       @RequestParam(required = false) String sort) {
        return userInfoService.getUserInfos(page, size, sort);
    }

    @PostMapping("/{id}/viewcount")
    public UserInfo updateViewCount(@PathVariable Integer id) {
        return userInfoService.incrementViewCount(id);
    }
}