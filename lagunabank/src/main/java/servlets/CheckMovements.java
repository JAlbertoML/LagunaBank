package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bs.LoginBs;
import pojos.Client;

public class CheckMovements extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CheckMovements() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession httpSession = request.getSession();
		if(httpSession.getAttribute("sessionState") == LoginBs.SESSION_ACTIVE) {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("jsp/movements.jsp");
			Client client = (Client) httpSession.getAttribute("client");
			request.setAttribute("client", client);
			requestDispatcher.forward(request, response);
		} else {
			response.sendRedirect("Login");
		}
	}
}
