package st.isacc.web;


/**
 * REST Web Service For Simple SpringMVC REST
 *
 * @author lihaiyun add test comment comment three
 */
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javapns.Push;
import javapns.communication.exceptions.CommunicationException;
import javapns.communication.exceptions.KeystoreException;
import javapns.notification.PushedNotification;
import javapns.notification.ResponsePacket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import st.isacc.service.BrandManageService;
import st.isacc.util.CommonUtil;

import com.sun.jersey.api.core.InjectParam;



@Controller
public class DemoController {

	@Autowired
	private BrandManageService brandManagerService;
	
	@RequestMapping("/")
	public String welcomeHandler() {
		
	    System.out.println(  brandManagerService.getAllBrandList().size());
	    sendAPS();
		return "welcome";
	}
	
	public static void sendAPS(){
		try {
			InputStream filePath = CommonUtil.getKeyStoreStream();
			 List<PushedNotification> notifications = Push.alert("Test", filePath,"P@ssw0rd", false, new String[]{"e3e1924d8af3d51d3e471f34727a5919c0689e16a5ade55b384c5a55b4742965"});
			 //close InputStream
			 filePath.close();
			 //Codes below just for debugging
			 for (PushedNotification notification : notifications) {
                 if (notification.isSuccessful()) {
                         /* Apple accepted the notification and should deliver it */  
                         System.out.println("Push notification sent successfully to: " +
                                                         notification.getDevice().getToken());
                         /* Still need to query the Feedback Service regularly */  
                 } else {
                          
                         Exception theProblem = notification.getException();
                         theProblem.printStackTrace();

                         /* If the problem was an error-response packet returned by Apple, get it */  
                         ResponsePacket theErrorResponse = notification.getResponse();
                         if (theErrorResponse != null) {
                                 System.out.println(theErrorResponse.getMessage());
                         }
                 }
         }
		} catch (CommunicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (KeystoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
