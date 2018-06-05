
package com.bottlerocket.coding.challenge.domain;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.bottlerocket.coding.challenge.domain.BaseEntity;

@Entity
@Table(name = "BR_LOOKUP_DATA", uniqueConstraints =
{
	@UniqueConstraint(name = "UQ_LOOKUP_DATA_TYPE_ID_NAME", columnNames =
	{
		"LOOKUP_TYPE_ID", "NAME"
	})
})
public class LookupReference extends BaseEntity implements Comparable<LookupReference>, Serializable
{
	private static final long serialVersionUID = 1L;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, targetEntity = LookupType.class)
	@JoinColumn(nullable = false, name = "LOOKUP_TYPE_ID")
	private LookupType lookupType;

	@Column(name = "NAME", length = 64, nullable = false)
	private String name;

	@Column(name = "DESCRIPTION", length = 255, nullable = true)
	private String description;

	public LookupReference()
	{
		super();
	}



	public LookupType getLookupType() {
		return lookupType;
	}



	public void setLookupType(LookupType lookupType) {
		this.lookupType = lookupType;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}

	// TODO: Figure out why hash code is failing if you have time
	@Override
	public boolean equals(Object obj) 
	{
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) 
		{
			return false;
		}

		LookupReference other = (LookupReference) obj;

		if (!name.equals(other.name)) {
			return false;
		}
		if (!description.equals(other.description)) {
			return false;
		}
		if (!lookupType.getName().equals(other.getLookupType().getName())) {
			return false;
		}

		return true;
	}

	@Override
	public int hashCode() 
	{
		int result = 1;

		result = 31 * result + name.hashCode();
		result = 31 * result + description.hashCode();
		return 31 * result + lookupType.hashCode();
	}
	
	@Override
	public int compareTo(LookupReference otherReference)
	{
		return (this.name).compareTo(otherReference.name);
	}

}
