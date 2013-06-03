package st.isacc.isaccwebservice;

import javax.ws.rs.Path;

import org.springframework.stereotype.Component;

import st.isacc.service.MessageManageService;

import com.sun.jersey.api.core.InjectParam;

@Component
@Path("messageAPI")
public class MessageRestController {
	@InjectParam
	private MessageManageService messageManageService;
}
