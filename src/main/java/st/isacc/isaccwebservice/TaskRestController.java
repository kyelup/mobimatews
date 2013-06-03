package st.isacc.isaccwebservice;

import java.util.Date;
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

import st.isacc.entity.TblTask;
import st.isacc.entity.UserStatus;
import st.isacc.service.TaskManageService;

import com.sun.jersey.api.core.InjectParam;

@Component
@Path("task")
public class TaskRestController {

	private UserStatus  status;
	
	@InjectParam
	private TaskManageService manageService;
	
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("getAssinedTaskByUserName/username/{username}")
	public UserStatus getTaskInformation(@PathParam("username") String username){
		List<TblTask> list = manageService.getTaskListByUserName(username);
		if(list.size()>0)
		{
			status=new UserStatus();
			status.setStatus(1);
			status.setObj(list);
			status.setCode(1);
		}
		
		else{
		status=new UserStatus();
		status.setStatus(0);
		status.setMsg("not found data");
		status.setCode(1);
		}
		
		
		return status;
		
	}
	
	@Path("createTask")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public UserStatus createTask(@FormParam("status") String taskStatus,@FormParam("strLocation") String strLocation,@FormParam("strMessage") String strMessage,
			@FormParam("operationUserName") String operationUserName){
		TblTask tblTask = new TblTask();
		tblTask.setStatus(taskStatus);
		tblTask.setStrLocation(strLocation);
		tblTask.setStrMessage(strMessage);
		tblTask.setOperationUserName(operationUserName);
		tblTask.setCreatedOn(new Date());
		tblTask.setDeliveryOn(new Date());
		tblTask.setUpdateOn(new Date());
		
		if(manageService.createTask(tblTask))
		{
		status=new UserStatus();
		status.setStatus(1);
		status.setMsg("insert data success");
		status.setCode(1);
		}
		else{
			status=new UserStatus();
			status.setStatus(0);
			status.setMsg("insert data fail");
			status.setCode(1);
		}
		
		return status;
		
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("updateTaskStatus/taskId/{taskId}/taskStatus/{taskStatus}")
	public UserStatus updateTaskStatus(@PathParam("taskId") int taskId,@PathParam("taskStatus") String taskStatus){
		if(manageService.updateTaskStatus(taskId, taskStatus)>0){
			status=new UserStatus();
			status.setStatus(1);
			status.setMsg("update data success");
			status.setCode(1);
		}
		
		else{
			status=new UserStatus();
			status.setStatus(0);
			status.setMsg("update data fail");
			status.setCode(1);
		}
		
		
		
		return status;
		
	}
	
}
