package st.isacc.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import st.isacc.entity.TblCurrentLoc;
import st.isacc.entity.TblHistoryLoc;
import st.isacc.entity.TblUser;

@Repository
public class GPSTrackingManageDaoImpl implements GPSTrackingManageDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public boolean creatAGPSTrackingForHistory(TblHistoryLoc gpsLoc) {
		
		
		Object object=this.sessionFactory.getCurrentSession().save(gpsLoc);
		return Integer.valueOf(object.toString())>0;
	}

	@Override
	public boolean creatAGPSTrackingForCurrent(TblCurrentLoc gpsLoc) {
		Object object=this.sessionFactory.getCurrentSession().save(gpsLoc);
		return Integer.valueOf(object.toString())>0;
	}

	@Override
	public boolean updateAGPSTrackingForCurrent(TblCurrentLoc gpsLoc) {
		// TODO Auto-generated method stub
        this.sessionFactory.getCurrentSession().saveOrUpdate(gpsLoc);
		return true;
	}

	@Override
	public List<TblCurrentLoc> getCurrentGPSTrackingByUser(TblUser user) {
		return this.sessionFactory.getCurrentSession()
				.createQuery("from TblCurrentLoc as currLoc where currLoc.strUserName='"+user.getUsername()+"'").list();
	}

}
