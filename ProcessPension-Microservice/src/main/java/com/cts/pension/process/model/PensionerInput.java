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
import static com.cts.pension.process.util.PensionConstant.AAHDAR_NOT_NULL;


@ApiModel(value = "Model object that stores the processpensionInput details.")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode
public class PensionerInput {

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
	
	
	@ApiModelProperty(notes = "pensiontype of pensioner")
	@NotNull(message="pension type should not be null")
	private String pensionType;

	
	

}
