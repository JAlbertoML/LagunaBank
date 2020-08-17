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
import bs.LoginBs;
import bs.RegisterBs;
import bs.UserBs;

public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Register() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession httpSession = request.getSession();
		if(httpSession.getAttribute("sessionState") != null) {
			if(httpSession.getAttribute("sessionState") == LoginBs.SESSION_INACTIVE) {
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("jsp/register.jsp");
				requestDispatcher.forward(request, response);
			} else {
				response.sendRedirect("Client");
			}
		} else {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("jsp/register.jsp");
			requestDispatcher.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String, String[]> parameterMap = request.getParameterMap();
		String message = RegisterBs.getRegisterMessage(parameterMap);
		if(message == null) {
			if(ClientBs.addClient(parameterMap)) {
				pojos.Client client = ClientBs.getClientByCurp(request.getParameter("curpTxt"));
				if(UserBs.addUser(request.getParameter("usernameTxt"), request.getParameter("passwordTxt"), client.getIdClient())) {
					RequestDispatcher requestDispatcher = request.getRequestDispatcher("jsp/successReg.jsp");
					requestDispatcher.forward(request, response);
				}
			}
		} else {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("jsp/register.jsp");
			request.setAttribute("message", message);
			request.setAttribute("person", RegisterBs.getTmpPerson(parameterMap));
			requestDispatcher.forward(request, response);
		}
	}

}
