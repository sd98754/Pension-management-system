package com.cts.pension.disbursement.service;

import org.springframework.beans.factory.annotation.Autowired;
import static com.cts.pension.disbursement.util.PensionConstant.PUBLIC;
import static com.cts.pension.disbursement.util.PensionConstant.PRIVATE;
import static com.cts.pension.disbursement.util.PensionConstant.AADHAR_NOT_FOUND;
import static com.cts.pension.disbursement.util.PensionConstant.CHECK_AMOUNT;
import static com.cts.pension.disbursement.util.PensionConstant.SERVICE_CHARGE;
import static com.cts.pension.disbursement.util.PensionConstant.PROCESS_PENSION_RESPONSE;


import org.springframework.stereotype.Service;

import com.cts.pension.disbursement.exception.AadharNumberNotFound;
import com.cts.pension.disbursement.exception.AuthorizationException;
import com.cts.pension.disbursement.feignclient.PensionerDetailFeignClient;
import com.cts.pension.disbursement.model.PensionerDetail;
import com.cts.pension.disbursement.model.ProcessPensionInput;
import com.cts.pension.disbursement.model.ProcessPensionResponse;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service
public class PensionDisbursementServiceImpl implements PensionDisbursementService {
	
	@Autowired
	private PensionerDetailFeignClient pensionDisbursementFeignClient;
	
	
	@Override
	public ProcessPensionResponse getResponce(String token,ProcessPensionInput processPensionInput) throws AuthorizationException, AadharNumberNotFound
	{
		PensionerDetail pensionerDetail = null;
		try
		{
		pensionerDetail = pensionDisbursementFeignClient.getPensionerDetailByAadhaar(token, processPensionInput.getAadharNumber());
		}
		catch(AadharNumberNotFound e)
		{
			throw new AadharNumberNotFound(AADHAR_NOT_FOUND);
			
		}
		ProcessPensionResponse processPensionResponse = new ProcessPensionResponse();
		double serviceCharge = processPensionInput.getBankCharge();
		
		double checkAmount=0;
		if(pensionerDetail.getBankType().equalsIgnoreCase(PUBLIC))
		{
			checkAmount = 500;
		}
		else if(pensionerDetail.getBankType().equalsIgnoreCase(PRIVATE))
		{
			checkAmount = 550;
		}
		
		log.info(CHECK_AMOUNT+checkAmount);
		log.info(SERVICE_CHARGE+serviceCharge);
		
		if(checkAmount == serviceCharge)
		{
			processPensionResponse.setProcessPensionStatusCode(10);
		}
		else
		{
			processPensionResponse.setProcessPensionStatusCode(21);
		}
		
		log.info(PROCESS_PENSION_RESPONSE+processPensionResponse);
		return processPensionResponse;
	}

}
