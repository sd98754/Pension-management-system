package com.cts.pension.process.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.cts.pension.process.exception.AadharNumberNotFound;
import com.cts.pension.process.exception.AuthorizationException;
import com.cts.pension.process.model.ProcessPensionInput;
import com.cts.pension.process.model.ProcessPensionResponse;
import static com.cts.pension.process.util.PensionConstant.AUTHORIZATION;


	

//@FeignClient(name = "PensionDisbursement-Microservices",url = "http://localhost:8300/disbursement/api/v1")
@FeignClient(name = "PensionDisbursement-Microservices",url = "lb-disbursement-728547974.ap-southeast-1.elb.amazonaws.com/disbursement/api/v1")

public interface PensionDisbursementFeignClient {
	
	@PostMapping("/disbursePension")
	public ProcessPensionResponse getResponse(
			@RequestHeader(value = AUTHORIZATION, required = true) String requestTokenHeader,
			@RequestBody ProcessPensionInput processpensionInput) throws AuthorizationException, AadharNumberNotFound;
	
}
