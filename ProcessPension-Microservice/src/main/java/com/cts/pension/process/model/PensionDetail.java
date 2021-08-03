package com.cts.pension.process.model;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@ApiModel(value = "Model object that stores the pension details.")
@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PensionDetail {

	@ApiModelProperty(notes = "name of pensioner")
	private String name;
	
	@ApiModelProperty(notes = "dateofbith of pensioner")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate  dateOfBirth;
	
	@ApiModelProperty(notes = "pan number of pensioner")
	private String pan;
	
	@ApiModelProperty(notes = "pensiontype of pensioner")
	private String pensionType;
	
	@ApiModelProperty(notes = "pensionamount of pensioner")
    private double pensionAmount;
}
