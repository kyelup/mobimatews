package st.isacc.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


/**
 * The persistent class for the tblMessageGroup database table.
 * 
 */
@Entity
public class TblMessageGroup implements Serializable {
	private static final long serialVersionUID = 1L;
	public static enum GROUPTYPE {
		BROADCAST,GROUP,SINGLE
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int groupID;

	private double dblLat;

	private double dblLong;

	@ManyToOne( cascade = {CascadeType.ALL})
    @JoinColumn(name="groupCreatorID")
	private TblUser groupCreator;

	private String groupType;

	private String strGroupName;

	private Timestamp timeStamp;
	
	@ManyToMany( targetEntity=TblUser.class, 
			cascade={CascadeType.PERSIST, CascadeType.MERGE} 
	)
	@JoinTable( name="tblmessagegroupmembers",
		joinColumns=@JoinColumn(name="groupID"),
		inverseJoinColumns=@JoinColumn(name="groupMemberID")
	)
	private List<TblUser> members;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "groupID")
	private List<TblMessageGroupMessage> messages;

	public TblMessageGroup() {
	}

	public int getGroupID() {
		return this.groupID;
	}

	public void setGroupID(int groupID) {
		this.groupID = groupID;
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

	public TblUser getGroupCreator() {
		return groupCreator;
	}

	public void setGroupCreator(TblUser groupCreator) {
		this.groupCreator = groupCreator;
	}

	public String getGroupType() {
		return this.groupType;
	}

	public void setGroupType(String groupType) {
		this.groupType = groupType;
	}

	public String getStrGroupName() {
		return this.strGroupName;
	}

	public void setStrGroupName(String strGroupName) {
		this.strGroupName = strGroupName;
	}

	public Timestamp getTimeStamp() {
		return this.timeStamp;
	}

	public void setTimeStamp(Timestamp timeStamp) {
		this.timeStamp = timeStamp;
	}

	
	public List<TblUser> getMembers() {
		return members;
	}

	public void setMembers(List<TblUser> members) {
		this.members = members;
	}

	public List<TblMessageGroupMessage> getMessages() {
		return messages;
	}

	public void setMessages(List<TblMessageGroupMessage> messages) {
		this.messages = messages;
	}

	

}