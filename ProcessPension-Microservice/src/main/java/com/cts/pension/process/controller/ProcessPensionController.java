package com.cts.pension.process.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.cts.pension.process.exception.AadharNumberNotFound;
import com.cts.pension.process.exception.AuthorizationException;
import com.cts.pension.process.exception.PensionerDetailException;
import com.cts.pension.process.feignclient.AuthorisingClient;
import com.cts.pension.process.model.PensionDetail;
import com.cts.pension.process.model.PensionerInput;
import com.cts.pension.process.model.ProcessPensionInput;
import com.cts.pension.process.model.ProcessPensionResponse;
import com.cts.pension.process.service.ProcessPensionServiceImpl;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import static com.cts.pension.process.util.PensionConstant.NOT_ALLOWED;
import static com.cts.pension.process.util.PensionConstant.AUTHORIZATION;
import static com.cts.pension.process.util.PensionConstant.PROCESS_RESPONSE_CODE;
import static com.cts.pension.process.util.PensionConstant.PROCESS_PENSION_CODE;
import static com.cts.pension.process.util.PensionConstant.PENSION_DETAILS;
import static com.cts.pension.process.util.PensionConstant.FIND_PENSION_DETAILS;



@RestController
@CrossOrigin
@Slf4j
@RequestMapping(value = "/api/v1")
public class ProcessPensionController {

	@Autowired
	ProcessPensionServiceImpl processPensionServiceImpl;
	
	@Autowired
	private AuthorisingClient authorisingClient;
	
	/***
	 * @param requestTokenHeader
	 * @param pensionerInput
	 * @return
	 * @throws AuthorizationException
	 * @throws PensionerDetailException
	 * @throws AadharNumberNotFound
	 */
	@PostMapping("/PensionDetail")
	@ApiOperation(notes = PENSION_DETAILS, value = FIND_PENSION_DETAILS)
	public PensionDetail getPensionDetail(
			@RequestHeader(value = AUTHORIZATION, required = true) String requestTokenHeader,
			@Valid @RequestBody PensionerInput pensionerInput) throws AuthorizationException, PensionerDetailException, AadharNumberNotFound
	{
		log.info("In process pension controller");
			if(authorisingClient.authorizeTheRequest(requestTokenHeader)) 
			{
				log.info("Authorization suceess");
				return processPensionServiceImpl.CalculatePension(requestTokenHeader,pensionerInput);
			}
			else
			{
				throw new AuthorizationException(NOT_ALLOWED);
			}
	}

	
	/***
	 * 
	 * @param requestTokenHeader
	 * @param processPensionInput
	 * @return
	 * @throws AuthorizationException
	 * @throws AadharNumberNotFound
	 */
	@PostMapping("/ProcessPension")
	@ApiOperation(notes = PROCESS_PENSION_CODE, value = PROCESS_RESPONSE_CODE)
	public ProcessPensionResponse getprocessingCode(
			@RequestHeader(value = AUTHORIZATION, required = true) String requestTokenHeader,
			@Valid @RequestBody ProcessPensionInput processPensionInput) throws AuthorizationException, AadharNumberNotFound
	{
		if(authorisingClient.authorizeTheRequest(requestTokenHeader)) 
		{
			return processPensionServiceImpl.getCode(requestTokenHeader,processPensionInput);
		}
		else
		{
			throw new AuthorizationException(NOT_ALLOWED);
		}
		
		
	}
	

	
}
