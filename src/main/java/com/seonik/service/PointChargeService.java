package com.seonik.service;

import com.seonik.domain.PointCharge;
import com.seonik.domain.UserInfo;
import com.seonik.repository.PointChargeRepository;
import com.seonik.repository.UserInfoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PointChargeService {
	private final UserInfoRepository userInfoRepository;
	private final PointChargeRepository pointChargeRepository;
	private final TossPaymentsClient tossPaymentsClient;

	public PointChargeService(UserInfoRepository userInfoRepository, PointChargeRepository pointChargeRepository,
			TossPaymentsClient tossPaymentsClient) {
		this.userInfoRepository = userInfoRepository;
		this.pointChargeRepository = pointChargeRepository;
		this.tossPaymentsClient = tossPaymentsClient;
	}

	public PointCharge charge(Integer userId, String paymentKey, String orderId, int amount) {
		tossPaymentsClient.confirm(paymentKey, orderId, amount);
		UserInfo user = userInfoRepository.findById(userId)
				.orElseThrow(() -> new IllegalArgumentException("user not found"));
		user.setPoint(user.getPoint() + amount);
		PointCharge charge = new PointCharge(user, amount, orderId, paymentKey);
		return pointChargeRepository.save(charge);
	}
}