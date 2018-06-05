
package com.bottlerocket.coding.challenge.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.BatchSize;

import com.bottlerocket.coding.challenge.domain.BaseEntity;

@Entity
@Table(name = "BR_MEDIA_CONTAINER", uniqueConstraints =
{
	@UniqueConstraint(name = "UQ_CONTAINER_TYPE_AND_NAME", columnNames =
	{
		"TYPE_ID", "NAME"
	})
})
public class MediaContainer extends BaseEntity implements Comparable<MediaContainer>, Serializable
{
	private static final long serialVersionUID = 1L;

	@Column(name = "NAME", length = 64, nullable = false)
	private String name;

	@Column(name = "DESCRIPTION", length = 1000, nullable = false)
	private String description;

	@ManyToOne(fetch = FetchType.EAGER, targetEntity = LookupReference.class)
	@JoinColumn(nullable = false, name = "TYPE_ID")
	private LookupReference containerType;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "associatedContainer", cascade = CascadeType.ALL, targetEntity = MediaAsset.class, orphanRemoval = true)
	@BatchSize(size = 25)
	private Set<MediaAsset> assets;
	
	public MediaContainer()
	{
		super();
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

	public LookupReference getContainerType() {
		return containerType;
	}

	public void setContainerType(LookupReference containerType) {
		this.containerType = containerType;
	}

	public Set<MediaAsset> getAssets() {
		return assets;
	}

	public void setAssets(Set<MediaAsset> assets) {
		this.assets = assets;
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
		
		MediaContainer other = (MediaContainer) obj;
		
		if (!name.equals(other.name)) {
			return false;
		}
		if (!description.equals(other.description)) {
			return false;
		}
		if (!containerType.getName().equals(other.containerType.getName())) {
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
        return 31 * result + containerType.hashCode();
    }
	
	@Override
	public int compareTo(MediaContainer otherContainer)
	{
		return (this.name).compareTo(otherContainer.name);
	}
}