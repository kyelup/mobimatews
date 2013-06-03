package st.isacc.dao;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import st.isacc.entity.TblTask;

@Repository
public class TblTaskManageDaoImpl implements TblTaskManageDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	public List<TblTask> getTaskListByUserName(String username) {
		
		return this.sessionFactory.getCurrentSession()
				.createQuery("from  TblTask as task where task.operationUserName='"+username+"'order by createdOn desc").list();
	}

	public boolean createTask(TblTask tblTask) {
//		String status, String strLocation, String strMessage,
		//String operationUserName
		/*TblTask tblTask = new TblTask();
		tblTask.setStatus(status);
		tblTask.setStrLocation(strLocation);
		tblTask.setStrMessage(strMessage);
		tblTask.setOperationUserName(operationUserName);
		tblTask.setCreatedOn(new Date());
		tblTask.setDeliveryOn(new Date());
		tblTask.setUpdateOn(new Date());*/
	   Object object = this.sessionFactory.getCurrentSession().save(tblTask);
		
		return Integer.valueOf(object.toString())>0;
		
		
	}

	public int updateTaskStatus(int taskId, String taskStatus) {
		
		int total = this.sessionFactory.getCurrentSession().createQuery("update TblTask t set t.status='"+
	    taskStatus+"'where t.id=" +taskId).executeUpdate();
	
		return total;
		
	}

}
