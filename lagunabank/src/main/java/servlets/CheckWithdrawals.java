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

public class CheckWithdrawals extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CheckWithdrawals() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession httpSession = request.getSession();
		if(httpSession.getAttribute("sessionState") == LoginBs.SESSION_ACTIVE) {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("jsp/withdrawals.jsp");
			Client client = (Client) httpSession.getAttribute("client");
			request.setAttribute("client", client);
			requestDispatcher.forward(request, response);
		} else {
			response.sendRedirect("Login");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
