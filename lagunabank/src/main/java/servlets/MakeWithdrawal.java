package servlets;

import java.io.IOException;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import bs.ClientBs;
import bs.LoginBs;
import bs.MovementsBs;
import pojos.Client;

public class MakeWithdrawal extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public MakeWithdrawal() {
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
		String message = MovementsBs.makeWithdrawal(client, request.getParameter("amountTxt"), request.getParameter("descTxt"));
		if(message != null) {
			httpSession.setAttribute("messageErrorMov", message);
			response.sendRedirect("Client");
		} else {
			Random random = new Random();
			String alert = "alert('Puedes retirar el dinero en cajeros con el siguiente numero: "+ Math.abs(random.nextInt()) +"');";
			client = ClientBs.getClientById(client.getIdClient());
			httpSession.setAttribute("client", client);
			httpSession.setAttribute("alert", alert);
			response.sendRedirect("Client");
		}
	}

}