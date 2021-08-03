package com.cts.pension.disbursement.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ApiModel(value = "Model object that gives the processpensionResponse details.")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class ProcessPensionResponse {
	
	@ApiModelProperty(notes = "processPensioncode to be returned")
    private int processPensionStatusCode;
}