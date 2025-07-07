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
       public Page<UserInfo> listUserInfo(@RequestParam(value = "page") int page,
                       @RequestParam(value = "size") int size,
                       @RequestParam(value = "sort", required = false) String sort) {
		if (page == 0) {
			page = 0;
		}
		if (size == 0) {
			size = 5;
		}
		return userInfoService.getUserInfos(page, size, sort);
	}

        @GetMapping("/{id}")
        public UserInfo getUserInfo(@PathVariable("id") Integer id) {
                return userInfoService.getUserInfo(id);
        }

        @PostMapping("/{id}/viewcount")
        public UserInfo updateViewCount(@PathVariable("id") Integer id) {
                return userInfoService.incrementViewCount(id);
        }

}