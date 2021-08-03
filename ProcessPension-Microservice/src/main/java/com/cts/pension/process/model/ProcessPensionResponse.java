package com.cts.pension.process.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
@ApiModel(value = "Model object that gives the processpensionResponse details.")
@Data
@EqualsAndHashCode
public class ProcessPensionResponse {
	
	@ApiModelProperty(notes = "processPensioncode to be returned")
	private int processPensionStatusCode;
}