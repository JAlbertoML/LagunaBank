package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bs.LoginBs;
import pojos.Movement;

public class Client extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Client() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession httpSession = request.getSession();
		if(httpSession.getAttribute("sessionState") == LoginBs.SESSION_ACTIVE) {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("jsp/client.jsp");
			pojos.Client client = (pojos.Client) httpSession.getAttribute("client");
			request.setAttribute("client", client);
			System.out.println(client.getPhoto());
			ArrayList<Movement> recentMovs = new ArrayList<Movement>();
			int i = 0;
			try {
				for(Movement mov : client.getMovements()) {
					if(mov.getType().equals(Movement.MOV_TRANSFER) || mov.getType().equals(Movement.MOV_WITHDRAWAL)) {
						request.setAttribute("lastExit", mov);
						break;
					}
				}
				for(Movement mov : client.getMovements()) {
					if(mov.getType().equals(Movement.MOV_TOP_UP_BALANCE) || mov.getType().equals(Movement.MOV_PAYMENT)) {
						request.setAttribute("lastEntry", mov);
						break;
					}
				}
				for(Movement mov : client.getMovements()) {
					recentMovs.add(mov);
					i++;
					if(i==5) {
						break;
					}
				}
				request.setAttribute("recentMovs", recentMovs);
			} catch (NullPointerException e) {
				System.out.println("No hay nada");
			}
			if(httpSession.getAttribute("messageErrorMov") != null) {
				request.setAttribute("messageErrorMov", httpSession.getAttribute("messageErrorMov"));
				httpSession.removeAttribute("messageErrorMov");
			}
			if(httpSession.getAttribute("alert") != null) {
				String alert = (String)httpSession.getAttribute("alert");
				request.setAttribute("alert", alert);
				System.out.println(alert);
				httpSession.removeAttribute("alert");
			}
			requestDispatcher.forward(request, response);
		} else {
			response.sendRedirect("Login");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}