package st.isacc.entity;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

import java.sql.Timestamp;
import java.util.Date;


/**
 * The persistent class for the tblUser database table.
 * 
 */
@Entity
@Table(name="tbluser")
@XmlRootElement
public class TblUser implements Serializable {
	private static final long serialVersionUID = 1L;
	public static enum STATUS {

		OFFLINE((byte) 1), ONLINE((byte) 2);

		private byte state;

		private STATUS(byte state) {
			this.state = state;
		}

		public byte getState() {
			return state;
		}

		public void setState(byte state) {
			this.state = state;
		}

	}
	
	@Id
	@Column(name = "ID")
	@GeneratedValue
	private int id;

	private String username;
	private String password;
	private byte online;
	private Timestamp createOn;
	private Timestamp lastLogin;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public byte getOnline() {
		return online;
	}
	public void setOnline(byte online) {
		this.online = online;
	}

	public Timestamp getCreateOn() {
		return createOn;
	}
	public void setCreateOn(Timestamp createOn) {
		this.createOn = createOn;
	}
	public Timestamp getLastLogin() {
		return lastLogin;
	}
	public void setLastLogin(Timestamp lastLogin) {
		this.lastLogin = lastLogin;
	}
	public TblUser(int id, String username, String password, byte online,
			Timestamp createOn, Timestamp lastLogin) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.online = online;
		this.createOn = createOn;
		this.lastLogin = lastLogin;
	}
	public TblUser() {
		super();
	}

	


}