package st.isacc.entity;

import java.io.Serializable;
import javax.persistence.*;

import java.sql.Date;
import java.sql.Timestamp;

/**
 * The persistent class for the tblIncident database table.
 * 
 */
@Entity
public class TblIncident implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private Timestamp createOn;
	private double dblLat;
	private double dblLong;
	private String incidentLocation;
	private String incidentNo;
	private String incidentStatus;
	private String incidentType;
	private String messageText;
	private String strImageFileName;
	private String urgency;
	private String username;

	public Timestamp getCreateOn() {
		return createOn;
	}

	public void setCreateOn(Timestamp createOn) {
		this.createOn = createOn;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public TblIncident() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getDblLat() {
		return dblLat;
	}

	public void setDblLat(double dblLat) {
		this.dblLat = dblLat;
	}

	public double getDblLong() {
		return dblLong;
	}

	public void setDblLong(double dblLong) {
		this.dblLong = dblLong;
	}

	public String getIncidentLocation() {
		return this.incidentLocation;
	}

	public void setIncidentLocation(String incidentLocation) {
		this.incidentLocation = incidentLocation;
	}

	public String getIncidentNo() {
		return this.incidentNo;
	}

	public void setIncidentNo(String incidentNo) {
		this.incidentNo = incidentNo;
	}

	public String getIncidentStatus() {
		return this.incidentStatus;
	}

	public void setIncidentStatus(String incidentStatus) {
		this.incidentStatus = incidentStatus;
	}

	public String getIncidentType() {
		return this.incidentType;
	}

	public void setIncidentType(String incidentType) {
		this.incidentType = incidentType;
	}

	public String getMessageText() {
		return this.messageText;
	}

	public void setMessageText(String messageText) {
		this.messageText = messageText;
	}

	public String getStrImageFileName() {
		return this.strImageFileName;
	}

	public void setStrImageFileName(String strImageFileName) {
		this.strImageFileName = strImageFileName;
	}

	public String getUrgency() {
		return this.urgency;
	}

	public void setUrgency(String urgency) {
		this.urgency = urgency;
	}

}