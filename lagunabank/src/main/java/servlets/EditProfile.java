package servlets;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import bs.ClientBs;
import bs.EditProfileBs;
import bs.LoginBs;
import bs.UserBs;
import pojos.Client;

public class EditProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EditProfile() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession httpSession = request.getSession();
		if (httpSession.getAttribute("sessionState") == LoginBs.SESSION_ACTIVE) {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("jsp/editProfile.jsp");
			pojos.Client client = (Client) httpSession.getAttribute("client");
			request.setAttribute("client", client);
			request.setAttribute("user", UserBs.getUserByClientId(client.getIdClient()));
			requestDispatcher.forward(request, response);
		} else {
			response.sendRedirect("Login");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String, String[]> parameterMap = request.getParameterMap();
		HttpSession httpSession = request.getSession();
		Client client = (Client)httpSession.getAttribute("client");
		String message = EditProfileBs.getEditProfileMessage(parameterMap, client);
		if (message == null) {
			Client tmpClient = EditProfileBs.getTmpClient(parameterMap);
			if(ClientBs.editClient(tmpClient, client.getIdClient())) {
				if(UserBs.editUsername(request.getParameter("usernameTxt"), client.getIdClient())) {
					httpSession.setAttribute("client", ClientBs.getClientById(client.getIdClient()));
					httpSession.setAttribute("user", UserBs.getUserByClientId(client.getIdClient()));
					response.sendRedirect("Profile");
				}
			}
		} else if (message == "0" ) {
			Client tmpClient = EditProfileBs.getTmpClient(parameterMap);
			if(ClientBs.editClient(tmpClient, client.getIdClient())) {
				if(UserBs.editUsername(request.getParameter("usernameTxt"), client.getIdClient())) {
					if(UserBs.editPassword(request.getParameter("newPasswordTxt"), client.getIdClient())) {
						httpSession.setAttribute("client", ClientBs.getClientById(client.getIdClient()));
						httpSession.setAttribute("user", UserBs.getUserByClientId(client.getIdClient()));
						httpSession.setAttribute("alert", "alert('La contraseña se ha actualizado correctamente.');");
						response.sendRedirect("Profile");
					}
				}
			}
		} else {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("jsp/editProfile.jsp");
			client = (Client) httpSession.getAttribute("client");
			request.setAttribute("client", client);
			request.setAttribute("user", UserBs.getUserByClientId(client.getIdClient()));
			request.setAttribute("message", message);
			requestDispatcher.forward(request, response);
		}
		
	}

}
