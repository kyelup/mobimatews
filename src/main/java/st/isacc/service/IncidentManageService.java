package st.isacc.service;

import java.util.List;

import st.isacc.entity.TblImageInfo;
import st.isacc.entity.TblIncident;

public interface IncidentManageService {
	
	public List<TblIncident> getIncidentByStatusAndUserName(String incidentStatus,String username);

	public int updateIncidentStatusById(String id,String incidentStatus);

	public int deleteIncidentById(String id);
	
	public int updatIncidentDetailById(String incidentType,String messageText,String dblLat,String dblLong,
			String urgency,String incidentLocation,String strImageFileName,  String id);

	public boolean createIncident(TblIncident tblIncident);
	
	public boolean createImageInfo(TblImageInfo tblImageInfo);
}
