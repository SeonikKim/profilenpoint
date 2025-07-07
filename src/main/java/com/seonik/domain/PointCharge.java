package com.seonik.domain;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "point_charge")
public class PointCharge {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_idx", nullable = false)
	private UserInfo user;

	@Column(nullable = false)
	private Integer amount;

	@Column(name = "order_id", nullable = false, length = 100)
	private String orderId;

	@Column(name = "payment_key", nullable = false, length = 200)
	private String paymentKey;

	@CreationTimestamp
	@Column(name = "charged_at", nullable = false, updatable = false, columnDefinition = "datetime default CURRENT_TIMESTAMP")
	private LocalDateTime chargedAt;

	public PointCharge() {
	}

	public PointCharge(UserInfo user, Integer amount, String orderId, String paymentKey) {
		this.user = user;
		this.amount = amount;
		this.orderId = orderId;
		this.paymentKey = paymentKey;
	}

	public Long getId() {
		return id;
	}

	public UserInfo getUser() {
		return user;
	}

	public Integer getAmount() {
		return amount;
	}

	public String getOrderId() {
		return orderId;
	}

	public String getPaymentKey() {
		return paymentKey;
	}

	public LocalDateTime getChargedAt() {
		return chargedAt;
	}
}