package st.isacc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import st.isacc.dao.MessageManageDao;

@Service
public class MessageManageServiceImpl implements MessageManageService {

	@Autowired(required = true)
	private MessageManageDao messageManageDao;
	
	
	
}
