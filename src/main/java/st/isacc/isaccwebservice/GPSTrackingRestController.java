package st.isacc.isaccwebservice;


import java.sql.Timestamp;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Component;

import com.sun.jersey.api.core.InjectParam;

import st.isacc.entity.TblCurrentLoc;
import st.isacc.entity.TblHistoryLoc;
import st.isacc.entity.TblUser;
import st.isacc.entity.UserStatus;
import st.isacc.service.GPSTrackingManageService;

@Component
@Path("trackAPI")
public class GPSTrackingRestController {

	private UserStatus userError;
	@InjectParam
	private GPSTrackingManageService gpsTrackingService;

	public GPSTrackingRestController() {

	}

	@POST
	@Path("tracking")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public UserStatus gpsTracking(@FormParam("userName") String userName,@FormParam("dblLat") double dblLat,@FormParam("dblLong") double dblLong,@FormParam("strTripId") String strTripId) {

		//as the gps tracking should do two steps.
		//1.should update the latest gps location to TblCurrentLoc
		//2.should insert the gps location to TblHistoryLoc
		
		TblUser tUser= new TblUser();
		tUser.setUsername(userName);
		
		TblHistoryLoc tblHistoryLoc= new TblHistoryLoc();
		tblHistoryLoc.setOperatorId(userName);
		tblHistoryLoc.setDblLat(dblLat);
		tblHistoryLoc.setDblLong(dblLong);
		tblHistoryLoc.setStrTripId(strTripId);
		tblHistoryLoc.setTimestamp(new Timestamp(System.currentTimeMillis()));
		
		TblCurrentLoc tblCurrentLoc= new TblCurrentLoc();
		tblCurrentLoc.setStrUserName(userName);
		tblCurrentLoc.setDblLat(dblLat);
		tblCurrentLoc.setDblLong(dblLong);
		tblCurrentLoc.setStrTripId(strTripId);
		tblCurrentLoc.setTimestamp(new Timestamp(System.currentTimeMillis()));
		
		if(gpsTrackingService.getCurrentGPSTrackingByUser(tUser)!=null&&gpsTrackingService.getCurrentGPSTrackingByUser(tUser).size()>0){
			TblCurrentLoc tblUpdateLoc= gpsTrackingService.getCurrentGPSTrackingByUser(tUser).get(0);
			tblUpdateLoc.setDblLat(dblLat);
			tblUpdateLoc.setDblLong(dblLong);
			tblUpdateLoc.setStrTripId(strTripId);
			gpsTrackingService.updateAGPSTrackingForCurrent(tblUpdateLoc);
			gpsTrackingService.creatAGPSTrackingForHistory(tblHistoryLoc);
		}else{
			gpsTrackingService.creatAGPSTrackingForCurrent(tblCurrentLoc);
			gpsTrackingService.creatAGPSTrackingForHistory(tblHistoryLoc);
		}
		
		userError = new UserStatus();
		userError.setStatus(1);
		userError.setCode(0);
		userError.setMsg("GPS tracking successfully.");
		return userError;

	}
	
	
}
