package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bs.ClientBs;
import bs.LoginBs;
import bs.MovementsBs;
import pojos.Client;

public class MakeTransfer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MakeTransfer() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession httpSession = request.getSession();
		if (httpSession.getAttribute("sessionState") != null) {
			if (httpSession.getAttribute("sessionState") == LoginBs.SESSION_INACTIVE) {
				response.sendRedirect("Client");
			} else {
				response.sendRedirect("Login");
			}
		} else {
			response.sendRedirect("Login");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession httpSession = request.getSession();
		Client client = (Client) httpSession.getAttribute("client");
		String message = MovementsBs.makeTransfer(client, request.getParameter("amountTxt"),
				request.getParameter("idReceiverTxt"), request.getParameter("descTxt"));
		if (message != null) {
			httpSession.setAttribute("messageErrorMov", message);
			response.sendRedirect("Client");
		} else {
			client = ClientBs.getClientById(client.getIdClient());
			httpSession.setAttribute("client", client);
			response.sendRedirect("Client");
		}
	}

}
