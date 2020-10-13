package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import bs.ClientBs;
import bs.LoginBs;
import bs.RemovePhotoBs;

public class RemoveProfilePhoto extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RemoveProfilePhoto() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession httpSession = request.getSession();
		if (httpSession.getAttribute("sessionState") == LoginBs.SESSION_ACTIVE) {
			pojos.Client client = (pojos.Client) httpSession.getAttribute("client");
			if (ClientBs.removeProfilePhoto(client) && RemovePhotoBs.deletePhoto(client)) {
				client = ClientBs.getClientById(client.getIdClient());
				httpSession.setAttribute("client", client);
				response.sendRedirect("Profile");
			}
		} else {
			response.sendRedirect("Login");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
