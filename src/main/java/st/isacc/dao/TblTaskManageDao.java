package st.isacc.dao;

import java.util.List;

import st.isacc.entity.TblTask;

public interface TblTaskManageDao {
	public List<TblTask> getTaskListByUserName(String username) ;
	
	public boolean createTask(TblTask tblTask);
	
	public int updateTaskStatus(int taskId, String taskStatus);
}
