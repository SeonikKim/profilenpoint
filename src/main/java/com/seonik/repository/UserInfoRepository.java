package com.seonik.repository;

import com.seonik.domain.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
public interface UserInfoRepository extends JpaRepository<UserInfo, Integer> {
	  Optional<UserInfo> findByUserId(String userId);
}