package com.seonik.service;

import com.seonik.domain.UserInfo;
import com.seonik.repository.UserInfoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserInfoService {

	private final UserInfoRepository userInfoRepository;

	public UserInfoService(UserInfoRepository userInfoRepository) {
		this.userInfoRepository = userInfoRepository;
	}

	public Page<UserInfo> getUserInfos(int page, int size, String sort) {// 페이지네이션, 소트
		Sort sortOption = switch (sort == null ? "" : sort) {
		case "views" -> Sort.by(Sort.Direction.DESC, "viewCount");
		case "created" -> Sort.by(Sort.Direction.DESC, "createdAt");
		default -> Sort.by(Sort.Direction.ASC, "name");
		};
		return userInfoRepository.findAll(PageRequest.of(page, size, sortOption));
	}

	public UserInfo getUserInfo(Integer id) {
		return userInfoRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("not found"));
	}

	public UserInfo incrementViewCount(Integer id) {
		UserInfo userInfo = getUserInfo(id);
		userInfo.incrementViewCount();
		return userInfoRepository.save(userInfo);
	}

	public java.util.List<UserInfo> getAllUserInfos() {
		return userInfoRepository.findAll();
	}

}