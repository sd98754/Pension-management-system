package com.cts.pension.process.model;

import java.time.LocalDate;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import static com.cts.pension.process.util.PensionConstant.AAHDAR_NOT_NULL;
import static com.cts.pension.process.util.PensionConstant.BANK_NAME_NOT_BLANK;
import static com.cts.pension.process.util.PensionConstant.ACCNO_NOT_NULL;



@ApiModel(value = "Model object that stores the pensioner details.")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class PensionerDetail {
	
	@ApiModelProperty(notes = "aadharNumber of pensioner")
	@NotNull(message=AAHDAR_NOT_NULL)
	private long aadharNumber;
	
	@ApiModelProperty(notes = "name of pensioner")
	private String name;
	
	@ApiModelProperty(notes = "dateofbirth of pensioner")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dateOfBirth;
	
	@ApiModelProperty(notes = "panNumber of pensioner")
	@Size(max = 15)
	private String pan;
	
	@ApiModelProperty(notes = "salary earned by pensioner")
	private double salaryEarned;
	
	@ApiModelProperty(notes = "allowances of pensioner")
	private double allowances;
	
	@ApiModelProperty(notes = "pensiontype of pensioner")
	private String pensionType;
	
	@ApiModelProperty(notes = "bankname of pensioner")
	@NotBlank(message=BANK_NAME_NOT_BLANK)
	@Size(max = 15)
	private String bankName;
	
	@ApiModelProperty(notes = "accountnumber of pensioner")
	@NotNull(message=ACCNO_NOT_NULL)
	@Size(max = 15)
	private String accountNumber;
	
	@ApiModelProperty(notes = "bankType of pensioner")
	@Size(max = 15)
	private String bankType;
	
}
