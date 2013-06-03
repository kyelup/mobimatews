package st.isacc.entity;
/**
 * the error password information
 */
import javax.persistence.Entity;

@Entity
public class UserStatus {

    private int status;
	
	private int code;
	
	private Object obj;
	
	private String msg;
	
	public UserStatus(){
		
	}

	public UserStatus(int status,int code,Object obj){
		this.status=status;
		this.code=code;
		this.obj=obj;
	}
	

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public Object getObj() {
		return obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}
}
