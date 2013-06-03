package st.isacc.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tblMessageContact database table.
 * 
 */
@Entity
public class TblMessageContact implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int contactId;

	private String contactName;

	private byte contactOnline;

	private String operatorId;

	public TblMessageContact() {
	}

	public int getContactId() {
		return this.contactId;
	}

	public void setContactId(int contactId) {
		this.contactId = contactId;
	}

	public String getContactName() {
		return this.contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public byte getContactOnline() {
		return this.contactOnline;
	}

	public void setContactOnline(byte contactOnline) {
		this.contactOnline = contactOnline;
	}

	public String getOperatorId() {
		return operatorId;
	}

	public void setOperatorId(String operatorId) {
		this.operatorId = operatorId;
	}

	

}