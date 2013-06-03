package st.isacc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import st.isacc.dao.TblTaskManageDao;
import st.isacc.entity.TblTask;

@Service
public class TaskManageServiceImpl implements TaskManageService{

	@Autowired(required = true)
	private TblTaskManageDao taskManageDao ;
	
	@Transactional
	public List<TblTask> getTaskListByUserName(String username) {
		return taskManageDao.getTaskListByUserName(username);
	}
	
	
	@Transactional
	public boolean createTask(TblTask tblTask) {
		return taskManageDao.createTask(tblTask);
	}

	@Transactional
	public int updateTaskStatus(int taskId, String taskStatus) {
		return taskManageDao.updateTaskStatus(taskId, taskStatus);
	}

}
