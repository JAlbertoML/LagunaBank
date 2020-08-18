package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import bs.ClientBs;
import bs.LoginBs;
import pojos.Account;
import pojos.Client;

public class RemoveAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public RemoveAccount() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession httpSession = request.getSession();
		if(httpSession.getAttribute("sessionState") != null) {
			if(httpSession.getAttribute("sessionState") == LoginBs.SESSION_INACTIVE) {
				response.sendRedirect("Client");
			} else {
				response.sendRedirect("Login");
			}
		} else {
			response.sendRedirect("Login");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession httpSession = request.getSession();
		Client client = (Client) httpSession.getAttribute("client");
		Integer idAccountToRemove = Integer.parseInt(request.getParameter("idAccount"));
		for(Account account : client.getSavedAccounts()) {
			if(account.getIdAccout() == idAccountToRemove) {
				client.getSavedAccounts().remove(account);
				break;
			}
		}
		if(ClientBs.editSavedAccount(client.getIdClient(), client.getSavedAccounts())) {
			httpSession.setAttribute("client", client);
			request.setAttribute("client", client);
			response.sendRedirect("SavedAccounts");
		}
	}

}
