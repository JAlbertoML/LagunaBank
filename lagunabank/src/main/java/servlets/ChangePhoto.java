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
import javax.servlet.http.Part;

public class ChangePhoto extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ChangePhoto() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Part filePart = request.getPart("photoInput"); // Obtiene el archivo
	    String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // MSIE fix.

	    //InputStream fileContent = filePart.getInputStream(); //Lo transforma en InputStream

	    String path="img/profilePhotos";
	    File uploads = new File(path); //Carpeta donde se guardan los archivos
	    uploads.mkdirs(); //Crea los directorios necesarios
	    File file = File.createTempFile("cod"+1+"-", "-"+fileName, uploads); //Evita que hayan dos archivos con el mismo nombre

	    try (InputStream input = filePart.getInputStream()){
	        Files.copy(input, file.toPath(), StandardCopyOption.REPLACE_EXISTING);
	    }
	    System.out.println(file.getPath());
	}

}
