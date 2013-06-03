package st.isacc.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tblOnlineUser database table.
 * 
 */
@Entity
public class TblOnlineUser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String device;
	
	private String userName;
	
	private String strDeviceToken;

	private String operatorId;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getStrDeviceToken() {
		return strDeviceToken;
	}

	public void setStrDeviceToken(String strDeviceToken) {
		this.strDeviceToken = strDeviceToken;
	}

	public TblOnlineUser() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDevice() {
		return this.device;
	}

	public void setDevice(String device) {
		this.device = device;
	}

	public String getOperatorId() {
		return operatorId;
	}

	public void setOperatorId(String operatorId) {
		this.operatorId = operatorId;
	}

	

}