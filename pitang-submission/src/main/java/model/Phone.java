package model;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class Phone implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer regionCode;
	private String number;
	private String numberType;
	
	public Phone(Integer regionCode, String number, String numberType) {
		this.regionCode = regionCode;
		this.number = number;
		this.numberType = numberType;
	}

	public Phone() {
		
	}
	
	public Integer getRegionCode() {
		return regionCode;
	}

	public void setRegionCode(Integer regionCode) {
		this.regionCode = regionCode;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getNumberType() {
		return numberType;
	}

	public void setNumberType(String numberType) {
		this.numberType = numberType;
	}
	
	
}
