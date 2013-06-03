package st.isacc.entity;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "gombimate_brand")
@XmlRootElement
public class BrandEntity {

	@Id
	@Column(name = "ID")
	@GeneratedValue
	private int id;

	@Column(name = "BRAND_DESCRIPTION")
	private String brandDescription;

	@Column(name = "BRAND_ICON_PATH")
	private String brandIconPath;

	@Column(name = "BRAND_SORT_CHAR")
	private String brandSortChar;

	@Column(name = "CREATE_TIME")
	private Date createTime;

	@Column(name = "UPDATE_TIME")
	private Date updateTime;

	public BrandEntity(int id, String brandDescription, String brandIconPath,
			String brandSortChar, Date createTime, Date updateTime) {
		super();
		this.id = id;
		this.brandDescription = brandDescription;
		this.brandIconPath = brandIconPath;
		this.brandSortChar = brandSortChar;
		this.createTime = createTime;
		this.updateTime = updateTime;
	}

	public BrandEntity() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBrandDescription() {
		return brandDescription;
	}

	public void setBrandDescription(String brandDescription) {
		this.brandDescription = brandDescription;
	}

	public String getBrandIconPath() {
		return brandIconPath;
	}

	public void setBrandIconPath(String brandIconPath) {
		this.brandIconPath = brandIconPath;
	}

	public String getBrandSortChar() {
		return brandSortChar;
	}

	public void setBrandSortChar(String brandSortChar) {
		this.brandSortChar = brandSortChar;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	
	



}
