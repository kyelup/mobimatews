package st.isacc.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import st.isacc.entity.TblDeviceToken;
import st.isacc.entity.TblUser;

@Repository
public class TblUserManageDaoImpl implements TblUserManageDao {
	@Autowired
	private SessionFactory sessionFactory;

	public String getPasswordByUsername(String username) {
		String password = (String) this.sessionFactory
				.getCurrentSession()
				.createSQLQuery(
						"select password from TblUser as user where user.username='"
								+ username + "'").uniqueResult();
		return password;
	}

	public List<TblUser> getUserListByUsername(String username) {
		return this.sessionFactory
				.getCurrentSession()
				.createQuery(
						"from TblUser as user where user.username='" + username
								+ "'").list();
	}

	public boolean createUser(TblUser user) {

		Object object = this.sessionFactory.getCurrentSession().save(user);
		return Integer.valueOf(object.toString()) > 0;

	}

	public boolean registerDevice(TblDeviceToken device) {
	    this.sessionFactory.getCurrentSession().saveOrUpdate(device);
		return true;
	}

	public List<TblDeviceToken> getRegisterDevicesByuserName(String username){
		
		return this.sessionFactory
				.getCurrentSession()
				.createQuery(
						"from TblDeviceToken as device where device.operationName='" + username
								+ "'").list();
	}
	
	

}
