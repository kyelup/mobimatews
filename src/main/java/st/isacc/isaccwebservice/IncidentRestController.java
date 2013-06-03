package st.isacc.isaccwebservice;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.ws.rs.GET;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Component;
import com.sun.jersey.api.core.InjectParam;
import st.isacc.entity.ErrorMessage;
import st.isacc.entity.TblImageInfo;
import st.isacc.entity.TblIncident;
import st.isacc.entity.RestResponse;
import st.isacc.service.IncidentManageService;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataParam;
import st.isacc.util.FileManager;

@Component
@Path("incidentAPI")
public class IncidentRestController {
	@InjectParam
	private IncidentManageService incidentManageService;

	public IncidentRestController() {
		super();
	}

	/**
	 * Get Incident By Incident incidentStatus or username
	 * 
	 * @param status
	 * @param username
	 * @return
	 */
	@GET
	@Path("getIncidentByStatusAndUserName/incidentStatus/{incidentStatus}/username/{username}")
	@Produces("application/json")
	public RestResponse getIncident(
			@PathParam("incidentStatus") String incidentStatus,
			@PathParam("username") String username) {
		System.out.println(incidentStatus + "," + username);
		RestResponse restResponse = new RestResponse();
		// error message
		ErrorMessage errorMessage = new ErrorMessage();
		errorMessage.setStatus("No image data found");
		errorMessage.setResult(0);

		List<TblIncident> list = incidentManageService
				.getIncidentByStatusAndUserName(incidentStatus, username);
		if (list.size() == 0) {
			restResponse.setObj(errorMessage);
			restResponse.setStatus(0);
			restResponse.setCode(0);
		} else {
			restResponse.setObj(list);
			restResponse.setStatus(1);
			restResponse.setCode(0);
		}
		return restResponse;
	}

	/**
	 * Update Incident Status By id
	 * 
	 * @param incidentStatus
	 * @return
	 */
	@GET
	@Path("updateIncidentStatus/id/{id}/incidentStatus/{incidentStatus}")
	@Produces("application/json")
	public RestResponse updateIncident(@PathParam("id") String id,
			@PathParam("incidentStatus") String incidentStatus) {
		System.out.println(id + "," + incidentStatus);
		RestResponse restResponse = new RestResponse();

		int row = incidentManageService.updateIncidentStatusById(id,
				incidentStatus);
		if (row > 0) {
			restResponse.setStatus(1);
			restResponse.setCode(1);
			restResponse.setMsg("update data success");
		} else {
			restResponse.setStatus(0);
			restResponse.setCode(1);
			restResponse.setMsg("update data fail");
		}

		return restResponse;
	}

	/**
	 * Delete Incident By Id
	 * 
	 * @param Id
	 * @return
	 */
	@GET
	@Path("deleteIncidentById/id/{id}")
	@Produces("application/json")
	public RestResponse deleteIncident(@PathParam("id") String id) {
		System.out.println(id);
		RestResponse restResponse = new RestResponse();
		int row = incidentManageService.deleteIncidentById(id);
		if (row > 0) {
			restResponse.setStatus(1);
			restResponse.setCode(1);
			restResponse.setMsg("delete data success");
		} else {
			restResponse.setStatus(0);
			restResponse.setCode(1);
			restResponse.setMsg("delete data fail");
		}
		return restResponse;
	}

	/**
	 * Update Incident Detail By id
	 * 
	 * @param incidentType
	 * @param messageText
	 * @param dblLat
	 * @param dblLong
	 * @param urgency
	 * @param incidentLocation
	 * @param strImageFileName
	 * @param id
	 * @return
	 */
	@POST
	@Path("updateIncidentDetail")
	@Produces("application/json")
	public RestResponse updatIncidentDetail(
			@FormParam("incidentType") String incidentType,
			@FormParam("messageText") String messageText,
			@FormParam("dblLat") String dblLat,
			@FormParam("dblLong") String dblLong,
			@FormParam("urgency") String urgency,
			@FormParam("incidentLocation") String incidentLocation,
			@FormParam("strImageFileName") String strImageFileName,
			@FormParam("id") String id) {
		RestResponse restResponse = new RestResponse();

		int row = incidentManageService.updatIncidentDetailById(incidentType,
				messageText, dblLat, dblLong, urgency, incidentLocation,
				strImageFileName, id);
		if (row > 0) {
			restResponse.setStatus(1);
			restResponse.setCode(1);
			restResponse.setMsg("update data success");
		} else {
			restResponse.setStatus(0);
			restResponse.setCode(1);
			restResponse.setMsg("update data fail");
		}

		return restResponse;
	}

