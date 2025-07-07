package com.seonik.controllers.dto;

import java.time.LocalDateTime;

public class ChargeResponse {
	private Long chargeId;
	private String userId;
	private Integer amount;
	private Integer totalPoint;
	private LocalDateTime chargedAt;

	public ChargeResponse(Long chargeId, String userId, Integer amount, Integer totalPoint, LocalDateTime chargedAt) {
		this.chargeId = chargeId;
		this.userId = userId;
		this.amount = amount;
		this.totalPoint = totalPoint;
		this.chargedAt = chargedAt;
	}

	public Long getChargeId() {
		return chargeId;
	}

	public String getUserId() {
		return userId;
	}

	public Integer getAmount() {
		return amount;
	}

	public Integer getTotalPoint() {
		return totalPoint;
	}

	public LocalDateTime getChargedAt() {
		return chargedAt;
	}
}