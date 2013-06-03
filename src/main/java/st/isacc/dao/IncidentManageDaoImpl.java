package st.isacc.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import st.isacc.entity.TblImageInfo;
import st.isacc.entity.TblIncident;

@Repository
public class IncidentManageDaoImpl implements IncidentManageDao{
	
	@Autowired
	private SessionFactory sessionFactory;

	public List<TblIncident> getIncident(String incidentStatus, String username) {
		
		String hql = null;
		if(username.equals("") || username == null){
			hql = "from TblIncident where incidentStatus = '"+incidentStatus+"' order by createOn desc";
		}else{
			hql = "from TblIncident where incidentStatus = '"+incidentStatus+"' and username = '"+username+"' order by createOn desc";
		}
		Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	}

	public int updateIncident(String id, String incidentStatus) {
		
		String hql = "update TblIncident set incidentStatus = '"+incidentStatus+"' where id = "+id+"";
		int row = this.sessionFactory.getCurrentSession().createQuery(hql).executeUpdate(); 
		return row;
	}

	public int deleteIncident(String id) {
		
		String hql = "delete TblIncident where id = "+id; 
		int row = this.sessionFactory.getCurrentSession().createQuery(hql).executeUpdate();  
		return row;
	}

	public int updatIncidentDetail(String incidentType, String messageText,
			String dblLat, String dblLong, String urgency,
			String incidentLocation, String strImageFileName, String id) {
		
		String hql = "update TblIncident t set t.incidentType =?,t.messageText=?,t.dblLat=?," +
				"t.dblLong=?,t.urgency=?,t.incidentLocation=?,t.strImageFileName=? " +
				"where id=?";
		Query q = this.sessionFactory.getCurrentSession().createQuery(hql);
		q.setString(0, incidentType);
		q.setString(1, messageText);
		q.setString(2, dblLat);
		q.setString(3, dblLong);
		q.setString(4, urgency);
		q.setString(5, incidentLocation);
		q.setString(6, strImageFileName);
		q.setString(7, id);
		int row = q.executeUpdate();
		return row;
	}

	public boolean createIncident(TblIncident tblIncident) {
		Object o = this.sessionFactory.getCurrentSession().save(tblIncident);
		return Integer.valueOf(o.toString()) > 0;
	}

	public boolean createImageInfo(TblImageInfo tblImageInfo) {
		Object o = this.sessionFactory.getCurrentSession().save(tblImageInfo);
		return Integer.valueOf(o.toString()) > 0;
	}
	
}
