package st.isacc.dao;


import java.util.List;

import st.isacc.entity.TblCurrentLoc;
import st.isacc.entity.TblHistoryLoc;
import st.isacc.entity.TblUser;

public interface GPSTrackingManageDao {
	public  boolean creatAGPSTrackingForHistory(TblHistoryLoc gpsLoc);
	public  boolean creatAGPSTrackingForCurrent(TblCurrentLoc gpsLoc);
	public  boolean updateAGPSTrackingForCurrent(TblCurrentLoc gpsLoc);
	public  List<TblCurrentLoc> getCurrentGPSTrackingByUser(TblUser user);

}
