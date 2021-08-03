package com.cts.pension.disbursement.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.pension.disbursement.exception.AadharNumberNotFound;
import com.cts.pension.disbursement.exception.AuthorizationException;
import com.cts.pension.disbursement.feignclient.AuthorisingClient;
import com.cts.pension.disbursement.model.ProcessPensionInput;
import com.cts.pension.disbursement.model.ProcessPensionResponse;
import com.cts.pension.disbursement.service.PensionDisbursementServiceImpl;
import static com.cts.pension.disbursement.util.PensionConstant.NOT_ALLOWED;
import static com.cts.pension.disbursement.util.PensionConstant.PENSION_RESPONSE_CODE;
import static com.cts.pension.disbursement.util.PensionConstant.PROCESS_RESPONSE_CODE;
import static com.cts.pension.disbursement.util.PensionConstant.AUTHORIZATION;


import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
@CrossOrigin
@RestController
@Slf4j
@RequestMapping(value = "/api/v1")
public class PensionDisbursementController {

	@Autowired
	private PensionDisbursementServiceImpl pensionDisbursementServiceImpl;
	
	@Autowired
	private AuthorisingClient authorisingClient;
	
	@PostMapping("/disbursePension")
	@ApiOperation(notes = PENSION_RESPONSE_CODE, value = PROCESS_RESPONSE_CODE)
	public ProcessPensionResponse getResponse(
			@RequestHeader(value = AUTHORIZATION, required = true) String requestTokenHeader,
			@Valid @RequestBody ProcessPensionInput processpensionInput) throws AuthorizationException, AadharNumberNotFound
	{
		log.info("pension disbursement controller");
		if (authorisingClient.authorizeTheRequest(requestTokenHeader)) 
		{
			return pensionDisbursementServiceImpl.getResponce(requestTokenHeader,processpensionInput);
		}
		else
		{
			throw new AuthorizationException(NOT_ALLOWED);
		}
		
			
	}
	
	
}
