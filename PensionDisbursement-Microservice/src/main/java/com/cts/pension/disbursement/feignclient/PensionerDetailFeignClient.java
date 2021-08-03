package com.cts.pension.disbursement.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import com.cts.pension.disbursement.exception.AadharNumberNotFound;
import com.cts.pension.disbursement.exception.AuthorizationException;
import com.cts.pension.disbursement.model.PensionerDetail;
import static com.cts.pension.disbursement.util.PensionConstant.AUTHORIZATION;
import static com.cts.pension.disbursement.util.PensionConstant.AADHAR_NUMBER;


import io.swagger.annotations.ApiParam;

@FeignClient(name ="PensionerDetail-Microservice",url = "http://localhost:8200/pensioner/api/v1")
public interface PensionerDetailFeignClient {
	
	@GetMapping("/PensionerDetailByAadhaar/{aadharNumber}")
	public PensionerDetail getPensionerDetailByAadhaar(
			@RequestHeader(value = AUTHORIZATION, required = true) String requestTokenHeader,
			@ApiParam(name = AADHAR_NUMBER, value = "aadhar card number") 
			@PathVariable long aadharNumber) throws AuthorizationException, AadharNumberNotFound;
}
