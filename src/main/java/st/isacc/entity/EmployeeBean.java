package st.isacc.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;



@Entity
@Table(name = "employeebean")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@XmlRootElement
public class EmployeeBean {

	
	@Id
	@Column(name = "ID")
	@GeneratedValue
	private int id;
	
	@Column(name = "height")
	private long height;
	@Column(name = "para1")
	private String para1;
	@Column(name = "para2")
	private String para2;
	
	
	




	public EmployeeBean(int id, long height, String para1, String para2) {
		super();
		this.id = id;
		this.height = height;
		this.para1 = para1;
		this.para2 = para2;
	}




	public EmployeeBean() {
		super();
	}




	public long getHeight() {
		return height;
	}




	public void setHeight(long height) {
		this.height = height;
	}




	public String getPara1() {
		return para1;
	}




	public void setPara1(String para1) {
		this.para1 = para1;
	}




	public String getPara2() {
		return para2;
	}




	public void setPara2(String para2) {
		this.para2 = para2;
	}



}
