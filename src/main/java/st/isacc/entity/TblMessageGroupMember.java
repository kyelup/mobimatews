package st.isacc.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tblMessageGroupMembers database table.
 * 
 */
@Entity
@Table(name="tblMessageGroupMembers")
public class TblMessageGroupMember implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private int groupID;

	private int groupMemberID;

	public TblMessageGroupMember() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getGroupID() {
		return this.groupID;
	}

	public void setGroupID(int groupID) {
		this.groupID = groupID;
	}

	public int getGroupMemberID() {
		return this.groupMemberID;
	}

	public void setGroupMemberID(int groupMemberID) {
		this.groupMemberID = groupMemberID;
	}

}