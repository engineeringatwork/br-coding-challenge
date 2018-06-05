
package com.bottlerocket.coding.challenge.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.BatchSize;

import com.bottlerocket.coding.challenge.domain.BaseEntity;

@Entity
@Table(name = "BR_LOOKUP_TYPE", uniqueConstraints =
{
		@UniqueConstraint(name = "UQ_LOOKUP_TYPE_NAME", columnNames =
			{
					"NAME"
			})
})
public class LookupType extends BaseEntity implements Comparable<LookupType>, Serializable
{
	private static final long serialVersionUID = 1L;

	@Column(name = "NAME", length = 64, nullable = false)
	private String name;

	@Column(name = "DESCRIPTION", length = 255, nullable = true)
	private String description;

	@Column(name = "IS_ACTIVE", length = 2, nullable = false)
	private Boolean isActive = true;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "lookupType", cascade = CascadeType.ALL, targetEntity = LookupReference.class)
	@BatchSize(size = 25)
	private Set<LookupReference> lookupReferences;

	public LookupType()
	{
		super();
	}

	/**
	 * @return the name
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * @param name
	 *        the name to set
	 */
	public void setName(String name)
	{
		this.name = name;
	}

	/**
	 * @return the description
	 */
	public String getDescription()
	{
		return description;
	}

	/**
	 * @param description
	 *        the description to set
	 */
	public void setDescription(String description)
	{
		this.description = description;
	}

	/**
	 * @return the isActive
	 */
	public Boolean getIsActive()
	{
		return isActive;
	}

	/**
	 * @param isActive
	 *        the isActive to set
	 */
	public void setIsActive(Boolean isActive)
	{
		this.isActive = isActive;
	}

	/**
	 * @return the lookupReferences
	 */
	public Set<LookupReference> getLookupReferences()
	{
		return lookupReferences;
	}

	/**
	 * @param lookupReferences
	 *        the lookupReferences to set
	 */
	public void setLookupReferences(Set<LookupReference> lookupReferences)
	{
		this.lookupReferences = lookupReferences;
	}

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

		LookupType other = (LookupType) obj;

		if (!name.equals(other.name)) {
			return false;
		}
		if (!description.equals(other.description)) {
			return false;
		}
		if (!isActive.equals(other.isActive)) {
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
		return 31 * result + isActive.hashCode();
	}

	@Override
	public int compareTo(LookupType otherLookup)
	{
		return (this.name).compareTo(otherLookup.name);
	}
}