	/**
	 * Create a new Incident using userName
	 * 
	 * @param incidentType
	 * @param messageText
	 * @param dblLat
	 * @param dblLong
	 * @param urgency
	 * @param incidentLocation
	 * @param strImageFileName
	 * @param incidentStatus
	 * @param userName
	 * @param incidentNo
	 * @return
	 */
	@POST
	@Path("createIncident")
	@Produces("application/json")
	public RestResponse createIncident(
			@FormParam("incidentType") String incidentType,
			@FormParam("messageText") String messageText,
			@FormParam("dblLat") String dblLat,
			@FormParam("dblLong") String dblLong,
			@FormParam("urgency") String urgency,
			@FormParam("incidentLocation") String incidentLocation,
			@FormParam("strImageFileName") String strImageFileName,
			@FormParam("incidentStatus") String incidentStatus,
			@FormParam("username") String username,
			@FormParam("incidentNo") String incidentNo) {
		RestResponse restResponse = new RestResponse();

		TblIncident tblIncident = new TblIncident();
		tblIncident.setIncidentType(incidentType);
		tblIncident.setMessageText(messageText);
		tblIncident.setDblLat(Double.parseDouble(dblLat));
		tblIncident.setDblLong(Double.parseDouble(dblLong));
		tblIncident.setUrgency(urgency);
		tblIncident.setIncidentLocation(incidentLocation);
		tblIncident.setStrImageFileName(strImageFileName);
		tblIncident.setIncidentStatus(incidentStatus);
		tblIncident.setUsername(username);
		tblIncident.setIncidentNo(incidentNo);
		Date dt = new Date();
		tblIncident.setCreateOn(new Timestamp(dt.getTime()));

		boolean result = incidentManageService.createIncident(tblIncident);
		if (result == true) {
			restResponse.setStatus(1);
			restResponse.setCode(1);
			restResponse.setMsg("insert data success");
		} else {
			restResponse.setStatus(0);
			restResponse.setCode(1);
			restResponse.setMsg("insert data fail");
		}

		return restResponse;
	}

	@POST
	@Path("/upload")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public RestResponse uploadFile(
			@FormDataParam("file") InputStream uploadedInputStream,
			@FormDataParam("file") FormDataContentDisposition fileDetail,
			@FormDataParam("username") String username,
			@FormDataParam("dblLat") double dblLat,
			@FormDataParam("dblLong") double dblLong,
			@FormDataParam("strRemark") String strRemark,
			@FormDataParam("incidentLocation") String incidentLocation,
			@FormDataParam("incidentNo") String incidentNo,
			@FormDataParam("incidentStatus") String incidentStatus,
			@FormDataParam("incidentType") String incidentType,
			@FormDataParam("messageText") String messageText,
			@FormDataParam("urgency") String urgency) {

		String fileRealName = fileDetail.getFileName();
		String fileExtension = FileManager.getExtensionName(fileRealName);
		String handleFileName = generateRandomFilename() + fileExtension;

		String uploadedFileLocation = "d://uploaded/" + handleFileName;

		TblImageInfo tblImageInfo = new TblImageInfo();
		tblImageInfo.setDblLat(dblLat);
		tblImageInfo.setDblLong(dblLong);
		tblImageInfo.setStrRemark(strRemark);
		tblImageInfo.setOperatorName(username);
		tblImageInfo.setDateTimeStamp(new Timestamp(new Date().getTime()));
		tblImageInfo.setStrImageFilename(handleFileName);

		TblIncident tblIncident = new TblIncident();
		tblIncident.setCreateOn(new Timestamp(new Date().getTime()));
		tblIncident.setDblLat(dblLat);
		tblIncident.setDblLong(dblLong);
		tblIncident.setIncidentLocation(incidentLocation);
		tblIncident.setIncidentNo(incidentNo);
		tblIncident.setIncidentStatus(incidentStatus);
		tblIncident.setIncidentType(incidentType);
		tblIncident.setMessageText(messageText);
		tblIncident.setStrImageFileName(handleFileName);
		tblIncident.setUsername(username);
		tblIncident.setUrgency(urgency);

		// save it
		boolean saveStatus = writeToFile(uploadedInputStream,
				uploadedFileLocation);
		RestResponse restResponse = new RestResponse();
		boolean allOperationStatus = false;
		if (saveStatus) {
			boolean saveImageStatus = incidentManageService
					.createImageInfo(tblImageInfo);
			boolean saveIncidentStatus = incidentManageService
					.createIncident(tblIncident);
			if (saveImageStatus && saveIncidentStatus) {
				allOperationStatus = true;
			}
		}

		if (allOperationStatus) {
			String msg = "File uploaded to server success. ";
			restResponse.setStatus(1);
			restResponse.setCode(1);
			restResponse.setMsg(msg);
		} else {
			String msg = "File uploaded to server failed.";
			restResponse.setStatus(0);
			restResponse.setCode(0);
			restResponse.setMsg(msg);
		}

		return restResponse;

	}

	// save uploaded file to new location
	private boolean writeToFile(InputStream uploadedInputStream,
			String uploadedFileLocation) {

		boolean uploadStatus = false;
		try {
			OutputStream out = new FileOutputStream(new File(
					uploadedFileLocation));
			int read = 0;
			byte[] bytes = new byte[1024];

			out = new FileOutputStream(new File(uploadedFileLocation));
			while ((read = uploadedInputStream.read(bytes)) != -1) {
				out.write(bytes, 0, read);
			}
			uploadStatus = true;
			out.flush();
			out.close();
		} catch (IOException e) {

			e.printStackTrace();
		}

		return uploadStatus;
	}

	/*
	 * 生成随机文件名
	 */
	public String generateRandomFilename() {
		String RandomFilename = "";
		Random rand = new Random();
		int random = rand.nextInt();

		Calendar calCurrent = Calendar.getInstance();
		int intDay = calCurrent.get(Calendar.DATE);
		int intMonth = calCurrent.get(Calendar.MONTH) + 1;
		int intYear = calCurrent.get(Calendar.YEAR);
		String now = String.valueOf(intYear) + "_" + String.valueOf(intMonth)
				+ "_" + String.valueOf(intDay) + "_";

		RandomFilename = now
				+ String.valueOf(random > 0 ? random : (-1) * random) + ".";

		return RandomFilename;
	}

}
