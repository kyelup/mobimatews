package st.isacc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import st.isacc.dao.GPSTrackingManageDao;
import st.isacc.entity.TblCurrentLoc;
import st.isacc.entity.TblHistoryLoc;
import st.isacc.entity.TblUser;

@Service
public class GPSTrackingManageServiceImpl implements GPSTrackingManageService {


	@Autowired(required = true)
	private GPSTrackingManageDao      gpsTrackingDao;
	
	@Transactional
	public boolean creatAGPSTrackingForHistory(TblHistoryLoc gpsLoc) {
		// TODO Auto-generated method stub
		return gpsTrackingDao.creatAGPSTrackingForHistory(gpsLoc);
	}

	@Transactional
	public boolean creatAGPSTrackingForCurrent(TblCurrentLoc gpsLoc) {
		// TODO Auto-generated method stub
		return gpsTrackingDao.creatAGPSTrackingForCurrent(gpsLoc);
	}

	@Transactional
	public boolean updateAGPSTrackingForCurrent(TblCurrentLoc gpsLoc) {
		// TODO Auto-generated method stub
		return gpsTrackingDao.updateAGPSTrackingForCurrent(gpsLoc);
	}

	@Transactional
	public List<TblCurrentLoc> getCurrentGPSTrackingByUser(TblUser user) {
		// TODO Auto-generated method stub
		return gpsTrackingDao.getCurrentGPSTrackingByUser(user);
	}

}
