package st.isacc.entity;

import java.awt.List;

import javax.persistence.Entity;

@Entity
public class UserErrorList{
	
	    private boolean status;
		
		private String login;
		
		private String message;
		
		public UserErrorList(){
			
		}

		public UserErrorList(String login,String message,boolean status){
			this.status=status;
			this.login=login;
			this.message=message;
		}

		public boolean isStatus() {
			return status;
		}

		public void setStatus(boolean status) {
			this.status = status;
		}

		public String getLogin() {
			return login;
		}

		public void setLogin(String login) {
			this.login = login;
		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}

}
