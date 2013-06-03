package st.isacc.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tblMessageReadStatu database table.
 * 
 */
@Entity
public class TblMessageReadStatu implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public static enum STATUS {
		
		CREATED("Created"), DELIVERED("Delivered"), READED("Readed");
		
		private String name;

		private STATUS(String name) {
			this.name = name;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
		
	}

	@EmbeddedId
	private TblMessageReadStatuPK id;

	private String status;

	public TblMessageReadStatu() {
	}

	public TblMessageReadStatuPK getId() {
		return this.id;
	}

	public void setId(TblMessageReadStatuPK id) {
		this.id = id;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}