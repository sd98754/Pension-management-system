package com.cts.pensioner.detail.service;

import com.cts.pensioner.detail.exception.AadharNumberNotFound;
import com.cts.pensioner.detail.model.PensionerDetail;

public interface PensionerDetailService {
	
	public PensionerDetail getPensionerDetailByAadharCard(long aadharNumber) throws AadharNumberNotFound;

}
