package com.cts.pension.process.model;


import javax.validation.constraints.NotNull;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import static com.cts.pension.process.util.PensionConstant.ACCNO_NOT_NULL;

@ApiModel(value = "Model object that stores the pensioner Input details.")

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class ProcessPensionInput {
	
	@ApiModelProperty(notes = "aadharNumber of pensioner")
	@NotNull(message=ACCNO_NOT_NULL)
	private long aadharNumber;
	
	@ApiModelProperty(notes = "pension amount of pensioner")
	private double pesionAmount;
	
	@ApiModelProperty(notes = "bankcharge of pensioner")
	@NotNull(message="bank charge should not be null")
	private double bankCharge;
	
	
}
