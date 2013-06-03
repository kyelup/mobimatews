package st.isacc.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tblDeclineReason database table.
 * 
 */
@Entity
public class TblDeclineReason implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int pid;

	@Lob
	private String audioMsgUrl;

	private String operatorId;

	private String supervisorId;

	private String taskId;

	@Lob
	private String textMsg;

	public TblDeclineReason() {
	}

	public int getPid() {
		return this.pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getAudioMsgUrl() {
		return audioMsgUrl;
	}

	public void setAudioMsgUrl(String audioMsgUrl) {
		this.audioMsgUrl = audioMsgUrl;
	}

	public String getOperatorId() {
		return operatorId;
	}

	public void setOperatorId(String operatorId) {
		this.operatorId = operatorId;
	}

	public String getSupervisorId() {
		return supervisorId;
	}

	public void setSupervisorId(String supervisorId) {
		this.supervisorId = supervisorId;
	}

	public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	public String getTextMsg() {
		return textMsg;
	}

	public void setTextMsg(String textMsg) {
		this.textMsg = textMsg;
	}

	

}