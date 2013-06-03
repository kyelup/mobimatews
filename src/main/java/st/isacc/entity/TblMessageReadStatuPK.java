package st.isacc.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the tblMessageReadStatu database table.
 * 
 */
@Embeddable
public class TblMessageReadStatuPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private int messageID;

	private int recipientID;

	public TblMessageReadStatuPK() {
	}
	
	public TblMessageReadStatuPK(int messageID , int recipientID) {
		this.messageID = messageID;
		this.recipientID = recipientID;
	}
	
	public int getMessageID() {
		return this.messageID;
	}
	public void setMessageID(int messageID) {
		this.messageID = messageID;
	}
	
	public int getRecipientID() {
		return recipientID;
	}

	public void setRecipientID(int recipientID) {
		this.recipientID = recipientID;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof TblMessageReadStatuPK)) {
			return false;
		}
		TblMessageReadStatuPK castOther = (TblMessageReadStatuPK)other;
		return 
			(this.messageID == castOther.messageID)
			&& this.recipientID == castOther.recipientID;
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.messageID;
		hash = hash * prime + this.recipientID;
		
		return hash;
	}
}