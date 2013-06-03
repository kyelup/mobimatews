package st.isacc.service;

import java.util.List;

import st.isacc.entity.TblTask;

public interface TaskManageService {
	public List<TblTask> getTaskListByUserName(String username);
	
	public boolean createTask(TblTask tblTask);
	
	public int updateTaskStatus(int taskId, String taskStatus);
}
