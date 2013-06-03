package st.isacc.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the tblCurrentLoc database table.
 * 
 */
@Entity
public class TblCurrentLoc implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private double dblLat;

	private double dblLong;

	private String strTripId;

	private String strUserName;

	private Timestamp timestamp;

	public TblCurrentLoc() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getStrTripId() {
		return this.strTripId;
	}

	public void setStrTripId(String strTripId) {
		this.strTripId = strTripId;
	}

	public String getStrUserName() {
		return strUserName;
	}

	public void setStrUserName(String strUserName) {
		this.strUserName = strUserName;
	}

	public Timestamp getTimestamp() {
		return this.timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

}