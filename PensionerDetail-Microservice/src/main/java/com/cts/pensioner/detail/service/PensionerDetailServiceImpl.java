package com.cts.pensioner.detail.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.pensioner.detail.exception.AadharNumberNotFound;
import com.cts.pensioner.detail.model.PensionerDetail;
import com.cts.pensioner.detail.repository.PensionerDetailRepository;
import static com.cts.pensioner.detail.util.PensionConstant.AADHAR_CARD_NUMBER_INVALID;


@Service
public class PensionerDetailServiceImpl implements PensionerDetailService {

	@Autowired
	private PensionerDetailRepository pensionerDetailRepository;
	
	@Override
	public PensionerDetail getPensionerDetailByAadharCard(long aadharNumber) throws AadharNumberNotFound
	{
		 return pensionerDetailRepository.findById(aadharNumber).orElseThrow(()-> new AadharNumberNotFound(AADHAR_CARD_NUMBER_INVALID));		
	}
	
	
	public List<PensionerDetail> getAllPensioner() {
		return pensionerDetailRepository.findAll();
	}
	
	
	
}
