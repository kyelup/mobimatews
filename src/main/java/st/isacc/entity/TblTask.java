package st.isacc.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;


/**
 * The persistent class for the tblTask database table.
 * 
 */
@Entity
public class TblTask implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createdOn;

	@Temporal(TemporalType.TIMESTAMP)
	private Date deliveryOn;

	private Date updateOn;

	private String status;

	private String strLocation;

	private String strMessage;

	private String operationUserName;

	public TblTask() {
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}


	public Date getDeliveryOn() {
		return deliveryOn;
	}



	public void setDeliveryOn(Date deliveryOn) {
		this.deliveryOn = deliveryOn;
	}




	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStrLocation() {
		return this.strLocation;
	}

	public void setStrLocation(String strLocation) {
		this.strLocation = strLocation;
	}

	public String getStrMessage() {
		return this.strMessage;
	}

	public void setStrMessage(String strMessage) {
		this.strMessage = strMessage;
	}



	public Date getUpdateOn() {
		return updateOn;
	}



	public void setUpdateOn(Date updateOn) {
		this.updateOn = updateOn;
	}



	public String getOperationUserName() {
		return operationUserName;
	}



	public void setOperationUserName(String operationUserName) {
		this.operationUserName = operationUserName;
	}



	



}