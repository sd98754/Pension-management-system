package com.cts.pension.disbursement.model;

import java.time.LocalDate;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@ApiModel(value = "Model object that stores the pensioner details.")
@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PensionerDetail {
	
	@ApiModelProperty(notes = "aadharNumber of pensioner")
	@NotNull(message="aadhar number should not be null")
    private long aadharNumber;
	
	@ApiModelProperty(notes = "name of pensioner")
	@NotBlank(message="name should not be blank")
    private String name;
	
	@ApiModelProperty(notes = "dateofbirth of pensioner")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dateOfBirth;
	
	@ApiModelProperty(notes = "panNumber of pensioner")
	@NotNull(message="pan number should not be null")
	@Size(max = 15)
    private String pan;
	
	@ApiModelProperty(notes = "salary earned by pensioner")
	@NotNull(message="salary earned should not be null")
    private double salaryEarned;
	
	@ApiModelProperty(notes = "allowances of pensioner")
	private double allowances;
	
	@ApiModelProperty(notes = "pensiontype of pensioner")
	@NotBlank(message="pensiontype should not be blank")
    private String pensionType;
	
	@ApiModelProperty(notes = "bankname of pensioner")
	private String bankName;
	
	@ApiModelProperty(notes = "accountnumber of pensioner")
	@NotNull(message="account number should not be null")
	@Size(max = 15)
    private String accountNumber;
	
	@ApiModelProperty(notes = "bankType of pensioner")
	private String bankType;
}
