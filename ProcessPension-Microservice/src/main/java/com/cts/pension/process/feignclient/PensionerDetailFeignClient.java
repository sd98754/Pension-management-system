package com.cts.pension.process.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import com.cts.pension.process.exception.AadharNumberNotFound;
import com.cts.pension.process.exception.AuthorizationException;
import com.cts.pension.process.model.PensionerDetail;

import io.swagger.annotations.ApiParam;
import static com.cts.pension.process.util.PensionConstant.AUTHORIZATION;
import static com.cts.pension.process.util.PensionConstant.AADHAR;
import static com.cts.pension.process.util.PensionConstant.AADHAR_NUMBER;


@FeignClient(name ="PensionerDetail-Microservice",url = "lb-pensionerdetail-1472919262.ap-southeast-1.elb.amazonaws.com/pensioner/api/v1")
public interface PensionerDetailFeignClient {
	
	@GetMapping("/PensionerDetailByAadhaar/{aadharNumber}")
	public PensionerDetail getPensionerDetailByAadhaar(
			@RequestHeader(value =AUTHORIZATION, required = true) String requestTokenHeader,
			@ApiParam(name = AADHAR, value = AADHAR_NUMBER) 
			@PathVariable long aadharNumber) throws AuthorizationException, AadharNumberNotFound;
	

}
