package com.cts.pension.disbursement.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@ApiModel(value = "Model object that stores the processPensionInput details.")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class ProcessPensionInput {
	
	@ApiModelProperty(notes = "aadharNumber of pensioner")
	@NotNull(message="aadhar number should not be null")
	private Long aadharNumber;
	
	@ApiModelProperty(notes = "pensionamount of pensioner")
	private double pensionAmount;
	
	@ApiModelProperty(notes = "bankcharge of pensioner")
	@NotNull(message="bank charge should not be null")
    private double bankCharge;
}