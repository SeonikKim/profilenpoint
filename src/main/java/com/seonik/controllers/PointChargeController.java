package com.seonik.controllers;

import com.seonik.controllers.dto.ChargeRequest;
import com.seonik.controllers.dto.ChargeResponse;
import com.seonik.domain.PointCharge;
import com.seonik.service.PointChargeService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/points")
public class PointChargeController {
	private final PointChargeService pointChargeService;

	public PointChargeController(PointChargeService pointChargeService) {
		this.pointChargeService = pointChargeService;
	}

	@PostMapping("/charge")
    public ChargeResponse charge(@RequestBody ChargeRequest rq) {
            PointCharge charge = pointChargeService.charge(rq.getUserId(), rq.getPaymentKey(),
                            rq.getOrderId(), rq.getAmount());
            return new ChargeResponse(charge.getId(), charge.getUser().getUserId(), charge.getAmount(),
                            charge.getUser().getPoint(), charge.getChargedAt());
    }
}