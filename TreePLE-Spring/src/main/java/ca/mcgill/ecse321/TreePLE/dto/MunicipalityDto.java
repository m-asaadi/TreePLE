package ca.mcgill.ecse321.TreePLE.dto;

import java.util.ArrayList;
import java.util.List;

import ca.mcgill.ecse321.TreePLE.model.Municipality.MunicipalityName;


public class MunicipalityDto {

	private MunicipalityName name;
	
	
	public MunicipalityDto() {
	}
	
	public MunicipalityDto(MunicipalityName name) {
		this.name=name;
	}
	
	
	public MunicipalityName getName() {
		return name;
	}
	

	
}
