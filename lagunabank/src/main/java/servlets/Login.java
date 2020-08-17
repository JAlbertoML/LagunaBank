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
import bs.UserBs;
import pojos.Client;
import pojos.User;

public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Login() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession httpSession = request.getSession();
		if(httpSession.getAttribute("sessionState") != null) {
			if(httpSession.getAttribute("sessionState") == LoginBs.SESSION_INACTIVE) {
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("jsp/login.jsp");
				requestDispatcher.forward(request, response);
			} else {
				response.sendRedirect("Client");
			}
		} else {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("jsp/login.jsp");
			requestDispatcher.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = UserBs.getUserByName(request.getParameter("usernameTxt"));
		String message = null;
		if(user != null) {
			if(LoginBs.validateCredentials(request.getParameter("passwordTxt"), user.getPassword())) {
				Client client = ClientBs.getClientById(user.getIdClient());
				Integer sessionState = LoginBs.SESSION_ACTIVE;
				HttpSession httpSession = request.getSession();
				httpSession.setAttribute("client", client);
				httpSession.setAttribute("sessionState", sessionState);
				httpSession.setAttribute("user", UserBs.getUserByClientId(client.getIdClient()));
				response.sendRedirect("Client");
			} else {
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("jsp/login.jsp");
				message = "La contraseña que ingresaste es incorrecta. Vuelve a intentarlo.";
				request.setAttribute("message", message);
				requestDispatcher.forward(request, response);
			}
		} else {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("jsp/login.jsp");
			message = "El usuario que ingresaste no existe. Vuelve a intentarlo.";
			request.setAttribute("message", message);
			requestDispatcher.forward(request, response);
		}
	}
}
