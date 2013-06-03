package st.isacc.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the tblMessage database table.
 * 
 */
@Entity
public class TblMessage implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private double dblLat;

	private double dblLong;

	private byte delivered;

	private String strMessage;

	private String strRecipentID;

	private String operatorId;

	private Timestamp timestamp;

	public TblMessage() {
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

	public byte getDelivered() {
		return this.delivered;
	}

	public void setDelivered(byte delivered) {
		this.delivered = delivered;
	}

	public String getStrMessage() {
		return this.strMessage;
	}

	public void setStrMessage(String strMessage) {
		this.strMessage = strMessage;
	}

	public String getStrRecipentID() {
		return this.strRecipentID;
	}

	public void setStrRecipentID(String strRecipentID) {
		this.strRecipentID = strRecipentID;
	}

	

	public String getOperatorId() {
		return operatorId;
	}

	public void setOperatorId(String operatorId) {
		this.operatorId = operatorId;
	}

	public Timestamp getTimestamp() {
		return this.timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

}