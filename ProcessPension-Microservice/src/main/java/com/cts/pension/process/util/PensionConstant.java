package com.cts.pension.process.util;

public class PensionConstant {
	PensionConstant() throws IllegalAccessException{
		throw new IllegalAccessException("constant class");
	}
	public static final String NOT_ALLOWED="Not allowed";
    public static final String AUTHORIZATION="Authorization";
    public static final String PROCESS_PENSION_CODE="Returns the Process Responce Code(10 or 21)";
    public static final String PROCESS_RESPONSE_CODE="Find Process Responce Code, If Process code is 10 then Suceess and 21 means not success";
	public static final String PENSION_DETAILS="Returns the Pension Details";
	public static final String FIND_PENSION_DETAILS="Find the pension details";
	public static final String PROCESS_PENSION_CONTROLLER="In process pension controller";
	public static final String AUTH_SUCESS="authorization suceess";
	public static final String AADHAR="aadharNumber";
	public static final String AADHAR_NUMBER="Aadhar Card Number";
	public static final String SELF="self";
	public static final String FAMILY="family";
	public static final String AADHAR_CARD_NOT_VALID="Aadhar Card Number is not Valid. Please check it and try again";
	public static final String INVALID_DETAILS="Invalid pensioner detail provided, please provide valid detail.";
	public static final String AAHDAR_NOT_NULL="aadhar number should not be null";
	public static final String BANK_NAME_NOT_BLANK="bank name should not be blank";
	public static final String ACCNO_NOT_NULL="account number should not be null";
	

}
