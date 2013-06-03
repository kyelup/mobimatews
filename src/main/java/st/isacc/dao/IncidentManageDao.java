package st.isacc.dao;

import java.util.List;

import javax.swing.text.StyledEditorKit.BoldAction;

import st.isacc.entity.TblImageInfo;
import st.isacc.entity.TblIncident;

public interface IncidentManageDao {
	
	public List<TblIncident> getIncident(String incidentStatus,String username);
	
	public int updateIncident(String id,String incidentStatus);
	
	public int deleteIncident(String id);
	
	public int updatIncidentDetail(String incidentType,String messageText,String dblLat,String dblLong,
			String urgency,String incidentLocation,String strImageFileName,  String id);
	
	public boolean createIncident(TblIncident tblIncident);
	
	public boolean createImageInfo(TblImageInfo tblImageInfo);
}
