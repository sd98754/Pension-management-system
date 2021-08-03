package com.cts.pensioner.detail.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.pensioner.detail.exception.AadharNumberNotFound;
import com.cts.pensioner.detail.exception.AuthorizationException;
import com.cts.pensioner.detail.feignclient.AuthorisingClient;
import com.cts.pensioner.detail.model.PensionerDetail;
import com.cts.pensioner.detail.service.PensionerDetailServiceImpl;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import static com.cts.pensioner.detail.util.PensionConstant.AUTHORIZATION;
import static com.cts.pensioner.detail.util.PensionConstant.NOT_ALLOWED;
import static com.cts.pensioner.detail.util.PensionConstant.AADHAR_NUMBER;
import static com.cts.pensioner.detail.util.PensionConstant.AADHAR_CARD_NUMBER;
import static com.cts.pensioner.detail.util.PensionConstant.PENSION_DETAILS_BY_AADHAR;
import static com.cts.pensioner.detail.util.PensionConstant.FIND_PENSION_DETAILS_BY_AADHAR;
import static com.cts.pensioner.detail.util.PensionConstant.PENSIONER_DETAILS;
import static com.cts.pensioner.detail.util.PensionConstant.PENSION_DETAILS;


@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping(value = "/api/v1")
public class PensionerDetailController {
	
	@Autowired
	PensionerDetailServiceImpl pensionerDetailServiceImpl;
	
	@Autowired
	private AuthorisingClient authorisingClient;
	
	@GetMapping("/PensionerDetailByAadhaar/{aadharNumber}")
	@ApiOperation(notes =PENSION_DETAILS_BY_AADHAR, value =FIND_PENSION_DETAILS_BY_AADHAR )
	public PensionerDetail getPensionerDetailByAadhar(
			@RequestHeader(value = AUTHORIZATION, required = true) String requestTokenHeader,
			@ApiParam(name = AADHAR_NUMBER, value =AADHAR_CARD_NUMBER) 
			@PathVariable long aadharNumber) throws AuthorizationException, AadharNumberNotFound
	{
		if (authorisingClient.authorizeTheRequest(requestTokenHeader))
		{
			return pensionerDetailServiceImpl.getPensionerDetailByAadharCard(aadharNumber);
		}
		
		else
		{
			throw new AuthorizationException(NOT_ALLOWED);
		}
		
		
	}
	
	@GetMapping("/getAllPensioner")
	@ApiOperation(notes = PENSION_DETAILS, value = PENSIONER_DETAILS)
	public List<PensionerDetail> getAllPensioner(
			@RequestHeader(value = AUTHORIZATION, required = true) String requestTokenHeader) throws AuthorizationException
	{
		if (authorisingClient.authorizeTheRequest(requestTokenHeader))
		{
			return pensionerDetailServiceImpl.getAllPensioner();
		}
		
		else
		{
			throw new AuthorizationException(NOT_ALLOWED);
		}
		
		
	}
	

}
