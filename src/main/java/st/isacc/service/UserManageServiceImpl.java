package st.isacc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import st.isacc.dao.TblUserManageDao;
import st.isacc.entity.TblDeviceToken;
import st.isacc.entity.TblUser;

@Service
public class UserManageServiceImpl implements UserManageService{

	@Autowired(required = true)
	private TblUserManageDao      tblUserManageDao;
	
	@Transactional
	public String getPasswordByUsername(String username) {
		return tblUserManageDao.getPasswordByUsername(username);
	}

	@Transactional
	public List<TblUser> getUserListByUsername(String username) {
		return tblUserManageDao.getUserListByUsername(username);
	}

	@Transactional
	public boolean createUser(TblUser user) {
		return tblUserManageDao.createUser(user);
	}

	@Transactional
	public  boolean registerDevice(TblDeviceToken device){
		return tblUserManageDao.registerDevice(device);
	}
	@Transactional
	public List<TblDeviceToken> getRegisterDevicesByuserName(String username){
		return tblUserManageDao.getRegisterDevicesByuserName(username);
	}
}
