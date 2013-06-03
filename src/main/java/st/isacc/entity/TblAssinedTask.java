package st.isacc.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tblAssinedTask database table.
 * 
 */
@Entity
public class TblAssinedTask implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String incidentNo;

	private String operatorId;

	private String status;

	private String supervisor;

	public TblAssinedTask() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIncidentNo() {
		return this.incidentNo;
	}

	public void setIncidentNo(String incidentNo) {
		this.incidentNo = incidentNo;
	}

	public String getOperatorId() {
		return this.operatorId;
	}

	public void setOperatorId(String operatorId) {
		this.operatorId = operatorId;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSupervisor() {
		return this.supervisor;
	}

	public void setSupervisor(String supervisor) {
		this.supervisor = supervisor;
	}

	@Override
	public String toString() {
		return "TblAssinedTask [id=" + id + ", incidentNo=" + incidentNo
				+ ", operatorId=" + operatorId + ", status=" + status
				+ ", supervisor=" + supervisor + "]";
	}

	public TblAssinedTask(int id, String incidentNo, String operatorId,
			String status, String supervisor) {
		super();
		this.id = id;
		this.incidentNo = incidentNo;
		this.operatorId = operatorId;
		this.status = status;
		this.supervisor = supervisor;
	}


	
}