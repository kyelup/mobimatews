package st.isacc.dao;

import java.util.List;

import st.isacc.entity.TblDeviceToken;
import st.isacc.entity.TblUser;

public interface TblUserManageDao {

	public String getPasswordByUsername(String username);

	public List<TblUser> getUserListByUsername(String username);

	public boolean createUser(TblUser user);

	public boolean registerDevice(TblDeviceToken device);
	
	public List<TblDeviceToken> getRegisterDevicesByuserName(String username);
	
	
}
