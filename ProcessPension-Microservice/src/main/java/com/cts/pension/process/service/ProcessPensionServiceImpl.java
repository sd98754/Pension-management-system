package com.cts.pension.process.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.cts.pension.process.exception.AadharNumberNotFound;
import com.cts.pension.process.exception.AuthorizationException;
import com.cts.pension.process.exception.PensionerDetailException;
import com.cts.pension.process.feignclient.PensionDisbursementFeignClient;
import com.cts.pension.process.feignclient.PensionerDetailFeignClient;
import com.cts.pension.process.model.PensionDetail;
import com.cts.pension.process.model.PensionerDetail;
import com.cts.pension.process.model.PensionerInput;
import com.cts.pension.process.model.ProcessPensionInput;
import com.cts.pension.process.model.ProcessPensionResponse;
import static com.cts.pension.process.util.PensionConstant.SELF;
import static com.cts.pension.process.util.PensionConstant.FAMILY;
import static com.cts.pension.process.util.PensionConstant.AADHAR_CARD_NOT_VALID;
import static com.cts.pension.process.util.PensionConstant.INVALID_DETAILS;


import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service
public class ProcessPensionServiceImpl implements ProcessPensionService {

	@Autowired
	private PensionerDetailFeignClient pensionerDeatailFeignClient;
	
	@Autowired
	private PensionDisbursementFeignClient pensionDisbursementFeignClient;
	
	@Override
	public PensionDetail CalculatePension(String token,PensionerInput pensionerInput) throws PensionerDetailException, AuthorizationException, AadharNumberNotFound
	
	{
		
		log.info("Aadhar"+pensionerInput.getAadharNumber());
		
		PensionerDetail pensionerDetail = null;
		
		try
		{
			pensionerDetail = pensionerDeatailFeignClient.getPensionerDetailByAadhaar(token, pensionerInput.getAadharNumber());
			log.info("pensionerDetail"+pensionerDetail);
		}
		catch (AadharNumberNotFound e) {
			throw new AadharNumberNotFound(AADHAR_CARD_NOT_VALID);
		}
		
		
		if(pensionerInput.getAadharNumber() == pensionerDetail.getAadharNumber() && pensionerInput.getName().equalsIgnoreCase(pensionerDetail.getName()) && pensionerInput.getPan().equalsIgnoreCase(pensionerDetail.getPan()))
		{
			
			double salary = pensionerDetail.getSalaryEarned();
			double allowances = pensionerDetail.getAllowances();
			double pensionAmount = 0;
			if(pensionerInput.getPensionType().equalsIgnoreCase(SELF))
			{
				pensionAmount = 0.8*salary + allowances;
			}
			else if(pensionerInput.getPensionType().equalsIgnoreCase(FAMILY))
			{
				pensionAmount = 0.5 * salary + allowances;
			}
			
			PensionDetail pensionDetail = new PensionDetail();
			pensionDetail.setName(pensionerDetail.getName());
			pensionDetail.setDateOfBirth(pensionerDetail.getDateOfBirth());
			pensionDetail.setPan(pensionerDetail.getPan());
			pensionDetail.setPensionAmount(pensionAmount);
			pensionDetail.setPensionType(pensionerDetail.getPensionType());
			
			return pensionDetail;
		}
		else
		{
			throw new PensionerDetailException(INVALID_DETAILS);
		}
		
	}
	
	@Override
	public ProcessPensionResponse getCode(String token,ProcessPensionInput processPensionInput) throws AuthorizationException, AadharNumberNotFound
	{	try
		{
		return pensionDisbursementFeignClient.getResponse(token, processPensionInput);
		}
	
		catch(AadharNumberNotFound e)
		{
			throw new AadharNumberNotFound(AADHAR_CARD_NOT_VALID);
		}
		 
	
		 
	}
	
	
}
