
package com.bottlerocket.coding.challenge.domain;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "BR_MEDIA_ASSET", uniqueConstraints =
{
		@UniqueConstraint(name = "UQ_MEDIA_TYPE_NAME", columnNames =
			{
					"TYPE_ID", "NAME"
			})
})
@Inheritance(strategy=InheritanceType.JOINED)
public class MediaAsset extends BaseEntity
{
	@Column(name = "NAME", length = 64, nullable = false)
	private String name;

	@ManyToOne(fetch = FetchType.EAGER, targetEntity = LookupReference.class)
	@JoinColumn(nullable = false, name = "TYPE_ID")
	private LookupReference mediaType;

	@Column(name = "URL", length = 512, nullable = false)
	private String url;

	@Column(name = "DATE_EXPIRED", length = 6, nullable = false)
	@Temporal(value = TemporalType.TIMESTAMP)
	protected Calendar dateExpired;

	@ManyToOne(fetch = FetchType.EAGER, targetEntity = MediaContainer.class)
	@JoinColumn(nullable = false, name = "CONTAINER_ID")
	private MediaContainer associatedContainer;

	public MediaAsset() 
	{
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LookupReference getMediaType() {
		return mediaType;
	}

	public void setMediaType(LookupReference mediaType) {
		this.mediaType = mediaType;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Calendar getDateExpired() {
		return dateExpired;
	}

	public void setDateExpired(Calendar dateExpired) {
		this.dateExpired = dateExpired;
	}

	public MediaContainer getAssociatedContainer() {
		return associatedContainer;
	}

	public void setAssociatedContainer(MediaContainer associatedContainer) {
		this.associatedContainer = associatedContainer;
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
		
		MediaAsset other = (MediaAsset) obj;
		
		if (!name.equals(other.getName())) {
			return false;
		}
		if (!url.equals(other.getUrl())) {
			return false;
		}
		if (!mediaType.getName().equals(other.mediaType.getName())) {
			return false;
		}
		
		return true;
	}
	
	@Override
    public int hashCode() 
	{
        int result = 1;
        result = 31 * result + name.hashCode();
        result = 31 * result + url.hashCode();
        return 31 * result + mediaType.hashCode();
    }
}