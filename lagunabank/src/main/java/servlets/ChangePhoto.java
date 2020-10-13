package servlets;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import bs.ClientBs;
import bs.RemovePhotoBs;
import pojos.Client;

public class ChangePhoto extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ChangePhoto() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("Login");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession httpSession = request.getSession();
		Client client = (Client) httpSession.getAttribute("client");
		Part filePart = request.getPart("photoInput");
		if(!client.getPhoto().equals("img/profileMan.png") && !client.getPhoto().equals("img/profileWoman.png") && !client.getPhoto().equals("img/profileNeutral.png")) {
			RemovePhotoBs.deletePhoto(client);
		}
	    String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
	    String path="/lagunabank/src/main/webapp/img/";
	    File uploads = new File(path);
	    uploads.mkdirs();
	    File file = File.createTempFile("profilePhotoClient"+client.getIdClient()+"-",fileName, uploads);
	    try (InputStream input = filePart.getInputStream()){
	        Files.copy(input, file.toPath(), StandardCopyOption.REPLACE_EXISTING);
	    } catch (Exception e) {
			System.out.println("No se copio la foto");
		}
	    if(ClientBs.changeProfilePhoto(path + file.getName(), client)) {
	    	client = ClientBs.getClientById(client.getIdClient());
	    	httpSession.setAttribute("client", client);
	    	response.sendRedirect("Profile");
	    }
	}
}
