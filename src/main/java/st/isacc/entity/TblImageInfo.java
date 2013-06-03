package st.isacc.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the tblImageInfo database table.
 * 
 */
@Entity
public class TblImageInfo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private Timestamp dateTimeStamp;

	private double dblLat;

	private double dblLong;

	private String strImageFilename;

	private String strRemark;

	private String operatorName;

	public TblImageInfo() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Timestamp getDateTimeStamp() {
		return this.dateTimeStamp;
	}

	public void setDateTimeStamp(Timestamp dateTimeStamp) {
		this.dateTimeStamp = dateTimeStamp;
	}

	public double getDblLat() {
		return this.dblLat;
	}

	public void setDblLat(double dblLat) {
		this.dblLat = dblLat;
	}

	public double getDblLong() {
		return this.dblLong;
	}

	public void setDblLong(double dblLong) {
		this.dblLong = dblLong;
	}

	public String getStrImageFilename() {
		return this.strImageFilename;
	}

	public void setStrImageFilename(String strImageFilename) {
		this.strImageFilename = strImageFilename;
	}

	public String getStrRemark() {
		return this.strRemark;
	}

	public void setStrRemark(String strRemark) {
		this.strRemark = strRemark;
	}

	public String getOperatorName() {
		return operatorName;
	}

	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}

}