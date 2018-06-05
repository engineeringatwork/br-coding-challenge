
package com.bottlerocket.coding.challenge.domain;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import org.hibernate.annotations.GenericGenerator;

@MappedSuperclass
public abstract class BaseEntity
{
	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Column(name = "ID", length = 36, nullable = false)
	private String id;

	@Column(name = "DATE_CREATED", length = 6, nullable = false)
	@Temporal(value = TemporalType.TIMESTAMP)
	protected Calendar dateCreated;

	@Column(name = "DATE_UPDATED", length = 6, nullable = false)
	@Temporal(value = TemporalType.TIMESTAMP)
	protected Calendar dateUpdated;

	@Version
	@Column(name = "VERSION")
	private Integer version;

	/**
	 * @return the id
	 */
	public String getId()
	{
		return id;
	}

	/**
	 * @param id
	 *        the id to set
	 */
	public void setId(String id)
	{
		this.id = id;
	}

	/**
	 * @return the version
	 */
	public Integer getVersion()
	{
		return version;
	}

	/**
	 * @param version
	 *        the version to set
	 */
	public void setVersion(Integer version)
	{
		this.version = version;
	}

	/**
	 * @return the dateCreated
	 */
	public Calendar getDateCreated()
	{
		return dateCreated;
	}

	/**
	 * @param dateCreated
	 *        the dateCreated to set
	 */
	public void setDateCreated(Calendar dateCreated)
	{
		this.dateCreated = dateCreated;
	}

	/**
	 * @return the dateUpdated
	 */
	public Calendar getDateUpdated()
	{
		return dateUpdated;
	}

	/**
	 * @param dateUpdated
	 *        the dateUpdated to set
	 */
	public void setDateUpdated(Calendar dateUpdated)
	{
		this.dateUpdated = dateUpdated;
	}

	@PrePersist
	public void setDateCreated()
	{
		Calendar date = Calendar.getInstance();

		this.setDateCreated(date);
		this.setDateUpdated(date);
	}

	@PreUpdate
	public void setDateUpdated()
	{
		this.setDateUpdated(Calendar.getInstance());
	}


	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj)
	{
		if (obj instanceof BaseEntity)
		{
			BaseEntity otherEntity = (BaseEntity) obj;
			if (this.getClass().equals(obj.getClass()))
			{
				if (this.getId() != null && otherEntity.getId() != null)
				{
					return this.getId().equals(otherEntity.getId());
				}
				else
				{
					return this == otherEntity;
				}
			}
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode()
	{
		if (this.getId() == null)
		{
			return 0;
		}

		return this.getId().hashCode();
	}
}