package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import bs.ClientBs;
import bs.LoginBs;
import bs.SavedAccountsBs;
import pojos.Client;

public class SavedAccounts extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public SavedAccounts() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession httpSession = request.getSession();
		if(httpSession.getAttribute("sessionState") == LoginBs.SESSION_ACTIVE) {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("jsp/savedAccounts.jsp");
			Client client = (Client) httpSession.getAttribute("client");
			request.setAttribute("client", client);
			requestDispatcher.forward(request, response);
		} else {
			response.sendRedirect("Login");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("jsp/savedAccounts.jsp");
		HttpSession httpSession = request.getSession();
		Client client = (Client) httpSession.getAttribute("client");
		String message = SavedAccountsBs.addAccount(client.getIdClient(), request.getParameter("idClientTxt"), request.getParameter("aliasTxt"), client.getSavedAccounts());
		if(message == null) {
			client = ClientBs.getClientById(client.getIdClient());
			httpSession.setAttribute("client", client);
			request.setAttribute("client", client);
			requestDispatcher.forward(request, response);
		} else {
			String alias = request.getParameter("aliasTxt"); 
			request.setAttribute("alias", alias);
			request.setAttribute("message", message);
			request.setAttribute("client", client);
			requestDispatcher.forward(request, response);
		}
		
	}

}
