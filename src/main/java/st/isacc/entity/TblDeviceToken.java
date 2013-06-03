package st.isacc.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tblDeviceToken database table.
 * 
 */
@Entity
public class TblDeviceToken implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String strDeviceToken;

	private String operationName;

	public TblDeviceToken() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStrDeviceToken() {
		return this.strDeviceToken;
	}

	public void setStrDeviceToken(String strDeviceToken) {
		this.strDeviceToken = strDeviceToken;
	}

	public String getOperationName() {
		return operationName;
	}

	public void setOperationName(String operationName) {
		this.operationName = operationName;
	}



	

}