package st.isacc.entity;
/**
 * logout  success  information
 */
import javax.persistence.Entity;

@Entity
public class UserLogoutList {

	private String logout;
	
	private boolean status;
	
	private String message;

	

	public UserLogoutList(){
		
	}
	
	public UserLogoutList(String logout,boolean status){
	 this.logout=logout;
	 this.status=status;
	}
	
	public UserLogoutList(String logout,boolean status,String message){
		 this.logout=logout;
		 this.status=status;
		 this.message=message;
		}
	
	public String getLogout() {
		return logout;
	}

	public void setLogout(String logout) {
		this.logout = logout;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
