package com.shopeasy.core.model.reference;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.shopeasy.core.constants.SchemaConstant;

@Entity
@Table(name = "COUNTRY_DESCRIPTION", uniqueConstraints = {
		@UniqueConstraint(columnNames = { "COUNTRY_ID", "LANGUAGE_ID" }) })
public class CountryDescription {

	@TableGenerator(name = "description_gen", table = "SM_SEQUENCER", pkColumnName = "SEQ_NAME", valueColumnName = "SEQ_COUNT", pkColumnValue = "country_description_seq", allocationSize = SchemaConstant.DESCRIPTION_ID_ALLOCATION_SIZE, initialValue = SchemaConstant.DESCRIPTION_ID_START_VALUE)
	@JsonIgnore
	@ManyToOne(targetEntity = Country.class)
	@JoinColumn(name = "COUNTRY_ID", nullable = false)
	private Country country;

	
	
	public CountryDescription(Country country) {
		super();
		this.country = country;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

}
