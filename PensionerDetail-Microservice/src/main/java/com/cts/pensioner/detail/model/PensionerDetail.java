package com.cts.pensioner.detail.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@ApiModel(value = "Model object that stores pensioner details.")
@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Table(name = "pensioner")
public class PensionerDetail {
	
	@ApiModelProperty(notes = "aadharnumber of pensioner")
    @Id
    @Column(name = "aadhar")
	private long aadharNumber;
	
	@ApiModelProperty(notes = "name of the pensioner")
	@Size(max = 20)
    private String name;
	
	@ApiModelProperty(notes = "dateofbirth of pensioner")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "dob")
	private LocalDate dateOfBirth;
	
	@ApiModelProperty(notes = "pan number of pensioner")
	@Size(max = 15)
	private String pan;
	
	@ApiModelProperty(notes = "salary earned by the pensioner")
	@Size(max = 15)
	@Column(name = "salary")
	private double salaryEarned;
	
	@ApiModelProperty(notes = "allowances of the pensioner")
	@Size(max = 15)
	private double allowances;
	
	@ApiModelProperty(notes = "pensiontype of pensioner")
	@Size(max = 15)
	@Column(name =  "pension")
	private String pensionType;
	
	@ApiModelProperty(notes = "bankaname of pensioner")
	@Size(max = 20)
	@Column(name = "bank")
	private String bankName;
	
	@ApiModelProperty(notes = "account number of pensioner")
	@Size(max = 20)
	@Column(name = "accnumber")
	private String accountNumber;
	
	@ApiModelProperty(notes = "banktype of pensioner")
	@Size(max = 15)
    @Column(name = "banktype")
	private String bankType;
	
}
