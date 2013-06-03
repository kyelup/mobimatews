package st.isacc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import st.isacc.dao.IncidentManageDao;
import st.isacc.entity.TblImageInfo;
import st.isacc.entity.TblIncident;

@Service
public class IncidentManageServiceImpl implements IncidentManageService{

	@Autowired(required = true)
	private IncidentManageDao incidentDao;

	@Transactional
	public List<TblIncident> getIncidentByStatusAndUserName(String incidentStatus, String username) {
		// TODO Auto-generated method stub
		return incidentDao.getIncident(incidentStatus, username);
	}

	@Transactional
	public int updateIncidentStatusById(String id, String incidentStatus) {
		// TODO Auto-generated method stub
		return incidentDao.updateIncident(id, incidentStatus);
	}
	
	@Transactional
	public int deleteIncidentById(String id) {
		// TODO Auto-generated method stub
		return incidentDao.deleteIncident(id);
	}

	@Transactional
	public int updatIncidentDetailById(String incidentType, String messageText,
			String dblLat, String dblLong, String urgency,
			String incidentLocation, String strImageFileName, String id) {
		// TODO Auto-generated method stub
		return incidentDao.updatIncidentDetail(incidentType, messageText, dblLat, dblLong, urgency, incidentLocation, strImageFileName, id);
	}

	@Transactional
	public boolean createIncident(TblIncident tblIncident) {
		// TODO Auto-generated method stub
		return incidentDao.createIncident(tblIncident);
	}

	@Transactional
	public boolean createImageInfo(TblImageInfo tblImageInfo) {
		// TODO Auto-generated method stub
		return incidentDao.createImageInfo(tblImageInfo);
	}
	
	
}
