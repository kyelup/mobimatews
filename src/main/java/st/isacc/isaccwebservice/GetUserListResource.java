/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package st.isacc.isaccwebservice;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Component;

import com.sun.jersey.api.core.InjectParam;

import st.isacc.entity.TblAssinedTask;
import st.isacc.service.BrandManageService;

/**
 * REST Web Service
 *
 * @author HoeTeckHwa
 */
@Component
@Path("getUserList")
public class GetUserListResource {

	@InjectParam
	private BrandManageService brandManagerService;
    /**
     * Creates a new instance of GetUserListResource
     */
    public GetUserListResource() {
    }

    /**
     * Retrieves representation of an instance of st.isacc.isaccwebservice.GetUserListResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/json")
    public TblAssinedTask getJson() {
        //TODO return proper representation object
       // throw new UnsupportedOperationException();
    	TblAssinedTask tb= new TblAssinedTask();
    	
         tb.setId(5);
         tb.setIncidentNo("sdfsfdsdf");
         tb.setStatus("OPEN");
         tb.setSupervisor("hello world");
         
         System.out.println( "sdfdsfdsf"+ brandManagerService.getAllBrandList().size());
		return tb;
    }

    /**
     * PUT method for updating or creating an instance of GetUserListResource
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/json")
    public void putJson(String content) {
    }
    
    @GET
    @Path("/upload")
    @Produces(MediaType.APPLICATION_JSON)
	public TblAssinedTask getJsonss() {
		// TODO return proper representation object
		// throw new UnsupportedOperationException();
		TblAssinedTask tb = new TblAssinedTask();

//		tb.setId(5);
		tb.setIncidentNo("sdfsfdsdf");
//		tb.setStatus("OPEN");
		tb.setSupervisor("hello world");

		System.out.println("sdfdsfdsf"
				+ brandManagerService.getAllBrandList().size());
		return tb;
	}
    
//    @GET
//    @Path("/test")
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//	public MyJaxbBean getTest() {
//		MyJaxbBean bean  = new MyJaxbBean();
//		bean.setAge(10);
//		bean.setName("bob");
//		
//		List<String> obj = new ArrayList<String>();
//		obj.add("a");
//		obj.add("b");
//		bean.setObj(obj);
//		
//		return bean;
//	}
    
}
