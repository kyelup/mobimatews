package st.isacc.isaccwebservice;


import java.security.MessageDigest;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.springframework.stereotype.Component;
import com.sun.jersey.api.core.InjectParam;

import st.isacc.entity.TblDeviceToken;
import st.isacc.entity.TblUser;
import st.isacc.entity.UserErrorList;
import st.isacc.entity.UserStatus;
import st.isacc.service.UserManageService;

@Component
@Path("userAPI")
public class UserRestController {

	private UserStatus userError;
	@InjectParam
	private UserManageService userManageService;

	public UserRestController() {

	}

	@Path("login")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@POST
	public UserStatus loginInformation(@FormParam("username") String username,
			@FormParam("password") String password) {

		/*
		 * String username = formParams.getFirst("username"); String
		 * password=formParams.getFirst("password");
		 */
		// MultivaluedMap<String, String> formParams

		UserErrorList userErrorList = new UserErrorList("failed",
				"password error", false);
		List<UserErrorList> list = new ArrayList<UserErrorList>();
		list.add(userErrorList);
		String msg = "Request parameter is missing, Either one or all (username or password).";

		password=password.toUpperCase();
		if (username == null || password == null) {
			userError = new UserStatus();
			userError.setStatus(0);
			userError.setCode(0);
			userError.setMsg(msg);

		} else if (username != null) {

			List<TblUser> userListByUsername = userManageService
					.getUserListByUsername(username);
			int size = userListByUsername.size();
			if (size == 0) {
				userError = new UserStatus();
				userError.setStatus(0);
				userError.setCode(0);
				userError.setMsg("User is not exist!please check.");
			}

			else if (!(size == 0)) {

				
				 TblUser loginUser= userListByUsername.get(0);
				String Password = loginUser.getPassword();
				if (!password.equals(Password)) {
					userError = new UserStatus();
					userError.setStatus(0);
					userError.setCode(0);
					userError.setMsg("password is wrong!please check.");
					//userError.setObj(list);

				} else if (password.equals(Password)) {
					TblUser tblUser = userListByUsername.get(0);
					List<TblUser> userlist = new ArrayList<TblUser>();
					userlist.add(tblUser);
					userError = new UserStatus();
					userError.setStatus(1);
					userError.setCode(0);
					userError.setObj(userlist);
				}

			}
		}
		return userError;

	}

	@GET
	@Path("logout/username/{username}")
	@Produces(MediaType.APPLICATION_JSON)
	public UserStatus userLogout(@PathParam("username") String username) {
		List<TblUser> userListByUsername = userManageService
				.getUserListByUsername(username);
		int size = userListByUsername.size();

		if (size > 0) {

			userError = new UserStatus();
			userError.setStatus(1);
			userError.setCode(0);
			userError.setMsg("login successfully.");
			
		} else {
			
			userError = new UserStatus();
			userError.setStatus(0);
			userError.setCode(0);
			userError.setMsg("unknow reason, failed update online statu");
		}
		return userError;

	}

	@POST
	@Path("register")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public UserStatus userRegister(@FormParam("username") String username,
			@FormParam("password") String password) throws Exception {

		if (username == null || username.equals("") || password == null
				|| password.equals("")) {

			userError = new UserStatus();
			userError.setStatus(0);
			userError.setCode(2);
			userError.setMsg("The username and password cannot be empty ");

		}

		else {
			int size = userManageService.getUserListByUsername(username).size();
			if (size > 0) {
				userError = new UserStatus();
				userError.setStatus(0);
				userError.setCode(2);
				userError.setMsg("the user exist");
			}

			else {
				TblUser user = new TblUser();
				String sPassword = "";
				MessageDigest md = MessageDigest.getInstance("SHA-256");
				md.update(password.getBytes("GBK"));
				for (byte b : md.digest()) {
					String Password = String.format("%02X", b);
					sPassword = sPassword + Password;
				}
				user.setPassword(sPassword);
				user.setUsername(username);
				user.setCreateOn(new Timestamp(System.currentTimeMillis()));
				user.setLastLogin(new Timestamp(System.currentTimeMillis()));
				if (userManageService.createUser(user)) {
					userError = new UserStatus();
					userError.setStatus(1);
					userError.setCode(2);
					userError.setMsg("Congratulations, register success");
				} else {
					userError = new UserStatus();
					userError.setStatus(0);
					userError.setCode(2);
					userError.setMsg("Congratulations, register fail");
				}
			}
		}

		return userError;

	}
	
	
	@Path("registerDevice")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@POST
	public UserStatus registerDeviceToken(@FormParam("username") String username,
			@FormParam("strDeviceToken") String strDeviceToken) {

		
		if (username == null || username.equals("") || strDeviceToken == null
				|| strDeviceToken.equals("")) {

			userError = new UserStatus();
			userError.setStatus(0);
			userError.setCode(0);
			userError.setMsg("The username and deviceToken cannot be empty ");

		}else{
			
			List<TblDeviceToken> devices = userManageService.getRegisterDevicesByuserName(username);
			TblDeviceToken tbl=null;
		    //each time should update the devicetoken avoid a account use different device
			if(devices.size()>0){
				tbl=devices.get(0);
			
			}else{
				tbl=new TblDeviceToken();
				tbl.setOperationName(username);
			}
			tbl.setStrDeviceToken(strDeviceToken);
			userManageService.registerDevice(tbl);
			userError = new UserStatus();
			userError.setStatus(1);
			userError.setCode(0);
			userError.setMsg("register apns successfully. ");
		}
		return userError;

	}
}
