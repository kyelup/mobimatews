package st.isacc.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the tblMessageGroupMessages database table.
 * 
 */
@Entity
@Table(name="tblMessageGroupMessages")
public class TblMessageGroupMessage implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private double dblLat;

	private double dblLong;

	@ManyToOne( cascade = {CascadeType.ALL} )
    @JoinColumn(name="groupID")
	private TblMessageGroup group;

	@ManyToOne( cascade = {CascadeType.ALL} )
    @JoinColumn(name="senderID")
	private TblUser owner;

	private String status;

	private String strMessage;

	private Timestamp timeStamp;

	public TblMessageGroupMessage() {
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

	public TblMessageGroup getGroup() {
		return group;
	}

	public void setGroup(TblMessageGroup group) {
		this.group = group;
	}

	public TblUser getOwner() {
		return owner;
	}

	public void setOwner(TblUser owner) {
		this.owner = owner;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStrMessage() {
		return this.strMessage;
	}

	public void setStrMessage(String strMessage) {
		this.strMessage = strMessage;
	}

	public Timestamp getTimeStamp() {
		return this.timeStamp;
	}

	public void setTimeStamp(Timestamp timeStamp) {
		this.timeStamp = timeStamp;
	}

	@Override
	public String toString() {
		return "TblMessageGroupMessage [id=" + id + ", dblLat=" + dblLat
				+ ", dblLong=" + dblLong + ", group=" + group + ", owner="
				+ owner + ", status=" + status + ", strMessage=" + strMessage
				+ ", timeStamp=" + timeStamp + "]";
	}
	
}